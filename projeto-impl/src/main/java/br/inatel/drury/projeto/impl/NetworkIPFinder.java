package br.inatel.drury.projeto.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NetworkIPFinder {

	
	public static List<String> getIPList(String networkIp, int cidr) {
		List<String> ipList = generateIps(networkIp, cidr);
		
		List<String> ipEquipementOn = new ArrayList<String>();
		
		for (String ip : ipList) {
				ipEquipementOn.add(ip);
		}
		
		return ipEquipementOn;
	}
	

	private static List<String> generateIps(String networkIp, int cidr) {
		List<String> ipList = new ArrayList<String>();
		int rangeSize = 0;
		for (int i = 0; i < 32 - cidr; i++) {
			rangeSize |= 1 << i;
		}
		long networkAddress = fromIp(networkIp);
		//String[] ips = new String[rangeSize - 1];
		for (int i = 1; i < rangeSize; i++) {
			ipList.add(toIp(networkAddress + i));
			//ips[i - 1] = toIp(networkAddress + i);
		}
		//return ips;
		return ipList;
	}

	private static long fromIp(String ip) {
		String[] octs = ip.split("\\.");
		long octs1 = Long.parseLong(octs[0]);
		long octs2 = Long.parseLong(octs[1]);
		long octs3 = Long.parseLong(octs[2]);
		long octs4 = Long.parseLong(octs[3]);
		return (octs1 << 24) | (octs2 << 16) | (octs3 << 8) | octs4;
	}

	private static String toIp(long value) {
		return String.format("%s.%s.%s.%s", value >> 24, (value >> 16) & 255, (value >> 8) & 255, value & 255);
	}
	

	
}
