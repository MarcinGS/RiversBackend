package com.golismarcin.riverslevelmonitor.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.golismarcin.riverslevelmonitor.security.model.RiverUserDetails;
import com.golismarcin.riverslevelmonitor.security.model.User;
import com.golismarcin.riverslevelmonitor.security.model.UserRole;
import com.golismarcin.riverslevelmonitor.security.repository.UserRepository;
import com.golismarcin.riverslevelmonitor.userList.service.UserListService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private UserListService userListService;
    private long expirationTime;
    private String secret;

    LoginController(AuthenticationManager authenticationManager,
                    UserRepository userRepository,
                    UserListService userListService,
                    @Value("${jwt.expirationTime}") long expirationTime,
                    @Value("${jwt.secret}") String secret) {
        this.authenticationManager = authenticationManager;
        this.expirationTime = expirationTime;
        this.secret = secret;
        this.userRepository = userRepository;
        this.userListService = userListService;
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginCredentials loginCredentials){
        User user = userRepository.findByUsername(loginCredentials.getUsername()).orElseThrow();
        return authenticate(user.getId(), loginCredentials.getPassword());
    }

    @PostMapping("/register")
    public Token register(@RequestBody @Valid RegisterCredentials registerCredentials){
        if(!registerCredentials.getPassword().equals(registerCredentials.getRepeatPassword())){
            throw new IllegalArgumentException("Hasła nie są takie same");
        }
        if(userRepository.existsByUsername(registerCredentials.getUsername())){
            throw new IllegalArgumentException("Użytkownik już istnieje");
        }
         User user = userRepository.save(User.builder()
                        .username(registerCredentials.getUsername())
                        .password("{bcrypt}" + new BCryptPasswordEncoder().encode(registerCredentials.getPassword()))
                        .enabled(true)
                        .authorities(List.of(UserRole.ROLE_CUSTOMER))
                        .build());
        userListService.createNewUserList(user.getId());
       return authenticate(user.getId(), registerCredentials.getPassword());
    }

    private Token authenticate(Long username, String password) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        RiverUserDetails principal = (RiverUserDetails) authenticate.getPrincipal();
        String token = JWT.create()
                .withSubject(String.valueOf(principal.getId()))
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
        return new Token(token, principal.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .filter(r -> UserRole.ROLE_ADMIN.name().equals(r))
                .map(r -> true)
                .findFirst()
                .orElse(false));
    }

    @Getter
    private static class LoginCredentials{
        private String username;
        private String password;
    }

    @Getter
    private static class RegisterCredentials{
        @Email
        private String username;
        @NotBlank
        private String password;
        @NotBlank
        private String repeatPassword;
    }

    @Getter
    @AllArgsConstructor
    private static class Token{
        private String token;
        private boolean adminAccess;
    }
}
