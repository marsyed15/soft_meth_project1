package vaccine_service;

import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    //should I define these here?
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;
    public static final int MONTHS = 12;
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int MAY = 5;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int OCTOBER = 10;
    public static final int DECEMBER = 12;

    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {
        String[] dateSplit = date.split("/");
        this.month = Integer.parseInt(dateSplit[0]);
        this.day = Integer.parseInt(dateSplit[1]);
        this.year = Integer.parseInt(dateSplit[2]);
    }
    //create an object with today’s date (see Calendar class)
    public Date() {
        Calendar todayDate = Calendar.getInstance();
        this.month = todayDate.get(Calendar.MONTH) + 1; //adding 1 b/c the months in the calender class start at 0
        this.day = todayDate.get(Calendar.DATE);
        this.year = todayDate.get(Calendar.YEAR);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private Boolean isLeapYear(int year) {
        if(year % QUADRENNIAL == 0) {
            if(year % CENTENNIAL == 0) {
                if(year % QUARTERCENTENNIAL == 0)
                    return true;
                else
                    return false;
            }
            return true;
        }
        return false;
    }

    private Boolean shouldHave31Days(int month) {
        if(month == JANUARY || month == MARCH || month == MAY || month == JULY
                || month == AUGUST || month == OCTOBER || month == DECEMBER)
            return true;
        return false;
    }

    public Boolean isValid() {
        Boolean leapYear = isLeapYear(this.year);
        Boolean ThirtyOneDays = shouldHave31Days(this.month);

        if(this.month > MONTHS)
            return false;

        if(this.month == FEBRUARY && this.day > 28) {
            if((this.day == 29 && leapYear == true))
                return true;
            return false;
        }

        if(this.day > 30) {
            if(this.day == 31 && ThirtyOneDays == true)
                return true;
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Date date) {
        if(this.year < date.year)
            return -1;
        else if(this.year > date.year)
            return 1;
        else {
            if(this.month < date.month)
                return -1;
            else if(this.month > date.month)
                return 1;
            else {
                if(this.day < date.day)
                    return -1;
                else if (this.day > date.day)
                    return 1;
                else
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        Date testDate = new Date("01/29/2022");
        Date todayDate = new Date();
        Boolean valid = todayDate.isValid();
        int compare = todayDate.compareTo(testDate);
        System.out.printf("Date is %b\n", valid);
        System.out.printf("Is Today's date valid? %d", compare);

    }
}

