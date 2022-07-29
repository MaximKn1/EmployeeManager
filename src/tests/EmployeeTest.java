package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import app.Employee;
import app.NullEmployee;

public class EmployeeTest {

	@Test
	public void testGetName() {
		Employee employee = new Employee();
		
		// Creating an empty employee
		Assert.assertTrue(employee.getName().equals(""));
		
		employee = new Employee("Knyazkin");
		
		// Creating an employee without name
		Assert.assertTrue(employee.getName().equals(""));
		
		employee = new Employee("Knyazkin", "Max");
		
		// Creating an employee
		Assert.assertTrue(employee.getName().equals("Max"));
	}

	@Test
	public void testGetSurname() {
		Employee employee = new Employee();
		
		// Creating an empty employee
		Assert.assertTrue(employee.getSurname().equals(""));
		
		employee = new Employee("Knyazkin");
		
		// Creating an employee without name
		Assert.assertTrue(employee.getSurname().equals("Knyazkin"));

		employee = new Employee("Knyazkin", "Max");
		
		// Creating an employee
		Assert.assertTrue(employee.getSurname().equals("Knyazkin"));
	}

	@Test
	public void testGetSurnameAndName() {
		Employee employee = new Employee();
		
		// Creating an empty employee
		Assert.assertTrue(employee.getSurnameAndName().equals(" "));
		
		employee = new Employee("Knyazkin");
		
		// Creating an employee without name
		Assert.assertTrue(employee.getSurnameAndName().equals("Knyazkin "));
		
		employee = new Employee("Knyazkin", "Max");
		
		// Creating an employee
		Assert.assertTrue(employee.getSurnameAndName().equals("Knyazkin Max"));
	}
	
	@Test
	public void testEmployee() {
		Employee employee = new Employee();
		
		// Creating an empty employee
		Assert.assertEquals(employee.getSurname(), "");
		Assert.assertEquals(employee.getName(), "");
		Assert.assertEquals(employee.getSurnameAndName(), " ");
	}
	
	@Test
	public void testEmployeeString() {
		Employee employee = new Employee("Knyazkin");
		
		// Creating an employee without name
		Assert.assertEquals(employee.getSurname(), "Knyazkin");
		Assert.assertEquals(employee.getName(), "");
		Assert.assertEquals(employee.getSurnameAndName(), "Knyazkin ");
	}
	
	@Test
	public void testEmployeeStringString() {
		Employee employee = new Employee("Snow", "John");
		
		// Creating an employee
		Assert.assertEquals(employee.getSurname(), "Snow");
		Assert.assertEquals(employee.getName(), "John");
		Assert.assertEquals(employee.getSurnameAndName(), "Snow John");
	}
	
	@Test
	public void testEmployeeHashCode() {
		Employee employee = new Employee("Snow", "John");
		
		// The same object
		Assert.assertEquals(employee.hashCode(), employee.hashCode());
		
		Employee secondEmployee = new Employee("Snow", "John");
		
		// The equal object
		Assert.assertEquals(employee.hashCode(), secondEmployee.hashCode());
		
		secondEmployee = new Employee("Snow", "Ramsay");
		
		// Different object
		Assert.assertNotEquals(employee.hashCode(), secondEmployee.hashCode());
		
		secondEmployee = new NullEmployee();
		
		// Null employee
		Assert.assertNotEquals(employee.hashCode(), secondEmployee.hashCode());
	}
	
	@Test
	public void testEmployeeEquals() {
		Employee employee = new Employee("Snow", "John");
		
		// Null
		Assert.assertFalse(employee.equals(null));
		
		// The same object
		Assert.assertTrue(employee.equals(employee));
		
		Employee secondEmployee = new Employee("Snow", "John");
		
		// The equal object
		Assert.assertTrue(employee.equals(secondEmployee));
		
		secondEmployee = new Employee("Snow", "Ramsay");
		
		// Different object
		Assert.assertFalse(employee.equals(secondEmployee));
		
		secondEmployee = new NullEmployee();
		
		// Null employee
		Assert.assertFalse(employee.equals(secondEmployee));
	}
}
