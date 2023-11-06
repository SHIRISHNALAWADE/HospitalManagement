package hospital;

import java.io.Serializable;
import java.util.ArrayList;

public class Hospital implements Serializable {
	private ArrayList<Patient> patient;
	private ArrayList<Doctor> doctor;
	private ArrayList<Department> department;
	private static String hospitalName;
	
	static {
		hospitalName="MyHospital";
	}

	public Hospital(ArrayList<Patient> patient, ArrayList<Doctor> doctor, ArrayList<Department> department) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.department = department;
	}

	public ArrayList<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Patient p1) {
	   patient.add(p1);
	}

	public ArrayList<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor.add(doctor);
	}

	public ArrayList<Department> getDepartment() {
		return department;
	}

	public void setDepartment(ArrayList<Department> department) {
		this.department = department;
	}

	public static String getHospitalName() {
		return hospitalName;
	}

	public static void setHospitalName(String hospitalName) {
		Hospital.hospitalName = hospitalName;
	}
	
	

}
