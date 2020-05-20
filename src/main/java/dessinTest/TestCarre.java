package dessinTest;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import dessin.DictionnaireRegex;

public class TestCarre {
	DictionnaireRegex dico;
	String carre, carre1;

	@Before
	public void init() {
		carre = "car1 = Carre((3, 7), (3, 7), (3, 7), (3, 7))";
		carre1 = "car2 = Carre((3, 7), (3, 7), (3, 7), (3, 7),(3, 7))";
	}

	@Test
	public void carreTest() {
		System.out.println("Vérification d'un carre #########");
		if (dico.textMacthing(carre)) {
			dico.separationSaisie(carre);
		} else {
			fail("Erreur de syntaxe ");
		}
	}

	@Test
	public void carreTest1() {
		System.out.println("Vérification d'un carre #########");
		if (dico.textMacthing(carre1)) {
			dico.separationSaisie(carre1);
		} else {
			System.out.println("Erreur de syntaxe ");
		}
	}

}
