package br.inatel.drury.projeto.interfaces;

import java.util.List;

import br.inatel.drury.projeto.api.Equipment;

public interface Network {
	
	List<String> getAvailableEquipmentOnNetwork(String networkIp, int cidr);
	
	Equipment getEquipmentStatus(String ip);
	
	List<Equipment> getEquipments();
	
}
