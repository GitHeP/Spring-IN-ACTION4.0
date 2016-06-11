package kernel.spring.DI.implemation;

import kernel.spring.DI.interfaces.Dessert;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by kernel on 2016/6/11.
 */
@Component("idCake")
@Primary
public class Cake implements Dessert{
}
