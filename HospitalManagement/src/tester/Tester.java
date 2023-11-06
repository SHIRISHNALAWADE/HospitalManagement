package tester;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import static utils.HospitalValidations.*;
import static utils.HospitalUtils.*;
import exception.HospitalException;
import hospital.Days;
import hospital.Doctor;
import hospital.Hospital;
import hospital.Patient;

public class Tester {

	public static void main(String[] args) {
		Hospital hospital1;
		try (Scanner sc = new Scanner(System.in)) {
			hospital1 = new Hospital(populatePatients(), populateDoctorsList(), populateDepartmentList());
			boolean exit = false;
			while (exit != true) {
				try {
					System.out.println("1:Patient registration" + "2:admin Login " + "3:Doctor Login "
							+ "4:Display details 0:EXIT");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter patientName,email, illness to register");
						Patient p = new Patient(sc.next(), sc.next(), sc.next());
						hospital1.setPatient(p);
						break;
					case 2:
						System.out.println("Enter Admin id and Password");
						if (adminSignIn(sc.next(), sc.next())) {
							boolean ex = false;
							while (ex != true) {
								try {
									System.out.println("1:Add Doctor\n"
											+ "2:Display name of specified doctor from list of dostors having highest salary\n"
											+ "3:Sort all doctors on the basis of experience\n"
											+ "4:search all doctors who are Orthopedics\n"
											+ "5:Store and Restore Doctors in and out of bin file  \n"
											+ "0:Admin Logout");
									switch (sc.nextInt()) {
									case 1:
										System.out.println("Enter doctorId , doctorName, emailId, password ,\n"
												+ "	joiningDate, speciality, salary, experience");
										int id = sc.nextInt();
										String nm = sc.next();
										String eml = sc.next();
										String ps = sc.next();
										String jd = sc.next();
										String sp = sc.next();
										double sl = sc.nextDouble();
										int ep = sc.nextInt();
										System.out.println("Enter doctor available days");
										char c = 'y';
										int cont = 0;
										String[] ds = new String[7];
										while (c == 'y') {
											if (cont < 7) {
												System.out.println("Enter day of week");
												ds[cont] = sc.next();
												System.out.println("Do you want add a day y/n");
												c = sc.next().charAt(0);
												cont++;
											} else
												System.out.println("No Days to Add");
										}
										Doctor dd = new Doctor(id, nm, eml, ps, parseAndValidateDate(jd), sp, sl, ep,
												parseAndValidateDays(ds));
										hospital1.setDoctor(dd);
										System.out.println("Doctor add successfully");
										break;
									case 2:
										Doctor doc11 = null;
										double hsal = 0.00;
										// hospital1.getDoctor().stream().forEach(d -> d.getSalary())
										for (Doctor d : hospital1.getDoctor()) {
											if (d.getSalary() > hsal) {
												doc11 = d;
												hsal = d.getSalary();
											}
										}
										System.out.println("Doctor With Highest Salary is");
										System.out.println(doc11);
										break;
									case 3:
										System.out.println("Sorting Doctors on their Experience");
										hospital1.getDoctor().sort(new Comparator<Doctor>() {

											@Override
											public int compare(Doctor o1, Doctor o2) {
												// TODO Auto-generated method stub
												return ((Integer) o1.getExperience()).compareTo(o2.getExperience());
											}

										});
										hospital1.getDoctor().stream().forEach(System.out::println);
										break;
									case 4:
										System.out.println("Doctors who are Orthopedics");
										hospital1.getDoctor().stream()
												.filter(pp -> pp.getSpeciality().toLowerCase().equals("orthopedics"))
												.forEach(System.out::println);
										break;
									case 5:
										System.out.println("Enter File path");
										String chc = sc.nextLine();
										String fl = sc.nextLine();
										if(chc!=null)
										fl.concat(chc);
										writeDoctorsToFile(hospital1, fl);
										System.out.println("Restoring and displaying doctors");
										readDoctorsFromFile(fl);
										break;
									case 0:
										System.out.println("Logged Out");
										ex = true;
										break;
									}
								} catch (Exception e) {
									System.out.println(e);
								}
							}
						} else
							System.out.println("Wrong email or password");

						break;
					case 3:
						System.out.println("Enter Doctor email and password");
						if (doctorSignIn(sc.next(), sc.next(), hospital1)) {
							System.out.println("signed in");
						} else
							System.out.println("Wrong email or password");

						break;
					case 4:
						System.out.println("----Patients");
						System.out.println(hospital1.getPatient());
						System.out.println("----Doctors");
						System.out.println(hospital1.getDoctor());
						System.out.println("----Departments");
						System.out.println(hospital1.getDepartment());
						break;
					case 0:
						exit = true;
						break;

					}

				} catch (Exception h) {
					System.out.println(h);
				}
			}
		} catch (HospitalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
