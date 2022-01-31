package vaccine_service;

public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;

    public Timeslot(Timeslot slot) {
        this.date = slot.date;
        this.time = slot.time;
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
}
