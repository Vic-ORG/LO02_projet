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
    	//int choix2=0;
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbgagnant=0; //On comptabilise le nombre de joueurs qui pourrait avoir plus de 5pt
    	Joueur[] gagnant = new Joueur[5];
    	int nbJrevel; //pour compter le nombre de joueur ayant une carte identit� revel�
    	
    	ArrayList<Joueur> listJ;
    	Partie.menu();
        Partie.initGame();
    	
        Partie partie = new Partie();
        listJ = partie.recupListeJ();
		Iterator<Joueur> it = listJ.iterator(); //liste des joueurs compl�te
		Iterator<Joueur> itA = listJ.iterator(); //liste des joueurs pour accusation (differente car on utulise l'autre dans le while)
		
		
		while(ScoredeFin==false) {
			//V�rification du score avant d'entrer dans une boucle de round
			while (it.hasNext()) {
				Joueur j = (Joueur) it.next();
				if(j.getScore()>=5) {
					//On compte le nombre de gens ayant plus de 5points et on les ajoute au tableau pour les comparer.
					nbgagnant++;
					gagnant[nbgagnant]=j;
				}
			}
			
			//D�but d'un round
			 //Initialisation du paquet de carte
	        JeuCarte jeuActu = new JeuCarte();
	        jeuActu.melanger();
	        partie.distribuerCartes();
	        
	        //Joueur jActu=new Joueur("patate", true, false, 0);
	        int index=0;
	        int index2=0;
	        
	        it = listJ.iterator();
	        nbJrevel=listJ.size(); //les cartes identit� sont du nombre de joueur dans la liste
	        
	        
	        while(nbJrevel>1) //un round ne s'arrete que lorsque 1 personne a encore sa carte identit� cach�
	        {
	        	Joueur jActu=listJ.get(index);
	        	System.out.println("Joueur actuel :" + jActu.getNom() + "Index dans list : " +index);
	        	//Afficher les cartes en mains :
	        	System.out.println("Vos carte en main :");
	        	Iterator<Carte> main = jActu.getMain().iterator();
	        	while(main.hasNext()) {
	        		System.out.println(main.next());
	        	}
	        	System.out.println("Choississez votre action : 1 pour accuser, 2 pour utiliser carte rumeur");
				choix=scanner.nextInt();
				
				if(choix==1) {
					//Accuser joueur
					itA = listJ.iterator();
					//on affiche les joueurs ayant leur carte encore secr�te et pas notre joueur
					while(itA.hasNext()) {
						if(itA.next().getEtatcarte()==false && listJ.indexOf(itA.next())!=index) {
						System.out.println("index : " + listJ.indexOf(itA.next()) + "Joueur : " + itA.next().getNom());} 
					}
					
					System.out.println("Choississez le joueur � accuser (sauf vous meme numero : " + index + " )");
					index2=scanner.nextInt();
					Joueur Jaccuser = listJ.get(index2);
					System.out.println("Joueur : "+ Jaccuser.getNom() + ", vous etes accus�.");
					System.out.println("Choississez si vous r�v�lez votre identit� : 0 non et 1 oui");
					int choix3=scanner.nextInt();
					
					
					if(choix3==1) {
						if(Jaccuser.isIdentite()==true) { //si le joueur accus� est une sorciere
							System.out.println("Le joueur : " + Jaccuser.getNom() + "accus� est une sorciere !");
							System.out.println("Le joueur accus� " + Jaccuser.getNom() + " est exclus du round !");
							System.out.println("Le joueur qui a accus� gagne 1 point. Il rejout !");
							//Comme il rejout, index ne change pas pour qu'il reprenne la main lors du prochain tour de boucle
							//listJ.remove(index2);
							Jaccuser.setEtatjeu(false);
							Jaccuser.setEtatcarte(true);
							nbJrevel=nbJrevel-1; //Parmi la totalit� des joueurs, 1 a r�v�l� sa carte
							listJ.set(index2, Jaccuser); //on met � jour dans listJ
							jActu.setScore(1);
						}
						else {
							System.out.println("Le joueur accus� est un villageois !");
							System.out.println("Le joueur accus� reprend la main (commence le prochain tour) !");
							System.out.println("Personne ne gagne ou perd de points !");
							//comme il reprend la main l'index du joueur accus� devient l'index qui sera utilis� pour le d�but de boucle
							//faire en sorte que Jaccuser soit le bon en recommen�ant la boucle
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
					jActu.jouerCarte(jActu.getMain().get(choixcarte)); //dans joueur, compl�ter la fonction en fonction de la carte
					//dans la fonction au dessus, je met la carte dans la deffausse du joueur
									
					//on retire la carte de la main du joueur
					jActu.getMain().remove(jActu.getMain().get(choixcarte));
				}
			
				//on remplace le joueur qu'on a pris avec les valeur de joueur actuelle, par exemple pour chang� score
				listJ.set(index, jActu);
				
				//Si Joueur suivant chang�, on affecte la valeur de son index2 � l'index.
				if(overideJoueur==true) {
					index=index2;
				}
				
				/*it = listJ.iterator();
				while(it.hasNext()) {
					if(it.next().getEtatcarte()==true) {
						nbJrevel=
					}
				}*/
	        
	        	
	        	
	        }//fin boucle round avec condition le nbcarterevel
	        
		}//fin boucle d'une partie avec condition de point
		
		scanner.close();
    }// fin main
    
}//fin class

	        //MAuvais et ancien :

	        /*// on s�lectionne le joueur actuelle dans la liste
	        while (it.hasNext()) {
	        	if(overideJoueur==false) {
	        		jActu = (Joueur) it.next(); //Le joueur normal
	        		index =listJ.indexOf(it.next()); //son indice dans le arraylist 
	        	}
	        	else {
	        		jActu = listJ.get(choix2); //Le joueur qui reprend la main apre�s �tre r�l�v� �tre villageois
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
						System.out.println("index : " + listJ.indexOf(itA.next()) + "Joueur : " + itA.next().getNom());}
						System.out.println("Choississez le joueur � accuser (sauf vous meme numero : " + index + " )");
						choix2=scanner.nextInt();
						Joueur Jaccuser = listJ.get(choix2);
						System.out.println("Joueur accus�, Choississez si vous r�v�lez votre identit� : 0 non et 1 oui");
						int choix3=scanner.nextInt();
						if(choix3==1) {
							if(Jaccuser.isIdentite()==true) { //si le joueur accus� est une sorciere
								System.out.println("Le joueur accus� est une sorciere !");
								System.out.println("Le joueur accus� est exclus du round !");
								System.out.println("Le joueur qui a accus� gagne 1 point. Il rejout !");
								//partie.retirerJoueur(Jaccuser);
								listJ.remove(choix2);
								jActu.setScore(1);
							}
							else {
								System.out.println("Le joueur accus� est un villageois !");
								System.out.println("Le joueur accus� reprend la main (commence le prochain tour) !");
								System.out.println("Personne ne gagne ou perd de points !");
								//faire en sorte que Jaccuser soit le bon en recommen�ant la boucle
								overideJoueur=true;
								
								
							}
						}
						//jActu.accuser(Jaccuser);
					}
				else if(choix==2) {
					//Afficher carte rumeur jouable
				}
				}
			
				//on remplace le joueur qu'on a pris avec les valeur de joueur actuelle
				listJ.set(index, jActu);
				//On v�rifie qu'il y a encore un joueur ensuite sinon on reset la liste joueur pour revenir au premier �l�ment.
				if(it.hasNext()==false) {
					it = listJ.iterator();
				}
	        }
	        
			
		}
		
		
		
        
        
			
        
    }
}*/
