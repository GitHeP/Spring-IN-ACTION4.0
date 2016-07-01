package kernel.spring.AOP.service;

import kernel.spring.AOP.aspect.PerformanceStatistics;
import kernel.spring.AOP.bean.LoginBean;
import kernel.spring.AOP.bean.SimpleBean;
import kernel.spring.AOP.bean.TestResultDataCollect;
import kernel.spring.AOP.config.SpringAOPConfig;
import kernel.spring.common.SpringApplicationContextProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kernel on 2016/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAOPConfig.class})
public class UserServiceTest {

    @Autowired
    private Environment environment;

    @Autowired
    private UserService userService;

    @Autowired
    private SimpleBean simpleBean;

    @Test
    public void testSE(){

        userService.test(simpleBean);
    }

    @Test
    public void testPerformanceStatisticsAspect(){

        ApplicationContext applicationContext = SpringApplicationContextProvider.getApplicationContext();
        PerformanceStatistics pfmss = applicationContext.getBean(PerformanceStatistics.class);
        Assert.assertNotNull(pfmss);
        System.out.println(pfmss.getClass().getName());
        LoginBean loginBean = new LoginBean("当时年少春衫薄","123","127.0.0.1",new Date());
        userService.login(loginBean);

        System.out.println("aop 动态代理[" + AopUtils.isAopProxy(userService) + "]");
        System.out.println("cglib 动态代理[" + AopUtils.isCglibProxy(userService) + "]");
        System.out.println("jdk 动态代理[" + AopUtils.isJdkDynamicProxy(userService)+ "]");
    }


    @Test
    public void testAutomationTest(){
        String time = environment.getProperty("test.time");
        int var_1 = Integer.parseInt(time);
        while (var_1 > 0){
            testPerformanceStatisticsAspect();
            var_1--;
        }
        List<Object> resultData = SpringApplicationContextProvider.
                                        getApplicationContext().
                                        getBean(TestResultDataCollect.class).
                                        getResultData();
        long sum = 0L;
        for(Object obj : resultData){
            if(obj instanceof Long){
                long ms = (Long)obj;
                sum += ms;
            }
        }
        long average = sum / resultData.size();
        System.out.println("[" + new Date() + "] 测试 [" + time + "] 次,平均用时 [" + average + "] 毫秒");
    }
}