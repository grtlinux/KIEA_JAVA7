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
package tain.kr.com.test.gson.v02;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest02.java
 *   -. Package    : tain.kr.com.test.gson.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest02 {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest02.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest02() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static class CmdBean {
		private String name = "";
		private String desc = "";
		private String host = "";
		private String port = "";
		private String[] cmd = new String[] { "" };
		private String[] env = new String[] { "" };
		private String dir = "";
		private String skip = "";
		private String[] fldName = new String[] { "" };
		private String result = "";
		
		///////////////////////////////////////
		
		public String getName() {
			return name;
		}
		public String getDesc() {
			return desc;
		}
		public String getHost() {
			return host;
		}
		public String getPort() {
			return port;
		}
		public String[] getCmd() {
			return cmd;
		}
		public String[] getEnv() {
			return env;
		}
		public String getDir() {
			return dir;
		}
		public String getSkip() {
			return skip;
		}
		public String[] getFldName() {
			return fldName;
		}
		public String getResult() {
			return result;
		}
		
		///////////////////////////////////////
		
		public void setName(String name) {
			this.name = name;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public void setPort(String port) {
			this.port = port;
		}
		public void setCmd(String[] cmd) {
			this.cmd = cmd;
		}
		public void setEnv(String[] env) {
			this.env = env;
		}
		public void setDir(String dir) {
			this.dir = dir;
		}
		public void setSkip(String skip) {
			this.skip = skip;
		}
		public void setFldName(String[] fldName) {
			this.fldName = fldName;
		}
		public void setResult(String result) {
			this.result = result;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new MainTest02();

		if (flag) {
			/*
			 * begin
			 */
			CmdBean cmdBean = new CmdBean();
			
			cmdBean.setName("cmdDir");
			cmdBean.setDesc("command of dir");
			
			cmdBean.setHost("127.0.0.1");
			cmdBean.setPort("1234");
			
			cmdBean.setCmd(new String[] { "cmd", "-c", "dir" });
			cmdBean.setEnv(new String[] { "PARAM1=hello", "PARAM2=world" });
			cmdBean.setDir("N:\\PROG");  // N:/PROG
			
			cmdBean.setSkip("0");
			cmdBean.setFldName(new String[] { "fld1", "fld2", "fld3" });
			
			Gson gson = new Gson();
			String strGson = gson.toJson(cmdBean);
			if (flag) System.out.println(strGson);
		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}
