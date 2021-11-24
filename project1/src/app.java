import joueurs.Joueur;

import java.util.ArrayList;
import java.util.Iterator;

import cartes.JeuCarte;
import java.util.Scanner;
import cartes.*;
public class app {
	
    public static void main(String[] args) throws Exception {
    	boolean overideJoueur=false;
    	Scanner scanner = new Scanner(System.in);
    	int choix;
    	int choix2=0;
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbgagnant=0; //On comptabilise le nombre de joueurs qui pourrait avoir plus de 5pt
    	Joueur[] gagnant = new Joueur[5];
    	ArrayList<Joueur> listJ;
    	Partie.menu();
        Partie.initGame();
    	
        Partie partie = new Partie();
        listJ = partie.recupListeJ();
		Iterator<Joueur> it = listJ.iterator(); //liste des joueurs complète
		Iterator<Joueur> itA = listJ.iterator(); //liste des joueurs pour accusation (differente car on utulise l'autre dans le while)
		
		
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
	        
	        Joueur jActu=new Joueur("patate", true, false, 0);
	        int index;
	        
	        it = listJ.iterator();
	        // on sélectionne le joueur actuelle dans la liste
	        while (it.hasNext()) {
	        	if(overideJoueur==false) {
	        		jActu = (Joueur) it.next(); //Le joueur normal
	        		index =listJ.indexOf(it.next()); //son indice dans le arraylist 
	        	}
	        	else {
	        		jActu = listJ.get(choix2); //Le joueur qui reprend la main apreès être rélévé être villageois
	        		index =listJ.indexOf(listJ.get(choix2)); //son indice dans le arraylist 
	        		overideJoueur=false;
	        		
	        	}
	        	
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
					itA = listJ.iterator();
					while(itA.hasNext()) {
						System.out.println("index : " + listJ.indexOf(itA.next()) + "Joueur : " + itA.next().getNom());
						System.out.println("Choississez le joueur à accuser (sauf vous meme numero : " + index + " )");
						choix2=scanner.nextInt();
						Joueur Jaccuser = listJ.get(choix2);
						System.out.println("Joueur accusé, Choississez si vous révélez votre identité : 0 non et 1 oui");
						int choix3=scanner.nextInt();
						if(choix3==1) {
							if(Jaccuser.isIdentite()==true) { //si le joueur accusé est une sorciere
								System.out.println("Le joueur accusé est une sorciere !");
								System.out.println("Le joueur accusé est exclus du round !");
								System.out.println("Le joueur qui a accusé gagne 1 point. Il rejout !");
								//partie.retirerJoueur(Jaccuser);
								listJ.remove(choix2);
								jActu.setScore(1);
							}
							else {
								System.out.println("Le joueur accusé est un villageois !");
								System.out.println("Le joueur accusé reprend la main (commence le prochain tour) !");
								System.out.println("Personne ne gagne ou perd de points !");
								//faire en sorte que Jaccuser soit le bon en recommençant la boucle
								overideJoueur=true;
								
								
							}
						}
						//jActu.accuser(Jaccuser);
					}
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
