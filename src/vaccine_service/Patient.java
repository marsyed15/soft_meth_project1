package vaccine_service;

public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;

    @Override
    public String toString() {
        String patient = this.fname + ' ' + this.lname + ' ';
        //I want to add this.dob.month.toString() but it keeps giving me error
        return patient;
    }

    @Override
    public int compareTo(Patient patient) {
        if(this.fname.equals(patient.fname) && this.lname.equals(patient.lname)
            && this.dob.compareTo(patient.dob) == 0) {
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        Patient p = new Patient();
        Date dob = new Date("10/7/2001");
        p.fname = "Nabihah";
        p.lname = "Rashid";
        p.dob = dob;
        String res = p.toString();
        System.out.println(res);
    }
}
