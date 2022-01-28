package vaccine_service;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;

    public boolean isValid() {
        return true;
    }
    @Override
    public String toString() {
        return "Hello";
    }
    @Override
    public int compareTo(Time time) {
        return 0;
    }
}
