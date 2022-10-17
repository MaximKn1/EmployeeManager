package app;

import java.sql.SQLException;
import java.util.Scanner;

public class PrintTopCommand extends Command {

	PrintTopCommand() {
		name = "print_top";
		description = "print_top - displays top N employees";
	}
	
	@Override
	void execute(Scanner scanner) throws SQLException {
		EmployeeDatabase database = new EmployeeDatabase();
		
		while (true) {
			System.out.println("Enter number of employees to display");
			if (scanner.hasNextInt()) {
				int N = scanner.nextInt();
				if (N > 0) {
					database.printTopEmployees(N);
					break;
				}
			}
			System.out.println("Invalid number");
		}
	}

}
