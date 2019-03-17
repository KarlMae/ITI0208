package java.com.training.config;

import com.training.config.CorsConfig;
import com.training.config.DatabaseConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DatabaseConfig.class, CorsConfig.class })
public class AppConfig {
}
