package dessin;

import java.util.List;

import javax.sound.midi.Soundbank;

public class Move implements Command {

	protected static List<String> list;

	/****
	 * Initialisation de la commande move avec les paramètres de l'élément a
	 * deplacer
	 * 
	 * @param valeur liste des paramètres de deplacement pour l'élément graphique
	 */
	public static void init(List<String> valeur) {
		list = valeur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String elementForSearchInDerbyDB = list.get(1), uuid;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		List<String> elementGroup;

		// Recherche dans le groupe d'abord
		if (derby.getgraphiqueCompositeDAO().getExistGroup(elementForSearchInDerbyDB)) {
			/**
			 * On sélectionne tous les éléments graphiques du groupe
			 */
			uuid = derby.getgraphiqueCompositeDAO().findGroupUUID(elementForSearchInDerbyDB);
			elementGroup = derby.getgraphiqueCompositeDAO().getAllElement(uuid);
			for (int i = 0; i < elementGroup.size(); i++) {
				Cercle cercle = derby.getCercleleDAO().finfByName(elementGroup.get(i));
				if (cercle != null) {
					derby.getCercleleDAO().move(cercle, Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)));
				} else {
					Carre carre = derby.getCarreDAO().finfByName(elementGroup.get(i));
					if (carre != null) {
						derby.getCarreDAO().move(carre, Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)));
					} else {
						Rectangle rectangle = derby.getRectangleDAO().finfByName(elementGroup.get(i));
						if (rectangle != null) {
							derby.getRectangleDAO().move(rectangle, Integer.parseInt(list.get(2)),
									Integer.parseInt(list.get(3)));
						} else {
							Triangle triangle = derby.getTriangleeDAO().finfByName(elementGroup.get(i));
							if (triangle != null) {
								derby.getTriangleeDAO().move(triangle, Integer.parseInt(list.get(2)),
										Integer.parseInt(list.get(3)));
							} else {

							}
						}
					}
				}
			}
			System.out.println("Le groupe a été déplacer !!!");
		} else {
			Cercle cercle = derby.getCercleleDAO().finfByName(elementForSearchInDerbyDB);
			if (cercle != null) {
				derby.getCercleleDAO().move(cercle, Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)));
			} else {
				Carre carre = derby.getCarreDAO().finfByName(elementForSearchInDerbyDB);
				if (carre != null) {
					derby.getCarreDAO().move(carre, Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)));
				} else {
					Rectangle rectangle = derby.getRectangleDAO().finfByName(elementForSearchInDerbyDB);
					if (rectangle != null) {
						derby.getRectangleDAO().move(rectangle, Integer.parseInt(list.get(2)),
								Integer.parseInt(list.get(3)));
					} else {
						Triangle triangle = derby.getTriangleeDAO().finfByName(elementForSearchInDerbyDB);
						if (triangle != null) {
							derby.getTriangleeDAO().move(triangle, Integer.parseInt(list.get(2)),
									Integer.parseInt(list.get(3)));
						} else {

						}
					}
				}
			}
		}
	}

}
