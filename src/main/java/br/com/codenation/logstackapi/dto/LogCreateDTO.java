package br.com.codenation.logstackapi.dto;

import br.com.codenation.logstackapi.model.entity.LogApplication;
import br.com.codenation.logstackapi.model.enums.LogLevel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
public class LogCreateDTO {
    @ApiModelProperty(value = "Title", example = "Null pointer exception", required = true)
    @Size(min = 2, max = 120)
    @NotNull
    private String title;

    @ApiModelProperty(value = "Dados da aplicação")
    private LogApplication application;

    @ApiModelProperty(value = "Nível do log", position = 4, example = "ERROR", allowableValues = "DEBUG, WARNING, ERROR")
    @NotNull
    private LogLevel level;

    @ApiModelProperty(value = "Timestamp", example = "2000-11-21 17:21:00")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    @ApiModelProperty(value = "Detalhe do erro", example = "Fatal error on line 45")
    @NotNull
    private String detail;
}