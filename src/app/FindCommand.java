package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FindCommand extends Command {
	
	FindCommand() {
		name = "find";
		description = "find - search for an employee by surname and/or name";
	}
	
	@Override
	void execute(Scanner scanner) throws SQLException {
		EmployeeDatabase database = new EmployeeDatabase();
		
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
	}
}
