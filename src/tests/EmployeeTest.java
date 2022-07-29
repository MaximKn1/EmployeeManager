package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import app.Employee;

public class EmployeeTest {

	@Test
	public void testGetName() {
		Employee employee = new Employee();
		Assert.assertTrue(employee.getName().equals(""));
		
		employee = new Employee("Knyazkin");
		Assert.assertTrue(employee.getName().equals(""));
		
		employee = new Employee("Knyazkin", "Max");
		Assert.assertTrue(employee.getName().equals("Max"));
	}

	@Test
	public void testGetSurname() {
		Employee employee = new Employee();
		Assert.assertTrue(employee.getSurname().equals(""));
		
		employee = new Employee("Knyazkin");
		Assert.assertTrue(employee.getSurname().equals("Knyazkin"));

		employee = new Employee("Knyazkin", "Max");
		Assert.assertTrue(employee.getSurname().equals("Knyazkin"));
	}

	@Test
	public void testGetSurnameAndName() {
		Employee employee = new Employee();
		Assert.assertTrue(employee.getSurnameAndName().equals(" "));
		
		employee = new Employee("Knyazkin");
		Assert.assertTrue(employee.getSurnameAndName().equals("Knyazkin "));
		
		employee = new Employee("Knyazkin", "Max");
		Assert.assertTrue(employee.getSurnameAndName().equals("Knyazkin Max"));
	}

}
