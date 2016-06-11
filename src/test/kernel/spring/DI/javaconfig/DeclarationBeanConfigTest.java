package kernel.spring.DI.javaconfig;

import kernel.spring.DI.bean.MagicBean;
import kernel.spring.DI.model.CEO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by kernel on 2016/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DeclarationBeanConfig.class})
public class DeclarationBeanConfigTest {

    @Autowired
    private Environment env;

    @Autowired
    private CEO ceo;

    @Autowired
    private MagicBean magicBean;

    @Test
    public void testConditionalAnnoation(){

        Assert.assertNotNull(magicBean);
    }


    @Test
    public void testBeanAnnoation(){

        System.out.println("ceoname : " + ceo.getCeoName());
        System.out.println("companyname : " + ceo.getCompanyName());
        Assert.assertNotNull(ceo);
    }

}