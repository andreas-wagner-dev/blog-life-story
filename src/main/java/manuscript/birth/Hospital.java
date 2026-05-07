package manuscript.birth;

public class Hospital {
    
    private final String name;
    
    public Hospital(String name) {
        this.name = name;
    }
    
    public void admitPatient(String patientName) {
        System.out.println("🏥 " + patientName + " wird im " + name + " aufgenommen.");
    }
    
    public void deliverBaby(String babyName) {
        System.out.println("👶 " + babyName + " wurde im " + name + " geboren!");
    }
}