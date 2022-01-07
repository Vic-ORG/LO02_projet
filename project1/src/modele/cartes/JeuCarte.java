package modele.cartes;
//import cartes.Carte;


import java.util.*;

/**Classe jeu de carte qui permet de créer un jeu de carte
 * @author victo
 *
 */
public class JeuCarte {
	/**nombre de carte fixe du jeu
	 * 
	 */
	public final static int NOMBRE_DE_CARTES = 12;
	private LinkedList<Carte> tasDeCartes;
	
	/**Permet la construction d'un jeu de carte avec les cartes
	 * 
	 */
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

	/**Permet de mélanger le paquet de carte crée
	 * Pas de parametre
	 * 
	 */
	public void melanger() {
		for (int i = 0; i < JeuCarte.NOMBRE_DE_CARTES; i++) {
			int position = (int)Math.round((JeuCarte.NOMBRE_DE_CARTES - 1) * Math.random());
			Carte carte = tasDeCartes.pop();
			tasDeCartes.add(position, carte);
			}
		}
	
	/**Prendre la carte du dessus du paquet
	 * Pas de parametre
	 * @return la carte du dessus du tas
	 */
	public Carte tirerCarteDuDessus() {
		return tasDeCartes.pop();
			}
	
		
	/**Permet de vérifier si le paquet de carte est vide ou non
	 * @return un blooean si le paquet de carte est vide ou non
	 */
	public boolean estVide() {
		return tasDeCartes.isEmpty();
	}
	
	/**Voir état en caractère du tas de carte
	 * return un string
	 */
	public String toString() {
		return tasDeCartes.toString();
		}
	}


//-----------------------------------------------


//-----------------------------------------------------------


