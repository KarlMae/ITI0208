package java.com.training.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DatabaseConfig.class)
@AllArgsConstructor
public class AppConfig {

    private final DatabaseConfig databaseConfig;
}
