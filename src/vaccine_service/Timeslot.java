package vaccine_service;

/**
 Represents a timeslot for vaccine appointment.
 @author maryam, nabihah
 */
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
     less than specified timeslot (either date or time are less, or both), and 1
     if this time slot is greater than specified timeslot (either date or time are
     greater, or both)
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
            return timeslot.time.equals(this.time) &&
                    timeslot.date.equals(this.date);
        }
        return false;
    }
    //testbed
    public static void main (String[]args){
        //testcase 1
        Timeslot slot = new Timeslot("02/14/2021, 9:40");
        Timeslot slot2 = new Timeslot("02/14/2023, 8:00");
        System.out.println(slot.compareTo(slot2));
        //testcase 2
        Timeslot slot3 = new Timeslot("01/14/2021, 10:40");
        Timeslot slot4 = new Timeslot("03/14/2021, 7:00");
        //testcase 3
        Timeslot slot5 = new Timeslot("06/10/2020, 10:40");
        Timeslot slot6 = new Timeslot("06/14/2020, 7:00");
        //testcase 4
        Timeslot slot7 = new Timeslot("05/12/2020, 10:50");
        Timeslot slot8 = new Timeslot("05/12/2019, 12:00");
        //testcase 5
        Timeslot slot9 = new Timeslot("04/20/2019, 10:50");
        Timeslot slot10 = new Timeslot("05/20/2019, 12:00");
        //testcase 6
        Timeslot slot11 = new Timeslot("05/20/2019, 10:50");
        Timeslot slot12 = new Timeslot("05/12/2010, 12:00");
        //testcase 7
        Timeslot slot13 = new Timeslot("01/13/2021, 10:50");
        Timeslot slot14 = new Timeslot("01/13/2021, 10:50");
        //testcase 8
        Timeslot slot15 = new Timeslot("12/12/2020, 2:10");
        Timeslot slot16 = new Timeslot("12/12/2020, 2:01");
        //testcase 9
        Timeslot slot17 = new Timeslot("12/12/2020, 3:01");
        Timeslot slot18 = new Timeslot("12/12/2020, 2:01");
        //testcase 10
        Timeslot slot19 = new Timeslot("12/12/2020, 6:21");
        Timeslot slot20 = new Timeslot("12/12/2020, 7:21");
        //testcase 11
        Timeslot slot21 = new Timeslot("12/12/2020, 6:21");
        Timeslot slot22 = new Timeslot("12/12/2020, 6:40");
    }
}
