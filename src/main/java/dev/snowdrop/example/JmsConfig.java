import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import io.fabric8.amq.connector.AMQConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

    private static final String BROKER_URL = "tcp://localhost:61616"; // URL del broker
    private static final String BROKER_USERNAME = "admin"; // Nombre de usuario del broker
    private static final String BROKER_PASSWORD = "admin"; // Contraseña del broker

    @Bean
    public AMQConnectionFactory connectionFactory() {
        AMQConnectionFactory connectionFactory = new AMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        connectionFactory.setUserName(BROKER_USERNAME);
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
        factory.setConcurrency("3-10"); // Configurar concurrencia según tus necesidades
        return factory;
    }
}
