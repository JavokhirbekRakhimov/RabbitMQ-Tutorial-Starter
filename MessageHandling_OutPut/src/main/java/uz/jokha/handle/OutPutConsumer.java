package uz.jokha.handle;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import uz.jokha.constantence.RabbitMQConstants;
import uz.jokha.dto.OutPutDto;

@Component
public class OutPutConsumer {
    static  int count=1;
    @RabbitListener(queues = RabbitMQConstants.FILA_OUTPUT)
    private void consumer(OutPutDto outPutDto){
        System.out.println("========> " +count+" - message <=========");
        System.out.println("Message: "+outPutDto.getMessage());
        System.out.println("Time: "+ outPutDto.getTime());
        count++;
    }

}
