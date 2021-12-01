package cartes;
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
		boolean temp=false;
		switch(this.getNom()){
 	   
        case "Angry Mob": 
        	if(effet=="hunt" && jAc.isIdentite()==false && jAc.getEtatcarte()==true) {
        		temp=true;
        	}
        	else if (effet=="witch") {
        		temp=true;
        	}
            break;
    
        case "The Inquisition":
        	if(effet=="hunt" && jAc.isIdentite()==false && jAc.getEtatcarte()==true) {
        		temp=true;
        	}
        	else if (effet=="witch") {
        		temp=true;
        	}
            
            break;
    
        case "Pointed Hat":
        	if(effet=="hunt" && jAc.getDefausse().size()>0) {
        		temp=true;
        		System.out.println("*** pointed hat defausse size supérieur 0 \n");
        	}
        	else if(effet=="witch" && jAc.getDefausse().size()>0) {
        		temp=true;
        		System.out.println("*** pointed hat defausse size égal 0 \n");
        	}
        	else {
        		temp=false;
        	}
        	return temp;
        	//temp=false;
            //break;
        case "Hooked Nose":
        	temp=true;
        	break;
        case "Broomstick":
        	temp=true;
        	break;
        case "Wart":
        	temp=true;
        	break;
        case "Ducking Stool":
        	temp=true;
        	break;
        case "Cauldron":
        	temp=true;
        	break;
        case "Evil Eye":
        	temp=true;
        	break;
        case "Toad":
        	temp=true;
        	break;
        case "Black Cat":
        	temp=true;
        	break;
        case "Pet Newt":
        	temp=true;
        	break;   	
        default:
            System.out.println("Choix incorrect");
            break;
    	}
		return temp;
	}
}
