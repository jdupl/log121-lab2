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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingWorker;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {
	
	private final int DELAI = 1000;
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	
	/**
	 * Constructeur
	 */
	public CommBase(){
	}
	
	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * Démarre la communication
	 */
	public void start(){
		creerCommunication();
	}
	
	/**
	 * Arrête la communication
	 */
	public void stop(){
		if(threadComm!=null)
			threadComm.cancel(true); 
		isActif = false;
	}
	
	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication() {		
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");
				while(true){
					Thread.sleep(DELAI);
					
					// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
					
					InetSocketAddress addr = new InetSocketAddress("localhost", 8080);
					try (Socket s = new Socket()) {
						s.connect(addr);
						BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
						System.out.println(in.readLine());
						System.out.println("got line");
						out.write("GET\n");
						out.flush();
						System.out.println("Wrote line");
						System.out.println(in.readLine());
						out.write("END\n");
						out.flush();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
 					//La méthode suivante alerte l'observateur 
					if(listener!=null)
					   firePropertyChange("ENVOIE-TEST", null, (Object) "."); 
				}
				//return null;
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}
	
	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
