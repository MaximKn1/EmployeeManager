package app;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class Command {
	protected String name;
	protected String description;
	
	Command() {
		name = "None";
		description = "None";
	}
	
	abstract void execute(Scanner scanner) throws SQLException;
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
}
