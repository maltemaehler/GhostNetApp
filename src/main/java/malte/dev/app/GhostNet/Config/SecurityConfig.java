package malte.dev.app.GhostNet.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Authorization rules for http requests
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/", "/login", "/register", "/nets", "/images/**", "/api/user", "/css/**", "/js/**", "/webjars/**", "/api/ghostnet").permitAll()
                .anyRequest().authenticated());
                //.requestMatchers("/", "login", "/registration", "/nets", "/images/**", "/css/**", "/js/**", "/webjars/**").permitAll();
        http.formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll());
        return http.build();
    }

    // Password encoding
    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
    
}
