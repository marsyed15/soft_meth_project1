package vaccine_service;

/**
 Represents a vaccine appointment with three fields: a patient object, timeslot
 object, and a location.
 @author nabihah, maryam
 */
public class Appointment {
    private Patient patient;
    private Timeslot slot;
    private Location location;

    /**
     Creates an instance of Appointment with given String
     @param appt A string with appointment in this format:
     "hh/mm/yyy" (DOB), followed by "firstName lastName", followed by
     "hh/mm/yyy mm:hh location"
     */
    public Appointment(String appt) {
        String[] split = appt.split(" ");
        this.patient = new Patient(split[0] + " " + split[1] + " " + split[2]);
        this.slot = new Timeslot(split[3] + " " + split[4]);
        switch(split[5].toLowerCase()) {
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

    /**
     Gets the Location from Appointment
     @return A location object representing the location in the appointment obj
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     Gets the Patient from Appointment
     @return A Patient object representing the Patient in the appointment obj
     */
    public Patient getPatient() {
        return this.patient;
    }

    /**
     Gets the Timeslot from Appointment
     @return A timeslot object representing the timeslot in the appointment object
     */
    public Timeslot getSlot() {
        return this.slot;
    }

    /**
     Overrides equals method. Two appointments are equal if the patient objects,
     timeslot objects, and locations are equal.
     @param obj an object
     @return true if both objects of type appointment are equal. false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Appointment) {
            Appointment appointment = (Appointment) obj;
            return appointment.patient.equals(this.patient) &&
                    appointment.slot.equals(this.slot)
                    && appointment.location == this.location;
        }
        return false;
    }

    /**
     Overrides toString method.
     @return Appointment as a string in "firstName lastName hh/mm/yyyy,
     Appointment Detail: hh/mm/yyy, hh:mm, locationCityName locationZipCode,
     location" format
     */
    @Override
    public String toString() {
        return this.patient.toString() + ", " + "Appointment Detail: " +
                this.slot.toString() + ", " + location.getCityName() + " " +
                location.getZipCode() + ", " + location;
    }
}
