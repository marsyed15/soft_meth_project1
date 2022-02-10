package vaccine_service;

public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;

    /**
     Creates an instance of Patient with given String
     @param patient A string with patient in mm/dd/yyyy firstName lastName format
     */
    public Patient(String patient) {
        String[] split = patient.split(" ");
        this.dob = new Date(split[0]);
        this.fname = split[1];
        this.lname = split[2];
    }

    public String getFname() { return this.fname; }

    public String getLname() { return this.lname; }

    /**
     Gets the DOB from patient
     @return A date object representing the DOB in the patient object
     */
    public Date getDob() { return this.dob; }

    /**
     Overrides toString method.
     @return Patient as a string in firstName lastName, DOB: hh/mm/yyy format
     */
    @Override
    public String toString() {
        return this.fname + " " + this.lname + ", DOB: " + this.dob.toString();
    }

    /**
     Overrides compareTo method. compares this patient with specified patient
     @param patient an instance of Patient
     @return 0 if this and specified patient are equal, -1 if this patient is
     less than specified patient, and 1 if this patient is greater than
     specified patient
     */
    @Override
    public int compareTo(Patient patient) {
        int stringCompare = 0;
        //sort by last name, then first, then dob
        if(this.lname.compareTo(patient.lname) == 0) {
            if(this.fname.compareTo(patient.fname) == 0) {
                if(this.dob.compareTo(patient.dob) == 0)
                    return 0;
                return this.dob.compareTo(patient.dob);
            }
            stringCompare = this.fname.compareTo(patient.fname);
            if(stringCompare < 0) return -1;
            else return 1;
        }
        stringCompare = this.lname.compareTo(patient.lname);
        if(stringCompare < 0) return -1;
        else return 1;
    }

    /**
     Overrides equals method.
     @param obj an object
     @return true if both objects of type patient are equal. false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient) {
            Patient patient = (Patient) obj;
            return patient.lname.equals(this.lname) && patient.fname.equals(this.fname)
                    && patient.dob.equals(this.dob);
        }
        return false;
    }

    public static void main(String[] args) {
        Patient p = new Patient("10/7/2001 Nabihah Rashid");
        Patient s = new Patient("02/15/2001 Maryam Syed");
        String res = p.toString();
        System.out.println(res);
        System.out.println(s.compareTo(p));
    }
}
