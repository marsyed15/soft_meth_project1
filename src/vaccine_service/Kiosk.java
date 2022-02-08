package vaccine_service;

import java.util.Scanner;
import java.util.Calendar;

public class Kiosk {

    //error checks to return error message on:
    // 1. A date is not a valid calendar date.
    // 2. The date of birth is today or a future date.
    // 3. The appointment date is today or a date before today.
    // 4. The time is not a 15-minute interval and outside of the range of the appointment times of the day.
    // 5. An appointment with the same patient, timeslot and location is already in the schedule.
    // 6. The specified timeslot (same date and time) at the specified location has already been taken.
    // 7. The location with the county name is not a valid location.
    // 8. The user is booking an appointment with the same patient and date but a different location with an existing appointment.

    Schedule schedule = new Schedule();

    private

    private void book(String input){
        Date todaysDate = new Date();
        Appointment currAppt = new Appointment(input.substring(2));
        String[] split = input.split(" ");

        if(currAppt.getSlot().getDate().isValid() == false)
            System.out.println("Invalid appointment date!");
        else if(currAppt.getPatient().getDob().compareTo(todaysDate) >= 0)
            System.out.println("Date of birth invalid -> it is a future date.");
        else if(currAppt.getPatient().getDob().compareTo(todaysDate) <= 0)
            System.out.println("Appointment date invalid -> must be a future date.");
        else if(currAppt.getSlot().getTime().isValid() == false) {
            System.out.println("Invalid appointment time! Must enter a time " +
                    "between 9:00 and 16:45 with a 15-minute interval.");
        }
        else if(schedule.add(currAppt) == false)
            System.out.println("Same appointment exists in the schedule.");
        //add method that is variation of schedule.find
        else if( )
            System.out.println("Time slot has been taken at this location.");
        else if(Location.locationExists(split[split.length - 1]) == false)
            System.out.println("Invalid location!");
        //add method that is variation of schedule.find
        else if( )
            System.out.println("Same patient cannot book an appointment with the same date.");
        else
            System.out.println("Appointment booked and added to the schedule.");
    }

    //make loop to remove all patient's appts
    private void cancelAll(String input){
        if(schedule.remove(new Appointment(input.substring(2)))){
            System.out.println("Appointment cancelled.");
        }
        else {
            System.out.println("Not cancelled, appointment does not exist.");
        }
    }

    private void cancel(String input){
        if(schedule.remove(new Appointment(input.substring(2)))){
            System.out.println("Appointment cancelled.");
        }
        else {
            System.out.println("Not cancelled, appointment does not exist.");
        }
    }

    private void print(){
        System.out.println("*list of appointments in the schedule*");
        schedule.print();
        System.out.println("*end of schedule*");
    }

    private void printZip(){
        System.out.println("*list of appointments by zip and time slot.");
        schedule.printByZip();
        System.out.println("*end of schedule*");
    }

    private void printPatient(){
        System.out.println("*list of appointments by patient");
        schedule.printByPatient();
        System.out.println("*end of schedule*");
    }

    public void run() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Kiosk running. Ready to process transactions");
        while(true){
            String input = userInput.nextLine();
            String [] command = input.split(" ");
            if(command[0].equals("B")){
                book(input);
            }
            else if(command[0].equals("CP")){
                cancelAll(input);
            }
            else if(command[0].equals("C")){
                cancel(input);
            }
            else if(command[0].equals("P")){
                print();
            }
            else if(command[0].equals("PZ")){
                printZip();
            }
            else if(command[0].equals("PP")){
                printPatient();
            }
            else if(command[0].equals("Q")){
                break;
            }
            else {
                System.out.println("Invalid command!");
            }
        }
        System.out.println("Kiosk session ended.");
    }
}
