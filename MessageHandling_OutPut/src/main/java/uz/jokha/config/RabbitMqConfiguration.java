package uz.jokha.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
    /* optional*/
    @Bean
    public RabbitListenerContainerFactory<DirectMessageListenerContainer> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        DirectRabbitListenerContainerFactory directRabbitListenerContainerFactory = new DirectRabbitListenerContainerFactory();
        directRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        directRabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        directRabbitListenerContainerFactory.setPrefetchCount(2);
//        directRabbitListenerContainerFactory.setGlobalQos(true);
//        directRabbitListenerContainerFactory.setConsumersPerQueue(20);
        return directRabbitListenerContainerFactory;
    }
}
