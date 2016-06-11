package kernel.spring.DI.implemation;

import kernel.spring.DI.interfaces.Team;
import kernel.spring.DI.model.CEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kernel on 2016/6/9.
 */
@Component
public class Company implements Team {

    @Autowired(required = false)
    private CEO ceo;

    public Company(){}

    public Company(CEO ceo){
        this.ceo = ceo;
    }

    @Override
    public void cooperation() {
        System.out.println("公司成员之间需要互相合作完成工作!!!");
    }

    @Override
    public void discuss() {
        ceo.saySomeThing();
    }

    @Autowired
    public void setCeo(CEO ceo){
        this.ceo = ceo;
    }

    public CEO getCeo(){
        return this.ceo;
    }
}
