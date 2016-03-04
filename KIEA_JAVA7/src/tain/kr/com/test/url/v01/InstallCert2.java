package tain.kr.com.test.url.v01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class InstallCert2 {

	public static void main(String[] args) throws Exception {
		checkCert();
	}

	public static void checkCert() throws Exception {
		String host = "www.itis.or.kr";
		int port = 443;
		char[] passphrase = "changeit".toCharArray();

		File file = new File("jssecacerts");
		System.out.println(System.getProperty("java.home"));

		if (file.isFile() == false) {
			char SEP = File.separatorChar;
			File dir = new File(System.getProperty("java.home") + SEP + "lib" + SEP + "security");
			file = new File(dir, "jssecacerts");
			if (file.isFile() == false) {
				file = new File(dir, "cacerts");
			}
		}
		System.out.println("Loading KeyStore " + file + "...");
		InputStream in = new FileInputStream(file);
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		ks.load(in, passphrase);
		in.close();

		SSLContext context = SSLContext.getInstance("TLS");
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(ks);
		X509TrustManager defaultTrustManager = (X509TrustManager)tmf.getTrustManagers()[0];
		SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
		context.init(null, new TrustManager[] {tm}, null);
		SSLSocketFactory factory = context.getSocketFactory();

		System.out.println("Opening connection to " + host + ":" + port + "...");
		SSLSocket socket = (SSLSocket)factory.createSocket(host, port);
		socket.setSoTimeout(10000);
		try {
			System.out.println("Starting SSL handshake...");
			socket.startHandshake();
			socket.close();
			System.out.println();
			System.out.println("No errors, certificate is already trusted");
			return;
		} catch (SSLException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace(System.out);
		}

		X509Certificate[] chain = tm.chain;
		if (chain == null) {
			System.out.println("Could not obtain server certificate chain");
			return;
		}

		@SuppressWarnings("unused")
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//System.out.println();
		//System.out.println("Server sent " + chain.length + " certificate(s):");
		//System.out.println();
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		for (int i = 0; i < chain.length; i++) {
			X509Certificate cert = chain[i];
			//System.out.println
			//  (" " + (i + 1) + " Subject " + cert.getSubjectDN());
			//System.out.println("   Issuer  " + cert.getIssuerDN());
			sha1.update(cert.getEncoded());
			//System.out.println("   sha1    " + toHexString(sha1.digest()));
			md5.update(cert.getEncoded());
			//System.out.println("   md5     " + toHexString(md5.digest()));
			//System.out.println();
		}

		//System.out.println("Enter certificate to add to trusted keystore or 'q' to quit: [1]");
		//String line = reader.readLine().trim();
		//int k;
		//try {
		//    k = (line.length() == 0) ? 0 : Integer.parseInt(line) - 1;
		//} catch (NumberFormatException e) {
		//    System.out.println("KeyStore not changed");
		//    return;
		//}

		int k=0;
		X509Certificate cert = chain[k];
		String alias = host + "-" + (k + 1);
		ks.setCertificateEntry(alias, cert);

		OutputStream out = new FileOutputStream("jssecacerts");
		ks.store(out, passphrase);
		out.close();

		//System.out.println();
		//System.out.println(cert);
		//System.out.println();
		System.out.println("Added certificate to keystore 'jssecacerts' using alias '" + alias + "'");
	}

	private static final char[] HEXDIGITS = "0123456789abcdef".toCharArray();

	@SuppressWarnings("unused")
	private static String toHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 3);
		for (int b : bytes) {
			b &= 0xff;
			sb.append(HEXDIGITS[b >> 4]);
			sb.append(HEXDIGITS[b & 15]);
			sb.append(' ');
		}
		return sb.toString();
	}

	private static class SavingTrustManager implements X509TrustManager {

		private final X509TrustManager tm;
		private X509Certificate[] chain;

		SavingTrustManager(X509TrustManager tm) {
			this.tm = tm;
		}

		public X509Certificate[] getAcceptedIssuers() {
			throw new UnsupportedOperationException();
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			throw new UnsupportedOperationException();
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			this.chain = chain;
			tm.checkServerTrusted(chain, authType);
		}
	}
}
