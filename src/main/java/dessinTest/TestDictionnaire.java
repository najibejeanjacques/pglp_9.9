package dessinTest;

import org.junit.Before;
import org.junit.Test;

import dessin.Cercle;
import dessin.DictionnaireRegex;

public class TestDictionnaire {
	
	DictionnaireRegex dico;
	String cercle;
	String rectangle;
	String carre;
	String triangle;
	
	@Before
	public void init()
	{
		cercle = "cer1 = Cercle((3, 7), 5)";
		rectangle = "rect1 = Rectangle( (2, 2) , (3, 3), (4, 4) , (5, 5))";
		carre = "car1 = Carre( (2, 2) , (3, 3), (4, 4) , (5, 5))";
		triangle = "tria1 = Triangle( (5.5  ,11.00), (2 , 3) , (55 , 66))";
	}

	@Test
	public void cercleTest() {
		System.out.println("Vérification d'un cercle #########");
		if(dico.textMacthing(cercle)) {
			dico.separationSaisie(cercle);
		}else {
			System.out.println("Erreur de syntaxe ");
		}
	}
	
	@Test
	public void carreTest() {
		System.out.println("Vérification d'un carre #########");
		if(dico.textMacthing(carre)) {
			dico.separationSaisie(carre);
		}else {
			System.out.println("Erreur de syntaxe ");
		}
	}
	
	@Test
	public void rectangleTest() {
		System.out.println("Vérification d'un rectangle #########");
		if(dico.textMacthing(rectangle)) {
			dico.separationSaisie(rectangle);
		}else {
			System.out.println("Erreur de syntaxe ");
		}
	}
	
	@Test
	public void triangleTest() {
		System.out.println("Vérification d'un triangle #########");
		if(dico.textMacthing(triangle)) {
			dico.separationSaisie(triangle);
		}else {
			System.out.println("Erreur de syntaxe ");
		}
	}
}
