package kernel.spring.DI.implemation;

import kernel.spring.DI.javaconfig.JavaConfig;
import kernel.spring.DI.model.CEO;
import kernel.spring.DI.model.CEOConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;

/**
 * Created by kernel on 2016/6/9.
 * 测试组件扫描能够发现CEO
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {CEOConfig.class})
@ContextConfiguration(classes = {JavaConfig.class})
public class JavaConfigTest {

    @Autowired(required = false)
    private CEO ceo;

    @Test
    public void ceoShouldNotBeNull(){
        Assert.assertNotNull(ceo);
    }

}