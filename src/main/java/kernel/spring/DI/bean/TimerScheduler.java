package kernel.spring.DI.bean;

/**
 * Created by kernel on 2016/6/14.
 */
public class TimerScheduler {

    private int hour;

    private int minute;

    private String ss;

    private boolean flag;

    public TimerScheduler(){}

    public TimerScheduler(boolean flag,int hour,int minute,String ss){
        this.hour = hour;
        this.flag = flag;
        this.minute = minute;
        this.ss = ss;
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

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
