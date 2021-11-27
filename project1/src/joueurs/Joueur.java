package joueurs;
import cartes.Carte;
import java.util.*;
import java.util.stream.IntStream;

import cartes.carte_role;


public class Joueur {
    private String nom;
    private boolean etatCarte; //true=idendité revelé, false = identité encore secrète
    private boolean etatJeu; // true = en vie dans le round, false = mort dans le round
    private boolean identite = carte_role.isRole(); //sorciere true, villageois false
    private int score;
    private LinkedList<Carte> main;
    private LinkedList<Carte> defausse;
    private int resultat; // 0=neutre, 1=vainqueur, 2=perdant (pour savoir avec qui démarré le round)
    
    private Carte derniereCarteJouee;

    public Joueur(String nom, boolean etatCarte, boolean etatJeu, boolean identite, int score) {
        this.nom = nom;
        this.etatCarte = etatCarte;
        this.etatJeu = etatJeu;
        this.identite = identite;
        this.score = score;
        main = new LinkedList<Carte>();
        defausse = new LinkedList<Carte>();
    }
    
    //------------------------------------
    
    public LinkedList<Carte> getMain(){
    	return this.main;
    }
    
    public LinkedList<Carte> getDefausse(){
    	return this.defausse;
    }
    
    public void prendreCarte(Carte carte) {
    	main.add(carte);
    }
    
    public int actionTour() {
    	int chx;
    	Scanner scannerfct = new Scanner(System.in);
    	System.out.println("Choississez votre action : 1 pour accuser, 2 pour utiliser carte rumeur");
		chx=scannerfct.nextInt();
		//scannerfct.close();
    	return chx;
    }
    
    public Joueur choisirVictime(int[] restrictChoix, ArrayList<Joueur> listJ) {
    	Scanner scannerfct = new Scanner(System.in);
    	int indexchoisi=0;
    	boolean contains=false;
    	int i;
    	while(contains==false) {
    		System.out.println("Choississez le joueur : ");
    		indexchoisi=scannerfct.nextInt();
    		for(i=0; i<restrictChoix.length; i++) {
    			if(restrictChoix[i]==indexchoisi) {
    				contains=true;
    			}		
		}}
		return listJ.get(indexchoisi);
    	
    }
    
    public Carte choisirCarte(int[] restrictChoix, LinkedList<Carte> listCd) {
    	Scanner scannerfct = new Scanner(System.in);
    	int indexchoisi=0;
    	boolean contains=false;
    	int i;
    	while(contains==false) {
    		System.out.println("Choississez la carte à recuperer : ");
    		indexchoisi=scannerfct.nextInt();
    		for(i=0; i<restrictChoix.length; i++) {
    			if(restrictChoix[i]==indexchoisi) {
    				contains=true;
    			}		
		}}
		return listCd.get(indexchoisi);
    	
    }
    
    public int repondreAccu() {
    	Scanner scannerfct = new Scanner(System.in);
    	System.out.println("Joueur : "+ this.getNom() + ", vous etes accusé.");
    	System.out.println("Choississez si vous révélez votre identité : 0 non et 1 oui");
		int choix3=scannerfct.nextInt();
		return choix3;
		}
    
    public int jouerTourSuivant() {
    	
    	
    	return 1;
    }
    
    

    
    public Joueur jouerCarte(Carte carteChoisi, String effet, ArrayList<Joueur> listJ, int indexActu, int indexdelautre) {
    	//derniereCarteJouee = carteChoisi;
    	Iterator<Joueur> itfct;
    	Iterator<Carte> cartfct;
    	LinkedList<Carte> deffoss;
    	LinkedList<Carte> m1;
		int[] restrictChoix=new int[6];
		int restrict=0;
		int indexdeux=0;
		int i=0;
		Joueur Jdesigner=this;
		Random rand = new Random();
		
    	switch(carteChoisi.getNom()){
    	   
        case "Angry Mob": 
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		//System.out.println("Vous rejouez un tour !");
        	}
        	else if(effet=="hunt"){
        		//carteChoisi
        	}
            
            break;
    
        case "The Inquisition":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		
    			itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
    			System.out.println("*******************************************************************************");
    			System.out.println("************Ceci est secret et à destination de :  " + this.getNom() + "***********");
    			if(Jdesigner.isIdentite()==true) {
    			System.out.println("************Identité du joueur désigné : SORCIERE ");}
    			else {
    				System.out.println("************Identité du joueur désigné : VILLAGEOIS ");
    			}
    			System.out.println("*******************************************************************************");
        	}
            break;
    
            
            
        case "Pointed Hat":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        	    deffoss=this.getDefausse();
        		cartfct=deffoss.iterator();
        		
        		System.out.println("Vos carte joué et révélé :");
		        
		        while(cartfct.hasNext()) {
		        	Carte C=cartfct.next();
		        	System.out.println("Les cartes révélé sont : \n");
		        	System.out.println(C.getNom() + "à index :  "+ deffoss.indexOf(C));
		        	restrictChoix[restrict]=deffoss.indexOf(C);
					restrict++;}
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
		        Carte carteRecup=this.choisirCarte(restrictChoix, deffoss);
				System.out.println("Carte choisi et récupérer dans la main : " + carteRecup.getNom());
				this.getMain().add(carteRecup);
		        this.getDefausse().remove(carteRecup);
				
		      //Tableau reinistialiser valeur
				for(i=0; i<restrictChoix.length; i++) {
					restrictChoix[i]=-1;
				}
	    		restrict=0;
				
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
        	}
            
            break;
            
            
        case "Hooked Nose":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom() + "Nombre de carte en main :  "+ A.getMain().size() );} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain en lui piquant une carte :");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			
    			int taillelist= Jdesigner.getMain().size();
    	    	Carte carteVoulu = Jdesigner.getMain().get(taillelist);
    	    	System.out.println("Carte  " + carteVoulu.getNom() + " prise au joueur :  " + Jdesigner.getNom());
    	        this.getMain().add(carteVoulu);
    	        Jdesigner.getMain().remove(carteVoulu);
        		
    			
        	}
        	break;
        	
        	
        	
        case "Broomstick":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
        	}
        	break;
        case "Wart":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
        	}
        	break;
        case "Ducking Stool":
        	if(effet=="witch") {
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=listJ.indexOf(this)) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Cauldron":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Evil Eye":
        	if(effet=="witch") {
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
        	}
        	else if(effet=="hunt"){
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
        	}
        	break;
        case "Toad":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Black Cat":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	break;
        case "Pet Newt":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		
        		
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=indexActu && A.getDefausse().size()>0) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom() + "Nombre de carte en révélé :  "+ A.getDefausse().size() );
    				
    				//
    				deffoss=A.getDefausse();
            		cartfct=deffoss.iterator();
            		
            		System.out.println("Les cartes révélé de ce joueurs sont :   ");
    		        
    		        while(cartfct.hasNext()) {
    		        	Carte C=cartfct.next();
    		        	System.out.println(C.getNom() + "à index :  "+ deffoss.indexOf(C));
    		        	}
    				} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur à qui prendre une carte révélé :");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			deffoss=Jdesigner.getDefausse();
        		cartfct=deffoss.iterator();
        		//Tableau reinistialiser valeur
				for(i=0; i<restrictChoix.length; i++) {
					restrictChoix[i]=-1;
				}
	    		restrict=0;
        		
        		System.out.println("Rappel : Les cartes révélé de ce joueur sont :   ");
		        while(cartfct.hasNext()) {
		        	Carte C=cartfct.next();
		        	System.out.println(C.getNom() + "à index :  "+ deffoss.indexOf(C));
		        	restrictChoix[restrict]=deffoss.indexOf(C);
					restrict++;
		        	}
		        
		        Carte carteVoulu = this.choisirCarte(restrictChoix, deffoss);
		        System.out.println("Carte  " + carteVoulu.getNom() + " prise au joueur :  " + Jdesigner.getNom());
    	        this.getMain().add(carteVoulu);
    	        Jdesigner.getMain().remove(carteVoulu);
    	        
    	        //Probleme pour choisir le joueur suivant
        	}
        	break;     	
        default:
            System.out.println("Choix incorrect");
            break;
    	}    	
    	this.getDefausse().add(carteChoisi);
    	this.getMain().remove(carteChoisi);
    	
    	
    	return Jdesigner;
    	
    	}
    	
    public Carte derniereCarteJouee() {
    	return derniereCarteJouee;
    	}
    	
    	
    	/*
    	public boolean aGagne() {
    	if (main.size() == JeuCarte.NOMBRE_DE_CARTES) {
    	return true;
    	}
    	else {return false;}
    	}
    	
    	public boolean aPerdu() {
    		if (main.size() == 0) {
    		return true;
    		} else {
    		return false;
    		}
    	}*/
    	
    	public String toString() {
    		StringBuffer sb = new StringBuffer();
    		sb.append(nom);
    		sb.append(" : ");
    		sb.append(main);
    		sb.append("\n");
    		return sb.toString();
    		}
    
    //--------------------------
    
    public Joueur() {
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = this.score+score;
    }

    public boolean isIdentite() {
        return identite;
    }

    public void setIdentite(boolean identite) {
        this.identite = identite;
    }

    /*public boolean isEtat() {
        return etat;
    }*/

    public void setEtatcarte(boolean etatCarte) {
        this.etatCarte = etatCarte;
    }
    public boolean getEtatcarte() {
        return this.etatCarte;
    }
    public void setEtatjeu(boolean etatJeu) {
        this.etatJeu = etatJeu;
    }
    public boolean getEtatjeu() {
        return this.etatJeu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getResultat() {
        return this.resultat;
    }
    
    

    
}
