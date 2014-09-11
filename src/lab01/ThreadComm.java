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
import lab01.formes.FormeFactory;

public class ThreadComm extends SwingWorker<Forme, Object> {

	private final int DELAI = 1000;

	private String host;
	private int port;

	public ThreadComm(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	protected Forme doInBackground() {
		// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
		InetSocketAddress addr = new InetSocketAddress(host, port);
		try (Socket s = new Socket()) {
			s.setSoTimeout(1000);
			s.connect(addr);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while (!this.isCancelled()) {
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
			}
			out.write("END\n");
			out.flush();
		} catch (UnknownHostException e) {
			firePropertyChange("ERREUR", null, String.format("L'hôte '%s' n'est pas trouvé sur le réseau.", host));
		} catch (ConnectException e) {
			firePropertyChange("ERREUR", null,
					String.format("L'hôte '%s' refuse la connexion sur le port %d.", host, port));
		} catch (IOException e) {
			firePropertyChange("ERREUR", null, String.format("Problème io"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			// Si le serveur ferme une String null sera traité et l'exception va remonter ici.
			firePropertyChange("ERREUR", null, String.format("Le serveur '%s' a fermé la connexion.", host));
		}
		return null;
	}

}
