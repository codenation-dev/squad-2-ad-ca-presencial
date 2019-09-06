package br.com.codenation.centralerrosapi.service;

import br.com.codenation.centralerrosapi.model.User;
import br.com.codenation.centralerrosapi.model.UserAuth;
import br.com.codenation.centralerrosapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new UserAuth(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());

    }
}
