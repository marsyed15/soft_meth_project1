package vaccine_service;

public class Appointment {
    private Patient patient;
    private Timeslot slot;
    private Location location;

    public Appointment(String appt) {
        String[] split = appt.split(", ");
        this.patient = new Patient(split[1] + " " + split[0]);
        this.slot = new Timeslot(split[2] + " " + split[3]);
//        this.location = split[4];
    }

    public Location getLocation() {
        return this.location;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public Timeslot getSlot() {
        return this.slot;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setSlot(Timeslot slot) {
        this.slot = slot;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Appointment) {
            Appointment appointment = (Appointment) obj;
            // define equals class for Location class (?)
            return appointment.patient.equals(this.patient) && appointment.slot.equals(this.slot)
                    && appointment.location.equals(this.location);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.patient.toString() + ", " + "Appointment Detail: " + this.slot.toString() + " " + location;
    }

    public static void main(String[] args) {
        Appointment appt = new Appointment("Jane Doe, DOB: 1/19/2000, Appointment detail: 12/1/2022, 9:45, Union 07083, UNION");
        System.out.println(appt.toString());
    }

}
