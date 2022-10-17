package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {
		List<Command> availableCommands = new ArrayList<>();
		availableCommands.add(new FindCommand());
		availableCommands.add(new PrintTopCommand());
		availableCommands.add(new HelpCommand(availableCommands));
		
		Scanner scanner = new Scanner(System.in);
		String entry;
		System.out.println("Enter 'help' to print available commands");
		while (true) {
			System.out.println("Enter command");
			entry = scanner.nextLine();
			
			if (entry.equals("exit")) {
				break;
			} else if (entry.isBlank()) {
				
			} else {
				Command command = null;
				for (Command cmd : availableCommands) {
					if (cmd.getName().equals(entry)) {
						command = cmd;
						break;
					}
				}
				
				if (command == null) {
					System.out.println("No such command found");
				} else {
					command.execute(scanner);
					scanner.nextLine();
				}
			}
		}
		scanner.close();
		
		System.out.println("App closed");
	}

}
