package io.security.corespringsecurity.config;

import io.security.corespringsecurity.repository.ResourcesRepository;
import io.security.corespringsecurity.security.configs.MethodSecurityConfig;
import io.security.corespringsecurity.service.SecurityResourceService;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore({MethodSecurityConfig.class})
public class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository) {
        SecurityResourceService SecurityResourceService = new SecurityResourceService(resourcesRepository);
        return SecurityResourceService;
    }
}
