package kernel.spring.DI.bean;

import org.springframework.stereotype.Component;

/**
 * Created by kernel on 2016/6/14.
 */
@Component("dynamicTimeArgConfig")
public class DynamicTimeArgConfig {

    private int hour = 10;

    private int minute = 3000;

    private int second;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
