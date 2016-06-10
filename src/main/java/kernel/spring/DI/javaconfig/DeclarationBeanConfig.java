package kernel.spring.DI.javaconfig;

import kernel.spring.DI.bean.MagicBean;
import kernel.spring.DI.implemation.MagicExistsCondition;
import kernel.spring.DI.model.CEO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * Created by kernel on 2016/6/10.
 * 显示的声明bean
 */

@Configuration
public class DeclarationBeanConfig {

    @Bean
    public CEO ceo(){
        int rndNum = new Random().nextInt(3);
        switch (rndNum){
            case 1 : return new CEO("xx","jack");
            case 2 : return new CEO("cc","rose");
            case 3 : return new CEO("ww","kobe");
            default:return new CEO();
        }
    }

//    @Bean
//    public MagicExistsCondition magicExistsCondition(){
//        return new MagicExistsCondition();
//    }

    @Bean
    @Conditional({MagicExistsCondition.class})
    public MagicBean magicBean(){

        return new MagicBean();
    }
}
