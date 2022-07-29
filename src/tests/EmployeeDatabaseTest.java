package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import app.Employee;
import app.EmployeeDatabase;

public class EmployeeDatabaseTest {

	@Test
	public void testEmployeeDatabase() {
		EmployeeDatabase database = new EmployeeDatabase();
		Assert.assertTrue(database.getDataBase().isEmpty());
	}

	@Test
	public void testEmployeeDatabaseEmployeeDatabase() {
		EmployeeDatabase firstBase = new EmployeeDatabase();
		EmployeeDatabase secondBase = new EmployeeDatabase(firstBase);
		Assert.assertTrue(secondBase.getDataBase().isEmpty());
		
		firstBase = new EmployeeDatabase();
		firstBase.appendEmployee(new Employee("Knyazkin", "Max"));
		secondBase = new EmployeeDatabase(firstBase);
		Assert.assertTrue(!secondBase.getDataBase().isEmpty());
	}

	@Test
	public void testEmployeeDatabaseListOfEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testAppendEmployee() {
		EmployeeDatabase database = new EmployeeDatabase();
		database.appendEmployee(new Employee("Knyazkin", "Max"));
		
		List<Employee> employees = database.getDataBase();
		Employee employee = employees.get(0);
		
		Assert.assertTrue(employee.getSurname().equals("Knyazkin"));
		Assert.assertTrue(employee.getName().equals("Max"));
	}

	@Test
	public void testPrintAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataBase() {
		EmployeeDatabase database = new EmployeeDatabase();
		database.appendEmployee(new Employee("Knyazkin", "Max"));
		
		List<Employee> employees = database.getDataBase();
		Employee employee = employees.get(0);
		
		Assert.assertTrue(employee.getSurname().equals("Knyazkin"));
		Assert.assertTrue(employee.getName().equals("Max"));
	}

	@Test
	public void testFindEmployeeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmployeeStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmployeesString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmployeesStringString() {
		fail("Not yet implemented");
	}

}
