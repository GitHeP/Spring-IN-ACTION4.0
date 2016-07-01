package kernel.spring.AOP.bean;

import org.springframework.stereotype.Component;

/**
 * Created by kernel on 2016/6/15.
 */
@Component("simpleBean")
public class SimpleBean {

    @Override
    public String toString() {
        return "我只是为了测试一下Spring引入的AspectJ的连接点表达式的 bean(*) 表达式";
    }
}
