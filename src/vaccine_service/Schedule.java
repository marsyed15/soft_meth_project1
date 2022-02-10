package vaccine_service;


public class Schedule {
    private Appointment [] appointments;
    private int numAppts;
    public static final int NOT_FOUND = -1;

    /**
     Creates an instance of Schedule
     */
    public Schedule() {
        this.appointments = new Appointment[4];
        this.numAppts = 0;
    }

    /**
     Gets the appointments array from schedule
     @return An array object representing the appointment's array in the Schedule object
     */
    public Appointment[] getAppointments() { return  this.appointments; }

    /**
     Gets the numAppts from Schedule
     @return An int representing the number of appointments in the schedule object
     */
    public int getNumAppts() {return this.numAppts; }

    /**
    Checks if given appointment exists in array
     @param appt an instance of Appointment
     @return index of appointment in array if found, or NOT_FOUND otherwise
     */
    //return the index, or NOT_FOUND
    private int find(Appointment appt) {
        for (int i = 0; i < this.numAppts; i++){
            if(this.appointments[i].equals(appt)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     Increases capacity of appointment array by 4
     */
    private void grow() {
        int newSize = this.appointments.length + 4;
        Appointment newAppointmentsArray[] = new Appointment[newSize];

        for(int i = 0; i < this.appointments.length; i++){
            newAppointmentsArray[i] = this.appointments[i];
        }
        this.appointments = newAppointmentsArray;
    }

    /**
     Adds given appointment exists to array
     @param appt an instance of Appointment
     @return true if appointment successfully added into array, false otherwise
     */
    public boolean add(Appointment appt) {
        //if appointment already booked
        if (find(appt) != NOT_FOUND){
            return false;
        }
        if(numAppts >= this.appointments.length){
            grow();
            this.appointments[numAppts] = appt;
            this.numAppts++;
        }
        else {
            this.appointments[numAppts] = appt;
            this.numAppts++;
        }
        return true;
    }

    /**
     Removes given appointment exists from array
     @param appt an instance of Appointment
     @return true if appointment successfully removed from array, false otherwise.
     */
    public boolean remove(Appointment appt) {
        int shiftLeftIndex = 0;
        for (int i = 0; i < this.numAppts; i++){
            if(this.appointments[i].equals(appt)){
                shiftLeftIndex = i;
                break;
            }
        }

        if(shiftLeftIndex == 0) return false;

        for(int i = shiftLeftIndex; i < this.numAppts-1; i++) {
            this.appointments[i] = this.appointments[i+1];
        }

        this.appointments[numAppts] = null;
        this.numAppts--;
        return true;
    }

    /**
     Prints all appointments in appointments' array
     */
    public void print() {
        for(int i = 0; i < numAppts; i++){
            System.out.println(appointments[i].toString());
        }
    }
    /**
     Prints all appointments in appointments' array by zipCode
     */
    public void printByZip() {
        for (int i = 1; i < numAppts; i++) {
            Appointment appt = appointments[i];
            int j = i - 1;
            while (j >= 0 && appointments[j].getLocation().getZipCode()
                    .compareTo(appt.getLocation().getZipCode()) == -1) {
                appointments[j + 1] = appointments[j];
                j--;
            }
            appointments[j + 1] = appt;
        }
        print();
    }
    /**
     Prints all appointments in appointments' array by PatientName
     */
    public void printByPatient() {
        for (int i = 1; i < numAppts; i++) {
            Appointment appt = appointments[i];
            int j = i - 1;
            while (j >= 0 && appointments[j].getPatient().compareTo(appt.getPatient()) == -1) {
                appointments[j + 1] = appointments[j];
                j--;
            }
            appointments[j + 1] = appt;
        }
        print();
    }
}
