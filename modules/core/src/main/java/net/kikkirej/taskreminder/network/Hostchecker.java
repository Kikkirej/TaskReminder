package net.kikkirej.taskreminder.network;

import java.net.InetAddress;

public class Hostchecker {

	String hostname;
	
	public Hostchecker(String hostname) {
		this.hostname = hostname;
	}

	public boolean isHostOnline() {
		String ip = ipHandler();
		boolean reachable;
		try {
			InetAddress address = InetAddress.getByName(ip);
			reachable = address.isReachable(10000);
		} catch (Exception e) {
			reachable = false;
			e.printStackTrace();
		}
		return reachable;
	}
	
	public String ipHandler(){
		return hostname;
	}

}
