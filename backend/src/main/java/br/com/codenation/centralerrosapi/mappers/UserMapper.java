package br.com.codenation.centralerrosapi.mappers;

import br.com.codenation.centralerrosapi.dto.UserDTO;
import br.com.codenation.centralerrosapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.io.InvalidObjectException;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User entity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
    })
    User toEntity(UserDTO dto) throws InvalidObjectException;

}
