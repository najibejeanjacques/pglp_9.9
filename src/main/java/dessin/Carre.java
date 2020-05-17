package dessin;

public class Carre implements Graphique {

	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;
	private String nom;
	
	/***
	 * Description d'un cercle
	 */
	public void getDecription() {
		// TODO Auto-generated method stub
		System.out.println(this.nom+" = "+"Carré (coordonnées=(("+this.point1.getX()+","+this.point1.getY()+"),("+this.point2.getX()+","+this.point2.getX()+"),("+this.point3.getX()+","+this.point3.getY()+"),("+this.point4.getX()+","+this.point4.getY()+"))");
	}
	
	/**
	 * 
	 * @return Retourne le premier point du cercle
	 */
	public Point getPoint1() {
		return point1;
	}

	/**
	 * 
	 * @return Retourne le deuxieme point du cercle
	 */
	public Point getPoint2() {
		return point2;
	}

	/**
	 * 
	 * @return Retourne le troisieme point du cercle
	 */
	public Point getPoint3() {
		return point3;
	}

	/**
	 * 
	 * @return Retourne le quatrième point du cercle
	 */
	public Point getPoint4() {
		return point4;
	}

	/**
	 * 
	 * @return Retourne le nom du cercle
	 */
	public String getNom() {
		return nom;
	}

	/***
	 * @param pointA Coordonnées du 1er point
	 * @param pointB Coordonnées du 2e point
	 * @param pointC Coordonnées du 3e point
	 * @param pointD Coordonnées du 4e point
	 */
	public Carre(Point pointA, Point pointB, Point pointC, Point pointD, String nom)
	{
		this.point1 = pointA;
		this.point2 = pointB;
		this.point3 = pointC;
		this.point4 = pointD;
		this.nom = nom;
	}

}
