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
package tain.kr.com.test.randomaccessfile.v01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FqType.java
 *   -. Package    : tain.kr.com.test.randomaccessfile.v01
 *   -. Comment    :
 *   -. Author     : KangSeok
 *   -. First Date : 2016. 3. 23. {time}
 * </PRE>
 *
 * @author KangSeok
 *
 */
public enum FqType {

	FQ_SEQ    ('N', '0',    0,   8,  "FQ_SEQ"    ,"FQ 순번"        , "" ),
	FQ_RDR    ('C', ' ',    8,  10,  "FQ_RDR"    ,"FQ READER"      , "" ),
	FQ_LEN    ('N', '0',   18,   5,  "FQ_LEN"    ,"FQ 길이"        , "" ),
	REC_LEN   ('N', '0',   23,   4,  "REC_LEN"   ,"REC 길이"       , "" ),
	REC_CNT   ('N', '0',   27,   7,  "REC_CNT"   ,"REC 건수"       , "" ),
	REC_SR    ('C', ' ',   34,   1,  "REC_SR"    ,"REC SR구분"     , "" ),
	REC_ORG   ('C', ' ',   35,   3,  "REC_ORG"   ,"REC 기관"       , "" ),
	REC_FILE  ('C', ' ',   38,  11,  "REC_FILE"  ,"REC 파일명"     , "" ),
	REC_FSIZ  ('N', '0',   49,   2,  "REC_FSIZ"  ,"REC 파일명길이" , "" ),
	REC_DATE  ('C', ' ',   51,   8,  "REC_DATE"  ,"REC 일자"       , "" ),
	REC_TIME  ('C', ' ',   59,   9,  "REC_TIME"  ,"REC 시간"       , "" ),
	REC_SEQ   ('N', '0',   68,   2,  "REC_SEQ"   ,"REC 순번"       , "" ),
	FILLER    ('C', ' ',   70,  53,  "FILLER"    ,"공백"           , "" ),
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
	 *   -. ClassName  : FqType
	 *   -. MethodName : FqType
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
	FqType(char type, char lead, int off, int len, String name, String desc, String defVal) {
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
			
			for (FqType fld : FqType.values()) {
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
			for (FqType fld : FqType.values()) {
				if (!flag) log.debug("[" + fld.name + "]");
				fld.setVal(bytes, fld.getDefVal());
			}
		}
		
		if (flag) {
			FqType.FQ_SEQ  .setVal(bytes, "");
			FqType.FQ_RDR  .setVal(bytes, "");
			FqType.FQ_LEN  .setVal(bytes, "");
			FqType.REC_LEN .setVal(bytes, "");
			FqType.REC_CNT .setVal(bytes, "");
			FqType.REC_SR  .setVal(bytes, "");
			FqType.REC_ORG .setVal(bytes, "");
			FqType.REC_FILE.setVal(bytes, "");
			FqType.REC_FSIZ.setVal(bytes, "");
			FqType.REC_DATE.setVal(bytes, "");
			FqType.REC_TIME.setVal(bytes, "");
			FqType.REC_SEQ .setVal(bytes, "");
			FqType.FILLER  .setVal(bytes, "");
		}
		
		return bytes;
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	
	private static final Logger log = Logger.getLogger(FqType.class);
	
	public static void print() throws Exception {
		
		if (flag) {
			int len = 0;
			int off = 0;
			for (FqType fld : FqType.values()) {
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
			for (FqType fld : FqType.values()) {
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
			
			byte[] bytes = FqType.makeBytes();
			
			if (flag) {
				FqType.FQ_SEQ  .setVal(bytes, "12");
				FqType.FQ_RDR  .setVal(bytes, "");
				FqType.FQ_LEN  .setVal(bytes, "101");
				FqType.REC_LEN .setVal(bytes, "671");
				FqType.REC_CNT .setVal(bytes, "4");
				FqType.REC_SR  .setVal(bytes, "S");
				FqType.REC_ORG .setVal(bytes, "POS");
				FqType.REC_FILE.setVal(bytes, "HWPOS000001");
				FqType.REC_FSIZ.setVal(bytes, "11");
				FqType.REC_DATE.setVal(bytes, new SimpleDateFormat("yyyyMMdd" , Locale.KOREA).format(new Date()));
				FqType.REC_TIME.setVal(bytes, new SimpleDateFormat("HHmmssSSS", Locale.KOREA).format(new Date()));
				FqType.REC_SEQ .setVal(bytes, "1");
				FqType.FILLER  .setVal(bytes, "");
			}
			
			FqType.print();
			FqType.print(bytes);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());

		if (flag) test01(args);
	}
}
