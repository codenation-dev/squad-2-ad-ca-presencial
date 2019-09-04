package br.com.codenation.centralerrosapi.dto;

import br.com.codenation.centralerrosapi.model.LogApplication;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class LogDTO {

    private UUID id;

    private String title;

    private LogApplication application;

    private Boolean archived;

    private LocalDateTime createdDate;

}
