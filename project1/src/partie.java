import java.util.Scanner;
import java.util.ArrayList;


import cartes.jeuCarte;
import joueurs.bot;
import joueurs.joueur;

public class partie {

    static Scanner ReadConsole = new Scanner(System.in);

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
        
        joueur joueur1 = new joueur(null, false, true, 0);
        joueur joueur2 = new joueur(null, false, true, 0);
        joueur joueur3 = new joueur(null, false, true, 0);
        joueur joueur4 = new joueur(null, false, true, 0);
        joueur joueur5 = new joueur(null, false, true, 0);
        joueur joueur6 = new joueur(null, false, true, 0);

        bot bot1 = new bot(null, false, true, 0, 0);
        bot bot2 = new bot(null, false, true, 0, 0);
        bot bot3 = new bot(null, false, true, 0, 0);
        bot bot4 = new bot(null, false, true, 0, 0);
        bot bot5 = new bot(null, false, true, 0, 0);

        System.out.println("\tChoisissez le nombre de joueurs humains (entre 1 et 6): ");
        nbJoueur = ReadConsole.nextInt();
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
        }
        
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
        }
        
        //Initialisation du paquet de carte
        jeuCarte jeuActu = new jeuCarte();
        jeuActu = jeuCarte.createJeuCartes();
        jeuActu.melangeJeu();
        
        //distribution des cartes
        while(jeuActu.size()>0) {
        	joueur1.getMain().addCarte(jeuActu.getOneCardAsTalon());
        	joueur2.getMain().addCarte(jeuActu.getOneCardAsTalon());
        	joueur3.getMain().addCarte(jeuActu.getOneCardAsTalon());
        	joueur4.getMain().addCarte(jeuActu.getOneCardAsTalon());
        	joueur5.getMain().addCarte(jeuActu.getOneCardAsTalon());
        	joueur6.getMain().addCarte(jeuActu.getOneCardAsTalon());
        }
        

    }
    
}