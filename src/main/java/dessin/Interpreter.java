package dessin;

import java.util.HashMap;

import dessin.Command;

public class Interpreter {

	protected final HashMap<String, Command> mapCommand = new HashMap<String, Command>();

	/****
	 * Enregistrer une commande
	 * 
	 * @param nom     Le nom de la commande a enregistrer
	 * @param command La commande a enregistrer
	 */
	public void register(String nom, Command command) {
		mapCommand.put(nom, command);
	}

	/***
	 * Execution de la commande
	 * 
	 * @param command La commande a executer
	 */
	public void execute(Command command) {
		if (command == null) {
			throw new IllegalStateException(command + " N'est pas une commande valide ");
		} else {
			command.execute();
		}
	}

}
