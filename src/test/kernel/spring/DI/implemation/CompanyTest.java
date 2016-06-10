package kernel.spring.DI.implemation;

import kernel.spring.DI.javaconfig.JavaConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;

/**
 * Created by kernel on 2016/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaConfig.class})
public class CompanyTest {

    @Autowired
    private Company company;

    @Test
    public void test(){
        Assert.assertNotNull(company);
        company.discuss();
    }
}