package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: ThreadComm.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Implémentation du protocole client
 *******************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingWorker;

import main.log121.lab2.formes.AbstractForme;

/**
 * SwingWorker qui demande au serveur de formes de nouvelles formes.
 *
 * @author Justin Duplessis
 *
 */
public class ThreadComm extends SwingWorker<AbstractForme, Object> {

	/**
	 * Délai entre les demandes en millisecondes
	 */
	private int delaiMSec = 1000;

	private InetSocketAddress adresse;
	private int nbFormes;

	/**
	 * ConstructeurdemarrerComm
	 *
	 * @param adresse
	 *            l'adresse du serveur de formes
	 * @param nbFormes
	 *            Le nombre de formes à obtenir. -1 pour aucune limite.
	 */
	public ThreadComm(InetSocketAddress adresse, int nbFormes, boolean bulk) {
		this.adresse = adresse;
		this.nbFormes = nbFormes;

		if (bulk) {
			delaiMSec = 20;
		} else {
			delaiMSec = 1000;
		}

	}

	/**
	 * Ce que le SwingWorker fait en arrière plan. Consiste à demander une nouvelle forme au serveur chaque seconde et
	 * d'aviser le listener.
	 */
	@Override
	protected AbstractForme doInBackground() {
		try (Socket socket = new Socket()) {
			socket.setSoTimeout(1000);
			socket.connect(adresse);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader ine = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			int compte = 0;
			while (!this.isCancelled() && compte != this.nbFormes) {
				try {
					// Lire prompt ( 'commande>' )
					ine.readLine();
					// TODO ? regarder si la bonne ligne
					out.write("GET\n");
					out.flush();
					// Lire la forme en tant que String
					String strForme = ine.readLine();
					AbstractForme forme = FormeFactory.lireString(strForme);
					compte++;
					// Alerter l'autre classe d'une nouvelle forme
					firePropertyChange("FORME", null, forme);
					// Attente avant la prochaine requête au serveur
					Thread.sleep(delaiMSec);
				} catch (InterruptedException e) {
					// Gérer l'interrpution du listener de l'arrêt
					this.fermerConnection(out);
				}
			}
			fermerConnection(out);
		} catch (UnknownHostException e) {
			firePropertyChange("ERREUR", null,
					String.format("L'hôte '%s' n'est pas trouvé sur le réseau.", adresse.getHostName()));
		} catch (ConnectException e) {
			firePropertyChange(
					"ERREUR",
					null,
					String.format("L'hôte '%s' refuse la connexion sur le port %d.", adresse.getHostName(),
							adresse.getPort()));
		} catch (IOException e) {
			firePropertyChange("ERREUR", null, String.format("Problème io"));
		} catch (NullPointerException e) {
			// Si le serveur ferme une String null sera traitée et l'exception va remonter ici.
			firePropertyChange("ERREUR", null,
					String.format("Le serveur '%s' a fermé la connexion.", adresse.getHostName()));
		}
		this.cancel(false);
		return null;
	}

	/*
	 * Envoie un END dans le bufferedWriter
	 */
	private void fermerConnection(BufferedWriter out){
		try {
			out.write("END\n");
			out.flush();
		} catch (IOException e) {
			firePropertyChange("ERREUR", null, String.format("Problème io"));
		}
	}

}
