package bll.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import bll.controll.Controller;

public class FAMSClient {

	private Socket clientsocket;
	private Thread receive;
	private ObjectOutputStream outobject = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	
	private boolean connect = false;

	public FAMSClient(Socket csocket) {

		this.clientsocket = csocket;

	}
	
	private void getBufferedReader() {

		try {
			if (in == null) {
				in = new BufferedReader(new InputStreamReader(
						clientsocket.getInputStream()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getPrintWriter() {

		try {
			if (out == null) {
				out = new PrintWriter(clientsocket.getOutputStream());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initReadThread() {

		receive = new Thread() {

			public void run() {

				try {
					
					getBufferedReader();

					if (clientsocket != null) {

						do{

							String cmd = in.readLine();
				
							if (cmd != null) {
								
								if (cmd.startsWith("MAC:")
										&& cmd.length() == 21) {
									
									getPrintWriter();

									connect = true;
									out.flush();
									out.println("ACK");
									out.flush();

								} else if (cmd.startsWith("SCAN")) {
									
									System.out.println(cmd);

									String msg = in.readLine();

									Controller.showScanResult(msg);
									
								}else if (cmd.startsWith("GET")) {

									String msg = in.readLine();

									Controller.showScanResult(msg);
									
								}

							}
						}while(connect);
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("close");
					try {

						in.close();
						clientsocket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}

		};

		receive.start();

	}
 
}
