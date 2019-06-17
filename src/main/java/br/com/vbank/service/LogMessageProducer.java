package br.com.vbank.service;

import java.util.Hashtable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.google.gson.Gson;

@Startup
@Singleton
public class LogMessageProducer {

	InitialContext context;
	Connection connection;

	@PostConstruct
	private void start() {
		try {
			Map<String, String> jdniProperties = new Hashtable<>();
			jdniProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			jdniProperties.put(Context.PROVIDER_URL, "vm://localhost");
//			jdniProperties.put(, value)
//			https://stackoverflow.com/questions/453561/using-activemq-via-jndi
//			https://cwiki.apache.org/confluence/display/ACTIVEMQ/JNDI+Support
//			activemq context initialcontext
			
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
			connection = factory.createConnection();
			connection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PreDestroy
	private void end() {
		try {
			connection.close();
			context.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void produce(String log) {
		try {
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer producer = session.createProducer((Destination) new InitialContext().lookup("auditoria"));
			Message message = session.createTextMessage(new Gson().toJson(log));
			producer.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
