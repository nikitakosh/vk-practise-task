package org.nikita.vkpractisetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class VkPractiseTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(VkPractiseTaskApplication.class, args);
    }

}
