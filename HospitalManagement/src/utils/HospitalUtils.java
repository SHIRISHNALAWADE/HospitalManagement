package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.HospitalException;

import static utils.HospitalValidations.*;

import hospital.Days;
import hospital.Department;
import hospital.Doctor;
import hospital.Hospital;
import hospital.Patient;

public class HospitalUtils {

	public static ArrayList<Doctor> populateDoctorsList() throws HospitalException {
		Doctor d1 = new Doctor(4500, "Rohit", "rohit@", "passr", parseAndValidateDate("2002-04-08"), "Psychiatry",
				50000, 12, parseAndValidateDays("SUNDAY", "WEDNESDAY"));
		Doctor d2 = new Doctor(4600, "Mohit", "moit@", "passm", parseAndValidateDate("2003-05-08"),
				"Emergency Medicine", 60000, 10, parseAndValidateDays("MONDAY", "WEDNESDAY"));
		Doctor d3 = new Doctor(4700, "Kunal", "kunal@", "passk", parseAndValidateDate("2003-06-04"), "Pediatrics",
				70000, 11, parseAndValidateDays("MONDAY", "WEDNESDAY"));
		Doctor d4 = new Doctor(4800, "Veena", "veena@", "passv", parseAndValidateDate("2004-07-02"), "Neurology", 50000,
				13, parseAndValidateDays("SUNDAY", "THURSDAY", "WEDNESDAY"));
		Doctor d5 = new Doctor(4900, "Madhuri", "maduri@", "passm", parseAndValidateDate("2002-08-03"), "Surgery",
				60000, 12, parseAndValidateDays("SUNDAY", "MONDAY", "WEDNESDAY"));
		Doctor d6 = new Doctor(4900, "Tushar", "tushar@", "passt", parseAndValidateDate("2002-10-13"), "Orthopedics",
				85000, 12, parseAndValidateDays("SUNDAY", "TUESDAY", "MONDAY", "WEDNESDAY"));
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		list.add(d5);
		list.add(d6);
		return list;
	}

	// int doctorId, String doctorName, String emailId, LocalDate joiningDate,
	// String speciality,
	// double salary, int experience, ArrayList<Days> avDays
	public static ArrayList<Department> populateDepartmentList() throws HospitalException {
		Doctor d1 = new Doctor(4500, "Rohit", "rohit@", "passr", parseAndValidateDate("2002-04-08"), "Psychiatry",
				50000, 12, parseAndValidateDays("SUNDAY", "WEDNESDAY"));
		Doctor d2 = new Doctor(4600, "Mohit", "moit@", "passm", parseAndValidateDate("2003-05-08"),
				"Emergency Medicine", 60000, 10, parseAndValidateDays("MONDAY", "WEDNESDAY"));
		Doctor d3 = new Doctor(4700, "Kunal", "kunal@", "passk", parseAndValidateDate("2003-06-04"), "Pediatrics",
				70000, 11, parseAndValidateDays("MONDAY", "WEDNESDAY"));
		Doctor d4 = new Doctor(4800, "Veena", "veena@", "passv", parseAndValidateDate("2004-07-02"), "Neurology", 50000,
				13, parseAndValidateDays("SUNDAY", "THURSDAY", "WEDNESDAY"));
		Doctor d5 = new Doctor(4900, "Madhuri", "maduri@", "passm", parseAndValidateDate("2002-08-03"), "Surgery",
				60000, 12, parseAndValidateDays("SUNDAY", "MONDAY", "WEDNESDAY"));
		Doctor d6 = new Doctor(4900, "Tushar", "tushar@", "passt", parseAndValidateDate("2002-10-13"), "Orthopedics",
				85000, 12, parseAndValidateDays("SUNDAY", "TUESDAY", "MONDAY", "WEDNESDAY"));
		ArrayList<Doctor> l1 = new ArrayList<Doctor>();
		ArrayList<Doctor> l2 = new ArrayList<Doctor>();
		ArrayList<Doctor> l3 = new ArrayList<Doctor>();
		ArrayList<Doctor> l4 = new ArrayList<Doctor>();
		ArrayList<Doctor> l5 = new ArrayList<Doctor>();
		ArrayList<Doctor> l6 = new ArrayList<Doctor>();
		l1.add(d1);
		l2.add(d2);
		l3.add(d3);
		l4.add(d4);
		l5.add(d5);
		l6.add(d6);

		Department dp1 = new Department("Psychiatry", l1, "Floor 1");
		Department dp2 = new Department("Emergency", l2, "Floor G");
		Department dp3 = new Department("Pediatrics", l3, "Floor 2");
		Department dp4 = new Department("Neurology", l4, "Floor 3");
		Department dp5 = new Department("Surgery", l5, "Floor 4");
		Department dp6 = new Department("Orthopedics", l6, "Floor 5");

		ArrayList<Department> deps = new ArrayList<Department>();
		deps.add(dp1);
		deps.add(dp2);
		deps.add(dp3);
		deps.add(dp4);
		deps.add(dp5);
		deps.add(dp6);
		return deps;
	}

	public static ArrayList<Patient> populatePatients() {
		ArrayList<Patient> plist = new ArrayList<Patient>();
		Patient p1 = new Patient("Yash", "yash@", "xyz1");
		Patient p2 = new Patient("Pritam", "pritam@", "xyz2");
		Patient p3 = new Patient("Bhushan", "bhushan@", "xyz3");
		Patient p4 = new Patient("Ankit", "ankit@", "xyz4");
		Patient p5 = new Patient("Sourabh", "sourabh@6", "xyz5");
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		plist.add(p5);
		return plist;
	}

//	public static addDoctor() {
//		
//	}
	public static void writeDoctorsToFile(Hospital hs, String filename) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
//			hs.getDoctor().stream().forEach(d -> {
//				try {
//					out.writeObject(d);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			
//			});
			out.writeObject(hs.getDoctor());
			// out.close();
		}
	}


	public static void readDoctorsFromFile(String filename)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			List<?> nl = (List<?>) in.readObject();
			nl.stream().forEach(System.out::println);
			// out.close();
		}
	}

}
