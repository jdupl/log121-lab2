package lab01;

import lab01.formes.Forme;

public class FormeListe {

	private int nbFormes;
	private Forme[] listeDeFormes = null;

	public FormeListe(int nbFormes) {
		this.nbFormes = nbFormes;
		listeDeFormes = new Forme[nbFormes];
	}

	/**
	 * Ajoute un élément au début de la fille. "Déplace" les autres instances de Formes
	 * 
	 * @param forme
	 *            La nouvelle forme.
	 * @return L'instance du nouveau tableau (éviter déplacer objets)
	 */
	public Forme[] ajouter(Forme forme) {
		Forme[] newList = new Forme[nbFormes];
		for (int i = 0; i < listeDeFormes.length - 1; i++) {
			newList[i + 1] = listeDeFormes[i];
		}
		newList[0] = forme;
		return newList;
	}

	public Forme[] getListeDeFormes() {
		return listeDeFormes;
	}

	public void setListeDeFormes(Forme[] listeDeFormes) {
		this.listeDeFormes = listeDeFormes;
	}

}
