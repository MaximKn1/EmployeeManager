package app;

public class App {

	public static void main(String[] args) {
		EmployeeDatabase database = new EmployeeDatabase();
		
		database.appendEmployee(new Employee("Knyazkin", "Maxim"));
		database.appendEmployee(new Employee("Tsydypov", "Agvan"));
		
		database.printAllEmployees();
	}

}