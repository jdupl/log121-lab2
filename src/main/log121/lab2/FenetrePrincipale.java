package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: FenetrePrincipale.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *@author Justin Duplessis
 2014-09-09 Implémentation de la gestion des event ERREUR et FORME
 *******************************************************/

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.log121.lab2.formes.Forme;

/**
 * Cette classe représente la fenêtre principale de l'application
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = -1210804336046370508L;
	private final static FenetreFormes fenetreFormes = new FenetreFormes();

	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm) {
		MenuFenetre menu = new MenuFenetre(comm);
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);

		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenètre principale
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // à réviser selon le comportement que vous désirez TODO
	}

	// Appelé lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String propriete = event.getPropertyName();
		switch (propriete) {
		case "FORME":
			fenetreFormes.ajouterForme((Forme) event.getNewValue());
			break;
		case "ERREUR":
			JOptionPane.showMessageDialog(null, event.getNewValue());
			break;
		default:
			break;
		}
	}
}
