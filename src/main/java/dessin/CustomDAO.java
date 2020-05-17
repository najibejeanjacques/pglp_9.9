package dessin;

public interface CustomDAO<T> {

	public int insertCustomer(T t);
	public boolean deleteCustomer(T t);
	public void updateCustomer(T t);
	public void findAllCustomer();
	public Graphique finfByName(String name);
	public void move(T t, int a, int b);

}
