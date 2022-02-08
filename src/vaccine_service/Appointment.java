package vaccine_service;

public class Appointment {
    private Patient patient;
    private Timeslot slot;
    private Location location;

    public Appointment(String appt) {
        String[] split = appt.split(" ");
        this.patient = new Patient(split[0] + " " + split[1] + " " + split[2]);
        this.slot = new Timeslot(split[3] + " " + split[4]);
        switch(split[5].toLowerCase()){
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
        Appointment appt = new Appointment("8/31/1978 Jane Doe 9/19/2022 9:15 union");
        Appointment appt2 = new Appointment("7/31/1992 Chris Young 2/27/2022 11:15 Morris");
        Appointment appt3 = new Appointment("2/29/2008 Roy Brooks 4/30/2022 10:30 middlesex");
        Appointment appt4 = new Appointment("2/29/2011 John Doe 3/32/2022 9:45 SOMERSET");
        System.out.println(appt.equals(appt2));
        Schedule schedule = new Schedule();
        schedule.add(appt);
        schedule.add(appt2);
        schedule.add(appt3);
        schedule.add(appt4);
        schedule.print();
        schedule.printByPatient();
    }

}
