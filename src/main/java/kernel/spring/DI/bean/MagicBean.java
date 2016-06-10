package kernel.spring.DI.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kernel on 2016/6/10.
 */
public class MagicBean {

    private String magic;

    public MagicBean(){

    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }
}
