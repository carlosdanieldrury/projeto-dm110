package br.inatel.drury.projeto.beans;

import java.util.List;

import br.inatel.drury.projeto.api.Equipment;
import br.inatel.drury.projeto.interfaces.NetworkLocal;
import br.inatel.drury.projeto.interfaces.NetworkRemote;
import br.inatel.drury.projeto.network.NetworkIPFinder;

public class NetworkBean implements NetworkLocal, NetworkRemote {

	@Override
	public List<String> getAvailableEquipmentOnNetwork(String networkIp, int cidr) {
		return NetworkIPFinder.getIPList(networkIp, cidr);
	}
	
	@Override
	public Equipment getEquipmentStatus(String ip) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
