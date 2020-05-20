package dessin;

import java.util.Dictionary;
import java.util.Scanner;
import java.util.Stack;

import org.apache.bcel.generic.SWITCH;

import dessin.Interpreter;

public class DrawingTUI {

	private Create create = new Create();
	private Move move = new Move();
	private Quit quit = new Quit();
	private Group group = new Group();
	private Help help = new Help();
	private Affiche affiche = new Affiche();
	public static Interpreter interpreteur = new Interpreter();
	protected Stack<Command> history;
	private DrawingApp drawingApp;

	/****
	 * Initialisation des commandes de base
	 */
	public void init() {
		interpreteur.register("create", create);
		interpreteur.register("move", move);
		interpreteur.register("quit", quit);
		interpreteur.register("group", group);
		interpreteur.register("help", help);
		interpreteur.register("affiche", affiche);
		drawingApp = DrawingApp.ENVIRONNEMENT;
		history = new Stack<Command>();
	}

	/**
	 * @param saisie La chaine de caractère saisie par l'utilisateur
	 * @return un objet implementant l'interface de la commande saisie par
	 *         l'utilisateur
	 */
	public void nextCommand() {
		Scanner sc = new Scanner(System.in);
		String saisie;
		Command command;

		while (true) {
			System.out.println("Saisir votre commande:" + "\nPour plus d'aide utiliser la commande help");
			saisie = sc.nextLine();
			drawingApp.run(saisie);
		}
	}

	/**
	 * Afficher un graphique
	 * 
	 * @param graphique Le graphique a afficher
	 */
	public static void printDessin(Graphique graphique) {
		graphique.getDecription();
	}
}
