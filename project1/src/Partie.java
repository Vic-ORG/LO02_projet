import cartes.*;
import joueurs.*;
import java.util.*;


import cartes.JeuCarte;
import joueurs.Bot;
import joueurs.Joueur;

public class Partie {
	
	private static ArrayList<Joueur> joueurs;
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
    		
    	public void jouer() {
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
    	}
    		
    	private void retirerPerdants() {
    	}
    	
    	private Joueur joueurGagnant(Carte carte) {
    		Joueur gagnant = null;
    		return gagnant;
    	}
    	
    	public String toString() {
    		return joueurs.toString();
    	}
    
    
    //--------------------------------------------------------
    public static void menu(){
    
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
                case 2 : System.out.println("Sous menu 2"); break;
                case 9 : arret = true; break;
                default : {
                    System.out.println("\t▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    System.out.println("\t▒▒ entrez un choix entre 1 et 3 ▒▒");
                    System.out.println("\t▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                } break;
            }
        }
    }

    public static void initGame() {
        int nbJoueur = 0;
        int nbBot = 0;
        String addBot;
        String nom;
        
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
            //joueurs.ajouterJoueur(new Joueur(nom, true, false, 0));
            joueurs.add(new Joueur(nom, true, false, 0));
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

                System.out.println("\tNom du deuxième joueur : ");
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

                System.out.println("\tNom du deuxième joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisième joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);
            } break;
            case 4 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxième joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisième joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);

                System.out.println("\tNom du quatrième joueur : ");
                nom = ReadConsole.next();
                joueur4.setNom(nom);
                joueur4.setEtat(true);
            } break;
            case 5 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxième joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisième joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);

                System.out.println("\tNom du quatrième joueur : ");
                nom = ReadConsole.next();
                joueur4.setNom(nom);
                joueur4.setEtat(true);

                System.out.println("\tNom du cinquième joueur : ");
                nom = ReadConsole.next();
                joueur5.setNom(nom);
                joueur5.setEtat(true);
                
            } break; 
            case 6 : {
                System.out.println("\tNom du premier joueur : ");
                nom = ReadConsole.next();
                joueur1.setNom(nom);
                joueur1.setEtat(true);

                System.out.println("\tNom du deuxième joueur : ");
                nom = ReadConsole.next();
                joueur2.setNom(nom);
                joueur2.setEtat(true);

                System.out.println("\tNom du troisième joueur : ");
                nom = ReadConsole.next();
                joueur3.setNom(nom);
                joueur3.setEtat(true);

                System.out.println("\tNom du quatrième joueur : ");
                nom = ReadConsole.next();
                joueur4.setNom(nom);
                joueur4.setEtat(true);

                System.out.println("\tNom du cinquième joueur : ");
                nom = ReadConsole.next();
                joueur5.setNom(nom);
                joueur5.setEtat(true);

                System.out.println("\tNom du sixième joueur : ");
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
                joueurs.add(new Bot(nom, true, false, 0, 0));
                //Bot.add(new Bot(nom, true, false, 0, 0));
            	}
            }
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
    
    
    
}