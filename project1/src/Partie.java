//import cartes.*;

//import joueurs.*;
import java.util.*;

import cartes.Carte;
import cartes.JeuCarte;
import joueurs.Bot;
import joueurs.Joueur;

public class Partie {
	
	private ArrayList<Joueur> joueurs;
	private JeuCarte cartes;
	private boolean partieEnCours;

    static Scanner ReadConsole = new Scanner(System.in);
    
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
    	
    	public void distribuerCartes() {
    		this.partieEnCours = true;
    		while (cartes.estVide() == false) {
    			Iterator<Joueur> it = joueurs.iterator();
    			while (it.hasNext()) {
    				Joueur j = (Joueur) it.next();
    				j.prendreCarte(cartes.tirerCarteDuDessus());
    			}
    		}
    	}
    		
    	/*public void jouer() {
    		ArrayList<Carte> cartesJouees = this.jouerCartes();
    		System.out.println("Cartes jouιes : " + cartesJouees);
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
    public void menu(){
    
        int sousmenu = 0;
        boolean arret = false;   

        while (!arret){
            System.out.println("\nβββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
            System.out.println("βββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
            System.out.println("βββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
            System.out.println("βββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
            System.out.println("βββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

            System.out.println("ββ\nββ\to JOUER   : tapez 1");
            System.out.println("ββ\to REGLES  : tapez 2");
            System.out.println("ββ\nββ\to QUITTER : tapez 9");
            System.out.println("ββ\nβββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
            sousmenu = ReadConsole.nextInt();
            
            switch(sousmenu){
                case 1 : initGame(); arret = true; break;
                case 2 : System.out.println("Sous menu 2"); break;
                case 9 : arret = true; break;
                default : {
                    System.out.println("\tββββββββββββββββββββββββββββββββββ");
                    System.out.println("\tββ entrez un choix entre 1 et 3 ββ");
                    System.out.println("\tββββββββββββββββββββββββββββββββββ");
                } break;
            }
        }
    }

    public void initGame() {
        int nbJoueur = 0;
        int nbBot = 0;
        String addBot;
        String nom, id;
        
        /*Joueur joueur1 = new Joueur(null, false, true, 0);
        Joueur joueur2 = new Joueur(null, false, true, 0);
        Joueur joueur3 = new Joueur(null, false, true, 0);
        Joueur joueur4 = new Joueur(null, false, true, 0);
        Joueur joueur5 = new Joueur(null, false, true, 0);
        Joueur joueur6 = new Joueur(null, false, true, 0);

        Bot bot1 = new Bot(null, false, true, 0, 0);
        Bot bot2 = new Bot(null, false, true, 0, 0);
        Bot bot3 = new Bot(null, false, true, 0, 0);
        Bot bot4 = new Bot(null, false, true, 0, 0);
        Bot bot5 = new Bot(null, false, true, 0, 0);*/

        System.out.println("\tChoisissez le nombre de joueurs humains (entre 1 et 6): ");
        nbJoueur = ReadConsole.nextInt();
        int i=0;
        for(i=1; i<=nbJoueur; i++) {
        	System.out.println("\tNom du joueur " + i + " :  ");
            nom = ReadConsole.next();
            ajouterJoueur(new Joueur(nom, false, true, true, 0));
            /*System.out.println("\tIdentitι du joueur (sor ou vil) " + i + " :  ");
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
        /*
        switch(nbJoueur){
            case 1 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);
            } break;
            case 2 : {
               System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du premier bot : ");
                nom = ReadConsole.next();
                bot1.setNom(nom);
                bot1.setEtat(true);
            } break;
            case 3 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);
            } break;
            case 4 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);

                System.out.println("\tNom du quatriΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur4.setNom(nom);
                joueur4.setEtat(true);
            } break;
            case 5 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);

                System.out.println("\tNom du quatriΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur4.setNom(nom);
                joueur4.setEtat(true);

                System.out.println("\tNom du cinquiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur5.setNom(nom);
                joueur5.setEtat(true);
                
            } break; 
            case 6 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);

                System.out.println("\tNom du quatriΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur4.setNom(nom);
                joueur4.setEtat(true);

                System.out.println("\tNom du cinquiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur5.setNom(nom);
                joueur5.setEtat(true);

                System.out.println("\tNom du sixiΓ¨me joueur : ");
                nom = ReadConsole.next();
                joueur6.setNom(nom);
                joueur6.setEtat(true);
                
            } break;
            default : break;
        }*/
        
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
			//on affiche les joueurs ayant leur carte encore secrθte et pas notre joueur
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
        /*
        System.out.println("\tAjouter des bots (y/n): ");
        addBot = ReadConsole.next();
        if (addBot.equals("y")){
            System.out.println("\tChoisissez le nombre de bots (maximum " + (6-nbBot-nbJoueur) + "): ");
            nbBot = ReadConsole.nextInt();

            switch(nbBot){

            }
        }
        else if (addBot.equals("n")){
            //lancer partie
            System.out.println(joueur1.getNom());
            System.out.println(joueur2.getNom());
            System.out.println(joueur3.getNom());
            System.out.println(joueur4.getNom());
            System.out.println(joueur5.getNom());
            System.out.println(joueur6.getNom());
        }
        else{
            System.out.println("\tAjouter des bots (y/n): ");
            addBot = ReadConsole.next();
        }*/
        
    }
    
    public boolean round(ArrayList<Joueur> listJ) {
    	boolean overideJoueur=false;
    	boolean overideJautre=false;
    	Scanner scanner = new Scanner(System.in);
    	int choix;
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbJrevel; //pour compter le nombre de joueur ayant une carte identitι revelι
    	String id, effet;
    	int[] restrictChoix=new int[6];
    	int restrict=0;
    	
    	//ArrayList<Joueur> listJ;
    	//listJ=joueurs;
    	
		Iterator<Joueur> it = listJ.iterator(); //liste des joueurs complθte
		Iterator<Joueur> itA = listJ.iterator(); //liste des joueurs pour accusation (differente car on utulise l'autre dans le while)
			
		//Dιbut d'un round
		//Initialisation du paquet de carte
	    JeuCarte jeuActu = new JeuCarte();
	    jeuActu.melanger();
	    distribuerCartes();
	    int i;
	    int index=0;
	    int index2=0;
	    int indextemp=0;
	    
	    it = listJ.iterator();
    	//on affiche les joueurs ayant leur carte encore secrθte et pas notre joueur
    	while(it.hasNext()) {
    		Joueur G=it.next();
    		G.setEtatjeu(true);
			G.setEtatcarte(false);
    		System.out.println("Joueur:" + G.getNom() + "  Score : " + G.getScore());

            System.out.println("\tIdentitι du joueur" + G.getNom() + " pour ce round (sor ou vil) :  ");
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
	        
	    it = listJ.iterator();
	    nbJrevel=listJ.size(); //les cartes identitι sont du nombre de joueur dans la liste
	    System.out.println("******\n nombre de cartes non revele : " + nbJrevel);
	        
	    while(nbJrevel>1) //un round ne s'arrete que lorsque 1 personne a encore sa carte identitι cachι
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
	        //actionTour pour soit accuser soit chasser
	        choix=jActu.actionTour();
	        /*System.out.println("Choississez votre action : 1 pour accuser, 2 pour utiliser carte rumeur");
			choix=scanner.nextInt();*/
				
			if(choix==1) {
			//Accuser joueur
			itA = listJ.iterator();
			//on affiche les joueurs ayant leur carte encore secrθte et pas notre joueur
			while(itA.hasNext()) {
				Joueur A=itA.next();
				if(A.getEtatcarte()==false && listJ.indexOf(A)!=index) {
					restrictChoix[restrict]=listJ.indexOf(A);
					restrict++;
				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
			}
			//Choisir qui accuser
			System.out.println("Choississez le joueur ΰ accuser : ");
			Joueur Jaccuser=jActu.choisirVictime(restrictChoix, listJ);
			index2=listJ.indexOf(Jaccuser);
			
			//Tableau reinistialiser valeur
			for(i=0; i<restrictChoix.length; i++) {
				restrictChoix[i]=-1;
			}
    		restrict=0;
    		
			//rιpondre accusation
			int choix3 = Jaccuser.repondreAccu();
			/*System.out.println("Choississez le joueur ΰ accuser (sauf vous meme numero : " + index + " )");
			index2=scanner.nextInt();
			Joueur Jaccuser = listJ.get(index2);
			System.out.println("Joueur : "+ Jaccuser.getNom() + ", vous etes accusι.");
			System.out.println("Choississez si vous rιvιlez votre identitι : 0 non et 1 oui");*/
			//int choix3=scanner.nextInt();
				
					
			if(choix3==1) {
				if(Jaccuser.isIdentite()==true) { //si le joueur accusι est une sorciere
					System.out.println("Le joueur : " + Jaccuser.getNom() + "accusι est une sorciere !");
					System.out.println("Le joueur accusι " + Jaccuser.getNom() + " est exclus du round !");
					System.out.println("Le joueur qui a accusι gagne 1 point. Il rejout !");
					//Comme il rejout, index ne change pas pour qu'il reprenne la main lors du prochain tour de boucle
					//listJ.remove(index2);
					Jaccuser.setEtatjeu(false);
					Jaccuser.setEtatcarte(true);
					nbJrevel=nbJrevel-1; //Parmi la totalitι des joueurs, 1 a rιvιlι sa carte
					listJ.set(index2, Jaccuser); //on met ΰ jour dans listJ
					jActu.setScore(1);
				}
				else {
				System.out.println("Le joueur accusι ΰ index   " + index2 + Jaccuser.getNom() +  "   est un villageois !");
				System.out.println("Le joueur accusι reprend la main (commence le prochain tour) !");
				System.out.println("Personne ne gagne ou perd de points !");
				//comme il reprend la main l'index du joueur accusι devient l'index qui sera utilisι pour le dιbut de boucle
				//faire en sorte que Jaccuser soit le bon en recommenηant la boucle
				overideJoueur=true;
				Jaccuser.setEtatcarte(true);
				nbJrevel=nbJrevel-1;
				listJ.set(index2, Jaccuser); //on met ΰ jour dans listJ
					
				}
			}
			else {
				effet="witch";
				//Afficher les cartes en mains :
		        System.out.println("Vos carte en main :");
		        main = Jaccuser.getMain().iterator();
		        while(main.hasNext()) {
		        	Carte C=main.next();
		        	boolean jouable=C.jouabiliteCarte(effet, Jaccuser);
		        	if(jouable==true) {
		        	System.out.println("Les cartes jouables sont : \n");
		        	System.out.println(C.getNom() + "ΰ index :  "+ Jaccuser.getMain().indexOf(C));
		        	restrictChoix[restrict]=Jaccuser.getMain().indexOf(C);
					restrict++;}
		        }
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
		        Carte carteRecup=Jaccuser.choisirCarte(restrictChoix, Jaccuser.getMain());
		        //int choixcarte=scanner.nextInt();
				
				
				System.out.println("Carte choisi : " + carteRecup.getNom());
				Joueur Jtemp=Jaccuser.jouerCarte(carteRecup, effet, listJ, index, index2);
				indextemp=listJ.indexOf(Jtemp);
				
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
				
			}
		} //fin du if accusation
				
			else if(choix==2) {
				effet="hunt";
				//Afficher les cartes en mains :
		        System.out.println("Vos carte en main :");
		        main = jActu.getMain().iterator();
		        while(main.hasNext()) {
		        	Carte C=main.next();
		        	boolean jouable=C.jouabiliteCarte(effet, jActu);
		        	if(jouable==true) {
		        	System.out.println("Les cartes jouables sont : \n");
		        	System.out.println(C.getNom() + "ΰ index :  "+ jActu.getMain().indexOf(C));
		        	restrictChoix[restrict]=jActu.getMain().indexOf(C);
					restrict++;}
		        }
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
		        Carte carteRecup=jActu.choisirCarte(restrictChoix, jActu.getMain());
		        
		        System.out.println("Carte choisi : " + carteRecup.getNom());
				Joueur Jtemp=jActu.jouerCarte(carteRecup, effet, listJ, index, index2);
				indextemp=listJ.indexOf(Jtemp);
				if(indextemp == index) {
					jActu=Jtemp;
				}
				else if(indextemp!=index) {
					listJ.set(indextemp, Jtemp);
					overideJautre=true;
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
				jActu.jouerCarte(jActu.getMain().get(choixcarte)); //dans joueur, complιter la fonction en fonction de la carte
				//dans la fonction au dessus, je met la carte dans la deffausse du joueur*/
								
				//on retire la carte de la main du joueur
				//jActu.getMain().remove(jActu.getMain().get(choixcarte));
			}
			
			//on remplace le joueur qu'on a pris avec les valeur de joueur actuelle, par exemple pour changι score
			listJ.set(index, jActu);
			
			//Si Joueur suivant changι, on affecte la valeur de son index2 ΰ l'index.
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
	    
	        //Vιrifier point de joueur et mettre si ScoredeFin=true ou false
	    	it = listJ.iterator();
	    	//on affiche les joueurs ayant leur carte encore secrθte et pas notre joueur
	    	while(it.hasNext()) {
	    		Joueur G=it.next();
	    		if(G.getEtatcarte()==false) {
	    			System.out.println("index : " + listJ.indexOf(G) + "Joueur : " + G.getNom() + "est le dernier a avoir sa carte identitι secrθte");
	    			if(G.isIdentite()==true) {
	    				System.out.println("Son identitι est : sorciθre, il gagne 2 points");
	    				G.setScore(2);
	    			}
	    			else {
	    				System.out.println("Son identitι est : villageois. Il gagne 1 points");
	    				G.setScore(1);
	    			}
	    			listJ.set(listJ.indexOf(G), G);
	    		}
		}
	    	//Vιrifier point de joueur et mettre si ScoredeFin=true ou false
	    	it = listJ.iterator();
	    	while (it.hasNext()) {
				Joueur j = (Joueur) it.next();
				if(j.getScore()>=5) {
					ScoredeFin=true;
				}
				}
	        //System.out.println("Programme fini gagnant : " + gagnant);
			//scanner.close();
	        return ScoredeFin;
    }
    
    
    
    
    
}