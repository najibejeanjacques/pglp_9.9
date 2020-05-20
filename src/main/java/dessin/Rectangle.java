package dessin;

public class Rectangle implements Graphique {

	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;
	private String nom;

	/***
	 * Donne la description d'un rectangle
	 */
	public void getDecription() {
		// TODO Auto-generated method stub
		System.out
				.println(this.nom + " = " + "Rectangle (coordonnées=((" + this.point1.getX() + "," + this.point1.getY()
						+ "),(" + this.point2.getX() + "," + this.point2.getX() + "),(" + this.point3.getX() + ","
						+ this.point3.getY() + "),(" + this.point4.getX() + "," + this.point4.getY() + "))");
	}

	/***
	 * 
	 * @return retourne le 1er point du rectangle
	 */
	public Point getPoint1() {
		return point1;
	}

	/***
	 * 
	 * @return retourne le 2eme point du triangle
	 */
	public Point getPoint2() {
		return point2;
	}

	/****
	 * 
	 * @return retourne le 3eme point du triangle
	 */
	public Point getPoint3() {
		return point3;
	}

	/***
	 * 
	 * @return retourne le 4eme point du triangle
	 */
	public Point getPoint4() {
		return point4;
	}

	/***
	 * 
	 * @return retourne le nom du rectangle
	 */
	public String getNom() {
		return nom;
	}

	public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD, String nom) {
		this.point1 = pointA;
		this.point2 = pointB;
		this.point3 = pointC;
		this.point4 = pointD;
		this.nom = nom;
	}

}
