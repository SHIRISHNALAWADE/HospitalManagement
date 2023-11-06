package hospital;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Arrays;

public class Department implements Serializable {
	private String deptName;
	private ArrayList<Doctor> doctors;
	private String floorNo;
	public Department(String deptName, ArrayList<Doctor> doctors, String floorNo) {
		super();
		this.deptName = deptName;
		this.doctors = doctors;
		this.floorNo = floorNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ",\n doctors=" + doctors + ",floorNo=" + floorNo + "]\n";
	}
	
	

}
