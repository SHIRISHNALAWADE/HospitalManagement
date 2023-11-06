package hospital;

//import java.util.Objects;

public class Patient {
	private int patientId;
	private String patientName;
	private String illness;
	private String email;
	private static int count;
	static {
		count=100;
	}
	
	public Patient(String patientName, String email, String illness) {
		super();
		this.patientId = count++;
		this.patientName = patientName;
		this.illness = illness;
		this.email = email;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", illness=" + illness + ", email="
				+ email + "]\n";
	}
	
	
	
	

}
