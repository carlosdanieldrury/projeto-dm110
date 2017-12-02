package br.inatel.drury.projeto.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.drury.projeto.entities.Equipment;
import br.inatel.drury.projeto.dao.NetworkDao;
import br.inatel.drury.projeto.interfaces.NetworkLocal;
import br.inatel.drury.projeto.interfaces.NetworkRemote;
import br.inatel.drury.projeto.network.ListNetwork;


@Stateless
@Local(NetworkLocal.class)
@Remote(NetworkRemote.class)
public class NetworkBean implements NetworkLocal, NetworkRemote {
	
	private NetworkMessageSender networkMessageSender;
	
	
	@Override
	public br.inatel.drury.projeto.api.Equipment getEquipmentStatus(String ip) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertEquipment(List<String> networkIps) {
		// TODO Auto-generated method stub
		ListNetwork listObjects = new ListNetwork();
		listObjects.setNetworkIps(networkIps);
		
		networkMessageSender.sendIps(listObjects);
	}
	
}
