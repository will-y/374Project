package team8.coffee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team8.coffee.service.DataBaseController;
import team8.coffee.service.impl.DataBaseControllerImpl;

@Configuration
public class Config {
    @Bean
    public DataBaseController dataBaseController() {
        return new DataBaseControllerImpl();
    }
}
