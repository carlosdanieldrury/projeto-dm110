package br.inatel.drury.projeto.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_projeto", sequenceName = "seq_projeto", allocationSize = 1)
public class Equipment {
	
	@Id
	@GeneratedValue(generator = "seq_projeto", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String ip;
	private boolean isUp;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isUp() {
		return isUp;
	}
	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}
	
	
	
	
}
