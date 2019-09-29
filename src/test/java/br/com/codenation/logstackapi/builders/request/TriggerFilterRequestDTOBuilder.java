package br.com.codenation.logstackapi.builders.request;

import br.com.codenation.logstackapi.dto.request.TriggerFilterRequestDTO;
import br.com.codenation.logstackapi.model.enums.LogEnvironment;
import br.com.codenation.logstackapi.model.enums.LogLevel;

public class TriggerFilterRequestDTOBuilder {

    private TriggerFilterRequestDTO trigger;

    private TriggerFilterRequestDTOBuilder() {
    }

    public static TriggerFilterRequestDTOBuilder gatilho1() {
        TriggerFilterRequestDTOBuilder builder = new TriggerFilterRequestDTOBuilder();
        builder.trigger = TriggerFilterRequestDTO.builder().appName("Nome Aplicativo").environment(LogEnvironment.DEVELOPMENT).level(LogLevel.DEBUG).build();
        return builder;
    }

    public TriggerFilterRequestDTO build() {
        return trigger;
    }
}
