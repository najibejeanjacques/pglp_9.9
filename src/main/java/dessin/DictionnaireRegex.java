package dessin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionnaireRegex {

	/***
	 * Format regex pour la création d'une élément graphique
	 */
	private static final String regex = ".+=.+";
	private static final Pattern pattern = Pattern.compile(regex);

	/***
	 * Format regex pour la création d'un Cercle
	 */
	private static final String cercleRegex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*\\.?\\d+?\\s*"
			+ ",\\s*\\d*\\.?\\d+\\s*\\)\\s*,\\s*\\d*\\.?\\d+?\\s*\\)";
	private static final Pattern cerclePattern = Pattern.compile(cercleRegex);

	/***
	 * Format regex pour la création d'un Carré et d'un Rectangle
	 */
	private static final String rect_carreRegex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
			+ "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\,"
			+ "\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*\\)";
	private static final Pattern rect_carrePattern = Pattern.compile(rect_carreRegex);


	/***
	 * Format regex pour la création d'un Triangle
	 */
	private static final String triangleRegex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
			+ "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern trianglePattern = Pattern.compile(triangleRegex);

	/***
	 * Format regex pour déplacer un élément graphique (cercle, carré, rectangle ou triangle)
	 */
	private static final String moveGraphiqueRegex = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-]+)\\s*\\,\\s*\\(\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern moveGraphiquePattern = Pattern.compile(moveGraphiqueRegex);

	/***
	 * Format regex pour déplacer un élément graphique (cercle, carré, rectangle ou triangle)
	 */
	private static final String groupGraphiqueRegex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*(([a-zA-Z0-9_-]*\\s*+),*)+\\)";
	private static final Pattern groupGraphiquePattern = Pattern.compile(groupGraphiqueRegex);

	/***
	 * Format regex pour déplacer un groupe d'éléments
	 */
	private static final String moveGroupGraphiqueRegex = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-]*\\s*+),*\\)";
	private static final Pattern moveGroupGraphiquePattern = Pattern.compile(groupGraphiqueRegex);

	/**
	 * Vérification de la saisie de l'utilisateur pour la création d'un élément graphique
	 * @param saisie C'est la saisie de l'utilisateur
	 * @return Vrai si ca matche avec un regex definie, regex pour la création d'un cercle, carre, rectangle ou d'un cercle
	 */

	public static boolean textMacthing(String saisie)
	{
		Matcher matcher = pattern.matcher(saisie);
		if(matcher.matches())
		{
			matcher = cerclePattern.matcher(saisie);
		}
		if(matcher.matches())
		{
			return true;
		}
		else
		{
			matcher = rect_carrePattern.matcher(saisie);
			if(matcher.matches())
			{
				return true;
			}
			else
			{
				matcher = trianglePattern.matcher(saisie);
				if(matcher.matches())
				{
					return true;
				}
				else
				{
					matcher = moveGraphiquePattern.matcher(saisie);
					if(matcher.matches())
					{
						return true;
					}
					else
					{
						matcher = groupGraphiquePattern.matcher(saisie);
						if(matcher.matches())
						{
							return true;
						}
						else
						{
							matcher = moveGroupGraphiquePattern.matcher(saisie);
							if(matcher.matches())
							{
								return true;
							}
						}
					}
				}
				return false;
			}
		}
	}

	/***
	 * Récupération de la commande et des arguments de la commande
	 * @param saisie
	 * @return
	 */

	public static List<String> separationSaisie(String saisie)
	{
		List<String> list = new ArrayList<String>(5);
		saisie = saisie.replaceAll("\\s","");
		saisie = saisie.replaceAll("=","#");
		saisie = saisie.replaceAll("\\(","#");
		saisie = saisie.replaceAll("\\)","#");
		saisie = saisie.replaceAll(",","#");
		for (String val: saisie.split("#"))
		{
			if(!val.equals("")) 
			{
				//System.out.println(val);
				list.add(val);
			}
		}
		return list;
	}
	/***
	 * On vérifie la commande saisie par l'utilisateur
	 * @param le text saisie par l'utilisateur
	 * @return La commande associé a la saisie de l'utilisateur
	 */

	public Command verifierCommand(String saisie)
	{
		Command command = DrawingTUI.interpreteur.mapCommand.get(saisie);
		return command;
	}

	/***
	 * Vérifie si c'est une commande pour deplacer un élément graphique
	 * @param val
	 * @return
	 */
	public boolean getMoveCommand(List<String> val)
	{
		if(val.get(0).toLowerCase().matches("move")) 
			return true;
		else
			return false;
	}

	/**
	 * Vérifie si la commande est une commande de group
	 * @param val La commande entrer par l'utilisateur sous forme de liste
	 * @return retoourne true si c'est une commande de group
	 */
	public boolean getGroupCommand(List<String> val)
	{
		if(val.get(1).toLowerCase().matches("group")) 
			return true;
		else
			return false;
	}
}
