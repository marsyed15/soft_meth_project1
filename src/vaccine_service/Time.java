package vaccine_service;

public class Time implements Comparable<Time> {
    public static final int minHour = 9;
    public static final int maxHour = 16;
    public static final int minMinute = 0;
    public static final int maxMinute = 45;
    public static final int intervalTime = 15;
    private int hour;
    private int minute;

    /**
     creates an instance of Time, given a string in hh:mm format.
     @param time String in hh:mm format
     */
    public Time(String time) {
        String[] split = time.split(":");
        this.hour = Integer.parseInt(split[0]);
        this.minute = Integer.parseInt(split[1]);
    }

    /**
     checks if time falls within 9:00 to 16:45 with a 15 minute interval
     @return true if time falls within 9:00 to 16:45 range with 15 minute interval
     and false otherwise
     */
    public boolean isValid() { 
        return this.hour >= minHour && this.hour <= maxHour && this.minute >=
                minMinute && this.minute <= maxMinute &&
                (this.minute % intervalTime == 0);
    }

    /**
     Overrides toString method
     @return time as a String in hh:mm format
     */
    @Override
    public String toString() {
        if (this.minute < 10) { //would this be a magic number?
            return this.hour + ":0" + this.minute;
        }
        return this.hour + ":" + this.minute;
    }

    /**
     Overrides compareTo method. compares this time with specified time
     @param time an instance of Time
     @return 0 if this and specified time are equal, -1 if this time is
     less than specified time, and 1 if time is greater than specified time
     (in terms of minute or hour, or both)
     */
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
    /**
     Overrides equals method.
     @param obj an object
     @return true if both objects of type Time are equal. false otherwise
     */
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

