package vaccine_service;


public class Schedule {
    private Appointment [] appointments;
    private int numAppts;
    public static final int NOT_FOUND = -1;

    public Schedule() {
        this.appointments = new Appointment[4];
        this.numAppts = 0;

    }
    //return the index, or NOT_FOUND
    private int find(Appointment appt) {
        for (int i = 0; i < this.numAppts; i++){
            if(this.appointments[i].equals(appt)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    //increase the capacity of the container by 4
    private void grow() {
        int newSize = this.appointments.length + 4;
        Appointment newAppointmentsArray[] = new Appointment[newSize];

        for(int i = 0; i < this.appointments.length; i++){
            newAppointmentsArray[i] = this.appointments[i];
        }
        this.appointments = newAppointmentsArray;
    }

    public boolean add(Appointment appt) {
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

    //print all the appointments in current order
    public void print() {
        for(int i = 0; i < numAppts; i++){
            System.out.println(appointments[i]);
        }

    }

    //sort by zip codes and print
    public void printByZip() {

    }
    //sort by patient and print
    public void printByPatient() {

    }
}
