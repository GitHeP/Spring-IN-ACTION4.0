package kernel.spring.AOP.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by kernel on 2016/6/14.
 */
@PropertySource("classpath:conf.properties")
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = {"kernel.spring.AOP","kernel.spring.common"})
public class SpringAOPConfig {
}
