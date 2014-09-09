import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingWorker;

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
				out.write("GET\n");
				out.flush();
				// Lire forme
				String strForme = in.readLine();
				Forme forme = FormeFactory.lireString(strForme);
				firePropertyChange("FORME", null, forme);
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
