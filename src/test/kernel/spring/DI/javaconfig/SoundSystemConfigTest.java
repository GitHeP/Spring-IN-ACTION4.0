package kernel.spring.DI.javaconfig;

import kernel.spring.DI.implemation.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kernel on 2016/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SoundSystemConfig.class})
public class SoundSystemConfigTest {

    final Logger logger = LogManager.getLogger(SoundSystemConfigTest.class);

    @Autowired
    private Company company;

    @Test
    public void testImportAnnoation(){

        SimpleDateFormat sipleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = sipleDate.format(new Date());
        System.out.println(curDate + "  company[" + company + "]");
        Assert.assertNotNull(company);
    }
}
