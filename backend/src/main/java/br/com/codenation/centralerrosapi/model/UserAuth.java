package br.com.codenation.centralerrosapi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserAuth extends User {
    private static final long serialVersionUID = 510L;

    public UserAuth(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
    }

}
