package kernel.spring.DI.bean;

/**
 * Created by kernel on 2016/6/14.
 */
public class TimerScheduler {

    private int hour;

    private int minute;

    public TimerScheduler(){}

    public TimerScheduler(int hour,int minute){
        this.hour = hour;
        this.minute = minute;
    }

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
}
