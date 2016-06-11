package kernel.spring.DI.javaconfig;

import kernel.spring.DI.model.CEO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by kernel on 2016/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExpressiveConfig.class})
public class ExpressiveConfigTest {

    @Autowired
    private CEO ceo;

    @Test
    public void test(){

        Assert.assertNotNull(ceo);
    }
}