package net.kikkirej.taskreminder.network;

import java.net.InetAddress;

public class Hostchecker {

	String hostname;
	
	int timeout;
	
	public Hostchecker(String hostname) {
		this.hostname = hostname;
		timeout=10000;
	}

	public boolean isHostOnline() {
		String ip = ipHandler();
		boolean reachable;
		try {
			InetAddress address = InetAddress.getByName(ip);
			reachable = address.isReachable(timeout);
		} catch (Exception e) {
			reachable = false;
		}
		return reachable;
	}
	
	public String ipHandler(){
		return hostname;
	}

	/**
	 * just for Tests
	 */
	void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
