package kr.co.fastcampus.admin_page.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  // Jpa 감시 활성화
public class JpaConfig {
}
