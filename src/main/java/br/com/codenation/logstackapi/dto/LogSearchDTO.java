package br.com.codenation.logstackapi.dto;

import br.com.codenation.logstackapi.model.enums.LogEnvironment;
import br.com.codenation.logstackapi.model.enums.LogLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogSearchDTO {

    private String title;
    private String appName;
    private String host;
    private String ip;
    private LogEnvironment environment;
    private LogLevel level;
    private LocalDateTime startTimestamp;
    private LocalDateTime endTimestamp;

}
