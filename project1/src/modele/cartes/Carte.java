package modele.cartes;
import java.util.*;

import modele.joueurs.*;


/**Classe carte et des actions que l'on peut faire avec
 * @author victo
 *
 */
public class Carte {
	String typeo;
	String nom;
	
	/**Constructeur
	 * @param typeo string
	 * @param nom string
	 */
	public Carte(String typeo, String nom) {
		this.typeo=typeo;
		this.nom=nom;
		
	}
    private boolean type;

    /**
     * @return boolean
     */
    public boolean isType() {
        return type;
    }

    /**
     * @param type boolean
     */
    public void setType(boolean type) {
        this.type = type;
    }

	/**obtenir le nom de la carte
	 * @return string le nom
	 */
	public String getNom() {
		return nom;
	}

	/**définir le nom d'une carte
	 * @param nom string
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
    
	/** Vérifie si carte est jouable ou non. 
	 * Est appelé par une carte. Le nom de cette carte sert d'entrer dans le switch
	 * @param effet witch ou hunt
	 * @param jAc le joueur Actuel
	 * @param listJ la liste de joueur Arraylist
	 * @return un boolean (si la carte est joable ou nom
	 */
	public boolean jouabiliteCarte(String effet, Joueur jAc, ArrayList<Joueur> listJ) {
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
        	if(effet=="hunt") {
        		Iterator<Joueur> jr = listJ.iterator();
        		while(jr.hasNext()) {
        			Joueur J= jr.next();
        			if(J.getEtatjeu()==true && J.getDefausse().size()>0) {
        				temp=true;
        				return temp;
        			}
        		}
        	}
        	temp=false;
        	break;   	
        default:
            System.out.println("Choix incorrect");
            break;
    	}
		return temp;
	}
}
