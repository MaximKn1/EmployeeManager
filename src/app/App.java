package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {
		EmployeeDatabase database = new EmployeeDatabase();
		
		Scanner scanner = new Scanner(System.in);
		String entry;
		System.out.println("Enter 'help' to print available commands");
		while (true) {
			System.out.println("Enter command");
			entry = scanner.nextLine();
			
			if (entry.equals("find")) {
				while (true) {
					System.out.println("Enter employee's surname");
					String surname = scanner.nextLine();
					System.out.println("Enter employee's name");
					String name = scanner.nextLine();
					
					if (name.isEmpty() && surname.isEmpty()) {
						System.out.println("Please try again");
					} else  {
						List<Employee> foundEmployees;
						if (surname.isEmpty()) {
							foundEmployees = database.findEmployeesByName(name);
						} else if (name.isEmpty()) {
							foundEmployees = database.findEmployees(surname);
						} else {
							foundEmployees = database.findEmployees(surname, name);
						}
						
						if (foundEmployees.isEmpty()) {
							System.out.println("No employees found");
						} else {
							foundEmployees.forEach(emp -> System.out.println(emp.getSurnameAndName()));					
						}
						break;
					}
				}
			} else if (entry.equals("help")) {
				System.out.println("find - look for employee by surname and/or name");
				System.out.println("exit - close app");
			} else if (entry.equals("exit")) {
				break;
			}
		}
		scanner.close();
		
		System.out.println("App closed");
	}

}
