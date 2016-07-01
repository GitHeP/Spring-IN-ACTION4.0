package kernel.spring.AOP.aspect;

import kernel.spring.AOP.annotation.MyAspect;
import kernel.spring.AOP.bean.LoginBean;
import kernel.spring.AOP.bean.TestResultDataCollect;
import kernel.spring.common.SpringApplicationContextProvider;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

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
            Object retVal = pjp.proceed(new Object[]{loginBean});
            System.out.println(retVal);
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

    @Before("execution(* kernel.spring.AOP.service.UserService.login(..)) && args(loginBean)")
    public void before(JoinPoint jp,LoginBean loginBean){

        System.out.println("[" + new Date() + "] execution method[before]");
        Object target = jp.getTarget();
        Object retVal = jp.getThis();
        System.out.println("ISAOPPROXY getThis [" + AopUtils.isAopProxy(retVal) + "]");
        System.out.println("ISAOPPROXY getTarget [" + AopUtils.isAopProxy(target) + "]");
        System.out.println("getTarget == getThis [" + (target == retVal) + "]");
        System.out.println("JoinPoint getThis [" + retVal + "]");
        System.out.println("目标对象 [" + target + "]");
        /*
         * 结论:getTarget() 得到的是被代理的目标对象
         * getThis() 得到的是代理后的对象
         * 但是这两个对象的 hashCode 是一样的
         */
        Object[] args = jp.getArgs();
        System.out.println("被代理对象的目标方法的参数 [" + Arrays.toString(args) + "]");
        System.out.println("参数中的数据 [" + ((LoginBean)args[0]).getUserName() + "]");

        String kind = jp.getKind();
        System.out.println("getKing [" + kind + "]");
        Signature signature = jp.getSignature();
        System.out.println("getSignature [" + signature.getName() + "]");
        /*
         * Signature 中封装了目标对象被代理方法的信息
         */

        SourceLocation sourceLocation = jp.getSourceLocation();
//        System.out.println("getSourceLocation [" + sourceLocation.getFileName() + "]");
    }


    @After("execution(* kernel.spring.AOP.service..*(..)) && args(loginBean)")
    public void after(LoginBean loginBean){
        System.out.println("[" + new Date() + "] execution method[after]");
    }

    @AfterReturning(value = "execution(* kernel.spring.AOP.service.UserService.test(..)) && bean(userService)",returning = "simpleBean")
    public Object afterReturning(Object simpleBean){

        System.out.println(simpleBean.getClass().getName());
        return simpleBean;
    }


}
