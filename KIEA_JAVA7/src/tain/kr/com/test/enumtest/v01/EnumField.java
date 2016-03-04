package tain.kr.com.test.enumtest.v01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public enum EnumField {

	// type, lead, off, len, name, desc, defVal
	
	MSG_LEN           ('N', '0',   0,   4, "MSG_LEN"            , "�����ѱ���"                     , "0879"),
	MSG_TEXT          ('C', ' ',   4,  10, "MSG_TEXT"           , "��������"                       , "INPIRT0210"),
	TRADE_GB_CD       ('N', ' ',  14,   6, "TRADE_GB_CD"        , "�ŷ������ڵ�"                   , "100010"),
	BUSI_DT           ('N', ' ',  20,   8, "BUSI_DT"            , "��������"                       , ""),
	TRADE_GENTD_DT    ('N', ' ',  28,   4, "TRADE_GENTD_DT"     , "�ŷ��߻�����"                   , ""),
	TRADE_GENTD_TM    ('N', ' ',  32,   6, "TRADE_GENTD_TM"     , "�ŷ��߻��ð�"                   , ""),
	TRADE_GENTD_STCD  ('N', ' ',  38,   4, "TRADE_GENTD_STCD"   , "�ŷ��߻�����ȣ"                 , "9900"),
	TRADE_GENTD_POSNO ('N', ' ',  42,   4, "TRADE_GENTD_POSNO"  , "�ŷ��߻�POS��ȣ"                , "7946"),
	TRADE_NO          ('N', ' ',  46,   4, "TRADE_NO"           , "�ŷ���ȣ"                       , "2839"),
	DO_BYID           ('N', ' ',  50,   6, "DO_BYID"            , "����ڻ��"                     , ""),
	CARD_NO           ('N', ' ',  56,  60, "CARD_NO"            , "ī���ȣ"                       , ""),
	CUST_ID           ('N', ' ', 116,   9, "CUST_ID"            , "��������ȣ"                   , ""),
	INPUT_FLG         ('N', ' ', 125,   1, "INPUT_FLG"          , "����Ʈī���νı���"             , "M"),
	BRCH_ID           ('N', ' ', 126,  10, "BRCH_ID"            , "������ID"                       , "E999999999"),
	RECPT_NO          ('N', ' ', 136,  20, "RECPT_NO"           , "��������ȣ"                     , ""),
	PASSWD            ('N', ' ', 156,   4, "PASSWD"             , "��й�ȣ"                       , ""),
	GIFTCARD_AMT      ('N', ' ', 160,  10, "GIFTCARD_AMT"       , "��ǰ�Ǳݾ�"                     , ""),
	CASH_AMT          ('N', ' ', 170,  10, "CASH_AMT"           , "���ܺ� �����ݾ�:����"           , ""),
	GIFTCARD_PAY_AMT  ('N', ' ', 180,  10, "GIFTCARD_PAY_AMT"   , "���ܺ� �����ݾ�:��ǰ��"         , ""),
	M_GIFTCARD_PAY_AMT('N', ' ', 190,  10, "M_GIFTCARD_PAY_AMT" , "���ܺ� �����ݾ�:��ǰ��(�����)" , ""),
	SHIN_CARD_AMT     ('N', ' ', 200,  10, "SHIN_CARD_AMT"      , "���ܺ� �����ݾ�:�ż����Ƽ"     , ""),
	ALLIANCE_CARD_AMT1('N', ' ', 210,  10, "ALLIANCE_CARD_AMT1" , "���ܺ� �����ݾ�:����ī��1"      , ""),
	ALLIANCE_CARD_AMT2('N', ' ', 220,  10, "ALLIANCE_CARD_AMT2" , "���ܺ� �����ݾ�:����ī��2"      , ""),
	ALLIANCE_CARD_AMT3('N', ' ', 230,  10, "ALLIANCE_CARD_AMT3" , "���ܺ� �����ݾ�:����ī��3"      , ""),
	OTHER_CARD_AMT    ('N', ' ', 240,  10, "OTHER_CARD_AMT"     , "���ܺ� �����ݾ�:Ÿ��ī��"       , ""),
	SHIN_DEBIT_AMT    ('N', ' ', 250,  10, "SHIN_DEBIT_AMT"     , "���ܺ� �����ݾ�:��������ī��"   , ""),
	DEBIT_AMT         ('N', ' ', 260,  10, "DEBIT_AMT"          , "���ܺ� �����ݾ�:����ī��"       , ""),
	OTHER_ETC_AMT     ('N', ' ', 270,  10, "OTHER_ETC_AMT"      , "���ܺ� �����ݾ�:��Ÿ����"       , ""),
	NOADD_AMT         ('N', ' ', 280,  10, "NOADD_AMT"          , "���ܺ� �����ݾ�:������������"   , ""),
	SPOINT_AMT        ('N', ' ', 290,  10, "SPOINT_AMT"         , "���ܺ� �����ݾ�:S-POINT���"    , ""),
	FILLER_AMT1       ('N', ' ', 300,  10, "FILLER_AMT1"        , "���ܺ� �����ݾ�:����1"          , ""),
	FILLER_AMT2       ('N', ' ', 310,  10, "FILLER_AMT2"        , "���ܺ� �����ݾ�:����2"          , ""),
	NOPOINT_PROD_AMT  ('N', ' ', 320,  10, "NOPOINT_PROD_AMT"   , "����Ʈ��������ǰ�ݾ�"           , ""),
	TOT_TRADE_AMT     ('N', ' ', 330,  10, "TOT_TRADE_AMT"      , "�Ѱŷ��ݾ�"                     , ""),
	TPOINT            ('N', ' ', 340,   8, "TPOINT"             , "��������Ʈ"                     , ""),
	UBPOINT           ('N', ' ', 348,   8, "UBPOINT"            , "��������Ʈ"                     , ""),
	GPOINT            ('N', ' ', 356,   8, "GPOINT"             , "��ȸ����Ʈ"                     , ""),
	CAMPAIGN_CLUB1    ('N', ' ', 364,   5, "CAMPAIGN_CLUB1"     , "ķ����:Ŭ��ID1"                 , ""),
	CAMPAIGN_AMT1     ('N', ' ', 369,  10, "CAMPAIGN_AMT1"      , "ķ����:���رݾ�1"               , ""),
	CAMPAIGN_CLUB2    ('N', ' ', 379,   5, "CAMPAIGN_CLUB2"     , "ķ����:Ŭ��ID2"                 , ""),
	CAMPAIGN_AMT2     ('N', ' ', 384,  10, "CAMPAIGN_AMT2"      , "ķ����:���رݾ�2"               , ""),
	CAMPAIGN_CLUB3    ('N', ' ', 394,   5, "CAMPAIGN_CLUB3"     , "ķ����:Ŭ��ID3"                 , ""),
	CAMPAIGN_AMT3     ('N', ' ', 399,  10, "CAMPAIGN_AMT3"      , "ķ����:���رݾ�3"               , ""),
	EXTINCT_POINT     ('N', ' ', 409,   8, "EXTINCT_POINT"      , "�Ҹ꿹������Ʈ"                 , ""),
	BASE_APOINT       ('N', ' ', 417,   8, "BASE_APOINT"        , "�߻�����Ʈ:�⺻����"            , ""),
	PROD_APOINT       ('N', ' ', 425,   8, "PROD_APOINT"        , "�߻�����Ʈ:��ǰ����"            , ""),
	CLUB_APOINT       ('N', ' ', 433,   8, "CLUB_APOINT"        , "�߻�����Ʈ:Ŭ������"            , ""),
	EVENT_APOINT      ('N', ' ', 441,   8, "EVENT_APOINT"       , "�߻�����Ʈ:�̺�Ʈ����"          , ""),
	ETC_APOINT        ('N', ' ', 449,   8, "ETC_APOINT"         , "�߻�����Ʈ:��Ÿ����"            , ""),
	CLUB01            ('N', ' ', 457,   5, "CLUB01"             , "Ŭ���Ӽ�:Ŭ��ID01"              , ""),
	CLUB02            ('N', ' ', 462,   5, "CLUB02"             , "Ŭ���Ӽ�:Ŭ��ID02"              , ""),
	CLUB03            ('N', ' ', 467,   5, "CLUB03"             , "Ŭ���Ӽ�:Ŭ��ID03"              , ""),
	CLUB04            ('N', ' ', 472,   5, "CLUB04"             , "Ŭ���Ӽ�:Ŭ��ID04"              , ""),
	CLUB05            ('N', ' ', 477,   5, "CLUB05"             , "Ŭ���Ӽ�:Ŭ��ID05"              , ""),
	CLUB06            ('N', ' ', 482,   5, "CLUB06"             , "Ŭ���Ӽ�:Ŭ��ID06"              , ""),
	CLUB07            ('N', ' ', 487,   5, "CLUB07"             , "Ŭ���Ӽ�:Ŭ��ID07"              , ""),
	CLUB08            ('N', ' ', 492,   5, "CLUB08"             , "Ŭ���Ӽ�:Ŭ��ID08"              , ""),
	CLUB09            ('N', ' ', 497,   5, "CLUB09"             , "Ŭ���Ӽ�:Ŭ��ID09"              , ""),
	CLUB10            ('N', ' ', 502,   5, "CLUB10"             , "Ŭ���Ӽ�:Ŭ��ID10"              , ""),
	CLUB11            ('N', ' ', 507,   5, "CLUB11"             , "Ŭ���Ӽ�:Ŭ��ID11"              , ""),
	CLUB12            ('N', ' ', 512,   5, "CLUB12"             , "Ŭ���Ӽ�:Ŭ��ID12"              , ""),
	CLUB13            ('N', ' ', 517,   5, "CLUB13"             , "Ŭ���Ӽ�:Ŭ��ID13"              , ""),
	CLUB14            ('N', ' ', 522,   5, "CLUB14"             , "Ŭ���Ӽ�:Ŭ��ID14"              , ""),
	CLUB15            ('N', ' ', 527,   5, "CLUB15"             , "Ŭ���Ӽ�:Ŭ��ID15"              , ""),
	CLUB16            ('N', ' ', 532,   5, "CLUB16"             , "Ŭ���Ӽ�:Ŭ��ID16"              , ""),
	CLUB17            ('N', ' ', 537,   5, "CLUB17"             , "Ŭ���Ӽ�:Ŭ��ID17"              , ""),
	CLUB18            ('N', ' ', 542,   5, "CLUB18"             , "Ŭ���Ӽ�:Ŭ��ID18"              , ""),
	CLUB19            ('N', ' ', 547,   5, "CLUB19"             , "Ŭ���Ӽ�:Ŭ��ID19"              , ""),
	CLUB20            ('N', ' ', 552,   5, "CLUB20"             , "Ŭ���Ӽ�:Ŭ��ID20"              , ""),
	CONV_CUST_FLG     ('C', ' ', 557,   1, "CONV_CUST_FLG"      , "��ȯ������"                   , ""),
	CUST_NAME_FLG     ('C', ' ', 558,   1, "CUST_NAME_FLG"      , "�������翩��"                 , ""),
	CASH_RECPT_FLG    ('C', ' ', 559,   1, "CASH_RECPT_FLG"     , "�ڵ�����ȣ����"                 , ""),
	MOBILE_NO         ('N', ' ', 560,  30, "MOBILE_NO"          , "�ڵ�����ȣ"                     , ""),
	REJCT_GB          ('C', ' ', 590,   1, "REJCT_GB"           , "��ұ���(�������/������)"    , ""),
	CASH_SAVING_GB    ('C', ' ', 591,   1, "CASH_SAVING_GB"     , "�ܵ�����ī�忩��"               , ""),
	ASIANA_GB         ('C', ' ', 592,   1, "ASIANA_GB"          , "�ƽþƴ�ī�忩��"               , ""),
	BASIS_CARNO1      ('C', ' ', 593,  12, "BASIS_CARNO1"       , "��������:��������1"             , ""),
	BASIS_CARNO2      ('C', ' ', 605,  12, "BASIS_CARNO2"       , "��������:��������2"             , ""),
	TODAY_CARNO       ('N', ' ', 617,   6, "TODAY_CARNO"        , "��������:��������"              , ""),
	OTRADE_BUSI_DT    ('N', ' ', 623,   8, "OTRADE_BUSI_DT"     , "���ŷ���������"                 , ""),
	OTRADE_STCD       ('N', ' ', 631,   4, "OTRADE_STCD"        , "���ŷ�����ȣ"                   , ""),
	OTRADE_POSNO      ('N', ' ', 635,   4, "OTRADE_POSNO"       , "���ŷ�POS��ȣ"                  , ""),
	OTRADE_RECPT_NO   ('N', ' ', 639,  20, "OTRADE_RECPT_NO"    , "���ŷ���������ȣ"               , ""),
	OTRADE_AMT        ('N', ' ', 659,  10, "OTRADE_AMT"         , "���ŷ��ݾ�"                     , ""),
	REPLY_CD          ('N', ' ', 669,   4, "REPLY_CD"           , "�����ڵ�"                       , ""),
	SYSTEM_CRE_DT     ('N', ' ', 673,   8, "SYSTEM_CRE_DT"      , "�ý�������"                     , ""),
	SYSTEM_CRE_TM     ('N', ' ', 681,   6, "SYSTEM_CRE_TM"      , "�ý��۽ð�"                     , ""),
	CUST_NAME         ('C', ' ', 687,  40, "CUST_NAME"          , "����"                         , ""),
	REPLY_MESG        ('C', ' ', 727,  40, "REPLY_MESG"         , "��������¸޽���"               , ""),
	APP_POINT_GB      ('C', ' ', 767,   2, "APP_POINT_GB"       , "APP����Ʈī�屸��"              , ""),
	APP_POINT_FLG     ('C', ' ', 769,  10, "APP_POINT_FLG"      , "APP����Ʈī�屸����"            , ""),
	FILLER            ('N', ' ', 779, 100, "FILLER"             , "����"                           , ""),
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
	
	EnumField(char type, char lead, int off, int len, String name, String desc, String defVal) {
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
		
		byte[] byVal = val.getBytes();
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
		}
	}

	public String getVal(byte[] bytes) {
		return new String(bytes, this.off, this.len);
	}

	///////////////////////////////////////////////////////////////////
	
	private static boolean flag = true;
	
	public static final int lenTotal = 879;

	public static byte[] makeBytes() {
		
		byte[] bytes = new byte[lenTotal];
		
		if (!flag) {
			for (int i=0; i < lenTotal; i++) {
				bytes[i] = (byte) ' ';
			}
		}
		
		if (flag) {
			for (EnumField fld : EnumField.values()) {
				fld.setVal(bytes, fld.getDefVal());
			}
		}
		
		return bytes;
	}
	
	public static byte[] clearBytes(byte[] bytes) {
		
		for (int i=0; i < lenTotal; i++) {
			bytes[i] = (byte) ' ';
		}
		
		return bytes;
	}
	
	///////////////////////////////////////////////////////////////////

	// socket recv
	public static byte[] recv(Socket socket, DataInputStream dis, final int size) throws Exception {
		int ret = 0;
		int readed = 0;
		byte[] buf = new byte[size];
		
		socket.setSoTimeout(0);
		while (readed < size) {
			ret = dis.read(buf, readed, size - readed);
			//System.out.println("    size:" + size + "    readed:" + readed + "     ret:" + ret);
			
			if (ret <= 0) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}

				continue;
			} else {
				socket.setSoTimeout(1000);
			}
			
			readed += ret;
		}
		
		return buf;
	}

	public static void main(String[] args) throws Exception {
		
		if (!flag) {
			int off = 0;
			for (EnumField fld : EnumField.values()) {
				System.out.printf("[%s] [%3d][%3d] [%3d] [%20s] [%s] [%s]\n"
						, fld.getType(), off, fld.getOff(), fld.getLen(), fld.getName(), fld.getDesc(), fld.getDefVal());
				off += fld.getLen();
			}
		}
		
		if (!flag) {
			//byte[] byt = new byte[EnumField.lenTotal];
			byte[] bytes = new byte[20];
			
			MSG_LEN     .setVal(bytes, String.valueOf(12));
			MSG_TEXT    .setVal(bytes, "TR0210");
			TRADE_GB_CD .setVal(bytes, "0210"  );
			System.out.println("[" + new String(bytes) + "]");
			
			System.out.println("[" + MSG_LEN      .getVal(bytes) + "]");
			System.out.println("[" + MSG_TEXT     .getVal(bytes) + "]");
			System.out.println("[" + TRADE_GB_CD  .getVal(bytes) + "]");
		}
		
		if (!flag) {
			byte[] bytes = EnumField.makeBytes();
			if (flag) System.out.println("[" + new String(bytes) + "]");
			EnumField.clearBytes(bytes);
			if (flag) System.out.println("[" + new String(bytes) + "]");
		}
		
		if (flag) {
			/*
			 * socket test
			 */
			Socket socket = new Socket("174.100.67.129", 64000);
			if (flag) System.out.println("STATUS : connection is OK!!!");
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			byte[] bytes = null;
			
			if (flag) {
				/*
				 * make send packet
				 */
				bytes = EnumField.makeBytes();
				
				BUSI_DT       .setVal(bytes, "20151209");
				TRADE_GENTD_DT.setVal(bytes, "1209");
				TRADE_GENTD_TM.setVal(bytes, "121212");
				
				if (!flag) System.out.println("[" + new String(bytes) + "]");
			}
			
			if (flag) {
				/*
				 * send request
				 */
				dos.write(bytes, 0, EnumField.lenTotal); dos.flush();
				if (flag) System.out.printf("-> SEND DATA [%s]\n", new String(bytes));
			}
			
			if (flag) {
				/*
				 * recv response
				 */
				byte[] len = recv(socket, dis, 4);
				int size = Integer.parseInt(new String(len));
				if (flag) System.out.printf("<- RECV LEN [%s][%d]\n", new String(len), size);
				
				byte[] data = recv(socket, dis, size - 4);
				if (flag) System.out.printf("<- RECV DATA [%s]\n", new String(data));
			}
			
			dis.close();
			dos.close();
			socket.close();
		}
	}
}
