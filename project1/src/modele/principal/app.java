package modele.principal;
import java.util.ArrayList;
import java.util.Iterator;

import modele.joueurs.Joueur;

//import cartes.JeuCarte;
//import java.util.Scanner;
//import cartes.*;
public class app {
	
    public static void main(String[] args) throws Exception {
    	//boolean overideJoueur=false;
    	//Scanner scanner = new Scanner(System.in);
    	//int choix;
    	//int choix2=0;
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbgagnant=0; //On comptabilise le nombre de joueurs qui pourrait avoir plus de 5pt
    	Joueur gagnant = new Joueur();
    	//int nbJrevel; //pour compter le nombre de joueur ayant une carte identité revelà
    	
    	ArrayList<Joueur> listJ;
    	
    	Partie partie = new Partie();
    	partie.menu();
        //partie.initGame();
    	
        
        listJ = partie.recupListeJ();
		Iterator<Joueur> it = listJ.iterator(); //liste des joueurs complàte
		//Iterator<Joueur> itA = listJ.iterator(); //liste des joueurs pour accusation (differente car on utulise l'autre dans le while)
		
		
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
			
			
