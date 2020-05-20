package dessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleDAO implements CustomDAO<Rectangle> {

	/*****
	 * Insertion d'un rectangle dans la base de données
	 */
	@Override
	public int insertCustomer(Rectangle t) {
		// TODO Auto-generated method stub
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"INSERT INTO Rectangle (nom, coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8)"
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
				System.out.println("Création d'un rectangle " + t);
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

	/*****
	 * Supprimer un rectangle dans la base de données
	 */
	@Override
	public boolean deleteCustomer(Rectangle t) {
		// TODO Auto-generated method stub
		return false;
	}

	/****
	 * Mettre a jour un cercle dans la base de données
	 */
	@Override
	public void updateCustomer(Rectangle t) {
		// TODO Auto-generated method stub
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"UPDATE Rectangle SET coord1 = ?, coord2 = ?, coord3 = ?, coord4 = ?, coord5 = ?, coord6 = ?, coord7 = ?, coord8 = ?  where nom = ?");
				prepare.setInt(1, t.getPoint1().getX());
				prepare.setInt(2, t.getPoint1().getY());
				prepare.setInt(3, t.getPoint2().getX());
				prepare.setInt(4, t.getPoint2().getY());
				prepare.setInt(5, t.getPoint3().getX());
				prepare.setInt(6, t.getPoint3().getY());
				prepare.setInt(7, t.getPoint4().getX());
				prepare.setInt(8, t.getPoint4().getY());
				prepare.setString(9, t.getNom());
				System.out.println("Mise a jour d'un rectangle " + t.getNom());
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

	/***
	 * Retrouver tous les rectangles dans la base de données
	 */
	public void findAllCustomer() {
		// TODO Auto-generated method stub
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"SELECT nom, coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8 FROM Rectangle ");
				ResultSet result = prepare.executeQuery();
				System.out.println("Selection de tous les rectangles :");
				int colonne2, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9;
				String colonne1;
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
						System.out.println(colonne1 + " = Rectangle((" + colonne2 + "," + colonne3 + "),(" + colonne4
								+ "," + colonne5 + "),(" + colonne6 + "," + colonne7 + "),(" + colonne8 + "," + colonne9
								+ "))");
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

	/****
	 * Trouver un rectangle a travers son nom
	 */
	@Override
	public Rectangle finfByName(String name) {
		// TODO Auto-generated method stub
		DerbyDaoFactory derby = new DerbyDaoFactory();
		Rectangle rectangle = null;
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"SELECT id, nom, coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8 FROM Rectangle where nom = ?");
				prepare.setString(1, name);
				ResultSet result = prepare.executeQuery();
				int colonne1, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9, colonne10;
				String colonne2;
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
						rectangle = new Rectangle(point1, point2, point3, point4, colonne2);
					} while (result.next());
				}
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rectangle;

	}

	/****
	 * Deplacer un rectangle
	 */
	@Override
	public void move(Rectangle rectangle, int a, int b) {
		// TODO Auto-generated method stub
		rectangle.getPoint1().setX(rectangle.getPoint1().getX() + a);
		rectangle.getPoint1().setY(rectangle.getPoint1().getY() + b);
		rectangle.getPoint2().setX(rectangle.getPoint2().getX() + a);
		rectangle.getPoint2().setY(rectangle.getPoint2().getY() + b);
		rectangle.getPoint3().setX(rectangle.getPoint3().getX() + a);
		rectangle.getPoint3().setY(rectangle.getPoint3().getY() + b);
		rectangle.getPoint4().setX(rectangle.getPoint4().getX() + a);
		rectangle.getPoint4().setY(rectangle.getPoint4().getY() + b);
		updateCustomer(rectangle);
	}

}
