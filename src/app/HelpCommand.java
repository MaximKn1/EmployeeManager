package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HelpCommand extends Command {
	private List<Command> commandList;
	
	HelpCommand(List<Command> cmdList) {
		name = "help";
		description = "help - displays all available commands";
		
		commandList = cmdList;
	}
	
	@Override
	void execute(Scanner scanner) throws SQLException {
		commandList.forEach(cmd -> System.out.println(cmd.getDescription()));
	}
}
