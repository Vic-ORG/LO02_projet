import joueurs.Joueur;

import java.util.ArrayList;
import java.util.Iterator;

import cartes.JeuCarte;

public class app {
	
    public static void main(String[] args) throws Exception {
    	ArrayList<Joueur> listJ;
    	Partie.menu();
        Partie.initGame();
    	
        Partie partie = new Partie();
        listJ = partie.recupListeJ();
    	
    	
        
		Iterator<Joueur> it = listJ.iterator();
		//Vérification du score avant d'entrer dans une boucle de round
		while (it.hasNext()) {
			Joueur j = (Joueur) it.next();
			if(j.getScore()>=5) {
				//On sort du jeu en annonçant le vainqueur
			}
		}
		
		//Début d'un round
		 //Initialisation du paquet de carte
        JeuCarte jeuActu = new JeuCarte();
        jeuActu.melanger();
        partie.distribuerCartes();
        
        //Iterator<Joueur> it = listJ.iterator();
		//Vérification du score avant d'entrer dans une boucle de round
		while (it.hasNext()) {
			Joueur j = (Joueur) it.next();
			if(j.getResultat()==2) { //si perdant il doit demarrer
				
			}
		}
			
        
    }
}
