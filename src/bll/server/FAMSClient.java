package bll.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import dal.model.Assets;
import dal.model.ClientInfo;
import bll.controll.Controller;

public class FAMSClient {

	private ClientInfo info;
	private Socket clientsocket;
	private Thread receive;

	private OutputStream socketout;
	private InputStream socketin;

	private ObjectInputStream inobject = null;
	private ObjectOutputStream outobject = null;
	private BufferedReader in = null;
	private PrintWriter out = null;

	private boolean connect = false;

	public FAMSClient(Socket csocket) {

		try {

			this.clientsocket = csocket;
			socketout = clientsocket.getOutputStream();
			socketin = clientsocket.getInputStream();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getBufferedReader() {

		if (in == null) {
			in = new BufferedReader(new InputStreamReader(socketin));
		}

	}

	private void getObjectInputStream() {

		try {
			if (inobject == null) {
				inobject = new ObjectInputStream(socketin);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getObjectOutputStream() {

		try {
			if (outobject == null) {
				outobject = new ObjectOutputStream(socketout);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getPrintWriter() {

		if (out == null) {
			out = new PrintWriter(socketout);
		}

	}

	public void initReadThread() {

		receive = new Thread() {

			public void run() {

				try {

					getBufferedReader();

					if (clientsocket != null) {

						do {

							String cmd = in.readLine();

							if (cmd != null) {

								System.out.println(cmd);

								if (cmd.equals("TERMINAL")) {

									getObjectInputStream();

									Object obj = inobject.readObject();

									info = (ClientInfo) obj;

									if (info != null) {
										getPrintWriter();
										connect = true;
										out.flush();
										out.println("ACK");
										out.flush();
										
										FAMSClientInfos.termap.put(info, clientsocket);
									}

								} else if (cmd.startsWith("SCAN")) {

									String msg = in.readLine();
									System.out.println(msg);
									Controller.showScanResult(msg);

								} else if (cmd.startsWith("GET")) {

									String msg = in.readLine();
									System.out.println(msg);

									getPrintWriter();

									out.println("Asset");
									out.flush();

									getObjectOutputStream();

									Assets asset = Controller.getAssets(msg);

									outobject.writeObject(asset);
									outobject.flush();

								}

							}
						} while (connect);
					}

				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("close");
					try {
						clientsocket.close();
						FAMSClientInfos.termap.remove(info);
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
