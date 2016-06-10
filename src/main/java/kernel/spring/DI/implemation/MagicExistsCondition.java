package kernel.spring.DI.implemation;

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
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + environment.getProperty("magic"));
        return environment.containsProperty("magic");
    }
}
