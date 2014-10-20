package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: Decortiqueur.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.log121.lab2.formes.SousForme;

/**
 * Permet de décorquiter avec une expression régulière les champs de bases des formes reçues du serveur.
 * 
 * @author Justin Duplessis
 *
 */
public class Decortiqueur {

	private int noSeq;
	private SousForme forme;
	private int[] dimensions;

	/**
	 * Constructeur qui tente de décortiquer la chaîne de caractères.
	 * 
	 * @param chaineServeur
	 *            La chaine reçue du serveur
	 * @throws IllegalArgumentException
	 *             Exception lancée si le format de la chaîne est invalide
	 */
	public Decortiqueur(String chaineServeur) throws IllegalArgumentException {
		// Regex pour trouver les informations relatives à la forme
		Pattern pattern = Pattern.compile("^([0-9]+)\\s+<([A-Z]+)>\\s*(([0-9]+\\s*){3,4})</[A-Z]+>$");
		Matcher matcher = pattern.matcher(chaineServeur);
		if (!matcher.find()) {
			throw new IllegalArgumentException(FormeFactory.ERREUR_FORME);
		}
		String noStr = matcher.group(1);
		String typeStr = matcher.group(2);
		String dimensionsStr = matcher.group(3);
		// Convertir les arguements de String en leur bon types
		noSeq = Integer.parseInt(noStr);
		// Retrouver la sous-forme en tant qu'enum
		forme = SousForme.getFromString(typeStr);
		// Convertir les dimensions de String à un tableau de String
		String[] dimsStr = dimensionsStr.split(" ");
		// Convertir le tableau de dimensions de String en int
		this.dimensions = new int[dimsStr.length];
		for (int i = 0; i < dimsStr.length; i++) {
			this.dimensions[i] = Integer.parseInt(dimsStr[i]);
		}
	}

	public int getNoSeq() {
		return noSeq;
	}

	public SousForme getForme() {
		return forme;
	}

	public int[] getDimensions() {
		return dimensions;
	}
}
