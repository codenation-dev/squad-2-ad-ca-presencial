package br.com.codenation.centralerrosapi.service;

import br.com.codenation.centralerrosapi.dto.UserCreateDTO;
import br.com.codenation.centralerrosapi.model.User;
import br.com.codenation.centralerrosapi.repository.UserRepository;
import br.com.codenation.centralerrosapi.service.exception.ResourceExistsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private PasswordEncoder bCrypt;

    public User save(UserCreateDTO dto) throws InvalidObjectException {

        Optional<User> user = repository.findByUsername(dto.getUsername());
        if (user.isPresent()) {
            throw new ResourceExistsException("Username is exists");
        }

        User entity = User.builder()
                .username(dto.getUsername())
                .password(bCrypt.encode(dto.getPassword()))
                .build();

        return repository.save(entity);

    }

}
