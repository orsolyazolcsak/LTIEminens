package com.orsolyazolcsak.allamvizsga.securingweb;

import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;

    public CustomAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("CustomAuthenticationProvider.authenticate");
        String username = authentication.getName();
        char[] password = authentication.getCredentials().toString().toCharArray();
        boolean passwordIsCorrect = userService.checkUser(username, password);
        if (!passwordIsCorrect) {
            throw new BadCredentialsException("Password and username don't match");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            String roleDescription = user.get().getRole().getDescription();
            grantedAuthorities.add(new SimpleGrantedAuthority(roleDescription));
        }
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
        System.out.println("auth = " + auth);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

