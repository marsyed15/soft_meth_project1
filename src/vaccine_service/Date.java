package vaccine_service;

import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
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

    /**
     Creates an instance of Date with given String
     @param date A string in mm/dd/yyyy format
     */
    public Date(String date) {
        String[] dateSplit = date.split("/");
        this.month = Integer.parseInt(dateSplit[0]);
        this.day = Integer.parseInt(dateSplit[1]);
        this.year = Integer.parseInt(dateSplit[2]);
    }

    /**
     Creates an instance of Date for today's date
     */
    public Date() {
        Calendar todayDate = Calendar.getInstance();
        this.month = todayDate.get(Calendar.MONTH) + 1; //adding 1 b/c the months in the calender class start at 0
        this.day = todayDate.get(Calendar.DATE);
        this.year = todayDate.get(Calendar.YEAR);
    }

    /**
     Gets the day from Date
     @return int representing the day in the Date
     */
    public int getDay() {
        return this.day;
    }

    /**
     Gets the month from Date
     @return int representing the month in the Date
     */
    public int getMonth() {
        return this.month;
    }

    /**
     Gets the year from Date
     @return int representing the year in the Date
     */
    public int getYear() {
        return this.year;
    }

    /**
     Checks if given year is a leap year or not
     @param year, an integer
     @return true if given year is leap year, false otherwise.
     */
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

    /**
     Checks if given month is a valid month from range 1-12
     @param month, an integer
     @return true if given month is valid and falls within range 1-12, false otherwise.
     */
    private Boolean shouldHave31Days(int month) {
        if(month == JANUARY || month == MARCH || month == MAY || month == JULY
                || month == AUGUST || month == OCTOBER || month == DECEMBER)
            return true;
        return false;
    }

    /**
     Checks if Date object is a valid date
     @return true if given Date object is valid, false otherwise.
     */
    public Boolean isValid() { //MAGIC NUMBERS
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

        if(this.year > 2022){
            return false;
        }
        return true;
    }

    /**
     Overrides compareTo method. compares this Date with specified Date
     @param date an instance of Date
     @return 0 if this and specified Date are equal, -1 if this Date is
     less than specified Date, and 1 if this Date is greater than
     specified Date
     */
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
            else
                return Integer.compare(this.day, date.day);
        }
    }

    /**
     Overrides toString method.
     @return Date as a string in mm/dd/yyyy format
     */
    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    /**
     Overrides equals method.
     @param obj an object
     @return true if both objects of type Date are equal. false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Date) {
            Date date = (Date) obj;
            return date.day == this.day && date.month == this.month &&
                    date.year == this.year;
        }
        return false;
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

