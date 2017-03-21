/**
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc. all rights reserved.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * -----------------------------------------------------------------
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc.
 *
 */
package tain.kr.com.commons.daemon.v02.support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DaemonConfiguration.java
 *   -. Package    : tain.kr.com.commons.daemon.v02.support
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 21. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class DaemonConfiguration {

	protected final static String DEFAULT_CONFIG  = "daemon.properties";
	
	protected final static String PREFIX = "daemon.";
	protected final static String BTOKEN = "${";
	protected final static String ETOKEN = "}";
	
	private final Properties configurationProperties;
	private final Properties systemProperties;
	
	/*
	 * default constructor
	 */
	public DaemonConfiguration() {
		this.configurationProperties = new Properties();
		this.systemProperties = System.getProperties();
	}
	
	/*
	 * loads the configuration properties file
	 */
	public boolean load(String fileName) {
		
		boolean ok = false;
		
		FileInputStream file = null;
		
		try {
			if (fileName == null) 
				fileName = DEFAULT_CONFIG;
			
			file = new FileInputStream(fileName);
			this.configurationProperties.clear();
			this.configurationProperties.load(file);
			ok = true;
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			//
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException e) {
				//
			}
		}
		
		return ok;
	}
	
	private String expandProperties(String propValue) throws ParseException {
		
		StringBuffer expanded;
		int btoken;
		int ctoken = 0;
		
		if (propValue == null)
			return null;
		
		expanded = new StringBuffer();
		btoken = propValue.indexOf(BTOKEN);
		while (btoken != -1) {
			if (btoken > 0 && propValue.charAt(btoken - 1) == BTOKEN.charAt(0)) {
				// skip and upquote
				expanded.append(propValue.substring(ctoken, btoken));
				ctoken = btoken + 1;
				btoken = propValue.indexOf(BTOKEN, btoken + BTOKEN.length());
				continue;
			}
			
			int etoken = propValue.indexOf(ETOKEN, btoken);
			if (etoken != -1) {
				String variable = propValue.substring(btoken + BTOKEN.length(), etoken);
				String sysvalue = systemProperties.getProperty(variable);
				if (sysvalue == null) {
					// try with the environment if there was no
					// property by that name
					sysvalue = System.getenv(variable); // N.B. deprecated in java
				}
				if (sysvalue != null) {
					String strtoken = propValue.substring(ctoken, btoken);
					expanded.append(strtoken);
					expanded.append(sysvalue);
					ctoken = etoken + ETOKEN.length();
				}
			} else {
				// we have ${ without }
				throw new ParseException("Error while looking for terminating '" + ETOKEN + "'", btoken);
			}
			
			btoken = propValue.indexOf(BTOKEN, etoken + ETOKEN.length());
		}
		// add what's left.
		expanded.append(propValue.substring(ctoken, propValue.length()));
		return expanded.toString();
	}
	
	/*
	 * gets the configuration property
	 */
	public String getProperty(String name) throws ParseException {
		
		if (name == null)
			return null;
		else
			return expandProperties(this.configurationProperties.getProperty(PREFIX + name));
	}
	
	/*
	 * gets the configuration property array
	 */
	public String[] getPropertyArray(String name) throws ParseException {
		
		ArrayList<String> list = new ArrayList<String>();
		String args;
		
		while ((args = getProperty(name + "[" + list.size() + "]")) != null) {
			list.add(args);
		}
		
		return (String[]) list.toArray(new String[list.size()]);
	}
}
