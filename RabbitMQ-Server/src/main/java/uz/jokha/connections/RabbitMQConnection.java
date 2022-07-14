package uz.jokha.connections;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;
import uz.jokha.constantence.RabbitMQConstants;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
    private final AmqpAdmin amqpAdmin;
    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin=amqpAdmin;
    }

    private static final String exchange = "amq.direct";
    private Queue fila(String nameFila){
        return new Queue(nameFila,true,false,false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(exchange);
    }
    private Binding binding(Queue fila,DirectExchange exchange){
      return   new Binding(fila.getName(), Binding.DestinationType.QUEUE, exchange.getName(), fila.getName(),null);
    }
    @PostConstruct
    private void adiciona(){
        Queue filaEstoque=fila(RabbitMQConstants.FILA_INPUT);
        Queue filaPreco=fila(RabbitMQConstants.FILA_OUTPUT);
        DirectExchange directExchange=directExchange();
        Binding bindingEstoque=binding(filaEstoque,directExchange);
        Binding bindingPreco=binding(filaPreco,directExchange);
        this.amqpAdmin.declareQueue(filaEstoque);
        this.amqpAdmin.declareQueue(filaPreco);
        this.amqpAdmin.declareExchange(directExchange);
        this.amqpAdmin.declareBinding(bindingEstoque);
        this.amqpAdmin.declareBinding(bindingPreco);
    }
}
