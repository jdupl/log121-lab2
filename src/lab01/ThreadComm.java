package lab01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	protected Forme doInBackground() throws Exception {
		// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
		InetSocketAddress addr = new InetSocketAddress(host, port);
		try (Socket s = new Socket()) {
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
			// TODO Afficher message
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Afficher message
			e.printStackTrace();
		}
		return null;
	}

}
