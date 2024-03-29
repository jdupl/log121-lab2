package main.log121.lab2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: ApplicationFormes.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *@author Justin Duplessis
 2014-09-09 Implémentation de la fermeture du worker avant de quitter
 *******************************************************/

/**
 * Cette classe représente l'application dans son ensemble.
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class ApplicationFormes {

	/**
	 * main de l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ApplicationFormes();
	}

	/**
	 * Constructeur
	 */
	public ApplicationFormes() {
		final CommBase comm = new CommBase();
		FenetrePrincipale fenetre = new FenetrePrincipale(comm);
		// Implémente un listener qui va toujours fermer la communication lorsque la fenêtre principale ferme.
		fenetre.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				if (comm.isActif()) {
					comm.stop();
				}
			}
		});
		comm.setPropertyChangeListener(fenetre);
	}
}
