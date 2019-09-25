package br.com.codenation.logstackapi.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlertRequestDTO {
    @ApiModelProperty(value = "Log ID", example = "f13903dc-dfca-11e9-8a34-2a2ae2dbcce4", required = true)
    private UUID logId;

    @ApiModelProperty(value = "Log Trigger", example = "f13903dc-dfca-11e9-8a34-2a2ae2dbcce4", required = true)
    private UUID triggerId;

}
