package dessin;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public interface CustomDAO<T> {

	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public int insertCustomer(T t);

	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public boolean deleteCustomer(T t);

	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public void updateCustomer(T t);

	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public void findAllCustomer();

	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public Graphique finfByName(String name);

	@SuppressFBWarnings("DLS_DEAD_LOCAL_STORE")
	public void move(T t, int a, int b);

}
