package dessinTest;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import dessin.DictionnaireRegex;

public class TestCercle {

	DictionnaireRegex dico;
	String cercle, cercle1;

	@Before
	public void init() {
		cercle = "cer1 = Cercle((3, 7), 5)";
		cercle1 = "cer1 = Cercl((3, 7), (4, 5), 5)";
	}

	@Test
	public void cercleTest() {
		System.out.println("Vérification d'un cercle #########");
		if (dico.textMacthing(cercle)) {
			dico.separationSaisie(cercle);
		} else {
			// fail("Erreur de syntaxe ");
		}
	}

	@Test
	public void cercleTest1() {
		System.out.println("Vérification d'un cercle #########");
		if (dico.textMacthing(cercle1)) {
			dico.separationSaisie(cercle1);
		} else {
			System.out.println("Erreur de syntaxe ");
		}
	}
}
