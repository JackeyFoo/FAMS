package dal.model;

import java.io.Serializable;



public class ClientInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mac;
	private String name;
	private String ip;

	public ClientInfo(String name, String mac, String ip) {

		this.mac = mac;
		this.name = name;
		this.ip = ip;

	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}