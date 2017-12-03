package br.inatel.drury.projeto.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.drury.projeto.api.Equipment;
import br.inatel.drury.projeto.api.NetworkService;
import br.inatel.drury.projeto.interfaces.NetworkRemote;

@RequestScoped
public class NetworkServiceImpl implements NetworkService {
	
	@EJB(lookup = "java:app/projeto-ejb-0.1-SNAPSHOT/NetworkBean!br.inatel.drury.projeto.interfaces.NetworkRemote")
	private NetworkRemote networkRemote;

	@Override
	public void start(String ip, int cidr) {
		
		List<String> networkIps = NetworkIPFinder.getIPList(ip, cidr);
		List<String> ipToBeSent = new ArrayList<String>();
		
		for (String ipString : networkIps) {
			ipToBeSent.add(ipString);
			
			if (ipToBeSent.size() == 10) {
				networkRemote.insertEquipment(ipToBeSent);
				ipToBeSent = new ArrayList<>();
			}
			
		}
		
		if (ipToBeSent.size() > 0) {
			networkRemote.insertEquipment(ipToBeSent);
		}
		

	}

	@Override
	public Equipment getIpStatus(String ip) {
		return networkRemote.getEquipmentStatus(ip);
	}

}
