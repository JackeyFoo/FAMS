package bll.server;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import dal.model.ClientInfo;

public class FAMSClientInfos {
	
	public static Map<ClientInfo, Socket> termap = new HashMap<ClientInfo, Socket>();

}
