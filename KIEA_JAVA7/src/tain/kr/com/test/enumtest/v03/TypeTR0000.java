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
package tain.kr.com.test.enumtest.v03;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TypeTR0000.java
 *   -. Package    : tain.kr.com.test.enumtest.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 2. 1. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public enum TypeTR0000 {

	TR_LEN            ('N', '0',   0,   4, "TR_LEN"        , "TR 길이"         , "0100"),
	TR_CODE           ('C', ' ',   4,   6, "TR_CODE"       , "TR 코드"         , "TR0100"),
	TR_DATE           ('C', '0',  10,   8, "TR_DATE"       , "TR 발생일자"     , "YYYYMMDD"),
	TR_TIME           ('C', '0',  18,   6, "TR_TIME"       , "TR 발생시간"     , "HHMMSS"),
	TR_USER           ('C', ' ',  24,  10, "TR_USER"       , "TR 사용자"       , "USER"),
	TR_PASS           ('C', ' ',  34,  10, "TR_PASS"       , "TR 비밀번호"     , "PASS"),
	KEY_CODE          ('C', ' ',  44,  10, "KEY_CODE"      , "키코드"          , "0000000000"),
	DATA_LEN          ('N', '0',  54,  15, "DATA_LEN"      , "DATA 길이"       , "000000000000000"),
	FILLER            ('C', '.',  69,  31, "FILLER"        , "RESERVED "       , ""),
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
	TypeTR0000(char type, char lead, int off, int len, String name, String desc, String defVal) {
		this.type = type;
		this.lead = lead;
		this.off = off;
		this.len = len;
		this.name = name;
		this.desc = desc;
		this.defVal = defVal;
	}
	
	////////////////////////////////////////////////////////////////////
	
	public void fill(byte[] bytes, byte by) {
		
		for (int i=0; i < this.len; i++) {
			bytes[this.off + i] = by;
		}
	}
	
	public void setVal(byte[] bytes, String val) {
		
		if (val == null) {
			// clear the exist string
			for (int i=0; i < this.len; i++) {
				bytes[this.off + i] = (byte) ' ';
			}
			
			return;
		}
		
		
	}
}
