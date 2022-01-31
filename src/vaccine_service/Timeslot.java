package vaccine_service;

public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;

    public Timeslot(String timeslot) {
        String[] split = timeslot.split(",");
        this.date = new Date(split[0]);
        this.time = new Time(split[1]);
        System.out.println("date is " + date + " time is " + time);
    }

    @Override
    public String toString() {
        return " " + this.date + " " + this.time;
    }

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
    //testbed
    public static void main (String[]args){
        Timeslot slot = new Timeslot("02/15/2001,9:46");



    }
}
