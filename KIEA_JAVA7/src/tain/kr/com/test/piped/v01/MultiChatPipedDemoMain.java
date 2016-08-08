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
 * 단일PC서버(Java)와 다수클라이언트(Android) 간의 소켓통신을 이용한 멀티채팅
 * 
 * Android 2015.07.01 17:41
 * 
 * 단일 PC서버에 다수의 Android Device가 접속하여 채팅하는 프로젝트입니다
 * 최대 접속가능한 Android Device의 갯수는 확인되지않았지만
 * 개인적으로 3대의 Android Device도 가능함을 확인했습니다.
 * 각각 접속되어있는 Device들은 Mac주소를이용하여 구분이되도록했고
 * 접속자수와 퇴장시메세지등등 아직 구현되지않은 기능들은 차후 열심히공부해서
 * 변경후 업데이트하겠습니다.
 * Mac주소를 받아오기위해서는 wifimanager클래스가필요한데
 * 그부분에대해서는 따로 작성하겠습니다.
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
 *         // 연결부 hashmap 생성자(Key, value) 선언
 *         clients = new HashMap<String, DataOutputStream>();
 *         // clients 동기화
 *         Collections.synchronizedMap(clients);
 *     }
 *  
 *     private void start() {
 *         
 *         // Port 값은 편의를위해 5001로 고정 (Random값으로 변경가능)
 *         int port = 5001;
 *         Socket socket = null;
 *  
 *         try {
 *             // 서버소켓 생성후 while문으로 진입하여 accept(대기)하고 접속시 ip주소를 획득하고 출력한뒤
 *             // MultiThread를 생성한다.
 *             ServerSocket = new ServerSocket(port);
 *             System.out.println("접속대기중");
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
 *                 // 객체를 주고받을 Stream생성자를 선언한다.
 *                 input = new DataInputStream(socket.getInputStream());
 *                 output = new DataOutputStream(socket.getOutputStream());
 *             } catch (IOException e) {
 *             }
 *         }
 *  
 *         public void run() {
 *  
 *             try {
 *                 // 접속된후 바로 Mac 주소를 받아와 출력하고 clients에 정보를 넘겨주고 클라이언트에게 mac주소를보낸다.
 *                 mac = input.readUTF();
 *                 System.out.println("Mac address : " + mac);
 *                 clients.put(mac, output);
 *                 sendMsg(mac + "   접속");
 *  
 *                 // 그후에 채팅메세지수신시
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
 *         // 메세지수신후 클라이언트에게 Return 할 sendMsg 메소드
 *         private void sendMsg(String msg) {
 *  
 *             // clients의 Key값을 받아서 String 배열로선언
 *             Iterator<String> it = clients.keySet().iterator();
 *  
 *             // Return 할 key값이 없을때까지
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
 *     // private static final String ipText = "192.168.0.7"; // IP지정으로 사용시에 쓸 코드
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
 *         // ReceiveThread를통해서 받은 메세지를 Handler로 MainThread에서 처리(외부Thread에서는 UI변경이불가)
 *         msghandler = new Handler() {
 *             @Override
 *             public void handleMessage(Message hdmsg) {
 *                 if (hdmsg.what == 1111) {
 *                     showText.append(hdmsg.obj.toString() + "\n");
 *                 }
 *             }
 *         };
 *  
 *         // 연결버튼 클릭 이벤트
 *         connectBtn.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View arg0) {            
 *                 //Client 연결부
 *                 client = new SocketClient(ip_EditText.getText().toString(),
 *                         port_EditText.getText().toString());
 *                 threadList.add(client);
 *                 client.start();
 *             }
 *         });
 *  
 *         //전송 버튼 클릭 이벤트
 *         Button_send.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View arg0) {
 *                 
 *                 //SendThread 시작
 *                 if (editText_massage.getText().toString() != null) {
 *                     send = new SendThread(socket);
 *                     send.start();
 *  
 *                     //시작후 edittext 초기화
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
 *                 // 연결후 바로 ReceiveThread 시작
 *                 socket = new Socket(ip, Integer.parseInt(port));
 *                 //inputStream = socket.getInputStream();
 *                 output = new DataOutputStream(socket.getOutputStream());
 *                 receive = new ReceiveThread(socket);
 *                 receive.start();
 *                 
 *                 //mac주소를 받아오기위해 설정
 *                 WifiManager mng = (WifiManager) getSystemService(WIFI_SERVICE);
 *                 WifiInfo info = mng.getConnectionInfo();
 *                 mac = info.getMacAddress();
 *                 
 *                 //mac 전송
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
 *         // 메세지 수신후 Handler로 전달
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
 *                 // 메세지 전송부 (누군지 식별하기위한 방법으로 mac를 사용)
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
 *             android:hint="IP주소를입력하세요" />
 *  
 *         <EditText
 *             android:id="@+id/port_EditText"
 *             android:layout_width="match_parent"
 *             android:layout_height="wrap_content"
 *             android:hint="PORT주소를입력하세요" />
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
 *             android:text="연결" />
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
 *             android:hint="메세지를작성해주세요" />
 *  
 *         <Button
 *             android:id="@+id/Button_send"
 *             android:layout_width="match_parent"
 *             android:layout_height="wrap_content"
 *             android:layout_weight="2"
 *             android:text="전송" />
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
