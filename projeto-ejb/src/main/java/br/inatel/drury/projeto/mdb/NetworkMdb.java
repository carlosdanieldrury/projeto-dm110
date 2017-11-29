package br.inatel.drury.projeto.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.inatel.drury.projeto.interfaces.NetworkLocal;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="java:/jms/queue/dm110queue"),
		@ActivationConfigProperty(propertyName="maxSession", propertyValue="5")
})
public class NetworkMdb implements MessageListener {
	
	@EJB
	NetworkLocal networkLocal;

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
