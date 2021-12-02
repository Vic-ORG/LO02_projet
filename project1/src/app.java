import joueurs.Joueur;


import java.util.ArrayList;
import java.util.Iterator;

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
			
			/*
			//Dàbut d'un round
			 //Initialisation du paquet de carte
	        JeuCarte jeuActu = new JeuCarte();
	        jeuActu.melanger();
	        partie.distribuerCartes();
	        
	        //Joueur jActu=new Joueur("patate", true, false, 0);
	        int index=0;
	        int index2=0;
	        
	        it = listJ.iterator();
	        nbJrevel=listJ.size(); //les cartes identité sont du nombre de joueur dans la liste
	        System.out.println("******\n nombre de cartes non revele : " + nbJrevel);
	        
	        while(nbJrevel>1) //un round ne s'arrete que lorsque 1 personne a encore sa carte identité cachà
	        {
	        	Joueur jActu=listJ.get(index);
	        	System.out.println("Joueur actuel :" + jActu.getNom() + "  Index dans list : " +index);
	        	//Afficher les cartes en mains :
	        	System.out.println("Vos carte en main :");
	        	Iterator<Carte> main = jActu.getMain().iterator();
	        	while(main.hasNext()) {
	        		Carte C=main.next();
	        		System.out.println(C.getNom());
	        	}
	        	System.out.println("Choississez votre action : 1 pour accuser, 2 pour utiliser carte rumeur");
				choix=scanner.nextInt();
				
				if(choix==1) {
					//Accuser joueur
					itA = listJ.iterator();
					//on affiche les joueurs ayant leur carte encore secràte et pas notre joueur
					while(itA.hasNext()) {
						Joueur A=itA.next();
						if(A.getEtatcarte()==false && listJ.indexOf(A)!=index) {
						System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
					}
					
					System.out.println("Choississez le joueur à accuser (sauf vous meme numero : " + index + " )");
					index2=scanner.nextInt();
					Joueur Jaccuser = listJ.get(index2);
					System.out.println("Joueur : "+ Jaccuser.getNom() + ", vous etes accusé.");
					System.out.println("Choississez si vous révélez votre identité : 0 non et 1 oui");
					int choix3=scanner.nextInt();
					
					
					if(choix3==1) {
						if(Jaccuser.isIdentite()==true) { //si le joueur accusé est une sorciere
							System.out.println("Le joueur : " + Jaccuser.getNom() + "accusé est une sorciere !");
							System.out.println("Le joueur accusé " + Jaccuser.getNom() + " est exclus du round !");
							System.out.println("Le joueur qui a accusé gagne 1 point. Il rejout !");
							//Comme il rejout, index ne change pas pour qu'il reprenne la main lors du prochain tour de boucle
							//listJ.remove(index2);
							Jaccuser.setEtatjeu(false);
							Jaccuser.setEtatcarte(true);
							nbJrevel=nbJrevel-1; //Parmi la totalità des joueurs, 1 a révélé sa carte
							listJ.set(index2, Jaccuser); //on met à jour dans listJ
							jActu.setScore(1);
						}
						else {
							System.out.println("Le joueur accusé est un villageois !");
							System.out.println("Le joueur accusé reprend la main (commence le prochain tour) !");
							System.out.println("Personne ne gagne ou perd de points !");
							//comme il reprend la main l'index du joueur accusé devient l'index qui sera utilisà pour le dàbut de boucle
							//faire en sorte que Jaccuser soit le bon en recommenàant la boucle
							overideJoueur=true;
							
						}
					}
				} //fin du if accusation
				
				else if(choix==2) {
					//Afficher carte rumeur jouable
					//Afficher les cartes en mains :
		        	System.out.println("Vos carte en main :");
		        	main = jActu.getMain().iterator();
		        	while(main.hasNext()) {
		        		System.out.println("Carte index" + jActu.getMain().indexOf(main.next()) + " nom : " + main.next().getNom());
		        	}
		        	System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
					int choixcarte=scanner.nextInt();
					System.out.println("Carte choisi : " + jActu.getMain().get(choixcarte).getNom());
					//on appel la carte et utiliser ces fonctions
					jActu.jouerCarte(jActu.getMain().get(choixcarte)); //dans joueur, complàter la fonction en fonction de la carte
					//dans la fonction au dessus, je met la carte dans la deffausse du joueur
									
					//on retire la carte de la main du joueur
					jActu.getMain().remove(jActu.getMain().get(choixcarte));
				}
			
				//on remplace le joueur qu'on a pris avec les valeur de joueur actuelle, par exemple pour changà score
				listJ.set(index, jActu);
				
				//Si Joueur suivant changà, on affecte la valeur de son index2 à l'index.
				if(overideJoueur==true) {
					index=index2;
				}
				
				///*it = listJ.iterator();
				while(it.hasNext()) {
					if(it.next().getEtatcarte()==true) {
						nbJrevel=
					}
				//}
	        
	        	
	        	
	        }//fin boucle round avec condition le nbcarterevel
	        
		}//fin boucle d'une partie avec condition de point
		System.out.println("Programme fini gagnant : " + gagnant);
		scanner.close();
    }// fin main
    
}//fin class*/
