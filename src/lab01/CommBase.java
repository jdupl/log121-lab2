package lab01;

/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: CommBase.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
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
	 */
	public void start(InetSocketAddress adresse) {
		isActif = true;
		creerCommunication(adresse);
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
	protected void creerCommunication(InetSocketAddress adresse) {
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new ThreadComm(adresse);
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
