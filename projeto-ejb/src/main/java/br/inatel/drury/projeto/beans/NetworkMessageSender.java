package br.inatel.drury.projeto.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class NetworkMessageSender {
	
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName = "java:/jms/queue/dm110queue")
	private Queue queue;
	public void sendMessage(String text) {
		try (
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(queue);
		) {

			TextMessage textMessage = session.createTextMessage(text);
			producer.send(textMessage);
			
		} catch (JMSException e) {
		// exception handling
		}
	}

}
