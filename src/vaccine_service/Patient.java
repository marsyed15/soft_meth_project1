package vaccine_service;

public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;

    public Patient(String patient) {
        String[] split = patient.split(" ");
        this.dob = new Date(split[0]);
        this.fname = split[1];
        this.lname = split[2];
    }

    @Override
    public String toString() {
        //does it have to be in a specific order?
        String patient = this.fname + ' ' + this.lname + ' ';
        //I want to add this.dob.month.toString() but it keeps giving me error
        return patient;
    }

    @Override
    public int compareTo(Patient patient) {
        //sort by last name, then first, then dob
        if(this.lname.compareTo(patient.lname) == 0) {
            if(this.fname.compareTo(patient.fname) == 0) {
                if(this.dob.compareTo(patient.dob) == 0)
                    return 0;
                return this.dob.compareTo(patient.dob);
            }
            return this.fname.compareTo(patient.fname);
        }
        return this.lname.compareTo(patient.lname);
    }

    public static void main(String[] args) {
        Patient p = new Patient("10/7/2001 Nabihah Rashid");
        String res = p.toString();
        System.out.println(res);
    }
}
