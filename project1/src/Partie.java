//import cartes.*;

//import joueurs.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import cartes.Carte;
import cartes.JeuCarte;
import joueurs.Bot;
import joueurs.Joueur;

public class Partie {
	
	private ArrayList<Joueur> joueurs;
	private LinkedList<Carte> deffausseG = new LinkedList<Carte>();
	private JeuCarte cartes;
	private boolean partieEnCours;

    static Scanner ReadConsole = new Scanner(System.in);
	private static Scanner scan;
    
    
    
    public Partie() {
    	joueurs = new ArrayList<Joueur>();
    	cartes = new JeuCarte();
    	cartes.melanger();
    	partieEnCours = false;
    	}
    
    public ArrayList<Joueur> recupListeJ() {
    	return joueurs;
    	
    }
    
    	public void ajouterJoueur(Joueur joueur) {
    	if (partieEnCours == false) {
    	joueurs.add(joueur);
    	}
    	}
    	
    	public void retirerJoueur(Joueur joueur) {
    		joueurs.remove(joueur);
    	}
    	
    	public void distribuerCartes(int tailleJ, ArrayList<Joueur> listJ, JeuCarte jeuActu) {
    		this.partieEnCours = true;
    		int compt=0;
    		if(tailleJ==5) {
    		while (12-compt != 10) {
    			compt++;
    			Iterator<Joueur> it = listJ.iterator();
    			while (it.hasNext()) {
    				Joueur j = (Joueur) it.next();
    				j.prendreCarte(jeuActu.tirerCarteDuDessus());
    			}
    		}
    		while (cartes.estVide() == false) {
    			deffausseG.add(jeuActu.tirerCarteDuDessus());
    		}
    		}
    		else {
    			while (jeuActu.estVide() == false) {
        			Iterator<Joueur> it = listJ.iterator();
        			while (it.hasNext()) {
        				Joueur j = (Joueur) it.next();
        				j.prendreCarte(jeuActu.tirerCarteDuDessus());
        			}
        		}
    			
    		}
    	}
    		
    	/*public void jouer() {
    		ArrayList<Carte> cartesJouees = this.jouerCartes();
    		System.out.println("Cartes jou�es : " + cartesJouees);
    	}
    	
    	private ArrayList<Carte> jouerCartes() {
    		ArrayList<Carte> cartesJouees = new ArrayList<Carte>();
    		Iterator<Joueur> itDepot = joueurs.iterator();
    		while (itDepot.hasNext()) {
    			Joueur j = (Joueur) itDepot.next();
    			cartesJouees.add(j.jouerCarte());
    		}
    		return cartesJouees;
    	}*/
    		
    	/*private void retirerPerdants() {
    	}
    	
    	private Joueur joueurGagnant(Carte carte) {
    		Joueur gagnant = null;
    		return gagnant;
    	}*/
    	
    	public String toString() {
    		return joueurs.toString();
    	}
    
    
    //--------------------------------------------------------
    public void menu() throws FileNotFoundException{
    
        int sousmenu = 0;
        boolean arret = false;   

        while (!arret){
            System.out.println("\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("▒▒█▒▒▒█▒███▒█████▒▒████▒▒█▒▒█▒▒▒▒▒█▒▒█▒▒█▒▒█▒▒██▒▒█▒█████▒▒");
            System.out.println("▒▒█▒█▒█▒▒█▒▒▒▒█▒▒▒▒█▒▒▒▒▒████▒▒▒▒▒████▒▒█▒▒█▒▒█▒█▒█▒▒▒█▒▒▒▒");
            System.out.println("▒▒▒█▒█▒▒███▒▒▒█▒▒▒▒████▒▒█▒▒█▒▒▒▒▒█▒▒█▒▒████▒▒█▒▒██▒▒▒█▒▒▒▒");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

            System.out.println("▒▒\n▒▒\to JOUER   : tapez 1");
            System.out.println("▒▒\to REGLES  : tapez 2");
            System.out.println("▒▒\n▒▒\to QUITTER : tapez 9");
            System.out.println("▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            sousmenu = ReadConsole.nextInt();
            
            switch(sousmenu){
                case 1 : initGame(); arret = true; break;
				case 2 : rule(); break;                
				case 9 : arret = true; break;
                default : {
                    System.out.println("\t▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    System.out.println("\t▒▒ entrez un choix entre 1 et 3 ▒▒");
                    System.out.println("\t▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                } break;
            }
        }
    }

	private static void rule() throws FileNotFoundException{
        File regle = new File("project1\\rules.txt");
        scan = new Scanner(regle);

        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }

    }

    public void initGame() {
        int nbJoueur = 0;
        int nbBot = 0;
        String addBot;
        String nom, id;

        System.out.println("\tChoisissez le nombre de joueurs humains (entre 1 et 6): ");
        nbJoueur = ReadConsole.nextInt();
        int i=0;
        for(i=1; i<=nbJoueur; i++) {
        	System.out.println("\tNom du joueur " + i + " :  ");
            nom = ReadConsole.next();
            ajouterJoueur(new Joueur(nom, false, true, true, 0));
            /*System.out.println("\tIdentit� du joueur (sor ou vil) " + i + " :  ");
            id = ReadConsole.next();
            switch(id){
     	   
            case "sor": 
                System.out.println("Bonjour");
                System.out.println("\tSORCIERE ");
            	ajouterJoueur(new Joueur(nom, false, true, true, 0));
                break;
        
            case "vil":
                System.out.println("Hello");
                System.out.println("\t Villageois ");
            	ajouterJoueur(new Joueur(nom, false, true, false, 0));
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        	}*/
            /*if(id=="vil") {
            	System.out.println("\t Villageois ");
            	ajouterJoueur(new Joueur(nom, false, true, false, 0));
            }
            else if(id=="sor") {
            	System.out.println("\tSORCIERE ");
            	ajouterJoueur(new Joueur(nom, false, true, true, 0));
            }*/
            
            
            //joueurs.add(new Joueur(nom, false, true, false, 0));
        }
        
        System.out.println("\tAjouter des bots (y/n): ");
        addBot = ReadConsole.next();
        if (addBot.equals("y")){
            System.out.println("\tChoisissez le nombre de bots (maximum " + (6-nbBot-nbJoueur) + "): ");
            nbBot = ReadConsole.nextInt();
            for(i=1; i<=nbBot; i++) {
            	System.out.println("\tNom du Bot " + i + " :  ");
                nom = ReadConsole.next();
                ajouterJoueur(new Bot(nom, false, true, false, 0, 0));
                //joueurs.add(new Bot(nom, false, true, false, 0, 0));
                //Bot.add(new Bot(nom, true, false, 0, 0));
            	}
            }
        else if (addBot.equals("n")){
            //lancer partie
        	Iterator<Joueur> itJ = joueurs.iterator();
			//on affiche les joueurs ayant leur carte encore secr�te et pas notre joueur
			while(itJ.hasNext()) {
				Joueur J=itJ.next();
				System.out.println("index : " + joueurs.indexOf(J) + "  Joueur : " + J.getNom());
			}
        }
        else{
            System.out.println("\tAjouter des bots (y/n): ");
            addBot = ReadConsole.next();
        }
        return;
   
        
    }
    
    public boolean round(ArrayList<Joueur> listJ) {
    	boolean overideJoueur=false;
    	boolean overideJautre=false;
    	Scanner scanner = new Scanner(System.in);
    	int choix;
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbJrevel; //pour compter le nombre de joueur ayant une carte identit� revel�
    	String id, effet;
    	int[] restrictChoix=new int[6];
    	int restrict=0;
    	LinkedList<Carte> deffausseGen = new LinkedList<Carte>();
    	boolean jouable=false;
    	
    	
    	
    	
    	//ArrayList<Joueur> listJ;
    	//listJ=joueurs;
    	int tailleJ=listJ.size();
		Iterator<Joueur> it = listJ.iterator(); //liste des joueurs compl�te
		Iterator<Joueur> itA = listJ.iterator(); //liste des joueurs pour accusation (differente car on utulise l'autre dans le while)
			
		//D�but d'un round
		//Initialisation du paquet de carte
	    
	    int i;
	    int choix3=0;
	    int index=0;
	    int index2=0;
	    int indextemp=0;
	    boolean overideAccuse=false;
	    
	    it = listJ.iterator();
    	//on affiche les joueurs ayant leur carte encore secr�te et pas notre joueur
    	while(it.hasNext()) {
    		Joueur G=it.next();
    		G.setEtatjeu(true);
			G.setEtatcarte(false);
    		System.out.println("Joueur:" + G.getNom() + "  Score : " + G.getScore());

            System.out.println("\tIdentit� du joueur" + G.getNom() + " pour ce round (sor ou vil) :  ");
            id = ReadConsole.next();
            switch(id){
     	   
            case "sor": 
                System.out.println("Bonjour");
                System.out.println("SORCIERE ");
                G.setIdentite(true);
                break;
        
            case "vil":
                System.out.println("Hello");
                System.out.println("\t Villageois ");
                G.setIdentite(false);
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        	}
            listJ.set(listJ.indexOf(G), G);
    	}
	    
    	JeuCarte jeuActu = new JeuCarte();
	    jeuActu.melanger();
	    distribuerCartes(tailleJ, listJ, jeuActu);
    	
	    it = listJ.iterator();
	    nbJrevel=listJ.size(); //les cartes identit� sont du nombre de joueur dans la liste
	    System.out.println("******\n nombre de cartes non revele : " + nbJrevel);
	        
	    while(nbJrevel>1) //un round ne s'arrete que lorsque 1 personne a encore sa carte identit� cach�
	    {
	    	
	    	System.out.println("******\n nombre de cartes non revele : " + nbJrevel);
	    	Joueur jActu=listJ.get(index);
	    	System.out.println("\n\n\n******************:");
	        System.out.println("Joueur actuel :" + jActu.getNom() + "  Index dans list : " +index + "  Status identit� : " + jActu.isIdentite() + "  Score : " + jActu.getScore());
	        System.out.println("Taille d�ffausse personnelle :" + jActu.getDefausse().size() + "  D�ffauseGloble : " + deffausseGen.size());
	        //Afficher les cartes en mains :
	        System.out.println("Vos carte en main :");
	        Iterator<Carte> main = jActu.getMain().iterator();
	        Iterator<Carte> deffausse = jActu.getDefausse().iterator();
	        while(main.hasNext()) {
	        	Carte C=main.next();
	        	System.out.println(C.getNom());
	        }
	        System.out.println("\nVos cartes r�v�l�s :");
	        while(deffausse.hasNext()) {
	        	Carte C=deffausse.next();
	        	System.out.println(C.getNom());
	        }
	        //actionTour pour soit accuser soit chasser
	        
	        effet="hunt";
			//Afficher les cartes en mains :
	        
	        main = jActu.getMain().iterator();
	        while(main.hasNext()) {
	        	Carte C=main.next();
	        	jouable=C.jouabiliteCarte(effet, jActu);
	        	if(jouable==true) {
	        		jouable=false;
	        		overideAccuse=false;
	        	}
	        }
	        if(overideAccuse==true) {
	        	choix=1;
	        }
	        else {choix=jActu.actionTour();}
	        overideAccuse=false;
	        jouable=false;
	        
	        
	        /*System.out.println("Choississez votre action : 1 pour accuser, 2 pour utiliser carte rumeur");
			choix=scanner.nextInt();*/
				
			if(choix==1) {
			//Accuser joueur
			System.out.println("Liste de joueurs accusable :");
			itA = listJ.iterator();
			//on affiche les joueurs ayant leur carte encore secr�te et pas notre joueur
			while(itA.hasNext()) {
				Joueur A=itA.next();
				if(A.getEtatcarte()==false && listJ.indexOf(A)!=index) {
					restrictChoix[restrict]=listJ.indexOf(A);
					restrict++;
				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
			}
			//Choisir qui accuser
			System.out.println("\nChoississez le joueur � accuser : ");
			Joueur Jaccuser=jActu.choisirVictime(restrictChoix, listJ);
			index2=listJ.indexOf(Jaccuser);
			
			//Tableau reinistialiser valeur
			for(i=0; i<restrictChoix.length; i++) {
				restrictChoix[i]=-1;
			}
    		restrict=0;
    		
    		effet="witch";
			//Afficher les cartes en mains :
	        
	        main = Jaccuser.getMain().iterator();
	        while(main.hasNext()) {
	        	Carte C=main.next();
	        	jouable=C.jouabiliteCarte(effet, jActu);
	        	if(jouable==true) {
	        		jouable=false;
	        		overideAccuse=false;
	        	}
	        }
	        if(overideAccuse==true) {
	        	choix3=1;
	        }
	        else {choix3=Jaccuser.repondreAccu();}
	        overideAccuse=false;
    		
			//r�pondre accusation
			
			/*System.out.println("Choississez le joueur � accuser (sauf vous meme numero : " + index + " )");
			index2=scanner.nextInt();
			Joueur Jaccuser = listJ.get(index2);
			System.out.println("Joueur : "+ Jaccuser.getNom() + ", vous etes accus�.");
			System.out.println("Choississez si vous r�v�lez votre identit� : 0 non et 1 oui");*/
			//int choix3=scanner.nextInt();
				
					
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
				System.out.println("Le joueur accus� � index   " + index2 + Jaccuser.getNom() +  "   est un villageois !");
				System.out.println("Le joueur accus� reprend la main (commence le prochain tour) !");
				System.out.println("Personne ne gagne ou perd de points !");
				//comme il reprend la main l'index du joueur accus� devient l'index qui sera utilis� pour le d�but de boucle
				//faire en sorte que Jaccuser soit le bon en recommen�ant la boucle
				overideJoueur=true;
				Jaccuser.setEtatcarte(true);
				nbJrevel=nbJrevel-1;
				listJ.set(index2, Jaccuser); //on met � jour dans listJ
					
				}
			}
			else {
				effet="witch";
				//Afficher les cartes en mains :
		        System.out.println("Vos carte en main :");
		        main = Jaccuser.getMain().iterator();
		        while(main.hasNext()) {
		        	Carte C=main.next();
		        	jouable=C.jouabiliteCarte(effet, Jaccuser);
		        	System.out.println("Jouable :  " +jouable);
		        	if(jouable==true) {
		        		
		        		jouable=false;
		        	System.out.println("Les cartes jouables sont : \n");
		        	System.out.println(C.getNom() + "� index :  "+ Jaccuser.getMain().indexOf(C));
		        	restrictChoix[restrict]=Jaccuser.getMain().indexOf(C);
					restrict++;}
		        	else {
		        		System.out.println("Carte injouable :  " +C.getNom() + "� index :  "+ Jaccuser.getMain().indexOf(C));
		        	}
		        }
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
		        Carte carteRecup=Jaccuser.choisirCarte(restrictChoix, Jaccuser.getMain());
		        //int choixcarte=scanner.nextInt();
				
				
				System.out.println("Carte choisi : " + carteRecup.getNom());
				Joueur Jtemp=Jaccuser.jouerCarte(carteRecup, effet, listJ, index, index2, deffausseGen, overideAccuse, nbJrevel);
				indextemp=listJ.indexOf(Jtemp);
				if(jActu.getEtatcarte()==true || Jtemp.getEtatcarte()==true || Jaccuser.getEtatcarte()==true) {
					nbJrevel--;
				}
				if(indextemp != index && indextemp != index2) {
					overideJautre=true;
					listJ.set(indextemp, Jtemp);
					listJ.set(index2, Jaccuser);
				}
				else if(indextemp==index2) {
					overideJoueur=true;
					Jaccuser=Jtemp;
					listJ.set(index2, Jaccuser);
				}
				else if(indextemp==index) {
					//Jaccuser a �t� modifi� en appelant la fonction mais pas accusateur qui est dans Jtemp 
					//Utile pour Hooked nose
					overideJoueur=true;
					jActu=Jtemp;
					listJ.set(index, jActu);
					listJ.set(index2, Jaccuser);
				}
				
				
			}
		} //fin du if accusation
				
			else if(choix==2) {
				effet="hunt";
				//Afficher les cartes en mains :
		        System.out.println("Vos carte en main :");
		        main = jActu.getMain().iterator();
		        while(main.hasNext()) {
		        	Carte C=main.next();
		        	jouable=C.jouabiliteCarte(effet, jActu);
		        	System.out.println("Jouable :  " +jouable);
		        	if(jouable==true) {
		        		jouable=false;
		        	System.out.println("Les cartes jouables sont : \n");
		        	System.out.println(C.getNom() + "� index :  "+ jActu.getMain().indexOf(C));
		        	restrictChoix[restrict]=jActu.getMain().indexOf(C);
					restrict++;}
		        }
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
		        Carte carteRecup=jActu.choisirCarte(restrictChoix, jActu.getMain());
		        
		        System.out.println("Carte choisi : " + carteRecup.getNom());
				Joueur Jtemp=jActu.jouerCarte(carteRecup, effet, listJ, index, index2, deffausseGen, overideAccuse, nbJrevel);
				indextemp=listJ.indexOf(Jtemp);
				if(jActu.getEtatcarte()==true || Jtemp.getEtatcarte()==true) {
					nbJrevel--;
				}
				if(indextemp == index) {
					jActu=Jtemp;
				}
				else if(indextemp!=index) {
					listJ.set(indextemp, Jtemp);
					if(Jtemp.getEtatjeu()==true) {
						overideJautre=true;}
				}
				
			/*//Afficher carte rumeur jouable
			//Afficher les cartes en mains :
		    System.out.println("Vos carte en main :");
		    main = jActu.getMain().iterator();
		    while(main.hasNext()) {
		        System.out.println("Carte index" + jActu.getMain().indexOf(main.next()) + " nom : " + main.next().getNom());
		        }
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
				//int choixcarte=scanner.nextInt();
				System.out.println("Carte choisi : " + jActu.getMain().get(choixcarte).getNom());
				//on appel la carte et utiliser ces fonctions
				jActu.jouerCarte(jActu.getMain().get(choixcarte)); //dans joueur, compl�ter la fonction en fonction de la carte
				//dans la fonction au dessus, je met la carte dans la deffausse du joueur*/
								
				//on retire la carte de la main du joueur
				//jActu.getMain().remove(jActu.getMain().get(choixcarte));
			}
			
			//on remplace le joueur qu'on a pris avec les valeur de joueur actuelle, par exemple pour chang� score
			listJ.set(index, jActu);
			
			//Si Joueur suivant chang�, on affecte la valeur de son index2 � l'index.
			if(overideJoueur==true) {
				index=index2;
				overideJoueur=false;
			}
			else if(overideJautre==true) {
				index=indextemp;
				overideJautre=false;
			}
			
			//Tableau reinistialiser valeur
			for(i=0; i<restrictChoix.length; i++) {
				restrictChoix[i]=-1;
			}
    		restrict=0;
			
			
				
				       
	        	
	        	
	        }//fin boucle round avec condition le nbcarterevel
	    
	        //V�rifier point de joueur et mettre si ScoredeFin=true ou false
	    	it = listJ.iterator();
	    	//on affiche les joueurs ayant leur carte encore secr�te et pas notre joueur
	    	while(it.hasNext()) {
	    		Joueur G=it.next();
	    		if(G.getEtatcarte()==false) {
	    			System.out.println("index : " + listJ.indexOf(G) + "Joueur : " + G.getNom() + "est le dernier a avoir sa carte identit� secr�te");
	    			if(G.isIdentite()==true) {
	    				System.out.println("Son identit� est : sorci�re, il gagne 2 points");
	    				G.setScore(2);
	    			}
	    			else {
	    				System.out.println("Son identit� est : villageois. Il gagne 1 points");
	    				G.setScore(1);
	    			}
	    			listJ.set(listJ.indexOf(G), G);
	    		}
	    		//On r�nitialise les jours et on vide leur main
	    		G.setEtatjeu(true);
	    		G.setEtatcarte(false);
	    		LinkedList<Carte> m1=G.getMain();
	    		m1.removeAll(m1);
	    		/*Iterator<Carte> cartereset=m1.iterator();
	    		while(cartereset.hasNext()) {
	    			Carte cr=cartereset.next();
	    			m1.remove(cr);
	    		}*/
	    		LinkedList<Carte> deffG=G.getDefausse();
	    		deffG.removeAll(deffG);
	    		/*cartereset=deffG.iterator();
	    		while(cartereset.hasNext()) {
	    			Carte cr=cartereset.next();
	    			deffG.remove(cr);
	    		}*/
		}
	    	//V�rifier point de joueur et mettre si ScoredeFin=true ou false
	    	it = listJ.iterator();
	    	while (it.hasNext()) {
				Joueur j = (Joueur) it.next();
				j.getMain().removeAll(j.getMain());
				j.getDefausse().removeAll(j.getDefausse());
				if(j.getScore()>=5) {
					ScoredeFin=true;
				}
				}
	        //System.out.println("Programme fini gagnant : " + gagnant);
			//scanner.close();
	        return ScoredeFin;
    }
    
    
    
    
    
}