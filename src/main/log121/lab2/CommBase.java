package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: CommBase.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *@author Justin Duplessis
 2014-09-09 Déplacer le SwingWorker à l'extérieur de cette classe
 *******************************************************/

import java.beans.PropertyChangeListener;
import java.net.InetSocketAddress;

import javax.swing.SwingWorker;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {

	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;

	/**
	 * Constructeur
	 */
	public CommBase() {
	}

	/**
	 * Définir le récepteur de l'information reçue dans la communication avec le serveur
	 *
	 * @param listener
	 *            sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener) {
		this.listener = listener;
	}

	/**
	 * Démarre la communication
	 *
	 * @param adresse
	 * @param nbFormes
	 *     Le nombre de formes a obtenir. -1 pour aucune limite.
	 *@param bulk
	 *     Faux pas défaut. Permet de récupérer toutes les formes d'un coup.
	 */
	public void start(InetSocketAddress adresse, int nbFormes, boolean bulk) {
		isActif = true;
		creerCommunication(adresse, nbFormes, bulk);
	}

	/**
	 * Arrête la communication
	 */
	public void stop() {
		if (threadComm != null) {
			threadComm.cancel(true);
		}
		isActif = false;
	}

	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(InetSocketAddress adresse, int nbFormes, boolean bulk) {
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new ThreadComm(adresse, nbFormes, bulk);
		isActif = true;
		if (listener != null) {
			// La méthode "propertyChange" de ApplicationFormes sera
			// donc appelée lorsque le SwinkWorker invoquera la méthode
			// "firePropertyChanger"
			threadComm.addPropertyChangeListener(listener);
			threadComm.execute(); // Lance le fil d'exécution parallèle.
		}
	}

	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif() {
		return isActif;
	}
}
