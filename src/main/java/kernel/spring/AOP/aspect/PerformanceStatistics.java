package kernel.spring.AOP.aspect;

import kernel.spring.AOP.annotation.MyAspect;
import kernel.spring.AOP.bean.LoginBean;
import kernel.spring.AOP.bean.TestResultDataCollect;
import kernel.spring.common.SpringApplicationContextProvider;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by kernel on 2016/6/15.
 */
//@MyAspect
@Component
@Aspect
public class PerformanceStatistics {

    @Around("execution(* kernel.spring.AOP.service.UserService.login(..)) && args(loginBean)")
    public void logForExecutionTime(ProceedingJoinPoint pjp, LoginBean loginBean){
        long startTime = System.currentTimeMillis();
        long entTime = 0L;
        try {
            Object proceed = pjp.proceed(new Object[]{loginBean});
            System.out.println(proceed);
            entTime = System.currentTimeMillis();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long executionTime = (entTime - startTime);
        System.out.println("方法 [ " + pjp.getTarget().getClass().getName() + "] 执行时间是 [" + executionTime + "] 毫秒");

        ApplicationContext applicationContext = SpringApplicationContextProvider.getApplicationContext();
        TestResultDataCollect trdc = applicationContext.getBean(TestResultDataCollect.class);
        trdc.collect(Long.valueOf(executionTime));
    }
}
