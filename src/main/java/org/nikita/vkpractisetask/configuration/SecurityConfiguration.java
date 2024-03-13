package org.nikita.vkpractisetask.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {



    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(customizer ->
                        customizer
                                .requestMatchers("/api/posts/**")
                                .hasAnyRole("ADMIN", "POSTS")
                                .requestMatchers("/api/albums/**")
                                .hasAnyRole("ADMIN", "ALBUMS")
                                .requestMatchers("/api/users/**")
                                .hasAnyRole("ADMIN", "USERS")
                                .anyRequest()
                                .authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails userHasAccessToPosts = User.builder()
                .username("userHasAccessToPosts")
                .password(passwordEncoder().encode("userHasAccessToPosts"))
                .roles("POSTS")
                .build();

        UserDetails userHasAccessToUsers = User.builder().
                username("userHasAccessToUsers")
                .password(passwordEncoder().encode("userHasAccessToUsers"))
                .roles("USERS")
                .build();

        UserDetails userHasAccessToAlbums = User.builder().
                username("userHasAccessToAlbums")
                .password(passwordEncoder().encode("userHasAccessToAlbums"))
                .roles("ALBUMS")
                .build();
        return new InMemoryUserDetailsManager(admin, userHasAccessToPosts, userHasAccessToUsers, userHasAccessToAlbums);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
