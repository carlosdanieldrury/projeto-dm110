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
import br.inatel.drury.projeto.network.NetworkIPFinder;


@Stateless
@Local(NetworkLocal.class)
@Remote(NetworkRemote.class)
public class NetworkBean implements NetworkLocal, NetworkRemote {
	
	@EJB
	NetworkDao networkDao;

	@Override
	public List<String> getAvailableEquipmentOnNetwork(String networkIp, int cidr) {
		List<String> ipList = NetworkIPFinder.getIPList(networkIp, cidr);
		for (String ip : ipList) {
			Equipment equipment = new Equipment();
			equipment.setIp(ip);
			equipment.setUp(true);
			networkDao.insertEquipment(equipment);
		}
		
		return ipList;
	}
	
	@Override
	public br.inatel.drury.projeto.api.Equipment getEquipmentStatus(String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<br.inatel.drury.projeto.api.Equipment> getEquipments() {
		// TODO Auto-generated method stub
		List<br.inatel.drury.projeto.api.Equipment> equipments = new ArrayList<>();
		
		List<Equipment> listEntities = networkDao.getEquipments();
		
		for (Equipment entity : listEntities) {
			br.inatel.drury.projeto.api.Equipment equipment = new br.inatel.drury.projeto.api.Equipment();
			equipment.setIp(entity.getIp());
			equipment.setStatus(true);
			
			equipments.add(equipment);
		}
		
		return equipments;
	}
	
}
