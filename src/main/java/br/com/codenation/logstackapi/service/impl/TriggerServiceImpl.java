package br.com.codenation.logstackapi.service.impl;

import br.com.codenation.logstackapi.dto.TriggerCreateDTO;
import br.com.codenation.logstackapi.exception.ResourceNotFoundException;
import br.com.codenation.logstackapi.mappers.TriggerMapper;
import br.com.codenation.logstackapi.model.entity.Trigger;
import br.com.codenation.logstackapi.repository.TriggerRepository;
import br.com.codenation.logstackapi.service.TriggerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TriggerServiceImpl implements TriggerService {

    private TriggerRepository triggerRepository;
    private TriggerMapper mapper;

    public Trigger save(TriggerCreateDTO dto) {
        if (dto.isNull()) throw new IllegalArgumentException("Deve informar no mínimo uma das opções de filtro");

        Trigger trigger = mapper.map(dto);
        trigger = triggerRepository.save(trigger);

        return trigger;
    }

    public List<Trigger> findAll() {
        return triggerRepository.findAll();
    }

    public Trigger findById(UUID id) {
        return triggerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gatilho não encontrado"));
    }
    public Trigger update(UUID id, TriggerCreateDTO dto) {

        if (dto.isNull()) throw new IllegalArgumentException("Deve informar no mínimo uma das opções de filtro");
        Trigger trigger=findById(id);
        trigger= mapper.map(dto);
        return triggerRepository.save(trigger);


    }

}