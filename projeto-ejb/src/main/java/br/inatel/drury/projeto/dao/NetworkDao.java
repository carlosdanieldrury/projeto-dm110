package br.inatel.drury.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.inatel.drury.projeto.entities.Equipment;

public class NetworkDao {
	
	@PersistenceContext(unitName = "network")
	private EntityManager em;
	
	
	public void insertEquipment(Equipment equipment) {
		em.persist(equipment);
	}
	
	public List<Equipment> getEquipments() {
		return em.createQuery("from Equipment e", Equipment.class).getResultList();
	}
	
	public Equipment getEquipmentStatus(String ip) {
		TypedQuery<Equipment> query = em.createQuery("from Cliente c where ip = :ip ", Equipment.class);
		query.setParameter("ip", ip);
		return query.getSingleResult();
	}

}
