package dessin;

public class Triangle implements Graphique {

	private Point point1;
	private Point point2;
	private Point point3;
	private String nom;

	/**
	 * Donne la description d'un TRiangle
	 */
	public void getDecription() {
		// TODO Auto-generated method stub
		System.out.println(this.nom + " = " + "Triangle (coordonnées=((" + this.point1.getX() + "," + this.point1.getY()
				+ "),(" + this.point2.getX() + "," + this.point2.getY() + "),(" + this.point3.getX() + ","
				+ this.point3.getY() + "))");
	}

	/***
	 * Création d'un nouveau triangle
	 * 
	 * @param pointA Le 1er point du Triangle
	 * @param pointB Le 2eme point du Triangle
	 * @param pointC Le 3eme point du Triangle
	 * @param nom    Le nom du triangle
	 */
	public Triangle(Point pointA, Point pointB, Point pointC, String nom) {
		this.point1 = pointA;
		this.point2 = pointB;
		this.point3 = pointC;
		this.nom = nom;
	}

	/***
	 * 
	 * @return retourne le 1er point du triangle
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
	 * @return retourne le nom du triangle
	 */
	public String getNom() {
		return nom;
	}

}
