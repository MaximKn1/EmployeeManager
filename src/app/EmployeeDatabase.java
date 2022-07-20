package app;

import java.util.List;
import java.util.ArrayList;

/**
 * Contains a list of employees
 */
public class EmployeeDatabase {
	List<Employee> employeeList;
	
	/**
	 * Initializes a database with an empty ArrayList
	 */
	public EmployeeDatabase() {
		employeeList = new ArrayList<>();
	}
	
	/**
	 * Creates a new database by copying an existing one
	 * @param base Existing database
	 */
	public EmployeeDatabase(EmployeeDatabase base) {
		employeeList = new ArrayList<>(base.getDataBase());
	}
	
	/**
	 * Creates a new database by copying an existing list of employees
	 * @param empList
	 */
	public EmployeeDatabase(List<Employee> empList) {
		employeeList = new ArrayList<>(empList);
	}
	
	public void appendEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	/**
	 * Prints all employees' surname and name on separate lines
	 */
	public void printAllEmployees() {
		employeeList.forEach(emp -> System.out.println(emp.getSurnameAndName()));
	}
	
	public List<Employee> getDataBase() {
		return employeeList;
	}
}
