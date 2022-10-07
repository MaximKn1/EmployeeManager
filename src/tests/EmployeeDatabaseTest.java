package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import app.Employee;
import app.EmployeeDatabase;
import app.NullEmployee;

public class EmployeeDatabaseTest {

	@Test
	public void testEmployeeDatabase() {
		// Creating an empty database
		EmployeeDatabase database = new EmployeeDatabase();
		Assert.assertTrue(database.getDataBase().isEmpty());
	}

	@Test
	public void testEmployeeDatabaseEmployeeDatabase() {
		// Copying existing empty database
		EmployeeDatabase firstBase = new EmployeeDatabase();
		EmployeeDatabase secondBase = new EmployeeDatabase(firstBase);
		Assert.assertTrue(secondBase.getDataBase().isEmpty());

		// Copying existing database
		firstBase = new EmployeeDatabase();
		firstBase.appendEmployee(new Employee("Knyazkin", "Max"));
		secondBase = new EmployeeDatabase(firstBase);
		Assert.assertFalse(secondBase.getDataBase().isEmpty());
	}

	@Test
	public void testEmployeeDatabaseListOfEmployee() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Knyazkin", "Max"));
		list.add(new Employee("Tsydypov", "Agvan"));
		list.add(new Employee("John", "Snow"));

		// Creating database from list
		EmployeeDatabase database = new EmployeeDatabase(list);
		Assert.assertEquals(list, database.getDataBase());
	}

	@Test
	public void testAppendEmployee() {
		EmployeeDatabase database = new EmployeeDatabase();
		database.appendEmployee(new Employee("Knyazkin", "Max"));

		List<Employee> employees = database.getDataBase();
		Employee employee = employees.get(0);

		// Adding employee to the database
		Assert.assertEquals(employee.getSurname(), "Knyazkin");
		Assert.assertEquals(employee.getName(), "Max");
	}

	@Test
	public void testPrintAllEmployees() {
		fail("Not implemented yet");
	}

	@Test
	public void testGetDataBase() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Knyazkin", "Max"));
		list.add(new Employee("Tsydypov", "Agvan"));
		list.add(new Employee("John", "Snow"));

		// Getting a list from a database
		EmployeeDatabase database = new EmployeeDatabase(list);
		Assert.assertEquals(list, database.getDataBase());
	}

	@Test
	public void testFindEmployeeString() {
		EmployeeDatabase database = new EmployeeDatabase();
		Employee foundEmployee = database.findEmployee("John");

		// Finding employee in an empty database
		Assert.assertTrue(foundEmployee instanceof NullEmployee);

		Employee employee = new Employee("Knyazkin", "Max");
		database.appendEmployee(employee);
		database.appendEmployee(new Employee("Tsydypov", "Agvan"));
		database.appendEmployee(new Employee("John", "Snow"));

		foundEmployee = database.findEmployee("Knyazkin");

		// Finding employee
		Assert.assertEquals(employee, foundEmployee);

		foundEmployee = database.findEmployee("Ackerman");

		// Trying to find employee that is not in a database
		Assert.assertTrue(foundEmployee instanceof NullEmployee);
	}

	@Test
	public void testFindEmployeeStringString() {
		EmployeeDatabase database = new EmployeeDatabase();
		Employee foundEmployee = database.findEmployee("John", "S");

		// Finding employee in an empty database
		Assert.assertTrue(foundEmployee instanceof NullEmployee);

		Employee employee = new Employee("Knyazkin", "Max");
		database.appendEmployee(employee);
		database.appendEmployee(new Employee("Tsydypov", "Agvan"));
		database.appendEmployee(new Employee("John", "Snow"));

		foundEmployee = database.findEmployee("Knyazkin", "Max");

		// Finding employee
		Assert.assertEquals(employee, foundEmployee);

		foundEmployee = database.findEmployee("Ackerman", "Mikasa");

		// Trying to find employee that is not in a database
		Assert.assertTrue(foundEmployee instanceof NullEmployee);
	}

	@Test
	public void testFindEmployeesString() {
		EmployeeDatabase database = new EmployeeDatabase();

		List<Employee> foundList = database.findEmployees("Knyazkin");

		// Trying to find employees that are not in a database
		Assert.assertTrue(foundList.isEmpty());

		Employee employee = new Employee("Knyazkin", "Max");
		database.appendEmployee(employee);
		database.appendEmployee(new Employee("Tsydypov", "Agvan"));
		database.appendEmployee(new Employee("John", "Snow"));

		List<Employee> list = new ArrayList<>();
		list.add(employee);

		foundList = database.findEmployees("Knyazkin");

		// Finding a list of employees
		Assert.assertEquals(list, foundList);

		list.add(employee);
		database = new EmployeeDatabase(list);
		foundList = database.findEmployees("Knyazkin");

		// Finding a list of employees
		Assert.assertEquals(list, foundList);
	}

	@Test
	public void testFindEmployeesStringString() {
		EmployeeDatabase database = new EmployeeDatabase();

		List<Employee> foundList = database.findEmployees("Knyazkin", "Max");

		// Trying to find employees that are not in a database
		Assert.assertTrue(foundList.isEmpty());

		Employee employee = new Employee("Knyazkin", "Max");
		database.appendEmployee(employee);
		database.appendEmployee(new Employee("Tsydypov", "Agvan"));
		database.appendEmployee(new Employee("John", "Snow"));

		List<Employee> list = new ArrayList<>();
		list.add(employee);

		foundList = database.findEmployees("Knyazkin", "Max");

		// Finding a list of employees
		Assert.assertEquals(list, foundList);

		list.add(employee);
		database = new EmployeeDatabase(list);
		foundList = database.findEmployees("Knyazkin", "Max");

		// Finding a list of employees
		Assert.assertEquals(list, foundList);
	}

}
