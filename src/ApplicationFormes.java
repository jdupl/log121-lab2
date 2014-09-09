/******************************************************
	Cours:  LOG121
	Projet: Squelette du laboratoire #1
	Nom du fichier: ApplicationFormes.java
	Date créé: 2013-05-03
 *******************************************************
	Historique des modifications
 *******************************************************
 *@author Patrice Boucher
	2013-05-03 Version initiale
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
		ApplicationFormes application = new ApplicationFormes();
	}

	/**
	 * Constructeur
	 */
	public ApplicationFormes() {
		CommBase comm = new CommBase("localhost", 10000);
		FenetrePrincipale fenetre = new FenetrePrincipale(comm);
		comm.setPropertyChangeListener(fenetre);
	}
}
