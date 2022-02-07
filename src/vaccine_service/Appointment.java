package vaccine_service;

public class Appointment {
    private Patient patient;
    private Timeslot slot;
    private Location location;

    public Appointment(String appt) {
        String[] split = appt.split(" ");
        this.patient = new Patient(split[3] + " " + split[0] + " " + split[1]);
        this.slot = new Timeslot(split[6] + " " + split[7]);
        switch(split[8].toLowerCase()){
            case("somerset"):
                this.location = Location.SOMERSET;
                break;
            case("morris"):
                this.location = Location.MORRIS;
                break;
            case("middlesex"):
                this.location = Location.MIDDLESEX;
                break;
            case("mercer"):
                this.location = Location.MERCER;
                break;
            case("union"):
                this.location = Location.UNION;
                break;
            default:
                //send back error message
        }

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
                    && appointment.location == this.location;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.patient.toString() + ", " + "Appointment Detail: " + this.slot.toString() + ", " +
                location.getCityName() + " " + location.getZipCode() + ", " + location;
    }

    public static void main(String[] args) {
        Appointment appt = new Appointment("Jane Doe DOB: 1/19/2000 Appointment detail: 12/1/2022 9:45 Union");
        Appointment appt2 = new Appointment("Jane Doe DOB: 1/19/2001 Appointment detail: 12/1/2022 9:45 Union");
        System.out.println(appt.equals(appt2));
        System.out.println(appt.toString());
    }

}
