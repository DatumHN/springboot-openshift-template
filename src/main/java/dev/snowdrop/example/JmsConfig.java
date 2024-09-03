import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {

    private static final String BROKER_URL = "tcp://localhost:61616"; // URL del broker de AMQ
    private static final String BROKER_USERNAME = "admin"; // Nombre de usuario del broker
    private static final String BROKER_PASSWORD = "admin"; // Contraseña del broker

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        connectionFactory.setUser(BROKER_USERNAME);
        connectionFactory.setPassword(BROKER_PASSWORD);
        return connectionFactory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(connectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(cachingConnectionFactory());
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(cachingConnectionFactory());
        factory.setConcurrency("3-10");
        return factory;
    }
}
