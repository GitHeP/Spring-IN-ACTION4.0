package kernel.spring.DI.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by kernel on 2016/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:conf/spring/applicationContext-root.xml")
public class TimerSchedulerTest {

    @Autowired
    private TimerScheduler timerScheduler;

    @Test
    public void testSpEL(){

        System.out.println("boolean[" + timerScheduler.isFlag() + "]");
        System.out.println("hour[" + timerScheduler.getHour() + "]");
        System.out.println("minute[" + timerScheduler.getMinute() + "]");
        System.out.println("String[" + timerScheduler.getSs() + "]");
        Assert.assertNotNull(timerScheduler);
    }
}