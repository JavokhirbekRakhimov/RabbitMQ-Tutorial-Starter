package uz.jokha.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OutPutDto implements Serializable {
    private String message;
    private LocalDateTime time=LocalDateTime.now();
}
