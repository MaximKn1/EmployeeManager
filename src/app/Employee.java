package app;

import java.lang.StringBuilder;
import java.util.Objects;

public class Employee {
	private String surname;
	private String name;
	
	public Employee() {
		surname = "";
		name = "";
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

	public Employee(String newSurname) {
		surname = newSurname;
		name = "";
	}
	
	public Employee(String newSurname, String newName) {
		surname = newSurname;
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getSurnameAndName() {
		StringBuilder builder = new StringBuilder(surname);
		builder.append(' ');
		builder.append(name);
		
		return builder.toString();
	}
}
