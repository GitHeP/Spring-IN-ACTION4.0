package kernel.spring.DI.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * Created by kernel on 2016/6/11.
 */

@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,
        ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Cold {
}
