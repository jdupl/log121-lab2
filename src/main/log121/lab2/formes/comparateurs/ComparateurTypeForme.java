package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.AbstractForme;

public class ComparateurTypeForme extends AbstractComparateur {

	public ComparateurTypeForme() {
		super(false);
	}

	public ComparateurTypeForme(boolean decroissant) {
		super(decroissant);
	}

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
	public int compare(AbstractForme forme1, AbstractForme forme2) {
		return inverserSiNecessaire(forme1.getImportance() - forme2.getImportance());
	}
}
