package bll.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import vl.util.NWEDialog;

public class FAMSServer {

	private static int port = 8888;
	private static ServerSocket serversocket = null;

	private static Thread listen = new Thread() {

		public void run() {

			while (true) {

				try {

					if (serversocket != null) {

						Socket clientsocket = serversocket.accept();

						FAMSClient client = new FAMSClient(clientsocket);

						client.initReadThread();

					} else {
						break;
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	};

	public static void startServer() {

		try {

			if (serversocket == null) {

				serversocket = new ServerSocket(port);

				NWEDialog.serverStartSuccess(null);
				
				listen.start();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void stopServer() {

		try {

			serversocket.close();
			serversocket = null;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
