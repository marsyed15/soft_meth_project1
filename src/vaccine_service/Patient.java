package vaccine_service;

public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Patient patient) {
        return 0;
    }
}
