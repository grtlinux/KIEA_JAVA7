/**
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc. all rights reserved.
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
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc.
 *
 */
package tain.kr.com.commons.daemon.v01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.commons.daemon.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainTest implements Daemon, Runnable, DaemonUserSignal {

	private ServerSocket server = null;
	private Thread thread = null;
	private DaemonController controller = null;
	private volatile boolean stopping = false;
	private String directory = null;
	private Vector<Handler> handlers = null;
	private boolean softReloadSignalled;
	
	public MainTest() {
		super();
		System.err.println("SimpleDaemon: instance " + this.hashCode() + " created.");
		this.handlers = new Vector<Handler>();
	}
	
	protected void finalize() {
		System.err.println("SimpleDaemon: instance " + this.hashCode() + " garbage collected.");
	}
	
	/* (non-Javadoc)
	 * @see tain.kr.com.commons.daemon.v01.Daemon#init(tain.kr.com.commons.daemon.v01.DaemonContext)
	 */
	@Override
	public void init(DaemonContext context) throws DaemonInitException,
			Exception {
		// TODO Auto-generated method stub
		System.err.println("SimpleDaemon: instance " + this.hashCode() + " init.");
		
		int port = 1200;
		
		String[] a = context.getArguments();
		
		if (a.length > 0)
			port = Integer.parseInt(a[0]);
		if (a.length > 1)
			this.directory = a[1];
		else
			this.directory = "/tmp";
		
		// dump a message
		System.err.println("SimpleDaemon: loading on port " + port);
		
		// set up this simple daemon
		this.controller = context.getController();
		this.server = new ServerSocket(port);
		this.thread = new Thread(this);
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.commons.daemon.v01.Daemon#start()
	 */
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		// dump a message
		System.err.println("SimpleDaemon: starting");
		
		// start
		this.thread.start();
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.commons.daemon.v01.Daemon#stop()
	 */
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		// dump a message
		System.err.println("SimpleDaemon: stopping");
		
		// close the serversocket, this will make our thread to terminate
		this.stopping = true;
		this.server.close();
		
		// wait for the main thread to exit and dump a message
		this.thread.join(5000);
		System.err.println("SimpleDaemon: stopped");
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.commons.daemon.v01.Daemon#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.err.println("SimpleDaemon: instance " + this.hashCode() + " destroy.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int number = 0;
		
		System.err.println("SimpleDaemon: started acceptor loop.");
		try {
			while (!this.stopping) {
				checkForReload();
				Socket socket = this.server.accept();
				checkForReload();
				
				Handler handler = new Handler(socket, this, this.controller);
				handler.setConnectionNumber(number++);
				handler.setDirectoryName(this.directory);
				new Thread(handler).start();
			}
		} catch (IOException e) {
			// TODO: handle exception
			// dont dump any error message if we are stopping. a ioexception
			// is generated when the serversocket is closed in stop
			if (!this.stopping) e.printStackTrace(System.err);
		}
		
		// terminate all handlers that at this point are still open
		Enumeration<Handler> openHandlers = this.handlers.elements();
		while (openHandlers.hasMoreElements()) {
			Handler handler = (Handler) openHandlers.nextElement();
			System.err.println("SimpleDaemon: dropping connection " + handler.getConnectionNumber());
			handler.close();
		}
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.commons.daemon.v01.DaemonUserSignal#signal()
	 */
	@Override
	public void signal() {
		// TODO Auto-generated method stub
		this.softReloadSignalled = true;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void checkForReload() {
		
		if (this.softReloadSignalled) {
			System.err.println("SimpleDaemon: picked up reload, waiting for connections to finish...");
			while (!this.handlers.isEmpty()) {}
			System.err.println("SimpleDaemon: all connections have finished, pretending to reload");
			this.softReloadSignalled = false;
		}
	}
	
	protected void addHandler(Handler handler) {
		
		synchronized (handler) {
			this.handlers.add(handler);
		}
	}
	
	protected void removeHandler(Handler handler) {
		
		synchronized (handler) {
			this.handlers.remove(handler);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static class Handler implements Runnable {
		
		private DaemonController controller = null;
		private MainTest parent = null;
		private String directory = null;
		private Socket socket = null;
		private int number = 0;
		
		public Handler(Socket socket, MainTest parent, DaemonController controller) {
			
			super();
			
			this.socket = socket;
			this.parent = parent;
			this.controller = controller;
		}
		
		@Override
		public void run() {
			
			this.parent.addHandler(this);
			System.err.println("SimpleDaemon: connection " + this.number + " opened from " + this.socket.getInetAddress());
			
			try {
				InputStream is = this.socket.getInputStream();
				OutputStream os = this.socket.getOutputStream();
				handle(is, os);
				this.socket.close();
			} catch (IOException e) {
				e.printStackTrace(System.err);
			}
			
			System.err.println("SimpleDaemon: connection " + this.number + " closed.");
			
			this.parent.removeHandler(this);
		}
		
		public void close() {
			
			try {
				this.socket.close();
			} catch (IOException e) {
				e.printStackTrace(System.err);
			}
		}
		
		public void setConnectionNumber(int number) {
			
			this.number = number;
		}
		
		public int getConnectionNumber() {
			
			return this.number;
		}
		
		public void setDirectoryName(String directory) {
			
			this.directory = directory;
		}
		
		public String getDirectoryName() {
			
			return this.directory;
		}
		
		public void log(String name) throws IOException {
			
			OutputStream file = new FileOutputStream(name, true);
			PrintStream out = new PrintStream(file);
			SimpleDateFormat fmt = new SimpleDateFormat();
			
			out.println(fmt.format(new Date()));
			out.close();
			file.close();
		}
		
		public void handle(InputStream is, OutputStream os) {
			
			PrintStream out = new PrintStream(os);
			
			while (true) {
				try {
					// if we dont have data in the system inputstrea, we want to ask to the user fro an option.
					if (is.available() == 0) {
						out.println();
						out.println("Please select one of the following:");
						out.println("    1) shutdown");
						out.println("    2) reload");
						out.println("    3) create a file");
						out.println("    4) disconnect");
						out.println("    5) soft reload");
						out.print("Your choice: ");
					}
					
					int no = is.read();
					
					switch (no) {
					case -1:
						// if the socket was closed, we simple return
						return;
						
					case 1:
						// attempt to shutdown
						out.println("attempting a shutdown....");
						try {
							this.controller.shutdown();
						} catch (IllegalStateException e) {
							out.println();
							out.println("Can't shutdown now");
							e.printStackTrace(out);
						}
						break;
						
					case 2:
						// attempt to reload
						out.println("attempting a reload....");
						try {
							this.controller.reload();
						} catch (IllegalStateException e) {
							out.println();
							out.println("Can't reload now");
							e.printStackTrace(out);
						}
						break;
						
					case 3:
						// create a file
						String name = this.getDirectoryName() + "/SimpleDaemon." + this.getConnectionNumber() + ".tmp";
						try {
							this.log(name);
							out.println("File '" + name + "' created");
						} catch (IOException e) {
							e.printStackTrace(out);
						}
						break;
						
					case 4:
						// disconnect
						out.println("Disconnecting...");
						return;
						
					case 5:
						// soft reload
						out.println("Reloading configuration...");
						this.parent.signal();
						return;

					case '\r':
					case '\n':
						// discard any carriage return newline characters
						break;
						
					default:
						// we get something that we werent supposed to get
						out.println("Unknown option '" + (char) no + "'");
						break;
					}
				} catch (IOException e) {
					// if we get an ioexception we return (disconnect)
					System.err.println("SimpleDaemon: IOException in connection " + this.getConnectionNumber());
					return;
				}
			}
		}
	}
}


































