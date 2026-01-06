package mailMerger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.ArrayList;

public class MailMergerMain {
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static final String NEXT_LINE = "\n";
	public static void main(String[] args) {
		readFromFile();
		diplayStudents();
		writeToFile();
	}

	private static void writeToFile() {
		for (Student student : students) {
			if (student.getDuration() < 100) {
				String fileName = student.getName().toUpperCase();
				File file = new File(fileName.trim() + ".txt");
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
					try {
					bw.write("Hello "+student.getName()+NEXT_LINE);
					
					bw.write("You didn't last too long at the lecture today! ("+student.getDuration()+" mins.) You need to stay for the full duration."+NEXT_LINE);
					}catch(DateTimeException e) {
						System.err.println("ERROR WITH DURATION CALCULATION - SKIPPING LINE");
						continue;
					}
					bw.write("Student: "+student.getName()+NEXT_LINE);
					bw.write("Student Number: "+ student.getStudentNumber()+NEXT_LINE);
					bw.write("Log on time: "+student.getLogOnTime()+NEXT_LINE);
					bw.write("Log off time: "+student.getLogOffTime()+NEXT_LINE);
					bw.write("Email: "+student.getEmail()+NEXT_LINE);
					System.out.println("File SMASHED");
				} catch (IOException e) {
					System.err.println("ERROR WRITING TO FILE");
					e.printStackTrace();
				}
			}
		}
	}

	private static void diplayStudents() {
		for (Student student : students) {
			student.displayAll();
			System.out.println();
		}
	}

	private static void readFromFile() {
		File file = new File("input.csv");
//		if(file.exists()) {
//			System.out.println("EXISTS");
//		}
		// name,student number,logon,logoff,email
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			br.readLine();
			String nextLine = br.readLine();
			while (nextLine != null) {
				String[] data = nextLine.split(",");
				if (data.length >= 5) {
					Student student = new Student();
					student.setName(data[0]);
					try {
						student.setStudentNumber(Integer.parseInt(data[1]));
					} catch (NumberFormatException e) {
						System.err.println("ERROR WITH PARSING INT: " + data[1] + "\nSkipping line");
						nextLine = br.readLine();
						continue;
					}
					student.setLogOnTime(data[2]);
					student.setLogOffTime(data[3]);
					student.setEmail(data[4]);
					students.add(student);
				} else {
					System.err.println("ERROR WITH PARSING - SKIPPING LINE " + nextLine);
				}
				nextLine = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
