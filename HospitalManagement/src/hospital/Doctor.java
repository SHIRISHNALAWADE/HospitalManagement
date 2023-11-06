package hospital;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Arrays;

public class Doctor implements Serializable{
	private int doctorId;
	private String doctorName;
	private String emailId;
	private String password;
	private LocalDate joiningDate;
	private String speciality;
	private double salary;
	private int experience;
	//private String availableDays[];
	private ArrayList<Days> avDays;
	
	public Doctor(int doctorId, String doctorName, String emailId, String password, LocalDate joiningDate,
			String speciality, double salary, int experience, ArrayList<Days> avDays) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.emailId = emailId;
		this.password = password;
		this.joiningDate = joiningDate;
		this.speciality = speciality;
		this.salary = salary;
		this.experience = experience;
		this.avDays = avDays;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public ArrayList<Days> getAvDays() {
		return avDays;
	}
	public void setAvDays(ArrayList<Days> avDays) {
		this.avDays = avDays;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", emailId=" + emailId + ", joiningDate="
				+ joiningDate + ", speciality=" + speciality + ", salary=" + salary + ", experience=" + experience
				+ ",\n avDays=" + avDays + "]\n";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	

}
