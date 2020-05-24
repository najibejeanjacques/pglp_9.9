package dessin;

import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public enum DrawingApp {
	ENVIRONNEMENT;

	/***
	 * Fonction qui recupère une commande l'execute et affiche le resultat
	 * 
	 * @param saisie commande saisie
	 */
	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public void run(String saisie) {
		DictionnaireRegex dico = new DictionnaireRegex();
		List<String> val;
		String typeGraphique;
		Command command;
		if (dico.textMacthing(saisie)) {
			val = dico.separationSaisie(saisie);
			typeGraphique = val.get(1).toLowerCase();
			dico.separationSaisie(saisie);
			if (dico.getMoveCommand(val)) {
				Move.init(val);
				DrawingTUI.interpreteur.mapCommand.get("move").execute();
			} else if (dico.getAfficheCommand(val)) {
				Affiche.init(val);
				DrawingTUI.interpreteur.mapCommand.get("affiche").execute();
			} else if (dico.getGroupCommand(val)) {
				Group.init(val);
				DrawingTUI.interpreteur.mapCommand.get("group").execute();
			} else {
				Create.init(val);
				DrawingTUI.interpreteur.mapCommand.get("create").execute();
			}
		} else {
			command = dico.verifierCommand(saisie);
			if (command instanceof Quit) {
				DrawingTUI.interpreteur.mapCommand.get("quit").execute();
			} else if (command instanceof Help) {
				DrawingTUI.interpreteur.mapCommand.get("help").execute();
			} else {
				System.out.println("Il n'ya pas de commande associé!!");
			}
		}
	}

	/***
	 * Classe main
	 * 
	 * @param args les arguments de la classe main
	 */
	public static void main(String args[]) {
		DrawingTUI drawingTui = new DrawingTUI();
		drawingTui.init();
		drawingTui.nextCommand();
	}
}
