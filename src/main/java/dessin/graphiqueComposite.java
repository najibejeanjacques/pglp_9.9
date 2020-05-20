package dessin;

import java.util.ArrayList;
import java.util.Collection;

public class graphiqueComposite {

	private Collection children;

	/***
	 * Constructeur pour initialiser un groupe d'élément
	 */
	public graphiqueComposite() {
		children = new ArrayList<Graphique>();
	}

	/***
	 * Ajouter un graphique dans le groupe d'élément
	 * 
	 * @param graphique le graphique a ajouter dans la liste
	 */
	public void add(Graphique graphique) {
		children.add(graphique);
	}

	/***
	 * Supprimer un graphique dans la liste de graphique
	 * 
	 * @param graphique le graphique a supprimer
	 */
	public void remove(Graphique graphique) {
		children.remove(graphique);
	}

}
