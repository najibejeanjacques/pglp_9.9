package dessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreDAO implements CustomDAO<Carre> {

	/**
	 * Inserer un carre dans la base de données
	 */
	@Override
	public int insertCustomer(Carre t) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement prepare = null;
		try (Connection connect = new DerbyDaoFactory().createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"INSERT INTO Carre (nom, coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8)"
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				prepare.setString(1, t.getNom());
				prepare.setInt(2, t.getPoint1().getX());
				prepare.setInt(3, t.getPoint1().getY());
				prepare.setInt(4, t.getPoint2().getX());
				prepare.setInt(5, t.getPoint2().getY());
				prepare.setInt(6, t.getPoint3().getX());
				prepare.setInt(7, t.getPoint3().getY());
				prepare.setInt(8, t.getPoint4().getX());
				prepare.setInt(9, t.getPoint4().getY());
				// System.out.println("Création d'un carré " + t);
				result = prepare.executeUpdate();
				connect.commit();
				connect.close();
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/***
	 * Supprimer un Carré de la base de données
	 */
	@Override
	public boolean deleteCustomer(Carre t) {
		// TODO Auto-generated method stub
		return false;
	}

	/***
	 * Mettre a jour un Carre dans la base de données
	 */
	@Override
	public void updateCustomer(Carre t) {
		// TODO Auto-generated method stub
		PreparedStatement prepare = null;
		try (Connection connect = new DerbyDaoFactory().createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"UPDATE Carre SET coord1 = ?, coord2 = ?, coord3 = ?, coord4 = ?, coord5 = ?, coord6 = ?, coord7 = ?, coord8 = ?  where nom = ?");
				prepare.setInt(1, t.getPoint1().getX());
				prepare.setInt(2, t.getPoint1().getY());
				prepare.setInt(3, t.getPoint2().getX());
				prepare.setInt(4, t.getPoint2().getY());
				prepare.setInt(5, t.getPoint3().getX());
				prepare.setInt(6, t.getPoint3().getY());
				prepare.setInt(7, t.getPoint4().getX());
				prepare.setInt(8, t.getPoint4().getY());
				prepare.setString(9, t.getNom());
				// System.out.println("Mise a jour du carre " + t.getNom());
				prepare.executeUpdate();
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
	 * Retourner tous les carre de la base de données
	 */
	@Override
	public void findAllCustomer() {
		// TODO Auto-generated method stub
		int colonne2, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9;
		ResultSet result;
		String colonne1;
		PreparedStatement prepare = null;
		try (Connection connect = new DerbyDaoFactory().createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"SELECT nom, coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8 FROM Carre ");
				result = prepare.executeQuery();
				// System.out.println("Selection de tous les carre :");

				while (result.next()) {
					do {
						colonne1 = result.getString(1);
						colonne2 = result.getInt(2);
						colonne3 = result.getInt(3);
						colonne4 = result.getInt(4);
						colonne5 = result.getInt(5);
						colonne6 = result.getInt(6);
						colonne7 = result.getInt(7);
						colonne8 = result.getInt(8);
						colonne9 = result.getInt(9);
						System.out.println(
								colonne1 + " = Carre((" + colonne2 + "," + colonne3 + "),(" + colonne4 + "," + colonne5
								+ "),(" + colonne6 + "," + colonne7 + "),(" + colonne8 + "," + colonne9 + "))");
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

	/**
	 * Retrouver un carre par son nom dans la base de données
	 */
	@Override
	public Carre finfByName(String name) {
		// TODO Auto-generated method stub
		Carre carre = null;
		int colonne1, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9, colonne10;
		String colonne2;
		ResultSet result;
		PreparedStatement prepare = null;
		try (Connection connect = new DerbyDaoFactory().createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"SELECT id, nom, coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8 FROM Carre where nom = ?");
				prepare.setString(1, name);
				result = prepare.executeQuery();

				while (result.next()) {
					do {
						colonne1 = result.getInt(1);
						colonne2 = result.getString(2);
						colonne3 = result.getInt(3);
						colonne4 = result.getInt(4);
						colonne5 = result.getInt(5);
						colonne6 = result.getInt(6);
						colonne7 = result.getInt(7);
						colonne8 = result.getInt(8);
						colonne9 = result.getInt(9);
						colonne10 = result.getInt(10);
						Point point1 = new Point(colonne3, colonne4);
						Point point2 = new Point(colonne5, colonne6);
						Point point3 = new Point(colonne7, colonne8);
						Point point4 = new Point(colonne9, colonne10);
						carre = new Carre(point1, point2, point3, point4, colonne2);
					} while (result.next());
				}
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carre;
	}

	/****
	 * Déplacer un carre
	 */
	@Override
	public void move(Carre carre, int a, int b) {
		// TODO Auto-generated method stub
		carre.getPoint1().setX(carre.getPoint1().getX() + a);
		carre.getPoint1().setY(carre.getPoint1().getY() + b);
		carre.getPoint2().setX(carre.getPoint2().getX() + a);
		carre.getPoint2().setY(carre.getPoint2().getY() + b);
		carre.getPoint3().setX(carre.getPoint3().getX() + a);
		carre.getPoint3().setY(carre.getPoint3().getY() + b);
		carre.getPoint4().setX(carre.getPoint4().getX() + a);
		carre.getPoint4().setY(carre.getPoint4().getY() + b);
		updateCustomer(carre);
	}

}
