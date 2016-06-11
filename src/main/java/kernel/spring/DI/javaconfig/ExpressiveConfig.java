package kernel.spring.DI.javaconfig;

import kernel.spring.DI.model.CEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by kernel on 2016/6/11.
 */

@Configuration
@PropertySource(value = "classpath:conf.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment env;

    @Bean
    public CEO ceo(){

        String property = env.getProperty("spring.test");
        System.out.println(property);
        return new CEO();
    }

}
