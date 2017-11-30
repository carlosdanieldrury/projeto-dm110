package br.inatel.drury.projeto.impl;

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
	public List<Equipment> getListEquipment(String ip, String mask) {
		return networkRemote.getEquipments();
	}

	@Override
	public Equipment getIpStatus(String ip) {
		return networkRemote.getEquipmentStatus(ip);
	}

}
