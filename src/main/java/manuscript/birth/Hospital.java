package manuscript.birth;

/**
 * Hospital.
 */
public class Hospital {
    
    private final String name;
    
    public Hospital(String name) {
        this.name = name;
    }
    
    public void admitPatient(String patientName) {
        System.out.println("🏥 " + patientName + " is admitted to " + name + ".");
    }
    
    public void deliverBaby(String babyName) {
        System.out.println("👶 " + babyName + " was born in " + name + "!");
    }
}