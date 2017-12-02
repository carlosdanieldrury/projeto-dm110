package br.inatel.drury.projeto.network;

import java.io.Serializable;
import java.util.List;

public class ListNetwork implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> networkIps;

	public List<String> getNetworkIps() {
		return networkIps;
	}

	public void setNetworkIps(List<String> networkIps) {
		this.networkIps = networkIps;
	}
		
}
