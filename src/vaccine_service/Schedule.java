package vaccine_service;


public class Schedule {
    private Appointment [] appointments;
    private int numAppts;

    //return the index, or NOT_FOUND
    private int find(Appointment appt) {
        for (int i = 0; i < numAppts; i++){
            if(appointments[i] == appt){
                return i;
            }
        }
        return -1;
    }

    //increase the capacity of the container by 4
    private void grow() {
        int newSize = appointments.length + 4;
        Appointment newArray[]=new Appointment[newSize];
        for(int i=0; i<newArray.length;i++){
            newArray[i]=appointments[i];
        }
        this.appointments=newArray;

    }
    public boolean add(Appointment appt) {
        //if first appt to add
        if(numAppts == 0){
            this.appointments = new Appointment[4];
            this.appointments[0] = appt;
            this.numAppts++;
        }
        else if(numAppts >= this.appointments.length){
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
