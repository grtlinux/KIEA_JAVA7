/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
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
 * Copyright 2014, 2015, 2016 TAIN, Inc.
 *
 */
package tain.kr.com.test.pos51.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : POSHW000003D.java
 *   -. Package    : tain.kr.com.test.pos51.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public enum POSHW000003D {

	/*
	 * 계약등기 > 3.배달결과 > DATA : 271 bytes
	 */
	
	DATA_CLAS         ('C', ' ',     0,   2,   "DATA_CLAS"           ,"데이터구분"                       , "" ),
	OUTSIDUSERID      ('C', ' ',     2,  13,   "OUTSIDUSERID"        ,"외부기관구분코드"                 , "" ),
	REGINO            ('C', ' ',    15,  13,   "REGINO"              ,"등기번호"                         , "" ),
	DELIVYMD          ('C', ' ',    28,   8,   "DELIVYMD"            ,"배달일자"                         , "" ),
	DELIVHHMI         ('C', ' ',    36,   4,   "DELIVHHMI"           ,"배달시분"                         , "" ),
	DELIVRSLTCD       ('C', ' ',    40,   2,   "DELIVRSLTCD"         ,"배달결과코드"                     , "" ),
	NONDELIVREASNCD   ('C', ' ',    42,   2,   "NONDELIVREASNCD"     ,"미배달코드"                       , "" ),
	NONDELIVREASNCDNM ('C', ' ',    44,  90,   "NONDELIVREASNCDNM"   ,"미배달사유명"                     , "" ),
	SUBRECPRSNNM      ('C', ' ',   134,  60,   "SUBRECPRSNNM"        ,"수령인명"                         , "" ),
	RELRECPRSNCD      ('C', ' ',   194,   2,   "RELRECPRSNCD"        ,"수령인관계코드"                   , "" ),
	RELRECPRSNCDNM    ('C', ' ',   196,  60,   "RELRECPRSNCDNM"      ,"수령인관계명"                     , "" ),
	SSN               ('C', ' ',   256,  13,   "SSN"                 ,"생년월일"                         , "" ),
	DELIVRSLTCHGCD    ('C', ' ',   269,   2,   "DELIVRSLTCHGCD"      ,"변경초리구분코드"                 , "" ),
	;
	
	private final char type;
	private final char lead;
	private final int off;
	private final int len;
	private final String name;
	private final String desc;
	private final String defVal; 
	
	public char getType() {
		return this.type;
	}
	
	public char getLead() {
		return this.lead;
	}
	
	public int getOff() {
		return this.off;
	}
	
	public int getLen() {
		return this.len;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getDefVal() {
		return this.defVal;
	}
	
	/**
	 * 
	 * Code Templates > Comments > Constructors
	 *
	 * <PRE>
	 *   -. ClassName  : TypeTR0000
	 *   -. MethodName : TypeTR0000
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 2. 1. {time}
	 * </PRE>
	 *
	 * @param type
	 * @param lead
	 * @param off
	 * @param len
	 * @param name
	 * @param desc
	 * @param defVal
	 */
	POSHW000003D(char type, char lead, int off, int len, String name, String desc, String defVal) {
		this.type = type;
		this.lead = lead;
		this.off = off;
		this.len = len;
		this.name = name;
		this.desc = desc;
		this.defVal = defVal;
	}
	
	////////////////////////////////////////////////////////////////////
	
	public void fill(byte[] bytes, byte by) throws Exception {
		
		for (int i=0; i < this.len; i++) {
			bytes[this.off + i] = by;
		}
	}
	
	public void setVal(byte[] bytes) throws Exception  {
		// clear the exist string
		fill(bytes, (byte)' ');
	}
	
	public void setVal(byte[] bytes, byte[] byVal) throws Exception {
		
		if (byVal == null) {
			// clear the exist string
			fill(bytes, (byte)' ');
			return;
		}
		
		int byLen = byVal.length;
		
		if (this.type == 'C') {
			// left arrange
			for (int i=0, j=0; i < this.len; i++, j++) {
				if (j < byLen) {
					bytes[this.off + i] = byVal[j];
				} else {
					bytes[this.off + i] = (byte) this.lead;
				}
			}
		} else if (this.type == 'N') {
			// right arrange
			for (int i=0, j=0; i < this.len; i++, j++) {
				if (j < byLen) {
					bytes[this.off + this.len - 1 - i] = byVal[byLen - 1 - j];
				} else {
					bytes[this.off + this.len - 1 - i] = (byte) this.lead;
				}
			}
		} else {
			// TODO 2016.03.08 : ERROR
		}
	}
	
	public void setVal(byte[] bytes, String strVal) throws Exception {
		if (strVal == null) {
			// clear the exist string
			fill(bytes, (byte)' ');
			return;
		}
		
		setVal(bytes, strVal.getBytes("EUC-KR"));
	}
	
	public String getString(byte[] bytes) throws Exception {
		return new String(bytes, this.off, this.len);
	}
	
	public byte[] getBytes(byte[] bytes) throws Exception {
		byte[] ret = new byte[this.len];
		
		for (int i=0; i < this.len; i++) {
			ret[i] = bytes[this.off + i];
		}
		
		return ret;
	}

	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(HWPOS000001D.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
