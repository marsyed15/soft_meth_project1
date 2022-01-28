package vaccine_service;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {

    }
    //create an object with today’s date (see Calendar class)
    public Date() {

    }
    public boolean isValid() {
        return true;
    }

    @Override
    public int compareTo(Date date) {
        return 0;
    }
}
