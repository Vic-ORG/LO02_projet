import joueurs.Joueur;

import java.util.ArrayList;
import java.util.Iterator;

import cartes.JeuCarte;
import java.util.Scanner;
import cartes.*;
public class app {
	
    public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(System.in);
    	int choix;
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbgagnant=0; //On comptabilise le nombre de joueurs qui pourrait avoir plus de 5pt
    	Joueur[] gagnant = new Joueur[5];
    	ArrayList<Joueur> listJ;
    	Partie.menu();
        Partie.initGame();
    	
        Partie partie = new Partie();
        listJ = partie.recupListeJ();
		Iterator<Joueur> it = listJ.iterator();
		
		
		while(ScoredeFin==false) {
			//Vérification du score avant d'entrer dans une boucle de round
			while (it.hasNext()) {
				Joueur j = (Joueur) it.next();
				if(j.getScore()>=5) {
					//On compte le nombre de gens ayant plus de 5points et on les ajoute au tableau pour les comparer.
					nbgagnant++;
					gagnant[nbgagnant]=j;
				}
			}
			
			//Début d'un round
			 //Initialisation du paquet de carte
	        JeuCarte jeuActu = new JeuCarte();
	        jeuActu.melanger();
	        partie.distribuerCartes();
	        
	        it = listJ.iterator();
	        // on sélectionne le joueur actuelle dans la liste
	        while (it.hasNext()) {
	        	Joueur jActu = (Joueur) it.next();
	        	int index =listJ.indexOf(jActu);
	        	
	        	//Afficher les cartes en mains :
	        	System.out.println("Vos carte en main :");
	        	Iterator<Carte> main = jActu.getMain().iterator();
	        	while(main.hasNext()) {
	        		System.out.println(main.next());
	        	}
	        	System.out.println("Choississez votre action : 1 pour accuser, 2 pour utiliser carte rumeur");
				choix=scanner.nextInt();
				while(choix!=1 || choix !=2) {
					
				
				if(choix==1) {
					//Accuser joueur
				}
				else if(choix==2) {
					//Afficher carte rumeur jouable
				}
				}
			
				//on remplace le joueur qu'on a pris avec les valeur de joueur actuelle
				listJ.set(index, jActu);
				//On vérifie qu'il y a encore un joueur ensuite sinon on reset la liste joueur pour revenir au premier élément.
				if(it.hasNext()==false) {
					it = listJ.iterator();
				}
	        }
	        
			
		}
		
		
		
        
        
			
        
    }
}
