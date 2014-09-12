package lab01;

/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: FenetreFormes.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *******************************************************/

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import lab01.formes.Forme;

/**
 * Cette fenêtre gère l'affichage des formes
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent {

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500, 500);
	private static final int NB_FORMES = 10;

	FormeListe listeDeFormes = null;

	/**
	 * Constructeur
	 */
	public FenetreFormes() {
		listeDeFormes = new FormeListe(NB_FORMES);
	}

	/**
	 * Redessine le composant soit toutes les formes non nulles présentes dans la liste
	 */
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < listeDeFormes.getListeDeFormes().length; i++) {
			Forme f = listeDeFormes.getListeDeFormes()[i];
			if (f != null) {
				f.dessiner(g);
			}
		}
	};

	/**
	 * Ajoute une forme à la liste et libère le plus ancien élément. Va appeler repaint() pour tout redessiner le
	 * composant.
	 * 
	 * @param forme
	 *            La nouvelle forme à insérer
	 */
	public void ajouterForme(Forme forme) {
		Forme[] tmp = listeDeFormes.ajouter(forme);
		listeDeFormes.setListeDeFormes(tmp);
		repaint();
	}

	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver l'espace nécessaire à son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}
}
