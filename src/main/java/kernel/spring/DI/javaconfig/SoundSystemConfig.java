package kernel.spring.DI.javaconfig;

import kernel.spring.DI.model.CEOConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by kernel on 2016/A6/10.
 * JavaConfig $ XmlConfig merge
 */
@Configuration
@Import({CEOConfig.class})
@ImportResource("classpath:conf/spring/applicationContext-*.xml")
public class SoundSystemConfig {

}
