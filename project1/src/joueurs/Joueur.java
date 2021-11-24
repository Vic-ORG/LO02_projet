package joueurs;
import cartes.Carte;
import java.util.*;

import cartes.carte_role;

public class Joueur {
    private String nom;
    private boolean etat;
    private boolean identite = carte_role.isRole();
    private int score;
    private LinkedList<Carte> main;
    private LinkedList<Carte> defausse;
    private int resultat; // 0=neutre, 1=vainqueur, 2=perdant (pour savoir avec qui démarré le round)
    
    private Carte derniereCarteJouee;

    public Joueur(String nom, boolean etat, boolean identite, int score) {
        this.nom = nom;
        this.etat = etat;
        this.identite = identite;
        this.score = score;
        main = new LinkedList<Carte>();
        defausse = new LinkedList<Carte>();
    }
    
    //------------------------------------
    
    public LinkedList<Carte> getMain(){
    	return this.main;
    }
    
    public void prendreCarte(Carte carte) {
    	main.add(carte);
    }
    	
    public Carte jouerCarte() {
    	derniereCarteJouee = main.pop();
    	return derniereCarteJouee;
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
        this.score = score;
    }

    public boolean isIdentite() {
        return identite;
    }

    public void setIdentite(boolean identite) {
        this.identite = identite;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getResultat() {
        return this.resultat;
    }
    
    

    
}
