package br.com.codenation.logstackapi.dto.request;

import br.com.codenation.logstackapi.model.enums.LogEnvironment;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"name", "host", "ip", "environment"})
public class LogApplicationRequestDTO {

    @ApiModelProperty(value = "Nome da aplicação", position = 1, example = "logstack-api", required = true)
    @NotNull
    private String name;

    @ApiModelProperty(value = "Hostname da aplicação", position = 2, example = "logstack-api.herokuapp.com", required = true)
    @NotNull
    private String host;

    @ApiModelProperty(value = "Ip da aplicação", position = 3, example = "184.456.41.11", required = true)
    @NotNull
    private String ip;

    @ApiModelProperty(value = "Ambiente da aplicação", position = 4, example = "PRODUCTION", allowableValues = "DEVELOPMENT, TEST, PRODUCTION", required = true)
    @NotNull
    private LogEnvironment environment;

}
