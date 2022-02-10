package vaccine_service;

public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;

    /**
     Creates an instance of Timeslot with the specified timeslot
     @param timeslot A string with date in mm/dd/yyyy format followed by time in
     hh:mm format
     */
    public Timeslot(String timeslot) {
        String[] split = timeslot.split(" ");
        this.date = new Date(split[0]);
        this.time = new Time(split[1]);
    }
    /**
     Gets the date from timeslot
     @return A date object representing the date in the timeslot
     */
    public Date getDate() {
        return this.date;
    }
    /**
     Gets the time from timeslot
     @return A time object representing the time in the timeslot
     */
    public Time getTime() {
        return this.time;
    }

    /**
     Overrides toString method.
     @return Date as a string in mm/dd/yyyy format
     */
    @Override
    public String toString() {
        return "" + this.date.getMonth() + "/" + this.date.getDay() + "/" +
                this.date.getYear() + ", " + this.time;
    }

    /**
     Overrides compareTo method. compares this timeslot with specified timeslot
     @param slot an instance of Timeslot
     @return 0 if this and specified timeslot are equal, -1 if this timeslot is
     less than specified timeslot, and 1 if this time slot is greater than
     specified timeslot
     */
    @Override
    public int compareTo(Timeslot slot) {
        if (this.date.compareTo(slot.date) == 1) {
            return 1;
        }
        if (this.date.compareTo(slot.date) == -1) {
            return -1;
        } else {
            if (this.time.compareTo(slot.time) == 0) {
                return 0;
            } else if (this.time.compareTo(slot.time) == 1) {
                return 1;
            } else {
                return -1;
            }

        }
    }

    /**
     Overrides equals method.
     @param obj an object
     @return true if both objects of type timeslot are equal. false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Timeslot) {
            Timeslot timeslot = (Timeslot) obj;
            return timeslot.time.equals(this.time) && timeslot.date.equals(this.date);
        }
        return false;
    }
    //testbed
    public static void main (String[]args){
        Timeslot slot = new Timeslot("02/15/2001, 9:46");
        System.out.println(slot.toString());
        Timeslot slot2 = new Timeslot("02/15/2001, 10:50");
        System.out.println(slot.compareTo(slot2));
        System.out.println(slot2.time.isValid());



    }
}
