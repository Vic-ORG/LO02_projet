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
    
    public Joueur choisirVictime(int[] restrictChoix, ArrayList<Joueur> listJ, int index2) {
    	Scanner scannerfct = new Scanner(System.in);
    	boolean contains=false;
    	int i;
    	while(contains==false) {
    		System.out.println("Choississez le joueur à accuser (sauf vous meme numero");
    		index2=scannerfct.nextInt();
    		for(i=0; i<restrictChoix.length; i++) {
    			if(restrictChoix[i]==index2) {
    				contains=true;
    			}		
		}}
		return listJ.get(index2);
    	
    }
    
    public int repondreAccu() {
    	Scanner scannerfct = new Scanner(System.in);
    	System.out.println("Joueur : "+ this.getNom() + ", vous etes accusé.");
    	System.out.println("Choississez si vous révélez votre identité : 0 non et 1 oui");
		int choix3=scannerfct.nextInt();
		return choix3;
		}

    
    public void jouerCarte(Carte carteChoisi, String effet, ArrayList<Joueur> listJ, int indexdelautre, boolean overideJ) {
    	//derniereCarteJouee = carteChoisi;
    	switch(carteChoisi.getNom()){
    	   
        case "Angry Mob": 
        	if(effet=="witch") {
        		System.out.println("Vous rejouez un tour !");
        	}
        	else if(effet=="hunt"){
        		//carteChoisi
        	}
            
            break;
    
        case "The Inquisition":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
            System.out.println("Hello");
            break;
    
        case "Pointed Hat":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
            System.out.println("Buenos dias");
            break;
        case "Hooked Nose":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Broomstick":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Wart":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Ducking Stool":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Cauldron":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Evil Eye":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Toad":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Black Cat":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;
        case "Pet Newt":
        	if(effet=="witch") {
        		
        	}
        	else if(effet=="hunt"){
        		
        	}
        	break;     	
        default:
            System.out.println("Choix incorrect");
            break;
    	}
    	
    	
    	defausse.add(carteChoisi);
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
