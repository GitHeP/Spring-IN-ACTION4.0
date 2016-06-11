package kernel.spring.DI.implemation;

import kernel.spring.DI.model.CEO;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by kernel on 2016/6/10.
 */
public class MagicExistsCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + Arrays.toString(activeProfiles));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + Arrays.toString(environment.getDefaultProfiles()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "[" + environment.getProperty("os.name") + "]");

        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        CEO ceo = beanFactory.getBean(CEO.class);
        System.out.println(ceo);

        return environment.containsProperty("os.name");
    }
}
