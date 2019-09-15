package br.com.codenation.logstackapi.service;

import br.com.codenation.logstackapi.dto.request.TriggerRequestDTO;
import br.com.codenation.logstackapi.model.entity.Trigger;

import java.util.List;
import java.util.UUID;

public interface TriggerService {

    Trigger save(TriggerRequestDTO dto);

    List<Trigger> findAll();

    Trigger findById(UUID id);

    public Trigger active(UUID id);

    public Trigger inactive(UUID id);

}
