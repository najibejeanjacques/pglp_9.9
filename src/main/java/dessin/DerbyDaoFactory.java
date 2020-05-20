package dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyDaoFactory extends DAOFactory {

	public static final String DBURL = "jdbc:derby:/home/ouedraogo/Documents/eclipse-workspace/exercice_9.9/dessindb;user=jacques;password=Bonsoire2017";

	/**
	 * 
	 * @return La connection a la base de données
	 * @throws SQLException
	 */
	public static Connection createConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(DBURL);
		return conn;

	}

	@Override
	public CarreDAO getCarreDAO() {
		// TODO Auto-generated method stub
		return new CarreDAO();
	}

	@Override
	public RectangleDAO getRectangleDAO() {
		// TODO Auto-generated method stub
		return new RectangleDAO();
	}

	@Override
	public CercleDAO getCercleleDAO() {
		// TODO Auto-generated method stub
		return new CercleDAO();
	}

	@Override
	public TriangleDAO getTriangleeDAO() {
		// TODO Auto-generated method stub
		return new TriangleDAO();
	}

	@Override
	public graphiqueCompositeDAO getgraphiqueCompositeDAO() {
		// TODO Auto-generated method stub
		return new graphiqueCompositeDAO();
	}

}
