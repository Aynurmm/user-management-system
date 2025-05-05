package az.academy.turing.usermanagementsystem.config;

import az.academy.turing.usermanagementsystem.helper.Sha256PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Sha256PasswordEncoder();
    }

}