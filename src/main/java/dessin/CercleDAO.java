package dessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dessin.DerbyDaoFactory;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class CercleDAO implements CustomDAO<Cercle> {

	/***
	 * Insertion d'un cercle dans la base de données
	 */
	@SuppressWarnings("static-access")
	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public int insertCustomer(Cercle t) {
		// TODO Auto-generated method stub
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect
						.prepareStatement("INSERT INTO Cercle (nom, rayon, coord1, coord2)" + "VALUES (?, ?, ?, ?)");
				prepare.setString(1, t.getNom());
				prepare.setInt(2, t.getRayon());
				prepare.setInt(3, t.getPoint().getX());
				prepare.setInt(4, t.getPoint().getY());
				System.out.println("Création d'un cercle " + t);
				result = prepare.executeUpdate();
				connect.commit();
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/****
	 * Suppression d'un cercle dans la base de données
	 */
	@SuppressWarnings("static-access")
	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public boolean deleteCustomer(Cercle t) {
		// TODO Auto-generated method stub
		return false;
	}

	/***
	 * Mise a jour d'un cercle dans la base de données
	 */
	@SuppressWarnings("static-access")
	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public void updateCustomer(Cercle t) {
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement("UPDATE Cercle SET coord1 = ?, coord2 = ? where nom = ?");
				prepare.setInt(1, t.getPoint().getX());
				prepare.setInt(2, t.getPoint().getY());
				prepare.setString(3, t.getNom());
				// System.out.println("Mise a jour du cercle " + t.getNom());
				result = prepare.executeUpdate();
				connect.commit();
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/****
	 * Retrouver tous les cercles dans la base de données
	 */
	@SuppressWarnings("static-access")
	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public void findAllCustomer() {
		// TODO Auto-generated method stub
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement("SELECT id, nom, rayon, coord1, coord2 FROM Cercle ");
				ResultSet result = prepare.executeQuery();
				System.out.println("Selection de tous les cercle :");
				int colonne1, colonne3, colonne4, colonne5;
				String colonne2;
				while (result.next()) {
					do {
						colonne1 = result.getInt(1);
						colonne2 = result.getString(2);
						colonne3 = result.getInt(3);
						colonne4 = result.getInt(4);
						colonne5 = result.getInt(5);
						System.out
								.println(colonne2 + " = Cercle((" + colonne4 + "," + colonne5 + "), " + colonne3 + ")");
					} while (result.next());
				}
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	@Override
	public Cercle finfByName(String name) {
		// TODO Auto-generated method stub
		Point pointA = new Point(0, 0);
		DerbyDaoFactory derby = new DerbyDaoFactory();
		Cercle cercle = null;// = new Cercle(pointA, 0, "Test");
		PreparedStatement prepare = null;
		try (@SuppressWarnings("static-access")
		Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement("SELECT id, nom, rayon, coord1, coord2 FROM Cercle where nom = ?");
				prepare.setString(1, name);
				ResultSet result = prepare.executeQuery();
				int colonne1, colonne3, colonne4, colonne5;
				String colonne2;
				while (result.next()) {
					do {
						colonne1 = result.getInt(1);
						colonne2 = result.getString(2);
						colonne3 = result.getInt(3);
						colonne4 = result.getInt(4);
						colonne5 = result.getInt(5);
						Point point = new Point(colonne4, colonne5);
						cercle = new Cercle(point, colonne3, colonne2);
					} while (result.next());
				}
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cercle;
	}

	
	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	@Override
	public void move(Cercle cercle, int a, int b) {
		// TODO Auto-generated method stub
		cercle.getPoint().setX(cercle.getPoint().getX() + a);
		cercle.getPoint().setY(cercle.getPoint().getY() + b);
		updateCustomer(cercle);

	}

}
