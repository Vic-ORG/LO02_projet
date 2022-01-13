package modele.principal;
import java.util.ArrayList;
import java.util.Iterator;

import modele.joueurs.Joueur;



//import cartes.JeuCarte;
//import java.util.Scanner;
//import cartes.*;
/**Classe de l'application console
 * @author victo
 *
 */
public class app {
	
    /**Main de la version console<br>
     * Créer une partie qui lancera l'initialisation des Joueurs type et role<br>
     * Une boucle while vérifie si le moindre des joueurs a plus de 5 points. Si ce n'est pas le cas, on relance un round<br>
     * 
     * @param args args du main
     * @throws Exception exception enc as d'erreur
     */
    public static void main(String[] args) throws Exception {
    	
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbgagnant=0; //On comptabilise le nombre de joueurs qui pourrait avoir plus de 5pt
    	Joueur gagnant = new Joueur();
    	
    	
    	ArrayList<Joueur> listJ;
    	
    	Partie partie = new Partie();
    	partie.menu();
        
    	
        
        listJ = partie.recupListeJ();
		Iterator<Joueur> it = listJ.iterator(); //liste des joueurs complàte
		
		
		
		while(ScoredeFin==false) {
			//on refait un round tant que nb de point n'est pas atteint
			ScoredeFin=partie.round(listJ);
			if(ScoredeFin==true) {
			//Vàrification du score avant d'entrer dans une boucle de round
			it = listJ.iterator();
			while (it.hasNext()) {
				Joueur j = (Joueur) it.next();
				if(j.getScore()>=5) {
					//On compte le nombre de gens ayant plus de 5points et on les ajoute au tableau pour les comparer.
					nbgagnant++;
					gagnant=j;
				}
			}
			}
		System.out.println("Gagnant : " + gagnant.getNom());
		}
    }
    }
			
			
