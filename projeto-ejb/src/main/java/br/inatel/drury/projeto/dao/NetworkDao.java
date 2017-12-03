package br.inatel.drury.projeto.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.inatel.drury.projeto.entities.Equipment;

@Stateless
public class NetworkDao {
	
	@PersistenceContext(unitName = "network")
	private EntityManager em;
	
	
	public void insertEquipment(Equipment equipment) {
		em.persist(equipment);
	}
	
	public List<Equipment> getEquipments() {
		return em.createQuery("from Equipment e", Equipment.class).getResultList();
	}
	
	public boolean getEquipmentStatus(String ip) {
		boolean result = em.createQuery("from Equipment e where ip = :ip ", Equipment.class)
				.setParameter("ip", ip)
				.getResultList()
				.get(0)
				.isUp();
		return result;
	}

}
