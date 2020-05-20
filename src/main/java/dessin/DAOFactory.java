package dessin;

import java.util.List;
import java.util.Optional;

public abstract class DAOFactory {

	// Liste des types de DAO supporté par notre Factory
	public static final int ORACLE = 1;
	public static final int DERBY = 2;

	// Nous avons des methodes pour chaque DAO que nous allons crée
	public abstract CarreDAO getCarreDAO();

	public abstract RectangleDAO getRectangleDAO();

	public abstract CercleDAO getCercleleDAO();

	public abstract TriangleDAO getTriangleeDAO();

	public abstract graphiqueCompositeDAO getgraphiqueCompositeDAO();

	/***
	 * 
	 * @param wichFactory le numéro du type de DAO a utiliser
	 * @return retourne une instance du type de DAO a utiliser
	 */
	public static DAOFactory getDAOFactory(int wichFactory) {
		switch (wichFactory) {
		case DERBY:
			return new DerbyDaoFactory();
		default:
			return null;
		}
	}

}
