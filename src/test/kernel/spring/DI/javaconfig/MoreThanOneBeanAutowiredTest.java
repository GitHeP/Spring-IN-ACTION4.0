package kernel.spring.DI.javaconfig;

import kernel.spring.DI.annotation.Cold;
import kernel.spring.DI.annotation.Creamy;
import kernel.spring.DI.interfaces.Dessert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kernel on 2016/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ImplemationPackageJavaConfig.class})
public class MoreThanOneBeanAutowiredTest {

    @Autowired
    @Cold
    @Creamy
    private Dessert dessert;

    @Test
    public void test(){

        System.out.println(dessert);
        Assert.assertNotNull(dessert);
    }
}
