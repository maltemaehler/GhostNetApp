package malte.dev.app.GhostNet.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Method configures security filter chain.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disabled CSRF protection for prototyping purposes. ENABLE in production!
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            // ToDo: Check if all authentication exceptions are necessary
            .requestMatchers("/", "/register", "/api/user", "/login", "/nets", "/api/ghostnet", "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
            .anyRequest().authenticated())
        .formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .permitAll())
        .logout(logout -> logout
            .permitAll()
            .logoutSuccessUrl("/"));
    
    return http.build();   
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }    
}
