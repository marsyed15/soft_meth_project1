package vaccine_service;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;

    public Time(String time) {
        String[] split = time.split(":");
        this.hour = Integer.parseInt(split[0]);
        this.minute = Integer.parseInt(split[1]);
        System.out.println("hour is " + this.hour + " minute is " + this.minute);
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

    //testbed
    public static void main(String[] args) {
        Time time = new Time("24:05");
        Time time2 = new Time("11:05");
        System.out.println(time.isValid());
        System.out.println(time.compareTo(time2));

    }
}

