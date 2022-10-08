package app;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Contains a list of employees
 */
public class EmployeeDatabase {
	Connection connection;
	
	/**
	 * Initializes a database and connects to the SQL database
	 */
	public EmployeeDatabase() throws SQLException {
		String url = "jdbc:postgresql://localhost/employees";
		String user = "test";
		String password = "HelloWorld";
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public void addEmployee(Employee employee) throws SQLException {
		String query = "INSERT INTO employees (surname, name) VALUES ('%s', '%s')";
		query = query.formatted(employee.getSurname(), employee.getName());
		
		Statement statement = connection.createStatement();
		statement.execute(query);
	}
	
	/**
	 * Prints all employees' surname and name on separate lines
	 */
	public void printAllEmployees() throws SQLException {
		String query = "SELECT * FROM employees";
		
		Statement statement = connection.createStatement();
		statement.execute(query);
		
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			System.out.print(resultSet.getString("surname") + ' ');
			System.out.println(resultSet.getString("name"));
		}
	}
	
	/**
	 * Returns a list of employees with matching surname
	 * @param surname Employee's surname
	 * @return A list of matching employees
	 */
	public List<Employee> findEmployees(String surname) throws SQLException {		
		String query = "SELECT * FROM employees WHERE surname = '%s'";
		query = query.formatted(surname);
		
		Statement statement = connection.createStatement();
		statement.execute(query);
		
		List<Employee> foundEmployees = new ArrayList<>();
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			Employee employee = new Employee(resultSet.getString("surname"), resultSet.getString("name"));
			foundEmployees.add(employee);
		}
		
		return foundEmployees;
	}
	
	/**
	 * Returns a list of employees with matching surname and name
	 * @param surname Employee's surname
	 * @param name Employee's name
	 * @return A list of matching employees
	 */
	public List<Employee> findEmployees(String surname, String name) throws SQLException {
		String query = "SELECT * FROM employees WHERE surname = '%s' AND name = '%s'";
		query = query.formatted(surname, name);
		
		Statement statement = connection.createStatement();
		statement.execute(query);
		
		List<Employee> foundEmployees = new ArrayList<>();
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			Employee employee = new Employee(resultSet.getString("surname"), resultSet.getString("name"));
			foundEmployees.add(employee);
		}
		
		return foundEmployees;
	}
}
