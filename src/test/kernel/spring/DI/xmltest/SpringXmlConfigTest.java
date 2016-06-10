package kernel.spring.DI.xmltest;

import kernel.spring.DI.implemation.Company;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kernel on 2016/6/10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring/applicationContext-*"})
public class SpringXmlConfigTest {

    @Autowired
    private Company company;

    @Test
    public void testConstructorAutowired(){

        System.out.println(company.getCeo().getCompanyName());
        System.out.println(company.getCeo().getCeoName());
        Assert.assertNotNull(company);
    }
}

