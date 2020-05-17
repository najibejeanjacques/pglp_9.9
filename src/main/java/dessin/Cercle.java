package dessin;

public class Cercle implements Graphique {

	private Point point;
	private String nom;
	private int rayon;

	/***
	 * 
	 * @return retourne le centre du Cerce
	 */
	public Point getPoint() {
		return point;
	}

	/***
	 * 
	 * @return retourne le nom du cercle
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @return retourne le rayon du cercle
	 */
	public int getRayon() {
		return rayon;
	}

	/**
	 * Constructeur de la classe Cercle
	 * @param centre1 coordonnées 1 du centre du cercle
	 * @param centre2 coordonnées 2 du centre du cercle
	 * @param rayon Rayon du cercle
	 */
	public Cercle(Point pointa, int rayon,String nom)
	{
		this.point = pointa;
		this.rayon = rayon;
		this.nom = nom;
	}

	/***
	 * Description d'un cercle
	 */
	public void getDecription() {
		// TODO Auto-generated method stub
		System.out.println(this.nom+" = "+"Cercle (centre=("+this.point.getX()+","+this.point.getY()+"), rayon = "+this.rayon+")");

	}

}
