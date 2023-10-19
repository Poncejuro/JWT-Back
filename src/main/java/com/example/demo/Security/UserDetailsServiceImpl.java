package com.example.demo.Security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;


@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        logger.debug("Intento de inicio de sesión de usuario: {}", username);
        var usuario = getById(username);

        if (usuario == null) {
            logger.debug("Usuario no encontrado: {}", username);
            throw new UsernameNotFoundException(username);
        }
        return User
                .withUsername(username)
                .password(usuario.password())
                .roles(usuario.roles().toArray(new String[0]))
                .build();
    }




    public record Usuario(String username, String password, Set<String> roles) {}

    public static Usuario getById(String username) {
        // "secreto" => [BCrypt] => "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq"
        var password = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";
        Usuario juan = new Usuario(
                "jcabelloc",
                password,
                Set.of("USER")
        );

        Usuario maria = new Usuario(
                "mlopez",
                password,
                Set.of("ADMIN")
        );
        var usuarios = List.of(juan, maria);

        return usuarios
                .stream()
                .filter(e -> e.username().equals(username))
                .findFirst()
                .orElse(null);
    }


}
