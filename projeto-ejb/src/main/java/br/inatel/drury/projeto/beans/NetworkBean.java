package br.inatel.drury.projeto.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import br.inatel.drury.projeto.entities.Equipment;
import br.inatel.drury.projeto.dao.NetworkDao;
import br.inatel.drury.projeto.interfaces.NetworkLocal;
import br.inatel.drury.projeto.interfaces.NetworkRemote;
import br.inatel.drury.projeto.network.ListNetwork;


@Stateless
@Local(NetworkLocal.class)
@Remote(NetworkRemote.class)
public class NetworkBean implements NetworkLocal, NetworkRemote {
		
	@EJB
	NetworkDao networkDao;
	
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName = "java:/jms/queue/projetoqueue")
	private Queue queue;
	
	
	
	public void sendIps( ListNetwork listNetwork) {
		try (
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(queue);
		) {
			
			ObjectMessage objectMessage = session.createObjectMessage(listNetwork);			
			producer.send(objectMessage);
			
		} catch (JMSException e) {
		// exception handling
		}
	}
	
	@Override
	public String getEquipmentStatus(String ip) {
		return networkDao.getEquipmentStatus(ip);
	}
	
	

	@Override
	public void insertEquipment(List<String> networkIps) {
		// TODO Auto-generated method stub

		ListNetwork listObjects = new ListNetwork();
		listObjects.setNetworkIps(networkIps);
		
		sendIps(listObjects);
	}
	
}
