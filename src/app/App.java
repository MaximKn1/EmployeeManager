package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class App {

	public static void main(String[] args) throws SQLException   {
		EmployeeDatabase database = new EmployeeDatabase();
		
		//database.addEmployee(new Employee("Carmack", "John"));
		//database.addEmployee(new Employee("Romero", "John"));
		
		database.printAllEmployees();
		List<Employee> foundEmployees = database.findEmployees("Knyazkin");
		
		for (Employee employee : foundEmployees) {
			System.out.println(employee.getSurname() + ' ' + employee.getName());
		}
	}

}
