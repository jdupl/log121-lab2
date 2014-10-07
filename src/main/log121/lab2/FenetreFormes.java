package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: FenetreFormes.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *@author Justin Duplessis
 2014-09-09 Implémentation
 *******************************************************/

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import main.log121.lab2.formes.Dessinateur;
import main.log121.lab2.formes.Forme;
import main.log121.lab2.utils.ListeChainee;
import ca.etsmtl.log.util.IDLogger;

/**
 * Cette fenêtre gère l'affichage des formes
 *
 */
public class FenetreFormes extends JComponent {

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500, 500);
	private static final int NB_FORMES = 10;

	/**
	 * Instance du logger qui permet de conserver les numéros de séquences dans un fichier.
	 */
	IDLogger logger = IDLogger.getInstance();

	/**
	 * Liste des formes à afficher
	 */
	ListeChainee<Forme> listeDeFormes = null;

	/**
	 * Instance du dessinateur qui permet de dessiner les formes a l'écran
	 */
	Dessinateur dessinateur = new Dessinateur();

	/**
	 * Constructeur
	 */
	public FenetreFormes() {
		listeDeFormes = new ListeChainee<Forme>();
	}

	/**
	 * Redessine le composant soit toutes les formes non nulles présentes dans la liste
	 */
	@Override
	public void paint(Graphics g) {
		dessinateur.dessiner(listeDeFormes, (Graphics2D) g);
	}

	/**
	 * Ajoute une forme à la liste et libère le plus ancien élément. Va appeler repaint() pour tout redessiner le
	 * composant. S'occupe aussi d'envoyer le numéro de séquence à la classe de logging.
	 *
	 * @param forme
	 *            La nouvelle forme à insérer
	 */
	public void ajouterForme(Forme forme) {
		listeDeFormes.ajouter(forme);
		logger.logID(forme.getId());
		repaint();
	}

	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver l'espace nécessaire à son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}

	public ListeChainee<Forme> getListeForme() {
		return listeDeFormes;
	}
}
