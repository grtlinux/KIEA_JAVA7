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

import java.util.StringTokenizer;

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

	/*
	 * 계약등기 > 1.접수정보 내역 > DATA : 671 bytes
	 */
	
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
	 *   -. ClassName  : HWPOS000001D
	 *   -. MethodName : HWPOS000001D
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
	
	private static int cntFld = -1;
	private static int lenTotal = -1;
	
	private static int setLenTotal() throws Exception {
		
		if (lenTotal < 0) {
			int cnt = 0;
			int off = 0;
			
			for (HWPOS000001D fld : HWPOS000001D.values()) {
				off += fld.getLen();
				cnt ++;
			}
			
			lenTotal = off;
			cntFld = cnt;
		}
		
		return lenTotal;
	}
	
	public static int getCntFld() throws Exception {
		setLenTotal();
		return cntFld;
	}
	
	public static int getLength() throws Exception {
		setLenTotal();
		return lenTotal;
	}
	
	public static byte[] makeBytes() throws Exception {
		
		setLenTotal();
		
		byte[] bytes = new byte[lenTotal];
		
		if (flag) {
			for (HWPOS000001D fld : HWPOS000001D.values()) {
				fld.setVal(bytes, fld.getDefVal());
			}
		}
		
		if (flag) {
			HWPOS000001D.DATA_CLAS         .setVal(bytes, "DT");
			HWPOS000001D.CARDSENDYMD       .setVal(bytes, "");
			HWPOS000001D.REGINO            .setVal(bytes, "");
			HWPOS000001D.REGIPOCD          .setVal(bytes, "");
			HWPOS000001D.KINDDIVCD         .setVal(bytes, "");
			HWPOS000001D.MAILWGHT          .setVal(bytes, "");
			HWPOS000001D.SPCLTREATCD       .setVal(bytes, "");
			HWPOS000001D.RECPRSNNM         .setVal(bytes, "");
			HWPOS000001D.RECPRSNZIPCD      .setVal(bytes, "");
			HWPOS000001D.RECPRSNADDR       .setVal(bytes, "");
			HWPOS000001D.RECPRSNDTAILADDR  .setVal(bytes, "");
			HWPOS000001D.SUBAREATELNO      .setVal(bytes, "");
			HWPOS000001D.HTELNO            .setVal(bytes, "");
			HWPOS000001D.RECEVPRC          .setVal(bytes, "");
			HWPOS000001D.BUNDNO            .setVal(bytes, "");
			HWPOS000001D.BUNDSEQ           .setVal(bytes, "");
			HWPOS000001D.RELYMD            .setVal(bytes, "");
			HWPOS000001D.SECTCD            .setVal(bytes, "");
			HWPOS000001D.SECTNM            .setVal(bytes, "");
			HWPOS000001D.OUTSIDUSERID      .setVal(bytes, "");
			HWPOS000001D.EXPYN             .setVal(bytes, "");
			HWPOS000001D.SSN               .setVal(bytes, "");
			HWPOS000001D.MAILCONT          .setVal(bytes, "");
			HWPOS000001D.PRSNAPPODELIVYN   .setVal(bytes, "");
		}
		
		return bytes;
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////

	public static String compress(byte[] bytes) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		
		for (HWPOS000001D fld : HWPOS000001D.values()) {
			
			sb.append(fld.getString(bytes).trim()).append("|");
		}
		
		if (flag) sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}
	
	public static String decompress(byte[] bytes) throws Exception {
		
		byte[] ret = null;
		
		if (!flag) {
			/*
			 * TODO 20160308 : for test
			 */
			StringTokenizer st = new StringTokenizer(new String(bytes), "|", false);
			int count = st.countTokens();
			
			for (int i=0; i < count && st.hasMoreTokens(); i++) {
				String str = st.nextToken();
				
				if (flag) log.debug("> [" + str + "]");
			}
		}
		
		if (flag) {
			/*
			 * 
			 */
			ret = HWPOS000001D.makeBytes();
			
			String[] items = new String(bytes).split("\\|", HWPOS000001D.getCntFld());   // TODO 2016.03.14 : have to fix the field count... ^^
			int i = 0;
			
			for (HWPOS000001D fld : HWPOS000001D.values()) {
				
				if (!flag) log.debug("> [" + items[i] + "]");
				if (flag) log.debug(String.format("> [%-20s] [%s]", fld.name, items[i]));

				fld.setVal(ret, items[i]);
				++ i;
			}
		}
		
		return new String(ret);
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	private static final Logger log = Logger.getLogger(HWPOS000001D.class);
	
	public static void print() throws Exception {
		
		if (flag) {
			int len = 0;
			int off = 0;
			for (HWPOS000001D fld : HWPOS000001D.values()) {
				len = fld.getLen();
				
				if (flag) log.debug(String.format("[%s] [%3d:%3d] [%3d:%3d] [%-10s] [%s] [%s]"
						, fld.getType(), off, fld.getOff(), len, fld.getLen(), fld.getName(), fld.getDesc(), fld.getDefVal()));
				
				off += fld.getLen();
			}
			
			if (flag) log.debug("Total Length = " + off);
		}
	}
	
	public static void print(byte[] bytes) throws Exception {
		
		if (flag) {
			int len = 0;
			int off = 0;
			for (HWPOS000001D fld : HWPOS000001D.values()) {
				len = fld.getLen();
				
				if (flag) log.debug(String.format("[%s] [%3d:%3d] [%3d:%3d] [%-10s] [%s]"
						, fld.getType(), off, fld.getOff(), len, fld.getLen(), fld.getName(), fld.getString(bytes)));
				
				off += fld.getLen();
			}
			
			if (flag) log.debug("[" + new String(bytes) + "]");
			if (flag) log.debug("Total Length = " + off);
		}
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			if (flag) log.debug(String.format("[FLD_CNT:%d] [REC_LEN:%d]", HWPOS000001D.getCntFld(), HWPOS000001D.getLength()));
			
			byte[] bytes = HWPOS000001D.makeBytes();
			
			HWPOS000001D.DATA_CLAS         .setVal(bytes, "DT");
			HWPOS000001D.CARDSENDYMD       .setVal(bytes, "");
			HWPOS000001D.REGINO            .setVal(bytes, "");
			HWPOS000001D.REGIPOCD          .setVal(bytes, "");
			HWPOS000001D.KINDDIVCD         .setVal(bytes, "");
			HWPOS000001D.MAILWGHT          .setVal(bytes, "");
			HWPOS000001D.SPCLTREATCD       .setVal(bytes, "");
			HWPOS000001D.RECPRSNNM         .setVal(bytes, "");
			HWPOS000001D.RECPRSNZIPCD      .setVal(bytes, "");
			HWPOS000001D.RECPRSNADDR       .setVal(bytes, "");
			HWPOS000001D.RECPRSNDTAILADDR  .setVal(bytes, "");
			HWPOS000001D.SUBAREATELNO      .setVal(bytes, "");
			HWPOS000001D.HTELNO            .setVal(bytes, "");
			HWPOS000001D.RECEVPRC          .setVal(bytes, "");
			HWPOS000001D.BUNDNO            .setVal(bytes, "");
			HWPOS000001D.BUNDSEQ           .setVal(bytes, "");
			HWPOS000001D.RELYMD            .setVal(bytes, "");
			HWPOS000001D.SECTCD            .setVal(bytes, "");
			HWPOS000001D.SECTNM            .setVal(bytes, "");
			HWPOS000001D.OUTSIDUSERID      .setVal(bytes, "");
			HWPOS000001D.EXPYN             .setVal(bytes, "");
			HWPOS000001D.SSN               .setVal(bytes, "");
			HWPOS000001D.MAILCONT          .setVal(bytes, "");
			HWPOS000001D.PRSNAPPODELIVYN   .setVal(bytes, "");
			
			HWPOS000001D.print();
			HWPOS000001D.print(bytes);
			
			String strCompress = HWPOS000001D.compress(bytes);
			if (flag) log.debug("> COMPRESS [" + strCompress + "]");
			
			String strDecompress = HWPOS000001D.decompress(strCompress.getBytes("EUC-KR"));
			if (flag) log.debug("> DECOMPRESS [" + strDecompress + "]");
			
			if (strDecompress.equals(new String(bytes))) {
				log.debug(">>>>> EQUALS");
			} else {
				log.debug(">>>>> MISMATCH");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());

		if (flag) test01(args);
	}
}
