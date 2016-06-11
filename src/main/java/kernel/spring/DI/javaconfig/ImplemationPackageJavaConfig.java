package kernel.spring.DI.javaconfig;

import kernel.spring.DI.implemation.Cake;
import kernel.spring.DI.implemation.Company;
import kernel.spring.DI.implemation.Cookie;
import kernel.spring.DI.implemation.IceCream;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by kernel on 2016/6/11.
 */
@Configuration
@ComponentScan(basePackageClasses = {Cake.class, Cookie.class, IceCream.class},
excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {Company.class})})
public class ImplemationPackageJavaConfig {
}
