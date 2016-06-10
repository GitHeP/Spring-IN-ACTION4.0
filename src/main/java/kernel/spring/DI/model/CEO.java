package kernel.spring.DI.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by kernel on 2016/6/9.
 */
@Component()
public class CEO implements Serializable{

    private String companyName;

    private String ceoName;

    public CEO(){}

    public CEO(String companyName,String ceoName){
        this.ceoName = ceoName;
        this.companyName = companyName;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }


    public void saySomeThing(){
        System.out.println("ceo say somethig....");
    }
}
