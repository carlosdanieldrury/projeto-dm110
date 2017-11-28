package br.inatel.drury.projeto.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.inatel.drury.projeto.dao.NetworkDao;

public class NetworkIPFinder {

	
	public static List<String> getIPList(String networkIp, int cidr) {
		List<String> ipList = generateIps(networkIp, cidr);
		
		List<String> ipEquipementOn = new ArrayList<String>();
		
		for (String ip : ipList) {
			if (execPing(ip)) {
				ipEquipementOn.add(ip);
			}
		}
		
		return ipEquipementOn;
	}
	
	public static boolean execPing(String address) {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("ping -n 1 " + address);
			InputStream is = process.getInputStream();
			InputStream es = process.getErrorStream();
			String input = processStream(is);
			String error = processStream(es);
			int code = process.waitFor();
			if (code != 0) {
				return false;
			}
			if (error.length() > 0) {
				return false;
			}
			if (input.contains("Host de destino inacess") || input.contains("Destination host unreachable")) {
				return false;
			}
			return true;
		} catch (IOException | InterruptedException e) {
			return false;
		}
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
	
	public static String processStream(InputStream is) {
		StringBuilder input = new StringBuilder();
		try (Scanner scanner = new Scanner(is)) {
			while (scanner.hasNextLine()) {
				input.append(scanner.nextLine()).append("\n");
			}
		}
		return input.toString();
	}

	
}
