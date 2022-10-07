package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws SQLException   {
		EmployeeDatabase database = new EmployeeDatabase();
		
		database.appendEmployee(new Employee("Knyazkin", "Maxim"));
		database.appendEmployee(new Employee("Tsydypov", "Agvan"));
		
		//database.printAllEmployees();
		Employee foundEmployee = database.findEmployee("Knyazkin");
		
		/*if (foundEmployee instanceof NullEmployee)
			System.out.println("Employee not found");
		else
			System.out.println(foundEmployee.getSurname());*/
		
		String url = "jdbc:postgresql://localhost/employees";
		String user = "test";
		String password = "HelloWorld";
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String query = "SELECT * FROM employees";
		Statement statement = connection.createStatement();
		statement.execute(query);
		
		ResultSet resultSet = statement.getResultSet();
		resultSet.next();
		System.out.print(resultSet.getString("surname") + ' ');
		System.out.println(resultSet.getString("name"));
		
		connection.close();
	}

}
