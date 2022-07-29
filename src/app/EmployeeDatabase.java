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
	
	/**
	 * Returns the first employee with matching surname
	 * @param surname Employee's surname
	 * @return Employee with matching surname
	 */
	public Employee findEmployee(String surname) {
		for (Employee employee : employeeList) {
			if (employee.getSurname().equals(surname))
				return employee;
		}
		
		return new NullEmployee();
	}
	
	/**
	 * Returns the first employee with matching surname and name
	 * @param surname Employee's surname
	 * @param name Employee's name
	 * @return Employee with matching surname and name
	 */
	public Employee findEmployee(String surname, String name) {
		for (Employee employee : employeeList) {
			if (employee.getSurname().equals(surname) && employee.getName().equals(name))
				return employee;
		}
		
		return new NullEmployee();
	}
	
	/**
	 * Returns a list of employees with matching surname
	 * @param surname Employee's surname
	 * @return A list of matching employees
	 */
	public List<Employee> findEmployees(String surname) {
		List<Employee> foundEmployees = new ArrayList<>();
		
		for (Employee employee : employeeList) {
			if (employee.getSurname().equals(surname))
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
	public List<Employee> findEmployees(String surname, String name) {
		List<Employee> foundEmployees = new ArrayList<>();
		
		for (Employee employee : employeeList) {
			if (employee.getSurname().equals(surname) && employee.getName().equals(name))
				foundEmployees.add(employee);
		}
		
		return foundEmployees;
	}
}
