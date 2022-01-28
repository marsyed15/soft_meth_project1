package vaccine_service;

public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Timeslot slot) {
        return 0;
    }
}
