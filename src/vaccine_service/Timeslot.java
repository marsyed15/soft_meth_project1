package vaccine_service;

public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;

    public Timeslot(String timeslot) {
        String[] split = timeslot.split(" ");
        this.date = new Date(split[2]);
        this.time = new Time(split[3]);
        System.out.println(time);
    }

    public Date getDate() {
        return this.date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "" + this.date.getMonth() + "/" + this.date.getDay() + "/" + this.date.getYear() + ", " + this.time;
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
