package dessin;

import java.util.List;
import java.util.UUID;

public class Group implements Command {

	static List<String> groupValeur;
	static String groupName;
	static String uuid = UUID.randomUUID().toString();
	/***
	 * Initialisation de la liste du groupe et des éléments composants ce ensemble
	 * @param valeur la liste des éléments graphique et le nom du groupe
	 */
	public static void init(List<String> valeur)
	{
		groupValeur = valeur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		groupName = groupValeur.get(0);
		graphiqueCompositeDAO groupeDAO = new graphiqueCompositeDAO();
		groupeDAO.InsertGroup(groupName, uuid);
		DerbyDaoFactory derby = new DerbyDaoFactory();
		for(int i=1;i<=groupValeur.size()-1;i++)
		{
			String elementForSearchInDerbyDB = groupValeur.get(i);
			try
			{
				Cercle cercle = derby.getCercleleDAO().finfByName(elementForSearchInDerbyDB);
				if(cercle!=null)
				{
					groupeDAO.insertCustomer(cercle);
					//findCercle.updateCustomer(cercle);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			try
			{
				Carre carre = derby.getCarreDAO().finfByName(elementForSearchInDerbyDB);
				if(carre!=null)
				{
					groupeDAO.insertCustomer(carre);
					//findCarre.updateCustomer(carre);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
				try
				{
					Rectangle rectangle = derby.getRectangleDAO().finfByName(elementForSearchInDerbyDB);
					if(rectangle!=null)
					{
						groupeDAO.insertCustomer(rectangle);
						//findRectangle.updateCustomer(rectangle);
					}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
					try
					{
						Triangle triangle = derby.getTriangleeDAO().finfByName(elementForSearchInDerbyDB);
						if(triangle!=null)
						{
							groupeDAO.insertCustomer(triangle);
							//findTriangle.updateCustomer(triangle);
						}
					}
					catch (Exception e) {
						// TODO: handle exception
					}
						
					}
		System.out.println("Group crée");
				}
		}
