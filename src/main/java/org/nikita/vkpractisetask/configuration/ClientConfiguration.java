package org.nikita.vkpractisetask.configuration;

import lombok.RequiredArgsConstructor;
import org.nikita.vkpractisetask.client.TypiCodeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class ClientConfiguration {
    private final WebClient.Builder webClientBuilder;

    @Bean
    public TypiCodeClient scrapperClient() {
        return new TypiCodeClient(webClientBuilder);
    }


}
