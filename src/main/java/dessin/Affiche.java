package dessin;

import java.util.List;

public class Affiche implements Command {

	private static String nomGraphique;

	/**
	 * Initialisation de la commande create avec les paramètres de l'élément a créer
	 * 
	 * @param list liste des paramètres de l'élément graphique
	 */
	public static void init(List<String> list) {
		nomGraphique = list.get(1);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		DerbyDaoFactory derby = new DerbyDaoFactory();
		int ref = 0;
		try {
			Cercle cercle = derby.getCercleleDAO().finfByName(nomGraphique);
			if (cercle != null) {
				cercle.getDecription();
				ref++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			Carre carre = derby.getCarreDAO().finfByName(nomGraphique);
			if (carre != null) {
				carre.getDecription();
				ref++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Rectangle rectangle = derby.getRectangleDAO().finfByName(nomGraphique);
			if (rectangle != null) {
				rectangle.getDecription();
				ref++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Triangle triangle = derby.getTriangleeDAO().finfByName(nomGraphique);
			if (triangle != null) {
				triangle.getDecription();
				ref++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (ref == 0) {
			System.out.println("Le graphique avec le nom suivant : " + nomGraphique + " n'existe pas !!!!");
		}
		ref = 0;
	}

}
