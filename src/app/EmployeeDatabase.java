package app;

import java.util.List;
import java.util.ArrayList;

public class EmployeeDatabase {
	List<Employee> employeeList;
	
	public EmployeeDatabase() {
		employeeList = new ArrayList<>();
	}
	
	public EmployeeDatabase(EmployeeDatabase base) {
		employeeList = new ArrayList<>(base.getDataBase());
	}
	
	public EmployeeDatabase(List<Employee> empList) {
		employeeList = new ArrayList<>(empList);
	}
	
	public void appendEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void printAllEmployees() {
		employeeList.forEach(emp -> System.out.println(emp.getSurnameAndName()));
	}
	
	public List<Employee> getDataBase() {
		return employeeList;
	}
}
