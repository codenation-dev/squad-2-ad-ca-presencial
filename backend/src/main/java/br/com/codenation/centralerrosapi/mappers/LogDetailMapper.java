package br.com.codenation.centralerrosapi.mappers;

import br.com.codenation.centralerrosapi.dto.LogDetailDTO;
import br.com.codenation.centralerrosapi.model.Log;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.io.InvalidObjectException;

@Mapper(componentModel = "spring")
public interface LogDetailMapper {

	public LogDetailDTO toDto(Log entity);

	@Mappings({
			@Mapping(source = "details", target = "details"),
	})
	public Log toEntity(LogDetailDTO dto) throws InvalidObjectException;

}
