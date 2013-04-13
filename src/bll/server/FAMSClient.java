package bll.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

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

	public void initReadThread() {

		receive = new Thread() {

			public void run() {

				try {
					if (in == null) {
						in = new BufferedReader(new InputStreamReader(
								clientsocket.getInputStream()));
					}

					if (out == null) {
						out = new PrintWriter(clientsocket.getOutputStream());
					}
					
					if (outobject == null) {
						outobject = new ObjectOutputStream(clientsocket.getOutputStream());
					}

					if (clientsocket != null) {

						do{

							String cmd = in.readLine();

							if (cmd != null) {

								System.out.println(cmd);

								if (cmd.startsWith("MAC:")
										&& cmd.length() == 21) {

									connect = true;
									out.println("ACK");
									out.flush();

								} else if (cmd.startsWith("SCAN")) {

									String msg = in.readLine();

									System.out.println(msg);
									
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
