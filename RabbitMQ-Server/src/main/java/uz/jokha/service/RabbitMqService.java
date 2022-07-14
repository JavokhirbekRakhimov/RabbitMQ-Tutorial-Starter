package uz.jokha.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RabbitMqService {
    @Autowired
    private  RabbitTemplate template;

    public void eniviaMessage(String nameFila,Object message){
        this.template.convertAndSend(nameFila,message);
    }
}
