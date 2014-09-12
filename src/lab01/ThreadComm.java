package lab01;

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

import lab01.formes.Forme;

public class ThreadComm extends SwingWorker<Forme, Object> {

	private final int DELAI = 1000;

	private InetSocketAddress adresse;

	public ThreadComm(InetSocketAddress adresse) {
		this.adresse = adresse;
	}

	@Override
	protected Forme doInBackground() {
		try (Socket s = new Socket()) {
			s.setSoTimeout(1000);
			s.connect(adresse);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while (!this.isCancelled()) {
				try {
					// Lire prompt ( 'commande>' )
					in.readLine();
					// TODO ? regarder si la bonne ligne
					out.write("GET\n");
					out.flush();
					// Lire la forme en tant que String
					String strForme = in.readLine();
					Forme forme = FormeFactory.lireString(strForme);
					// Alerter l'autre classe d'une nouvelle forme
					firePropertyChange("FORME", null, forme);
					// Attente avant la prochaine requête au serveur
					Thread.sleep(DELAI);
				} catch (InterruptedException e) {
					// Gérer l'interrpution du listener de l'arrêt
					out.write("END\n");
					out.flush();
				}
			}
		} catch (UnknownHostException e) {
			firePropertyChange("ERREUR", null,
					String.format("L'hôte '%s' n'est pas trouvé sur le réseau.", adresse.getHostName()));
		} catch (ConnectException e) {
			firePropertyChange("ERREUR", null, String.format("L'hôte '%s' refuse la connexion sur le port %d.",
							adresse.getHostName(), adresse.getPort()));
		} catch (IOException e) {
			firePropertyChange("ERREUR", null, String.format("Problème io"));
		} catch (NullPointerException e) {
			// Si le serveur ferme une String null sera traité et l'exception va remonter ici.
			firePropertyChange("ERREUR", null,
					String.format("Le serveur '%s' a fermé la connexion.", adresse.getHostName()));
		}
		return null;
	}

}
