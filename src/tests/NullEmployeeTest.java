package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import app.Employee;
import app.NullEmployee;

public class NullEmployeeTest {

	@Test
	public void testNullEmployee() {
		Employee employee = new NullEmployee();
		
		Assert.assertTrue(employee.getName().equals("None"));
		
		Assert.assertTrue(employee.getSurname().equals("None"));
		
		Assert.assertTrue(employee.getSurnameAndName().equals("None None"));
	}

}
