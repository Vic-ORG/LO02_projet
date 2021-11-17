package cartes;
//import cartes.Carte;


import java.util.*;

public class JeuCarte {
	public final static int NOMBRE_DE_CARTES = 12;
	private LinkedList<Carte> tasDeCartes;
	
	public JeuCarte() {
		tasDeCartes = new LinkedList<Carte>();
		tasDeCartes.add(new Carte("rumeur", "Angry Mob"));
		tasDeCartes.add(new Carte("rumeur", "The Inquisition"));
		tasDeCartes.add(new Carte("rumeur", "Pointed Hat"));
		tasDeCartes.add(new Carte("rumeur", "Hooked Nose"));
		tasDeCartes.add(new Carte("rumeur", "Broomstick"));
		tasDeCartes.add(new Carte("rumeur", "Wart"));
		tasDeCartes.add(new Carte("rumeur", "Ducking Stool"));
		tasDeCartes.add(new Carte("rumeur", "Cauldron"));
		tasDeCartes.add(new Carte("rumeur", "Evil Eye"));
		tasDeCartes.add(new Carte("rumeur", "Toad"));
		tasDeCartes.add(new Carte("rumeur", "Black Cat"));
		tasDeCartes.add(new Carte("rumeur", "Pet Newt"));
		
	}

	public void melanger() {
		for (int i = 0; i < JeuCarte.NOMBRE_DE_CARTES; i++) {
			int position = (int)Math.round((JeuCarte.NOMBRE_DE_CARTES - 1) * Math.random());
			Carte carte = tasDeCartes.pop();
			tasDeCartes.add(position, carte);
			}
		}
	
	public Carte tirerCarteDuDessus() {
		return tasDeCartes.pop();
			}
	
	/*
	public carte tirerCarte() {
		int position = (int) Math.round((jeuCarte.NOMBRE_DE_CARTES - 1)* Math.random());
		return tasDeCartes.remove(position);
	}*/
		
	public boolean estVide() {
		return tasDeCartes.isEmpty();
	}
	
	public String toString() {
		return tasDeCartes.toString();
		}
	}


//-----------------------------------------------
/*public class jeuCarte {

	// Variables d'instance
	
	private ArrayList<carte>   jeu;

	//Construit un jeu de cartes vide.
	public jeuCarte() {
		jeu = new ArrayList<carte>();
	}

	//Ajoute cette carte au jeu.
	public boolean addCarte(carte carte) {
		return this.jeu.add(carte);
	}

	
	static public jeuCarte createJeuCartes() {

		jeuCarte jeu = new jeuCarte();
		
		jeu.addCarte(new carte("rumeur", "Angry Mob"));
		jeu.addCarte(new carte("rumeur", "Hooked nose"));
		jeu.addCarte(new carte("rumeur", "Angry Mob"));
		jeu.addCarte(new carte("rumeur", "Angry Mob"));
		jeu.addCarte(new carte("rumeur", "Angry Mob"));
		jeu.addCarte(new carte("rumeur", "Angry Mob"));
		jeu.addCarte(new carte("rumeur", "Angry Mob"));
		jeu.addCarte(new carte("rumeur", "Angry Mob"));
		
		return jeu;
	}

	//Melange le jeu
	public void melangeJeu() {
		ArrayList<carte> jeuMelange = new ArrayList<carte>();
		int n;
		while (!this.jeu.isEmpty()) {
			n = (int) (Math.random() * this.jeu.size());
			jeuMelange.add(this.jeu.remove(n));
		}
		this.jeu = jeuMelange;
	}

	
	//Verifier si tas de jeu est vide
	public boolean isEmpty() {
		return this.jeu.isEmpty();
	}
	
	public carte getOneCardAsTalon() {
		if (this.jeu.size() > 0) {
			// Retourner derniere carte du talon extraction
			carte carte = (this.jeu.remove(this.jeu.size() - 1));
			return carte;
		}
		else {
			// Si il n'ya plus de carte
			return null;
		}
	}

}*/


//-----------------------------------------------------------


