package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.HospitalException;
import hospital.Days;
import hospital.Doctor;
import hospital.Hospital;

public class HospitalValidations {
	// int doctorId, String doctorName, String emailId, LocalDate joiningDate,
	// String speciality,
	// double salary, int experience, ArrayList<Days> avDays
	public static Doctor parseAndValidateDoctor(int doctorId, String doctorName, String emailId, String pass,
			LocalDate joiningDate, String speciality, double salary, int experience, ArrayList<Days> avDays) {
		return new Doctor(doctorId, doctorName, emailId, pass, joiningDate, speciality, salary, experience, avDays);

	}

	public static ArrayList<Days> parseAndValidateDays(String... ds) throws HospitalException {
		ArrayList<Days> days = new ArrayList<Days>();
		for (String d : ds) {
			boolean flag = false;
			// System.out.println(d);
			if (d != null) {
				for (Days dc : Days.values()) {
					// System.out.println(dc);
					if (Days.valueOf(d.toUpperCase()).equals(dc)) {
						days.add(dc);
						flag = true;
						break;
					}
				}
				if (flag == false)
					throw new HospitalException("Invalid Day");
			}
		}
		return days;
	}

	public static LocalDate parseAndValidateDate(String date) throws HospitalException {
		LocalDate checkDate = LocalDate.parse("2001-05-10");
		if (LocalDate.parse(date).isAfter(checkDate))
			return LocalDate.parse(date);
		else
			throw new HospitalException("Date must be after 10 May 2001");
	}

	public static boolean doctorSignIn(String email, String pass, Hospital hos) {
		// List docs=hos.getDoctor();
		for (Doctor d : hos.getDoctor()) {
			if (d.getEmailId().equals(email) && d.getPassword().equals(pass))
				return true;

		}
		return false;

	}

	public static boolean adminSignIn(String email, String pass) {
		String ad = "admin";

		if (email.equals(ad) && pass.equals(ad))
			return true;

		return false;

	}

}
