package br.inatel.drury.projeto.interfaces;

import java.util.List;

import br.inatel.drury.projeto.api.Equipment;

public interface Network {
		
	Equipment getEquipmentStatus(String ip);
		
	void insertEquipment(List<String> networkIps);
	
}
