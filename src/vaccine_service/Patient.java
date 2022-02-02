package vaccine_service;

public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;

    public Patient(String patient) {
        String[] split = patient.split(" ");
        this.dob = new Date(split[1]);
        this.fname = split[2];
        this.lname = split[3];
    }

    public String getFname() { return this.fname; }

    public String getLname() { return this.lname; }

    public Date getDob() { return this.dob; }

    public void setFname(String fname) { this.fname = fname; }

    public void setLname(String lname) { this.lname = lname; }

    public void setDob(Date dob) { this.dob = dob; }

    @Override
    public String toString() {
        return this.fname + " " + this.lname + ", DOB: " + this.dob.toString();
    }

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
