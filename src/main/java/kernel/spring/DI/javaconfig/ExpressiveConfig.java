package kernel.spring.DI.javaconfig;

import kernel.spring.DI.model.Book;
import kernel.spring.DI.model.CEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by kernel on 2016/6/11.
 */

@Configuration("classpath:conf/spring/applicationContext-root.xml")// 配置文件没有起作用
@PropertySource(value = "classpath:conf.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment env;

    @Value("${book.name}")
    private String bookName;

    @Value("${author.name}")
    private String authorName;

    @Bean
    public CEO ceo(){

        String property = env.getProperty("spring.test");
        // 深入学习 Environment
        String envProperty = env.getProperty("ceo.ceoName", "rattle and hum");
        String u2 = env.getProperty("ceo.companyName", "U2");
        Integer dbConnectionCount = env.getProperty("db.connection.count", Integer.class, 30);
        System.out.println("ceo.ceoName[" + envProperty + "]");
        System.out.println("ceo.companyName[" + u2 + "]");
        System.out.println("[" + dbConnectionCount + "]");

        System.out.println(property);
        return new CEO();
    }

    @Bean
    public Book book(){

        return new Book(this.bookName,this.authorName);
    }

}
