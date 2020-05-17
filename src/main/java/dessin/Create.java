package dessin;

import java.util.List;
import java.util.Stack;

public class Create implements Command {

	private  static List<String> graphique;

	/**
	 * Initialisation de la commande create avec les paramètres de l'élément a créer
	 * @param list liste des paramètres de l'élément graphique
	 */
	public static void init(List<String> list)
	{
		graphique = list;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String typeGraphique = graphique.get(1).toLowerCase();
		DerbyDaoFactory derby = new DerbyDaoFactory();
		switch (typeGraphique) 
		{
		case "cercle":
			Point pointA = new Point(Integer.parseInt(graphique.get(2)), Integer.parseInt(graphique.get(3)));
			Cercle cercle = new Cercle(pointA, Integer.parseInt(graphique.get(4)),graphique.get(0));
			derby.getCercleleDAO().insertCustomer(cercle);
			DrawingTUI.printDessin(cercle);
			break;

		case "carre":
			Point point1 = new Point(Integer.parseInt(graphique.get(2)), Integer.parseInt(graphique.get(3)));
			Point point2 = new Point(Integer.parseInt(graphique.get(4)), Integer.parseInt(graphique.get(5)));
			Point point3 = new Point(Integer.parseInt(graphique.get(6)), Integer.parseInt(graphique.get(7)));
			Point point4 = new Point(Integer.parseInt(graphique.get(8)), Integer.parseInt(graphique.get(9)));
			Carre carre = new Carre(point1, point2, point3, point4, graphique.get(0));
			derby.getCarreDAO().insertCustomer(carre);
			DrawingTUI.printDessin(carre);
			break;

		case "rectangle":
			Point point11 = new Point(Integer.parseInt(graphique.get(2)), Integer.parseInt(graphique.get(3)));
			Point point21 = new Point(Integer.parseInt(graphique.get(4)), Integer.parseInt(graphique.get(5)));
			Point point31 = new Point(Integer.parseInt(graphique.get(6)), Integer.parseInt(graphique.get(7)));
			Point point41 = new Point(Integer.parseInt(graphique.get(8)), Integer.parseInt(graphique.get(9)));
			Rectangle rectangle = new Rectangle(point11, point21, point31, point41, graphique.get(0));
			derby.getRectangleDAO().insertCustomer(rectangle);
			DrawingTUI.printDessin(rectangle);
			break;

		default:
			Point point111 = new Point(Integer.parseInt(graphique.get(2)), Integer.parseInt(graphique.get(3)));
			Point point211 = new Point(Integer.parseInt(graphique.get(4)), Integer.parseInt(graphique.get(5)));
			Point point311 = new Point(Integer.parseInt(graphique.get(6)), Integer.parseInt(graphique.get(7)));
			Triangle triangle = new Triangle(point111, point211, point311,  graphique.get(0));
			derby.getTriangleeDAO().insertCustomer(triangle);
			DrawingTUI.printDessin(triangle);
			break;
		}

	}

}
