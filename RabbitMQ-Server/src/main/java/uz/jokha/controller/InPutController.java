package uz.jokha.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.jokha.constantence.RabbitMQConstants;
import uz.jokha.dto.InputDto;
import uz.jokha.service.RabbitMqService;


@RestController
@RequestMapping(path = "/inPut")
@RequiredArgsConstructor
public class InPutController {
    private final RabbitMqService rabbitMqService;
    @PutMapping
    private ResponseEntity<?>receive(@RequestBody InputDto inputDto){
        rabbitMqService.eniviaMessage(RabbitMQConstants.FILA_INPUT,inputDto);
        return ResponseEntity.ok("message receive inPut");
    }
}
