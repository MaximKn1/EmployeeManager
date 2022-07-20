package app;

import java.lang.StringBuilder;
import java.util.Objects;

/**
 * Employee class is used to store info about single employee
 */
public class Employee {
	private String surname;
	private String name;
	
	/**
	 * Creates an employee with empty surname and name
	 */
	public Employee() {
		surname = "";
		name = "";
	}
	
	/**
	 * Creates an employee with a surname and empty name
	 * @param newSurname Surname of the employee
	 */
	public Employee(String newSurname) {
		surname = newSurname;
		name = "";
	}
	
	/**
	 * Creates an employee with a surname and name
	 * @param newSurname Surname of the employee
	 * @param newName Name of the employee
	 */
	public Employee(String newSurname, String newName) {
		surname = newSurname;
		name = newName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Returns the surname and name of the employee
	 * @return String formated as "Surname Name"
	 */
	public String getSurnameAndName() {
		StringBuilder builder = new StringBuilder(surname);
		builder.append(' ');
		builder.append(name);
		
		return builder.toString();
	}
}
