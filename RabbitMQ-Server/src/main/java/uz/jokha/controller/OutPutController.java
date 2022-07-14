package uz.jokha.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.jokha.constantence.RabbitMQConstants;
import uz.jokha.dto.OutPutDto;
import uz.jokha.service.RabbitMqService;


@RestController
@RequestMapping(path = "/outPut")
@RequiredArgsConstructor
public class OutPutController {
    private final RabbitMqService service;
    @PutMapping
    private ResponseEntity<?>receive(@RequestBody OutPutDto outPutDto){
       service.eniviaMessage(RabbitMQConstants.FILA_OUTPUT,outPutDto);
        return ResponseEntity.ok("message receive outPut");
    }
}
