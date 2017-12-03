package br.inatel.drury.projeto.api;

import java.io.Serializable;

public class Equipment implements Serializable {
	
	private String ip;
	
	private boolean status;
	
	public Equipment() {
		
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
