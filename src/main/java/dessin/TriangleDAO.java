package dessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriangleDAO implements CustomDAO<Triangle> {

	/***
	 * Inserer un triangle dans la base de données
	 */
	@Override
	public int insertCustomer(Triangle t) {
		// TODO Auto-generated method stub
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		try (Connection connect = derby.createConnection()) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO Triangle (nom, coord1, coord2, coord3, coord4, coord5, coord6)" +
					"VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepare.setString(1, t.getNom());
			prepare.setInt(2, t.getPoint1().getX());
			prepare.setInt(3, t.getPoint1().getY());
			prepare.setInt(4, t.getPoint2().getX());
			prepare.setInt(5, t.getPoint2().getY());
			prepare.setInt(6, t.getPoint3().getX());
			prepare.setInt(7, t.getPoint3().getY());
			System.out.println("Création d'un triangle " + t);
			result = prepare.executeUpdate();
			connect.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*****
	 * Supprimer un triangle de la base de données
	 */
	@Override
	public boolean deleteCustomer(Triangle t) {
		// TODO Auto-generated method stub
		return false;
	}

	/*****
	 * Mettre a jour un triangle dans la base de données
	 */
	@Override
	public void updateCustomer(Triangle t) {
		// TODO Auto-generated method stub
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		try (Connection connect = derby.createConnection()) {
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE Triangle SET coord1 = ?, coord2 = ?, coord3 = ?, coord4 = ?, coord5 = ?, coord6 = ? where nom = ?");
			prepare.setInt(1, t.getPoint1().getX());
			prepare.setInt(2, t.getPoint1().getY());
			prepare.setInt(3, t.getPoint2().getX());
			prepare.setInt(4, t.getPoint2().getY());
			prepare.setInt(5, t.getPoint3().getX());
			prepare.setInt(6, t.getPoint3().getY());
			prepare.setString(7, t.getNom());
			System.out.println("Mise a jour d'un triangle " + t.getNom());
			result = prepare.executeUpdate();
			connect.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	

	}

	/***
	 * Retrouver tous les triangles de la base de données
	 */
	@Override
	public void findAllCustomer() {
		// TODO Auto-generated method stub
		DerbyDaoFactory derby = new DerbyDaoFactory();
		try (Connection connect = derby.createConnection()) {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT nom, coord1, coord2, coord3, coord4, coord5, coord6 FROM Triangle ");
			ResultSet result = prepare.executeQuery();
			System.out.println("Selection de tous les rectangles :");
			int colonne2,colonne3,colonne4,colonne5,colonne6,colonne7,colonne8,colonne9;
			String colonne1;
			while(result.next())
			{
				do
				{
					colonne1=result.getString(1);
					colonne2=result.getInt(2);
					colonne3=result.getInt(3);
					colonne4=result.getInt(4);
					colonne5=result.getInt(5);
					colonne6=result.getInt(6);
					colonne7=result.getInt(7);
					System.out.println(colonne1+" = Triangle(("+colonne2+","+colonne3+"),("+colonne4+","+colonne5+"),("+colonne6+","+colonne7+"))");
				}
				while(result.next());
			}
			connect.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/***
	 * TRouver un triangle dans la base de données a travers son nom
	 */
	@Override
	public Triangle finfByName(String name) {
		// TODO Auto-generated method stub
		DerbyDaoFactory derby = new DerbyDaoFactory();
		Triangle triangle = null;
		try (Connection connect = derby.createConnection()) {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT id, nom, coord1, coord2, coord3, coord4, coord5, coord6 FROM Triangle where nom = ?");
			prepare.setString(1, name);
			ResultSet result = prepare.executeQuery();
			int colonne1,colonne3,colonne4,colonne5,colonne6,colonne7,colonne8;
			String colonne2;
			while(result.next())
			{
				do
				{
					colonne1=result.getInt(1);
					colonne2=result.getString(2);
					colonne3=result.getInt(3);
					colonne4=result.getInt(4);
					colonne5=result.getInt(5);
					colonne6=result.getInt(6);
					colonne7=result.getInt(7);
					colonne8=result.getInt(8);
					Point point1 = new Point(colonne3, colonne4);
					Point point2 = new Point(colonne5, colonne6);
					Point point3 = new Point(colonne7, colonne8);
					triangle =  new Triangle(point1, point2, point3, colonne2);
				}
				while(result.next());
			}
			connect.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return triangle;

	}

	/***
	 * Déplacer un triangle 
	 */
	@Override
	public void move(Triangle triangle, int a, int b) {
		// TODO Auto-generated method stub
		triangle.getPoint1().setX(triangle.getPoint1().getX() + a);
		triangle.getPoint1().setY(triangle.getPoint1().getY() + b);
		triangle.getPoint2().setX(triangle.getPoint2().getX() + a);
		triangle.getPoint2().setY(triangle.getPoint2().getY() + b);
		triangle.getPoint3().setX(triangle.getPoint3().getX() + a);
		triangle.getPoint3().setY(triangle.getPoint3().getY() + b);
		updateCustomer(triangle);
	}

}
