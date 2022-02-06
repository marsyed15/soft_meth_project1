package vaccine_service;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;

    public Time(String time) {
        String[] split = time.split(":");
        this.hour = Integer.parseInt(split[0]);
        this.minute = Integer.parseInt(split[1]);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isValid() {
        return this.hour > 0 && this.hour <= 24 && this.minute >= 0 && this.minute <= 59;
    }

    @Override
    public String toString() {
        if (this.minute < 10) {
            return this.hour + ":0" + this.minute;
        }
        return this.hour + ":" + this.minute;
    }

    @Override
    public int compareTo(Time time) {
        if (this.hour > time.hour) {
            return 1;
        } else if (this.hour < time.hour) {
            return -1;
        } else {
            return Integer.compare(this.minute, time.minute);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Time) {
            Time time = (Time) obj;
            return time.hour == this.hour && time.minute == this.minute;
        }
        return false;
    }
    //testbed
    public static void main(String[] args) {
        Time time = new Time("24:05");
        Time time2 = new Time("11:05");
        System.out.println(time.isValid());
        System.out.println(time.compareTo(time2));

    }
}

