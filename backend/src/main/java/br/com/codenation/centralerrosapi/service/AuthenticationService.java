package br.com.codenation.centralerrosapi.service;

import br.com.codenation.centralerrosapi.config.security.JWTUtils;
import br.com.codenation.centralerrosapi.dto.LoginDTO;
import br.com.codenation.centralerrosapi.model.UserAuth;
import br.com.codenation.centralerrosapi.service.exception.AuthorizationException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private JWTUtils jwt;
    private UserDetailsServiceImpl userDetailsService;
    private AuthenticationManager authenticationManager;

    public void validAuthentication(LoginDTO login) {
        if (login.getUsername() == null || login.getUsername() == null) {
            throw new AuthorizationException("Username or password invalids");
        }
        if (login.getPassword().length() < 8) {
            throw new IllegalArgumentException("The password needs to have at least 8 characters");
        }
    }

    public Authentication authenticate(AuthenticationManager authenticationManager, LoginDTO login) {

        validAuthentication(login);

        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword(), new ArrayList<>());
            return authenticationManager.authenticate(authToken);
        } catch (Exception e) {
            throw new AuthorizationException("User or password invalid");
        }
    }

    public String getUserAuthentication(Authentication auth) {
        return ((UserAuth) auth.getPrincipal()).getUsername();
    }

    public String getTokenAuthentication(LoginDTO login) {
        Authentication auth = authenticate(authenticationManager, login);
        String userAuth = getUserAuthentication(auth);
        String username = getUserByUsername(userAuth);
        return jwt.generateToken(username);
    }

    public String getUserByUsername(String username) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return userDetails.getUsername();
        } catch (UsernameNotFoundException e) {
            throw new AuthorizationException("Usuário ou senha inválido");
        }
    }


}
