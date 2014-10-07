package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurTypeForme extends Comparateur {

	/**
	 * Compare 2 formes selon le type de sous forme.
	 * 
	 * @param forme1
	 *            La première forme à comparer
	 * @param forme2
	 *            La deuxième forme à comparer
	 * @return Un entier < 0 si la forme 1 est plus petite. 0 si les deux formes sont égales. >0 Si la forme 1 est plus
	 *         grande.
	 */
	@Override
	public int compare(Forme forme1, Forme forme2) {
		return forme1.getImportance() - forme2.getImportance();
	}
}
