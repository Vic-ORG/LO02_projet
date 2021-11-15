package cartes;
import cartes.carte;

//----------------------------------------------
import java.util.ArrayList;

public class jeuCarte {

	// Variables d'instance
	/** Le jeu de cartes */
	private ArrayList<carte>   jeu;

	//Construit un jeu de cartes vide.
	public jeuCarte() {
		jeu = new ArrayList<carte>();
	}

	//Ajoute cette carte au jeu.
	private boolean addCarte(carte carte) {
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

}


//-----------------------------------------------------------


