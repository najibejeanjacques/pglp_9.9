package dessin;

public class Point {

	private int x;
	private int y;

	/***
	 * 
	 * @param x Coordonnées de l'axe des abscisses
	 * @param y Coordonnées de l'axe des ordonées
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/***
	 * 
	 * @return L'abscisse x du point
	 */
	public int getX() {
		return this.x;
	}

	/***
	 * 
	 * @return L'ordonée y du point
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * 
	 * @param x La valeur x de l'abscisse
	 */
	public void setX(int x) {
		this.x = x;
	}

	/***
	 * 
	 * @param y La valeur y de l'ordonée
	 */
	public void setY(int y) {
		this.y = y;
	}

}
