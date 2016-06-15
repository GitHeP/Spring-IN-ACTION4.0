package kernel.spring.AOP.bean;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kernel on 2016/6/15.
 */
@Component
public class TestResultDataCollect {

    private final List<Object> resultData = new ArrayList<Object>();

    public List<Object> collect(Object resultDate){

        resultData.add(resultDate);
        return resultData;
    }

    public List<Object> getResultData(){
        return this.resultData;
    }

}
