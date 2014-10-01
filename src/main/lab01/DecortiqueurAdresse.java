package main.lab01;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: DecortiqueurAdresse.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/
import java.net.InetSocketAddress;

/**
 * Permet de décorquiter une adresse réseau et son port.
 * 
 * @author Justin Duplessis
 *
 */
public class DecortiqueurAdresse {

	private final static String ERREUR_PORT = "Aucun port valide n'a pu être validé dans l'adresse entrée.\n"
			+ " Un port doit avoir une valeur numérique entre 1 et 65536.";
	private final static String ERREUR_ADRESSE = "Veuillez entrer une adresse et un numéro de port séparés par ':'";

	/**
	 * Décortiquer une adresse réseau fournit par l'utilisateur afin d'instancier une adresse.
	 * 
	 * @param entreeUtilisateur
	 *            La Chaîne entrée par l'utilisateur
	 * @return Une instance d'une adresse utilisable par une socket
	 * @throws IllegalArgumentException
	 *             L'adresse n'est pas valide. Erreur spécifique à afficher pour l'utilisateur disponible dans le
	 *             message de l'exception.
	 */
	public static InetSocketAddress decortiquerAdresseReseau(String entreeUtilisateur) throws IllegalArgumentException {
		try {
			String[] raw = entreeUtilisateur.split(":");
			String hostname = raw[0];
			int port = Integer.parseInt(raw[1]);
			return new InetSocketAddress(hostname, port);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERREUR_PORT);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(ERREUR_ADRESSE);
		}
	}
}