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
 2014-09-09 Ajout fenêtre connection
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

/**
 * Crée le menu de la fenêtre de l'applicationé
 */
public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1536336192561843187L;
	private static final int MENU_DESSIN_ARRETER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_ARRETER_TOUCHE_RACC = KeyEvent.VK_A;
	private static final int MENU_DESSIN_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;

	private static final String
	MENU_FICHIER_TITRE = "app.frame.menus.file.title",
	MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
	MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
	MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start",
	MENU_DESSIN_ARRETER = "app.frame.menus.draw.stop",
	MENU_DESSIN_OBTENIR_FORMES = "app.frame.menus.getshapes",
	MENU_AIDE_TITRE = "app.frame.menus.help.title",
	MENU_TRIER_TITRE="app.frame.menus.sort.title",
	MENU_TRIER_AIRE_CROISSANTE="app.frame.menus.sort.ascendingarea",
	MENU_TRIER_AIRE_DECROISSANTE="app.frame.menus.sort.descendingarea",
	MENU_TRIER_TYPE_CROISSANT="app.frame.menus.sort.ascendingshapetype",
	MENU_TRIER_TYPE_DECROISSANT="app.frame.menus.sort.descendingshapetype",
	MENU_TRIER_DISTANCE_MAX_CROISSANTE="app.frame.menus.sort.ascendingmaxdistance",
	MENU_TRIER_DISTANCE_MAX_DECROISSANTE="app.frame.menus.sort.descendingmaxdistance",
	MENU_TRIER_LARGEUR_CROISSANTE="app.frame.menus.sort.ascendingwidth",
	MENU_TRIER_LARGEUR_DECROISSANTE="app.frame.menus.sort.descendingwidth",
	MENU_TRIER_HAUTEUR_CROISSANTE="app.frame.menus.sort.ascendingheight",
	MENU_TRIER_HAUTEUR_DECROISSANTE="app.frame.menus.sort.descendingheight",
	MENU_TRIER_ORDRE_ARRIVEE="app.frame.menus.sort.arrivalorder",
	MENU_AIDE_PROPOS = "app.frame.menus.help.about",
	MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	private JMenuItem arreterMenuItem, demarrerMenuItem, obtenirFormesMenuItem;
	private static final int DELAI_QUITTER_MSEC = 200;

	private static final String MESSAGE_CONNECTION = "Quel est le nom d'hôte et le port du serveur de formes.";

	CommBase comm; // Pour activer/désactiver la communication avec le serveur

	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm) {
		this.comm = comm;
		addMenuDessiner();
		addMenuFichier();
		addMenuTrier();
		addMenuAide();
	}

	/**
	 * Créer le menu "Draw".
	 */
	protected void addMenuDessiner() {
		JMenu menu = creerMenu(MENU_DESSIN_TITRE, new String[] { MENU_DESSIN_DEMARRER, MENU_DESSIN_ARRETER,
				MENU_DESSIN_OBTENIR_FORMES });

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				demarrerComm(-1, false);
			}
		});
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(MENU_DESSIN_DEMARRER_TOUCHE_RACC,
				MENU_DESSIN_DEMARRER_TOUCHE_MASK));

		arreterMenuItem = menu.getItem(1);
		arreterMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stop();
				rafraichirMenus();
			}
		});

		arreterMenuItem.setAccelerator(KeyStroke.getKeyStroke(MENU_DESSIN_ARRETER_TOUCHE_RACC,
				MENU_DESSIN_ARRETER_TOUCHE_MASK));

		obtenirFormesMenuItem = menu.getItem(2);
		obtenirFormesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demarrerComm(10, true);

			}
		});

		add(menu);
	}

	/**
	 * Créer le menu "File".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_FICHIER_QUITTER });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stop();
				try {
					Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC, MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 * Créer le menu "Trier".
	 */
	private void  addMenuTrier() {
		JMenu menu = creerMenu(
				MENU_TRIER_TITRE,
				new String[] {
						MENU_TRIER_AIRE_CROISSANTE,
						MENU_TRIER_AIRE_DECROISSANTE,
						MENU_TRIER_DISTANCE_MAX_CROISSANTE,
						MENU_TRIER_DISTANCE_MAX_DECROISSANTE,
						MENU_TRIER_TYPE_CROISSANT,
						MENU_TRIER_TYPE_DECROISSANT,
						MENU_TRIER_HAUTEUR_CROISSANTE,
						MENU_TRIER_HAUTEUR_DECROISSANTE,
						MENU_TRIER_LARGEUR_CROISSANTE,
						MENU_TRIER_LARGEUR_DECROISSANTE,
						MENU_TRIER_ORDRE_ARRIVEE
				});

		//MENU_TRIER_AIRE_CROISSANTE
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});

		//MENU_TRIER_AIRE_DECROISSANTE
		menu.getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_DISTANCE_MAX_CROISSANTE
		menu.getItem(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_DISTANCE_MAX_DECROISSANTE
		menu.getItem(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_TYPE_CROISSANT
		menu.getItem(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_TYPE_DECROISSANT
		menu.getItem(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_HAUTEUR_CROISSANTE
		menu.getItem(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_HAUTEUR_DECROISSANTE
		menu.getItem(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_LARGEUR_CROISSANTE
		menu.getItem(8).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_LARGEUR_DECROISSANTE
		menu.getItem(9).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});
		//MENU_TRIER_ORDRE_ARRIVEE
		menu.getItem(10).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACTION ICI
			}
		});

		add(menu);
	}

	/**
	 * Créer le menu "Help".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS),
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
		String entreeUtilisateur = JOptionPane.showInputDialog(MESSAGE_CONNECTION, "localhost:10000");
		try {
			InetSocketAddress adresse = DecortiqueurAdresse.decortiquerAdresseReseau(entreeUtilisateur);
			comm.start(adresse, nbFormes, bulk);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Adresse invalide", JOptionPane.ERROR_MESSAGE);
		}
		rafraichirMenus();
	}

}
