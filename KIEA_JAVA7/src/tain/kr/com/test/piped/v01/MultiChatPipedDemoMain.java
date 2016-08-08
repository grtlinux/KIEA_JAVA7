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
package tain.kr.com.test.piped.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MultiChatPipedDemoMain.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 *
 * ����PC����(Java)�� �ټ�Ŭ���̾�Ʈ(Android) ���� ��������� �̿��� ��Ƽä��
 * 
 * Android 2015.07.01 17:41
 * 
 * ���� PC������ �ټ��� Android Device�� �����Ͽ� ä���ϴ� ������Ʈ�Դϴ�
 * �ִ� ���Ӱ����� Android Device�� ������ Ȯ�ε����ʾ�����
 * ���������� 3���� Android Device�� �������� Ȯ���߽��ϴ�.
 * ���� ���ӵǾ��ִ� Device���� Mac�ּҸ��̿��Ͽ� �����̵ǵ����߰�
 * �����ڼ��� ����ø޼������ ���� ������������ ��ɵ��� ���� �����������ؼ�
 * ������ ������Ʈ�ϰڽ��ϴ�.
 * Mac�ּҸ� �޾ƿ������ؼ��� wifimanagerŬ�������ʿ��ѵ�
 * �׺κп����ؼ��� ���� �ۼ��ϰڽ��ϴ�.
 * 
 * 
 * -------------- Server.java (PC) ----------------------------------------------------------------------------------------------
 * 
 * import java.io.DataInputStream;
 * import java.io.DataOutputStream;
 * import java.io.IOException;
 * import java.io.OutputStream;
 * import java.net.InetAddress;
 * import java.net.ServerSocket;
 * import java.net.Socket;
 * import java.util.Collections;
 * import java.util.HashMap;
 * import java.util.Iterator;
 *  
 * public class SocketClient {
 *  
 *     HashMap<String, DataOutputStream> clients;
 *     private ServerSocket ServerSocket = null;
 *  
 *     public static void main(String[] args) {
 *         new SocketClient().start();
 *     }
 *  
 *     public SocketClient() {
 *  
 *         // ����� hashmap ������(Key, value) ����
 *         clients = new HashMap<String, DataOutputStream>();
 *         // clients ����ȭ
 *         Collections.synchronizedMap(clients);
 *     }
 *  
 *     private void start() {
 *         
 *         // Port ���� ���Ǹ����� 5001�� ���� (Random������ ���氡��)
 *         int port = 5001;
 *         Socket socket = null;
 *  
 *         try {
 *             // �������� ������ while������ �����Ͽ� accept(���)�ϰ� ���ӽ� ip�ּҸ� ȹ���ϰ� ����ѵ�
 *             // MultiThread�� �����Ѵ�.
 *             ServerSocket = new ServerSocket(port);
 *             System.out.println("���Ӵ����");
 *             while (true) {
 *                 socket = ServerSocket.accept();
 *                 InetAddress ip = socket.getInetAddress();
 *                 System.out.println(ip + "  connected");
 *                 new MultiThread(socket).start();
 *             }
 *         } catch (IOException e) {
 *             System.out.println(e);
 *         }
 *     }
 *  
 *     class MultiThread extends Thread {
 *  
 *         Socket socket = null;
 *  
 *         String mac = null;
 *         String msg = null;
 *  
 *         DataInputStream input;
 *         DataOutputStream output;
 *  
 *         public MultiThread(Socket socket) {
 *             this.socket = socket;
 *             try {
 *                 // ��ü�� �ְ���� Stream�����ڸ� �����Ѵ�.
 *                 input = new DataInputStream(socket.getInputStream());
 *                 output = new DataOutputStream(socket.getOutputStream());
 *             } catch (IOException e) {
 *             }
 *         }
 *  
 *         public void run() {
 *  
 *             try {
 *                 // ���ӵ��� �ٷ� Mac �ּҸ� �޾ƿ� ����ϰ� clients�� ������ �Ѱ��ְ� Ŭ���̾�Ʈ���� mac�ּҸ�������.
 *                 mac = input.readUTF();
 *                 System.out.println("Mac address : " + mac);
 *                 clients.put(mac, output);
 *                 sendMsg(mac + "   ����");
 *  
 *                 // ���Ŀ� ä�ø޼������Ž�
 *                 while (input != null) {
 *                     try {
 *                         String temp = input.readUTF();
 *                         sendMsg(temp);
 *                         System.out.println(temp);
 *                     } catch (IOException e) {
 *                         sendMsg("No massege");
 *                         break;
 *                     }
 *                 }
 *             } catch (IOException e) {
 *                 System.out.println(e);
 *             }
 *         }
 *  
 *         // �޼��������� Ŭ���̾�Ʈ���� Return �� sendMsg �޼ҵ�
 *         private void sendMsg(String msg) {
 *  
 *             // clients�� Key���� �޾Ƽ� String �迭�μ���
 *             Iterator<String> it = clients.keySet().iterator();
 *  
 *             // Return �� key���� ����������
 *             while (it.hasNext()) {
 *                 try {
 *                     OutputStream dos = clients.get(it.next());
 *                     // System.out.println(msg);
 *                     DataOutputStream output = new DataOutputStream(dos);
 *                     output.writeUTF(msg);
 *  
 *                 } catch (IOException e) {
 *                     System.out.println(e);
 *                 }
 *             }
 *         }
 *     }
 * }
 * 
 * 
 * -------------- Client.java (Android) ----------------------------------------------------------------------------------------------
 * 
 * package com.example.sockettest_1;
 *  
 * import java.io.BufferedReader;
 * import java.io.DataInputStream;
 * import java.io.DataOutputStream;
 * import java.io.IOException;
 * import java.io.OutputStream;
 * import java.io.PipedInputStream;
 * import java.io.PipedOutputStream;
 * import java.net.Socket;
 * import java.util.LinkedList;
 *  
 * import android.app.Activity;
 * import android.net.wifi.WifiInfo;
 * import android.net.wifi.WifiManager;
 * import android.os.Bundle;
 * import android.os.Handler;
 * import android.os.Message;
 * import android.util.Log;
 * import android.view.View;
 * import android.widget.Button;
 * import android.widget.EditText;
 * import android.widget.TextView;
 *  
 * public class MainActivity extends Activity {
 *  
 *     // private static int port = 5001;
 *     // private static final String ipText = "192.168.0.7"; // IP�������� ���ÿ� �� �ڵ�
 *     String streammsg = "";
 *     TextView showText;
 *     Button connectBtn;
 *     Button Button_send;
 *     EditText ip_EditText;
 *     EditText port_EditText;
 *     EditText editText_massage;
 *     Handler msghandler;
 *  
 *     SocketClient client;
 *     ReceiveThread receive;
 *     SendThread send;
 *     Socket socket;
 *  
 *     PipedInputStream sendstream = null;
 *     PipedOutputStream receivestream = null;
 *  
 *     LinkedList<SocketClient> threadList;
 *  
 *     @Override
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.main);
 *  
 *         ip_EditText = (EditText) findViewById(R.id.ip_EditText);
 *         port_EditText = (EditText) findViewById(R.id.port_EditText);
 *         connectBtn = (Button) findViewById(R.id.connect_Button);
 *         showText = (TextView) findViewById(R.id.showText_TextView);
 *         editText_massage = (EditText) findViewById(R.id.editText_massage);
 *         Button_send = (Button) findViewById(R.id.Button_send);
 *         threadList = new LinkedList<MainActivity.SocketClient>();
 *  
 *         ip_EditText.setText("192.168.0.7");
 *         port_EditText.setText("5001");
 *  
 *         // ReceiveThread�����ؼ� ���� �޼����� Handler�� MainThread���� ó��(�ܺ�Thread������ UI�����̺Ұ�)
 *         msghandler = new Handler() {
 *             @Override
 *             public void handleMessage(Message hdmsg) {
 *                 if (hdmsg.what == 1111) {
 *                     showText.append(hdmsg.obj.toString() + "\n");
 *                 }
 *             }
 *         };
 *  
 *         // �����ư Ŭ�� �̺�Ʈ
 *         connectBtn.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View arg0) {            
 *                 //Client �����
 *                 client = new SocketClient(ip_EditText.getText().toString(),
 *                         port_EditText.getText().toString());
 *                 threadList.add(client);
 *                 client.start();
 *             }
 *         });
 *  
 *         //���� ��ư Ŭ�� �̺�Ʈ
 *         Button_send.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View arg0) {
 *                 
 *                 //SendThread ����
 *                 if (editText_massage.getText().toString() != null) {
 *                     send = new SendThread(socket);
 *                     send.start();
 *  
 *                     //������ edittext �ʱ�ȭ
 *                     editText_massage.setText("");
 *                 }
 *             }
 *         });
 *     }
 *  
 *     class SocketClient extends Thread {
 *         boolean threadAlive;
 *         String ip;
 *         String port;
 *         String mac;
 *  
 *         //InputStream inputStream = null;
 *         OutputStream outputStream = null;
 *         BufferedReader br = null;
 *  
 *         private DataOutputStream output = null;
 *  
 *         public SocketClient(String ip, String port) {
 *             threadAlive = true;
 *             this.ip = ip;
 *             this.port = port;
 *         }
 *  
 *         @Override
 *         public void run() {
 *  
 *             try {
 *                 // ������ �ٷ� ReceiveThread ����
 *                 socket = new Socket(ip, Integer.parseInt(port));
 *                 //inputStream = socket.getInputStream();
 *                 output = new DataOutputStream(socket.getOutputStream());
 *                 receive = new ReceiveThread(socket);
 *                 receive.start();
 *                 
 *                 //mac�ּҸ� �޾ƿ������� ����
 *                 WifiManager mng = (WifiManager) getSystemService(WIFI_SERVICE);
 *                 WifiInfo info = mng.getConnectionInfo();
 *                 mac = info.getMacAddress();
 *                 
 *                 //mac ����
 *                 output.writeUTF(mac);
 *  
 *             } catch (IOException e) {
 *                 e.printStackTrace();
 *             }
 *         }
 *     }
 *  
 *     class ReceiveThread extends Thread {
 *         private Socket socket = null;
 *         DataInputStream input;
 *  
 *         public ReceiveThread(Socket socket) {
 *             this.socket = socket;
 *             try{
 *                 input = new DataInputStream(socket.getInputStream());            
 *             }catch(Exception e){            
 *             }
 *         }
 *         // �޼��� ������ Handler�� ����
 *         public void run() {
 *             try {
 *                 while (input != null) {
 *                     
 *                     String msg = input.readUTF();
 *                     if (msg != null) {
 *                         Log.d(ACTIVITY_SERVICE, "test");
 *  
 *                         Message hdmsg = msghandler.obtainMessage();
 *                         hdmsg.what = 1111;
 *                         hdmsg.obj = msg;
 *                         msghandler.sendMessage(hdmsg);
 *                         Log.d(ACTIVITY_SERVICE,hdmsg.obj.toString());                    
 *                     }
 *                 }
 *             } catch (IOException e) {
 *                 e.printStackTrace();
 *             }
 *         }
 *     }
 *  
 *     class SendThread extends Thread {
 *         private Socket socket;
 *         String sendmsg = editText_massage.getText().toString();
 *         DataOutputStream output;
 *  
 *         public SendThread(Socket socket) {
 *             this.socket = socket;
 *             try {
 *                 output = new DataOutputStream(socket.getOutputStream());
 *             } catch (Exception e) {
 *             }
 *         }
 *  
 *         public void run() {
 *  
 *             try {
 *                 
 *                 // �޼��� ���ۺ� (������ �ĺ��ϱ����� ������� mac�� ���)
 *                 Log.d(ACTIVITY_SERVICE, "11111");
 *                 String mac = null;
 *                 WifiManager mng = (WifiManager) getSystemService(WIFI_SERVICE);
 *                 WifiInfo info = mng.getConnectionInfo();
 *                 mac = info.getMacAddress();
 *  
 *                 if (output != null) {
 *                     if (sendmsg != null) {
 *                         output.writeUTF(mac + "  :  " +sendmsg);
 *                     }
 *                 }
 *             } catch (IOException e) {
 *                 e.printStackTrace();
 *             } catch (NullPointerException npe) {
 *                 npe.printStackTrace();
 *  
 *             }
 *         }
 *     }
 * }
 * 
 * -------------- Client.xml ----------------------------------------------------------------------------------------------
 * <?xml version="1.0" encoding="utf-8"?>
 * <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"
 *     android:orientation="vertical" >
 *  
 *     <LinearLayout
 *         android:layout_width="match_parent"
 *         android:layout_height="wrap_content"
 *         android:orientation="vertical" >
 *  
 *         <EditText
 *             android:id="@+id/ip_EditText"
 *             android:layout_width="match_parent"
 *             android:layout_height="wrap_content"
 *             android:hint="IP�ּҸ��Է��ϼ���" />
 *  
 *         <EditText
 *             android:id="@+id/port_EditText"
 *             android:layout_width="match_parent"
 *             android:layout_height="wrap_content"
 *             android:hint="PORT�ּҸ��Է��ϼ���" />
 *     </LinearLayout>
 *  
 *     <RelativeLayout
 *         android:layout_width="match_parent"
 *         android:layout_height="wrap_content"
 *         android:gravity="center" >
 *  
 *         <Button
 *             android:id="@+id/connect_Button"
 *             android:layout_width="match_parent"
 *             android:layout_height="wrap_content"
 *             android:text="����" />
 *     </RelativeLayout>
 *  
 *     <LinearLayout
 *         android:layout_width="match_parent"
 *         android:layout_height="wrap_content"
 *         android:layout_weight="1"
 *         android:orientation="horizontal" >
 *  
 *         <ScrollView
 *             android:layout_width="match_parent"
 *             android:layout_height="match_parent" >
 *  
 *             <TextView
 *                 android:id="@+id/showText_TextView"
 *                 android:layout_width="match_parent"
 *                 android:layout_height="match_parent"
 *                 android:text="" />
 *         </ScrollView>
 *     </LinearLayout>
 *  
 *     <LinearLayout
 *         android:layout_width="fill_parent"
 *         android:layout_height="wrap_content"
 *         android:orientation="horizontal" >
 *  
 *         <EditText
 *             android:id="@+id/editText_massage"
 *             android:layout_width="match_parent"
 *             android:layout_height="wrap_content"
 *             android:layout_weight="0.5"
 *             android:ems="10"
 *             android:hint="�޼������ۼ����ּ���" />
 *  
 *         <Button
 *             android:id="@+id/Button_send"
 *             android:layout_width="match_parent"
 *             android:layout_height="wrap_content"
 *             android:layout_weight="2"
 *             android:text="����" />
 *     </LinearLayout>
 *  
 * </LinearLayout>
 * 
 *
 */
@SuppressWarnings("unused")
public class MultiChatPipedDemoMain {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(MultiChatPipedDemoMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
