package dessinTest;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import dessin.DictionnaireRegex;

public class TestRectangle {

	DictionnaireRegex dico;
	String rectangle,rectangle1;
	
	@Before
	public void init()
	{
		rectangle = "rect1 = Rectangle((3, 7), (3, 7), (3, 7), (3, 7))";
		rectangle1 = "rect2 = Rectangle((3, 7), (3, 7), (3, 7), (3, 7),(3, 7))";
	}
	
	@Test
	public void rectangleTest() {
		System.out.println("Vérification d'un rectangle #########");
		if(dico.textMacthing(rectangle)) {
			dico.separationSaisie(rectangle);
		}else {
			fail("Erreur de syntaxe ");
		}
	}
	
	@Test
	public void rectangleTest1() {
		System.out.println("Vérification d'un rectangle #########");
		if(dico.textMacthing(rectangle)) {
			dico.separationSaisie(rectangle1);
		}else {
			System.out.println("Erreur de syntaxe ");
		}
	}

}
