package dessinTest;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import dessin.DictionnaireRegex;

public class TestTriangle {

	DictionnaireRegex dico;
	String triangle, triangle1;

	@Before
	public void init() {
		triangle = "tri1 = Triangle((3, 7), (3, 7), (3, 7), (3, 7))";
		triangle1 = "tri2 = Triangle((3, 7), (3, 7), (3, 7), (3, 7),(3, 7))";
	}

	@Test
	public void triangleTest() {
		System.out.println("Vérification d'un triangle #########");
		if (dico.textMacthing(triangle)) {
			dico.separationSaisie(triangle);
		} else {
			fail("Erreur de syntaxe ");
		}
	}

	@Test
	public void triangleTest1() {
		System.out.println("Vérification d'un triangle #########");
		if (dico.textMacthing(triangle1)) {
			dico.separationSaisie(triangle1);
		} else {
			System.out.println("Erreur de syntaxe ");
		}
	}
}
