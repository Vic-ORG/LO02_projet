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
	
		
	public boolean estVide() {
		return tasDeCartes.isEmpty();
	}
	
	public String toString() {
		return tasDeCartes.toString();
		}
	}


//-----------------------------------------------


//-----------------------------------------------------------


