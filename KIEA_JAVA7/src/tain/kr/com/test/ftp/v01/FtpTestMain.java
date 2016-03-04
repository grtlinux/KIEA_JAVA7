package tain.kr.com.test.ftp.v01;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpTestMain {

	private static boolean flag = true;
	
	private static final String HOST = "174.100.67.129";
	private static final String PORT = "21";
	private static final String USER = "cmpn";
	private static final String PASS = "cmpn12#";

	private FTPClient ftpClient = null;
	private String path = null;

	public FtpTestMain() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean ftpConnection()
	{
		if (flag) {
			try {
				
				ftpClient = new FTPClient();
				ftpClient.setControlEncoding("EUC-KR");
				ftpClient.connect(HOST, Integer.parseInt(PORT));
				int reply = ftpClient.getReplyCode();
				if (!FTPReply.isPositiveCompletion(reply)) {
					// ������ ����
					if (flag) System.out.println(ftpClient.getReplyString());
					return false;
				}
				// ���� ����
				if (flag) System.out.println(ftpClient.getReplyString());
				
				// TIMEOUT ����
				ftpClient.setSoTimeout(10000);
				
				// ����� ����
				if (!ftpClient.login(USER, PASS)) {
					// ��������
					if (flag) System.out.println(ftpClient.getReplyString());
					return false;
				}
				if (flag) System.out.println(ftpClient.getReplyString());
				
				// Passive Mode
				ftpClient.enterLocalPassiveMode();
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}

	private boolean ftpDisconnection()
	{
		if (flag) {
			if (ftpClient != null && ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
					if (flag) System.out.println("FTP disconnect..");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}

	@SuppressWarnings("unused")
	private void makeWorkingFolder(String path)
	{
		if (flag) {
			try {
				ftpClient.makeDirectory(path);
				if (!flag) System.out.println(ftpClient.getReplyString());
				if (flag) System.out.printf("[%s] ������ �����..\n", path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void setWorkingFolder(String path)
	{
		if (flag) {
			try {
				ftpClient.changeWorkingDirectory(path);
				if (!flag) System.out.println(ftpClient.getReplyString());
				if (flag) System.out.printf("[%s] ������ �̵��Ѵ�.\n", path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unused")
	private List<String> getRemoteList()
	{
		List<String> list = null;
		
		if (flag) {
			try {
				list = Arrays.asList(ftpClient.listNames());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	@SuppressWarnings("unused")
	private void storeFiles(String fileName)
	{
		if (flag) {
			try {
				ftpClient.setFileType(FTP.STREAM_TRANSFER_MODE); // Default
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

				InputStream is = new FileInputStream(new File(this.path + "/" + fileName));
				ftpClient.storeFile(fileName, is);
				is.close();
				if (flag) System.out.printf("[%s] ������ upload �Ϸ� !!!\n", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void sendFtp()
	{
		if (flag) {
			if (ftpConnection()) {
				// ���� ����
				if (flag) System.out.printf("FTP server connection is OK !!!.\n");

//				List<String> list = null;
//				boolean flg = true;
//				
//				// FTP ROOT ����
//				setWorkingFolder("/");
//				list = getRemoteList();
//				flg = true;
//				for (String item : list) {
//					if (item.equals(ftpInfo.getRDate())) {
//						flg = false;
//						break;
//					}
//				}
//				
//				if (flg) {
//					// rdate������ Ȯ���Ͽ� ������ �����.
//					makeWorkingFolder(ftpInfo.getRDate());
//				}
//				
//				// rdate������ �̵��Ѵ�.
//				setWorkingFolder(ftpInfo.getRDate());
//				list = getRemoteList();
//				flg = true;
//				for (String item : list) {
//					if (item.equals(ftpInfo.getJobId())) {
//						flg = false;
//						break;
//					}
//				}
//
//				if (flg) {
//					// jobId������ Ȯ���Ͽ� ������ �����.
//					makeWorkingFolder(ftpInfo.getJobId());
//				}
//				
//				// jobId������ �̵��Ѵ�.
//				setWorkingFolder(ftpInfo.getJobId());
//				
//				// csv ���ϵ��� �����Ѵ�.
//				for (String fileName : ftpInfo.getList()) {
//					storeFiles(fileName);
//				}
				
			} else {
				// ���� ����
				if (flag) System.out.printf("FTP server refused connection.\n");
			}
		}
		
		if (flag) {
			ftpDisconnection();
		}
	}

	private static void test01(String[] args) {
		
		if (flag) {
			new FtpTestMain().sendFtp();
		}
	}

	public static void main(String[] args) {
		if (!flag) test01(args);
	}
}
