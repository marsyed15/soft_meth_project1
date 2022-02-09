package vaccine_service;

public class Time implements Comparable<Time> {
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
    public boolean isValid() { //MAGIC NUMBERS
        return this.hour >=9 && this.hour <= 16 && this.minute >= 0 &&
                this.minute <= 45 && (this.minute % 15 == 0);
    }

    /**
     
     @return
     */
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

