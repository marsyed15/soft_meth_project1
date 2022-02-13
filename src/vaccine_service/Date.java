package vaccine_service;

import java.util.Calendar;

/**
 Represents a calender date with three fields: day, month, and year. Can check
 if date is a valid calendar date.
 @author nabihah, maryam
 */

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    public static final int MAX_DAYS_IN_FEB = 28;
    public static final int MAX_DAYS_IN_LEAP_YEAR_FEB = 29;
    public static final int MAX_DAYS_IN_FOUR_MONTHS = 30;
    public static final int MAX_DAYS_IN_SEVEN_MONTHS = 31;
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
        this.month = todayDate.get(Calendar.MONTH) + 1;
        this.day = todayDate.get(Calendar.DATE);
        this.year = todayDate.get(Calendar.YEAR);
    }

    /**
     Gets the day from Date object
     @return int representing the day in the Date
     */
    public int getDay() {
        return this.day;
    }

    /**
     Gets the month from Date object
     @return int representing the month in the Date
     */
    public int getMonth() {
        return this.month;
    }

    /**
     Gets the year from Date object
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
     Checks if given month should have 31 days or not.
     @param month, an integer
     @return true if given month is January, March, May, July, August, October,
     or December and false otherwise
     */
    private Boolean shouldHave31Days(int month) {
        if(month == JANUARY || month == MARCH || month == MAY || month == JULY
                || month == AUGUST || month == OCTOBER || month == DECEMBER)
            return true;
        return false;
    }

    /**
     Checks if Date object is a valid date.
     @return true if given Date object is valid, false otherwise.
     */
    public Boolean isValid() {
        Boolean leapYear = isLeapYear(this.year);
        Boolean ThirtyOneDays = shouldHave31Days(this.month);

        if(this.month > MONTHS)
            return false;

        if(this.month == FEBRUARY && this.day > MAX_DAYS_IN_FEB) {
            if((this.day == MAX_DAYS_IN_LEAP_YEAR_FEB && leapYear == true))
                return true;
            return false;
        }

        if(this.day > MAX_DAYS_IN_FOUR_MONTHS) {
            if(this.day == MAX_DAYS_IN_SEVEN_MONTHS && ThirtyOneDays == true)
                return true;
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
     Overrides equals method. day, year, and month must be equal for two dates
     to be equal.
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
    //testbed main
    public static void main(String[] args) {
        //testcase1
        Date testDate = new Date("15/21/2022");
        System.out.println(testDate.isValid());
        //testcase2
        Date testDate1 = new Date("1/41/2013");
        System.out.println(testDate1.isValid());
        //testcase3
        Date testDate2 = new Date("6/31/2021");
        System.out.println(testDate2.isValid());
        //testcase4
        Date testDate3 = new Date("2/29/2018");
        System.out.println(testDate3.isValid());
        //testcase5
        Date testDate4 = new Date("2/31/2020");
        System.out.println(testDate4.isValid());
    }
}

