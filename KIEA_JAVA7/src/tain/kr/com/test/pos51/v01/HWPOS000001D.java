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
 *   -. FileName   : HWPOS000001D.java
 *   -. Package    : tain.kr.com.test.pos51.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public enum HWPOS000001D {

	DATA_CLAS         ('C', ' ',     0,   2,   "DATA_CLAS"           ,"데이타구분"                       , "" ),
	CARDSENDYMD       ('C', ' ',     2,   8,   "CARDSENDYMD"         ,"발송일자"                         , "" ),
	REGINO            ('C', ' ',    10,  13,   "REGINO"              ,"등기번호"                         , "" ),
	REGIPOCD          ('C', ' ',    23,   5,   "REGIPOCD"            ,"접수우체국구기호"                 , "" ),
	KINDDIVCD         ('C', ' ',    28,   3,   "KINDDIVCD"           ,"종별구분코드"                     , "" ),
	MAILWGHT          ('C', ' ',    31,   7,   "MAILWGHT"            ,"중량"                             , "" ),
	SPCLTREATCD       ('C', ' ',    38,   3,   "SPCLTREATCD"         ,"특수취급코드"                     , "" ),
	RECPRSNNM         ('C', ' ',    41, 100,   "RECPRSNNM"           ,"수취인명"                         , "" ),
	RECPRSNZIPCD      ('C', ' ',   141,   6,   "RECPRSNZIPCD"        ,"수취인우편번호"                   , "" ),
	RECPRSNADDR       ('C', ' ',   147, 100,   "RECPRSNADDR"         ,"수취인주소"                       , "" ),
	RECPRSNDTAILADDR  ('C', ' ',   247, 200,   "RECPRSNDTAILADDR"    ,"수취인상세주소"                   , "" ),
	SUBAREATELNO      ('C', ' ',   447,  15,   "SUBAREATELNO"        ,"수령지전화번호(수취인전화번호)"   , "" ),
	HTELNO            ('C', ' ',   462,  12,   "HTELNO"              ,"이동전화번호(수취인핸드폰번호)"   , "" ),
	RECEVPRC          ('C', ' ',   474,  15,   "RECEVPRC"            ,"접수금액"                         , "" ),
	BUNDNO            ('C', ' ',   489,  15,   "BUNDNO"              ,"묶음번호"                         , "" ),
	BUNDSEQ           ('C', ' ',   504,   4,   "BUNDSEQ"             ,"묶음번호일연번호"                 , "" ),
	RELYMD            ('C', ' ',   508,   8,   "RELYMD"              ,"연계일자"                         , "" ),
	SECTCD            ('C', ' ',   516,   6,   "SECTCD"              ,"부서코드"                         , "" ),
	SECTNM            ('C', ' ',   522,  50,   "SECTNM"              ,"과명"                             , "" ),
	OUTSIDUSERID      ('C', ' ',   572,  13,   "OUTSIDUSERID"        ,"외부고객접수아이디"               , "" ),
	EXPYN             ('C', ' ',   585,   2,   "EXPYN"               ,"특습유무"                         , "" ),
	SSN               ('C', ' ',   587,  13,   "SSN"                 ,"수취인주민번호"                   , "" ),
	MAILCONT          ('C', ' ',   600,  70,   "MAILCONT"            ,"우편물내역"                       , "" ),
	PRSNAPPODELIVYN   ('C', ' ',   670,   1,   "PRSNAPPODELIVYN"     ,"본인지정배달여부"                 , "" ),
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
	HWPOS000001D(char type, char lead, int off, int len, String name, String desc, String defVal) {
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
