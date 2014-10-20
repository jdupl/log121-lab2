package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: MenuFenetre.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
 2013-05-03 Version initiale
 *@author Justin Duplessis
 2014-09-09 Ajout fenétre connection
 *******************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.InetSocketAddress;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import main.log121.lab2.formes.comparateurs.AbstractComparateur;
import main.log121.lab2.utils.tris.TriFactory;
import main.log121.lab2.utils.tris.Tris;

/**
 * Crée le menu de la fenêtre de l'application
 */
public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1536336192561843187L;
	private static final int ARRET_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char ARRET_TOUCHE_RACC = KeyEvent.VK_A;
	private static final int DEMARRE_MASK = ActionEvent.CTRL_MASK;
	private static final char DEMARRE_RACC = KeyEvent.VK_D;
	private static final int QUITTER_MASK = ActionEvent.CTRL_MASK;
	private static final char QUITTER_RACC = KeyEvent.VK_Q;

	private static final String
	FICHIER_TITRE = "app.frame.menus.file.title",
	FICHIER_QUITTER = "app.frame.menus.file.exit",
	MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
	DESSIN_DEMARRER = "app.frame.menus.draw.start",
	DESSIN_ARRETER = "app.frame.menus.draw.stop",
	OBTENIR_FORMES = "app.frame.menus.getshapes",
	MENU_AIDE_TITRE = "app.frame.menus.help.title",
	MENU_TRIER_TITRE="app.frame.menus.sort.title",
	MENU_AIRE_C="app.frame.menus.sort.ascendingarea",
	MENU_AIRE_D="app.frame.menus.sort.descendingarea",
	MENU_TYPE_C="app.frame.menus.sort.ascendingshapetype",
	MENU_TYPE_D="app.frame.menus.sort.descendingshapetype",
	MENU_DISTANCE_C="app.frame.menus.sort.ascendingmaxdistance",
	MENU_DISTANCE_D="app.frame.menus.sort.descendingmaxdistance",
	MENU_LARGEUR_C="app.frame.menus.sort.ascendingwidth",
	MENU_LARGEUR_D="app.frame.menus.sort.descendingwidth",
	MENU_HAUTEUR_C="app.frame.menus.sort.ascendingheight",
	MENU_HAUTEUR_D="app.frame.menus.sort.descendingheight",
	ORDRE_ARRIVEE="app.frame.menus.sort.arrivalorder",
	ORDRE_ORIGINAL="app.frame.menus.sort.originalorder",
	MENU_AIDE_PROPOS = "app.frame.menus.help.about",
	MESS_A_PROPOS = "app.frame.dialog.about";

	private JMenuItem arreterMenuItem, demarrerMenuItem, obtenirFormes;
	private static final int DELAI_QUITTER = 200;

	private static final String MESS_CONNECTION = "Quel est le nom d'hôte et le port du serveur de formes.";

	CommBase comm; // Pour activer/désactiver la communication avec le serveur
	FenetreFormes fen;

	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm, FenetreFormes fen) {
		this.comm = comm;
		this.fen = fen;
		addMenuDessiner();
		addMenuFichier();
		addMenuTrier();
		addMenuAide();
	}

	/**
	 * Créer le menu "Draw".
	 */
	protected void addMenuDessiner() {
		JMenu menu = creerMenu(MENU_DESSIN_TITRE, new String[] { DESSIN_DEMARRER, DESSIN_ARRETER,
				OBTENIR_FORMES });

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				demarrerComm(-1, false);
			}
		});
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(DEMARRE_RACC,
				DEMARRE_MASK));

		arreterMenuItem = menu.getItem(1);
		arreterMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stop();
				rafraichirMenus();
			}
		});

		arreterMenuItem.setAccelerator(KeyStroke.getKeyStroke(ARRET_TOUCHE_RACC,
				ARRET_TOUCHE_MASK));

		obtenirFormes = menu.getItem(2);
		obtenirFormes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				demarrerComm(10, true);

			}
		});

		add(menu);
	}

	/**
	 * Créer le menu "File".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(FICHIER_TITRE, new String[] { FICHIER_QUITTER });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stop();
				try {
					Thread.sleep(DELAI_QUITTER);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(QUITTER_RACC, QUITTER_MASK));
		add(menu);
	}

	/**
	 * Créer le menu "Trier".
	 */
	private void  addMenuTrier() {
		JMenu menu = creerMenu(
				MENU_TRIER_TITRE,
				new String[] {
						MENU_AIRE_C,
						MENU_AIRE_D,
						MENU_DISTANCE_C,
						MENU_DISTANCE_D,
						MENU_TYPE_C,
						MENU_TYPE_D,
						MENU_HAUTEUR_C,
						MENU_HAUTEUR_D,
						MENU_LARGEUR_C,
						MENU_LARGEUR_D,
						ORDRE_ARRIVEE,
						ORDRE_ORIGINAL,
				});

		//MENU_TRIER_AIRE_CROISSANTE
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.AIRE, false, true);
			}
		});

		//MENU_TRIER_AIRE_DECROISSANTE
		menu.getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.AIRE, true, true);
			}
		});
		//MENU_TRIER_DISTANCE_MAX_CROISSANTE
		menu.getItem(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.DISTANCE_MAX, false, true);
			}
		});
		//MENU_TRIER_DISTANCE_MAX_DECROISSANTE
		menu.getItem(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.DISTANCE_MAX, true, true);
			}
		});
		//MENU_TRIER_TYPE_CROISSANT
		menu.getItem(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.TYPE, false, true);
			}
		});
		//MENU_TRIER_TYPE_DECROISSANT
		menu.getItem(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.TYPE, true, true);
			}
		});
		//MENU_TRIER_HAUTEUR_CROISSANTE
		menu.getItem(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.HAUTEUR, false, true);
			}
		});
		//MENU_TRIER_HAUTEUR_DECROISSANTE
		menu.getItem(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.HAUTEUR, true, true);
			}
		});
		//MENU_TRIER_LARGEUR_CROISSANTE
		menu.getItem(8).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.LARGEUR, false, true);
			}
		});
		//MENU_TRIER_LARGEUR_DECROISSANTE
		menu.getItem(9).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.LARGEUR, true, true);
			}
		});
		//MENU_TRIER_ORDRE_ARRIVEE
		menu.getItem(10).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.ORIGINAL, false, true);
			}
		});
		//MENU_TRIER_ORDRE_ORIGINAL
		menu.getItem(11).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trier(Tris.ORIGINAL, false, false);
			}
		});

		add(menu);
	}

	private void trier(Tris tri, boolean decroissant, boolean decale) {
		AbstractComparateur comparateur = TriFactory.creerComparateur(tri, decroissant);
		fen.getListeForme().trier(comparateur);
		fen.dessiner(decale);
	}

	/**
	 * Créer le menu "Help".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, LangueConfig.getResource(MESS_A_PROPOS),
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	/**
	 * Activer ou désactiver les items du menu selon la sélection.
	 */
	private void rafraichirMenus() {
		//demarrerMenuItem.setEnabled(!comm.isActif());
		//arreterMenuItem.setEnabled(comm.isActif());
	}

	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 *
	 * @param titleKey
	 *            champs principal
	 * @param itemKeys
	 *            éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey, String[] itemKeys) {
		JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
		for (int i = 0; i < itemKeys.length; ++i) {
			menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
		}
		return menu;
	}

	private void demarrerComm(int nbFormes, boolean bulk) {
		String entreeUtilisateur = JOptionPane.showInputDialog(MESS_CONNECTION, "localhost:10000");
		try {
			InetSocketAddress adresse = DecortiqueurAdresse.decortiquerAdresseReseau(entreeUtilisateur);
			comm.start(adresse, nbFormes, bulk);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Adresse invalide", JOptionPane.ERROR_MESSAGE);
		}
		rafraichirMenus();
	}

}
