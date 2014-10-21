/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: TestComparateurs.java
 Date créé: 2014-10-20
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 *@author Alexandre Viau
 *@author Samuel Lague
 2014-10-20 Version initiale
 *******************************************************/

package test.log121.lab2;

import main.log121.lab2.formes.Ligne;
import main.log121.lab2.formes.Rectangle;
import main.log121.lab2.formes.SousForme;
import main.log121.lab2.formes.comparateurs.ComparateurTypeForme;

import org.junit.Assert;
import org.junit.Test;

public class TestComparateurs {

	@Test
	public void testComparateurTypeForme() {
		Ligne ligne = new Ligne(new int[4], -1, -1);
		Rectangle rectangle = new Rectangle(SousForme.RECTANGLE, new int[4], -1, -1);
		Rectangle carre = new Rectangle(SousForme.CARRE, new int[4], -1, -1);
		ComparateurTypeForme comp = new ComparateurTypeForme();

		Assert.assertTrue(comp.compare(ligne, carre) > 0);
		Assert.assertTrue(comp.compare(rectangle, carre) > 0);
		Assert.assertTrue(comp.compare(carre, rectangle) < 0);
		Assert.assertTrue(comp.compare(rectangle, ligne) < 0);
		Assert.assertEquals(0, comp.compare(rectangle, rectangle));
	}

	@Test
	public void testComparateurTypeFormeDecroissant() {
		Ligne ligne = new Ligne(new int[4], -1, -1);
		Rectangle rectangle = new Rectangle(SousForme.RECTANGLE, new int[4], -1, -1);
		Rectangle carre = new Rectangle(SousForme.CARRE, new int[4], -1, -1);
		ComparateurTypeForme comp = new ComparateurTypeForme(true);

		Assert.assertTrue(comp.compare(ligne, carre) < 0);
		Assert.assertTrue(comp.compare(rectangle, carre) < 0);
		Assert.assertTrue(comp.compare(carre, rectangle) > 0);
		Assert.assertTrue(comp.compare(rectangle, ligne) > 0);
		Assert.assertEquals(0, comp.compare(rectangle, rectangle));
	}
}
