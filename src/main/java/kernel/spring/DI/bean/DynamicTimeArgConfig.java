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

    private String arg = "spring in action 4.0";

    private String email = "anonymou_s@163.com";

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

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
