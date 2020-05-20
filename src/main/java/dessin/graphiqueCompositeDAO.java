package dessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class graphiqueCompositeDAO implements CustomDAO<Graphique> {

	/***
	 * Inserer un groupe d'éléments graphique dans la base de données
	 */
	@Override
	public int insertCustomer(Graphique t) {
		// TODO Auto-generated method stub
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				Cercle cer;
				cer = (Cercle) t;
				prepare = connect
						.prepareStatement("INSERT INTO GraphiqueEnsemble (uuidGroup,nomElement)" + "VALUES (?, ?)");
				prepare.setString(1, Group.uuid);
				prepare.setString(2, cer.getNom());
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

	/****
	 * 
	 * @param uuid la référence uuid du groupe d'élément
	 * @return la liste des noms des éléments graphiques présentes dans le groupe
	 */
	public List<String> getAllElement(String uuid) {
		DerbyDaoFactory derby = new DerbyDaoFactory();
		List<String> liste = new ArrayList<String>();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement("SELECT nomelement FROM GraphiqueEnsemble where uuidgroup = ?");
				prepare.setString(1, uuid);
				ResultSet result = prepare.executeQuery();
				String colonne2;
				while (result.next()) {
					do {
						colonne2 = result.getString(1);
						liste.add(colonne2);
					} while (result.next());
				}
				connect.commit();
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	/***
	 * Supprimer un groupe d'éléments graphique dans la base de données
	 */
	@Override
	public boolean deleteCustomer(Graphique t) {
		// TODO Auto-generated method stub
		return false;
	}

	/***
	 * Mettre a jour un groupe d'éléments graphique dans la base de données
	 */
	@Override
	public void updateCustomer(Graphique t) {
		// TODO Auto-generated method stub

	}

	/***
	 * Avoir la liste de tous les groupes d'éléments dans la base de données
	 */
	public void findAllCustomer() {
		// TODO Auto-generated method stub

	}

	@Override
	public Graphique finfByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/***
	 * 
	 * @param nomGroup nomGroup Le du group a rechercher
	 * @return retourne l'uuid du groupe correspondant
	 */
	public String findGroupUUID(String nomGroup) {
		DerbyDaoFactory derby = new DerbyDaoFactory();
		String colonne1, colonne2 = null;
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement("SELECT nom, uuid FROM Groupgraphique where nom = ?");
				prepare.setString(1, nomGroup);
				ResultSet result = prepare.executeQuery();
				while (result.next()) {
					colonne1 = result.getString(1);
					colonne2 = result.getString(2);
				}
				connect.commit();
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colonne2;
	}

	/****
	 * 
	 * @param nomGRoup Le nom du groupe, afin de vérifier son existence
	 * @return return un boolean , sui est vrai si le groupe exist
	 */
	public boolean getExistGroup(String nomGRoup) {
		DerbyDaoFactory derby = new DerbyDaoFactory();
		String colonne1, colonne2 = null;
		boolean resultat = false;
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement("SELECT nom, uuid FROM Groupgraphique where nom = ?");
				prepare.setString(1, nomGRoup);
				ResultSet result = prepare.executeQuery();
				while (result.next()) {
					colonne1 = result.getString(1);
					colonne2 = result.getString(2);
					resultat = true;
				}
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/***
	 * On crée le groupe correspondant
	 * 
	 * @param nom  le nom du groupe
	 * @param uuid l'identifiant du groupe
	 */
	public void insertGroup(String nom, String uuid) {
		int result = 0;
		DerbyDaoFactory derby = new DerbyDaoFactory();
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement("INSERT INTO GroupGraphique (nom, uuid)" + "VALUES (?, ?)");
				prepare.setString(1, nom);
				prepare.setString(2, uuid);
				// System.out.println("Création d'un cercle " + t);
				result = prepare.executeUpdate();
				connect.commit();
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void move(Graphique t, int a, int b) {
		// TODO Auto-generated method stub

	}

}
