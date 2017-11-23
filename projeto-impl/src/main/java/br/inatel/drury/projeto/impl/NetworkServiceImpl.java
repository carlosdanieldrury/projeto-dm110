package br.inatel.drury.projeto.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.inatel.drury.projeto.api.Equipment;
import br.inatel.drury.projeto.api.NetworkService;

@RequestScoped
public class NetworkServiceImpl implements NetworkService {
	
//	@EJB(lookup = "java:app/dm110-ejb-0.1-SNAPSHOT/HelloBean!br.inatel.dm110.hello.interfaces.HelloRemote")
//	private HelloRemote hello;


	@Override
	public List<Equipment> getListEquipment(String ip, String mask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipment getIpStatus(String ip) {
		// TODO Auto-generated method stub
		return null;
	}

}
