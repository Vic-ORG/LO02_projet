package cartes;
import java.util.*;
import joueurs.*;



public class Carte {
	String typeo;
	String nom;
	
	public Carte(String typeo, String nom) {
		this.typeo=typeo;
		this.nom=nom;
		
	}
    private boolean type;

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
	public boolean jouabiliteCarte(String effet, Joueur jAc) {
		switch(this.getNom()){
 	   
        case "Angry Mob": 
        	if(effet=="hunt" && jAc.isIdentite()==false && jAc.getEtatcarte()==true) {
        		return true;
        	}
        	else if (effet=="witch") {
        		return true;
        	}
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
		return true;
	}
}
