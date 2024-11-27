package controller;

import model.GraduatedClass;
import model.GraduatedStudent;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DataImportation {

	public static GraduatedClass importGraduatedClassFrom(File file) throws FileNotFoundException {

		GraduatedClass cl = new GraduatedClass();
		GraduatedStudent student = null;

		Scanner scanner = null;

		try {
			scanner = new Scanner(file);
		} catch(FileNotFoundException ex) {
			throw ex;
		}

		while(scanner.hasNextLine()) {
			student = createStudentFromLine(scanner.nextLine());
			if(student != null)
				cl.add(student);
		}

		scanner.close();
		return cl;
	}

	private static GraduatedStudent createStudentFromLine(String line) {

		GraduatedStudent student = null;

		Scanner scanner = new Scanner(line);
		scanner.useDelimiter(";");

		int studentNumber = 0;
		String studentFirstName = "";
		String studentLastName = "";
		int studentDepartment = 0;
		String studentDegree = "";

		int index = 0;
		String element = "";

		while(scanner.hasNext()) {
			element = scanner.next();
			switch(index) {
				case 0 :
					studentNumber = Integer.parseInt(element);
					break;
				case 1 : 
					studentLastName = element;
					break;
				case 2 :
					studentFirstName = element;
					break;
				case 3 :
					studentDepartment = Integer.parseInt(element);
					break;
				case 4 :
					studentDegree = element;
					break;
				default :
					break;
			}
			++index;
		}

		if(index >= 4)
			student = new GraduatedStudent(studentNumber, studentFirstName, studentLastName, studentDepartment, studentDegree);

		scanner.close();
		return student;
	}
}
