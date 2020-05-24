package dessin;

public class Help implements Command {

	public String message;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		message = "Bienvenue dans le logiciel de dessin:\n"
				+ "******************************************************************************************************************************************\n"
				+ "* Pour crée un élément graphique (cercle, carre, rectangle ou un triangle) suiver les instructions suivantes								\n"
				+ "* 1) Pour créer un cercle utiliser la commande suivante																					\n"
				+ "* Exemple: Pour un cercle: c1 = cercle( (2, 4), 5) qui désigne le centre du cercle et son rayon											\n"
				+ "* Pour un carré: car1 = carre( (2,3), (2,5), (2,6), (4,7)) les arguments representent, les coordonnées des 4 point du carré				\n"
				+ "* Pour un rectngle: rect1 = rectangle( (2,3), (2,5), (2,6), (4,7)) les arguments representent, les coordonnées des 4 point du carré		\n"
				+ "* Pour un Triangle: tri1 = triangle( (2,3), (2,5), (2,6)) les arguments representent, les coordonnées des 3 point du carré				\n"
				+ "* 2) Pour déplacer un élément graphique il faut utiliser la syntaxe suivante:															\n"
				+ "*	Exemple: move(c1, (4,5))																											\n"
				+ "* La commande move prends deux arguments le 1er étant le nom de l'élément a déplacer puis le 2ème le point auquel il 					\n"
				+ "* faut déplacer l'lément graphique.																										\n"
				+ "* 3) Pour créer un ensemble d'élément graphique utiliser la commande suivant:															\n"
				+ "*	Exemple: groupeCercle = group( c1, c1)																								\n"
				+ "* Il faut préciser le nom du groupe, puis la liste des éléments graphiques qui constitueront le groupe.									\n"
				+ "* 4) Pour déplacer un élément graphique utiliser la commande suivante:																	\n"
				+ "*	Exemple: move(groupeCercle, (3, 5))																									\n"
				+ "*Avec comme argument N°1 le nom du groupe , et le 2ème argument le point qui servira a déplacer le groupe délément						\n"
				+ "	  5) Pour afficher un graphique utiliser la commande suivante:																			\n"
				+ "       Exemple: affiche(cercle) 																											\n"
				+ "L'argument de la fonction represente le nom du graphique																					\n"
				+ "******************************************************************************************************************************************\n";
		System.out.println(message);
	}

}
