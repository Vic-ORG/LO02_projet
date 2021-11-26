package joueurs;
import cartes.Carte;
import java.util.*;

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
    	
    public void jouerCarte(Carte carteChoisi) {
    	//derniereCarteJouee = carteChoisi;
    	switch(carteChoisi.getNom()){
    	   
        case "Angry Mob": 
            System.out.println("Bonjour");
            break;
    
        case "The Inquisition":
            System.out.println("Hello");
            break;
    
        case "Pointed Hat":
            System.out.println("Buenos dias");
            break;
        case "Hooked Nose":
        	break;
        case "Broomstick":
        	break;
        case "Wart":
        	break;
        case "Ducking Stool":
        	break;
        case "Cauldron":
        	break;
        case "Evil Eye":
        	break;
        case "Toad":
        	break;
        case "Black Cat":
        	break;
        case "Pet Newt":
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
