package modele.principal;
//import cartes.*;

//import joueurs.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import modele.cartes.Carte;
import modele.cartes.JeuCarte;
import modele.joueurs.Bot;
import modele.joueurs.Joueur;

/**Classe Partie (un round)
 * @author victo
 *
 */
public class Partie {
	
	private ArrayList<Joueur> joueurs;
	
	private JeuCarte cartes;
	private boolean partieEnCours;

    static Scanner ReadConsole = new Scanner(System.in);
	private static Scanner scan;
    
    
    
    /**Constructeur d'une partie
     * 
     */
    public Partie() {
    	joueurs = new ArrayList<Joueur>();
    	cartes = new JeuCarte();
    	cartes.melanger();
    	partieEnCours = false;
    	}
    
    /**Obtenir la liste de joueur de la partie
     * @return liste de joueur
     */
    public ArrayList<Joueur> recupListeJ() {
    	return joueurs;
    	
    }
    
    	/**Ajouter joueur à liste de joueur
    	 * @param joueur joueur à ajouter
    	 */
    	public void ajouterJoueur(Joueur joueur) {
    	if (partieEnCours == false) {
    	joueurs.add(joueur);
    	}
    	}
    	
    	/**Retire joueur de liste de joueur
    	 * @param joueur joueur à retirer
    	 */
    	public void retirerJoueur(Joueur joueur) {
    		joueurs.remove(joueur);
    	}
    	
    	/**Distribuer les cartes entre les joueurs
    	 * @param tailleJ taille de la liste de joueur
    	 * @param listJ liste des joueurs de la partie
    	 * @param jeuActu tas de carte de la partie à distribuer
    	 * @param deffausseGen liste de la défausse générale
    	 */
    	public void distribuerCartes(int tailleJ, ArrayList<Joueur> listJ, JeuCarte jeuActu, LinkedList<Carte> deffausseGen) {
    		this.partieEnCours = true;
    		int compt=0;
    		if(tailleJ==5) {
    		while (12-compt != 10) {
    			compt++;
    			Iterator<Joueur> it = listJ.iterator();
    			while (it.hasNext()) {
    				Joueur j = (Joueur) it.next();
    				j.prendreCarte(jeuActu.tirerCarteDuDessus());
    			}
    		}
    		while (jeuActu.estVide() == false) {
    			deffausseGen.add(jeuActu.tirerCarteDuDessus());
    		}
    		}
    		else {
    			while (jeuActu.estVide() == false) {
        			Iterator<Joueur> it = listJ.iterator();
        			while (it.hasNext()) {
        				Joueur j = (Joueur) it.next();
        				j.prendreCarte(jeuActu.tirerCarteDuDessus());
        			}
        		}
    			
    		}
    	}
    		
    	
    	
    	/**Version texte de joueur
    	 *@return string texte du joueur
    	 */
    	public String toString() {
    		return joueurs.toString();
    	}
    
    
    //--------------------------------------------------------
    /**Menu de démarrage console du jeu
     * @throws FileNotFoundException exception
     */
    public void menu() throws FileNotFoundException{
    
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
				case 2 : rule(); break;                
				case 9 : arret = true; break;
                default : {
                    System.out.println("\t▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    System.out.println("\t▒▒ entrez un choix entre 1 et 3 ▒▒");
                    System.out.println("\t▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                } break;
            }
        }
    }

	/**Lire les règles
	 * @throws FileNotFoundException exception fichier non trouvé
	 */
	private static void rule() throws FileNotFoundException{
        File regle = new File("project1\\rules.txt");
        scan = new Scanner(regle);

        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }

    }
	
	/**Définir stratégie du bot pour la partie
	 * @return entier définissant stratégie du bot
	 */
	public int strategie() {
    	int chxb=1;
    	double x;
    	x=Math.random();
    	if(x<=0.5) {
    		chxb=0;
    		System.out.println("Bot mode aléatoire ");
    	}
    	else {
    		chxb=1;
    		System.out.println("Bot mode agressif ");
    	}
    	return chxb;
    }

    /**Initialisation d'une partie (nombre de joueurs, etc...)
     * 
     */
    public void initGame() {
        int nbJoueur = 0;
        int nbBot = 0;
        String addBot;
        String nom;

        System.out.println("\tChoisissez le nombre de joueurs humains (entre 1 et 6): ");
        nbJoueur = ReadConsole.nextInt();
        int i=0;
        for(i=1; i<=nbJoueur; i++) {
        	System.out.println("\tNom du joueur " + i + " :  ");
            nom = ReadConsole.next();
            ajouterJoueur(new Joueur(nom, false, true, true, 0));
            
        }
        
        System.out.println("\tAjouter des bots (y/n): ");
        addBot = ReadConsole.next();
        if (addBot.equals("y")){
            System.out.println("\tChoisissez le nombre de bots (maximum " + (6-nbBot-nbJoueur) + "): ");
            nbBot = ReadConsole.nextInt();
            for(i=1; i<=nbBot; i++) {
            	System.out.println("\tNom du Bot " + i + " :  ");
                nom = ReadConsole.next();
                int chstrateg=strategie();
                ajouterJoueur(new Bot(nom, false, true, false, 0, chstrateg));
                
            	}
            }
        else if (addBot.equals("n")){
            //lancer partie
        	Iterator<Joueur> itJ = joueurs.iterator();
			//on affiche les joueurs ayant leur carte encore secràte et pas notre joueur
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
   
        
    }
    
    /**Joueur un round complet (ou manche)<br>
     * Principe de la fonction :<br>
     * On prend la liste de joueurs déjà initialisé précedemment<br>
     * On leur fait choisir le rôle entre villageois et Sorcière<br>
     * On distribue les cartes<br>
     * Tant que le nombre de carte identité encore non révélé des joueurs est supérieur à 1 on continuera les action ci dessous :<br>
     * Choisir entre accuser ou jouer une carte effet hunt (si pas de carte jouable, accusation forcé)<br>
     * Si accusation choisi, on choisit un joueur et ce dernier choisit s'il répond ou non en jouant une carte<br>
     * Si jouer carte hunt est choisi, on choisit une carte et son affet s'applique<br>
     * On met à jour l'état des joueurs dans la liste de Joueurs<br>
     * ---Fin Tant que---<br><br>
     * On vérifie ensuite si joueur à le score suffisant pour ne pas relancer de round<br>
     * On vide la défausse générale et les mains des joueurs des éléments qui pourrait leur rester<br>
     * 
     * 
     * @param listJ liste de joueur
     * @return un boolean précisant si un score de fin (>5) a été atteint.
     * @throws InterruptedException exception interruption
     * @throws IOException exceptionIO
     */
    public boolean round(ArrayList<Joueur> listJ) throws InterruptedException, IOException {
    	boolean overideJoueur=false;
    	boolean overideJautre=false;
    	Scanner scanner = new Scanner(System.in);
    	int choix=0;
    	boolean ScoredeFin=false; //true=qqun a plus de 5points, false l'inverse
    	int nbJrevel; //pour compter le nombre de joueur ayant une carte identité revelà
    	String id, effet;
    	int[] restrictChoix=new int[6];
    	
    	int restrict=0;
    	LinkedList<Carte> deffausseGen = new LinkedList<Carte>();
    	boolean jouable=false;
    	
    	int tailleJ=listJ.size();
		Iterator<Joueur> it = listJ.iterator(); //liste des joueurs complàte
		Iterator<Joueur> itA = listJ.iterator(); //liste des joueurs pour accusation (differente car on utulise l'autre dans le while)
			
		//Dàbut d'un round
		//Initialisation du paquet de carte
	    
	    int i;
	    int choix3=0;
	    int index=0;
	    int index2=0;
	    int indextemp=0;
	    int choixrole=0;
	    boolean overideAccuse=false;
	    
	    it = listJ.iterator();
    	//on affiche les joueurs ayant leur carte encore secràte et pas notre joueur
    	while(it.hasNext()) {
    		Joueur G=it.next();
    		G.setEtatjeu(true);
			G.setEtatcarte(false);
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    		System.out.println("Joueur:" + G.getNom() + "  Score : " + G.getScore());

            System.out.println("\tidentité du joueur" + G.getNom() + " pour ce round (sor ou vil) :  ");
            choixrole=G.choisirRole();
            if(choixrole==1) {
            	System.out.println("Vous avez choisi SORCIERE ");
                G.setIdentite(true);
            }
            else {
            	System.out.println("Vous avez choisi Villageois ");
                G.setIdentite(false);
            }
            
            listJ.set(listJ.indexOf(G), G);
    	}
	    
    	JeuCarte jeuActu = new JeuCarte();
	    jeuActu.melanger();
	    distribuerCartes(tailleJ, listJ, jeuActu, deffausseGen);
    	
	    it = listJ.iterator();
	    nbJrevel=listJ.size(); //les cartes identité sont du nombre de joueur dans la liste
	    System.out.println("******\n nombre de cartes non revele : " + nbJrevel);
	        
	    while(nbJrevel>1) //un round ne s'arrete que lorsque 1 personne a encore sa carte identité cachà
	    {
	    	
	    	System.out.println("******\n nombre de cartes non revele : " + nbJrevel);
	    	Joueur jActu=listJ.get(index);
	    	System.out.println("\n\n\n******************:");
	        System.out.println("Joueur actuel :" + jActu.getNom() + "  Index dans list : " +index + "  Status identité : " + jActu.isIdentite() + "  Score : " + jActu.getScore());
	        System.out.println("Taille déffausse personnelle :" + jActu.getDefausse().size() + "  déffausseGloble : " + deffausseGen.size());
	        //Afficher les cartes en mains :
	        System.out.println("Vos carte en main :");
	        Iterator<Carte> main = jActu.getMain().iterator();
	        Iterator<Carte> deffausse = jActu.getDefausse().iterator();
	        while(main.hasNext()) {
	        	Carte C=main.next();
	        	System.out.println(C.getNom());
	        }
	        System.out.println("\nVos cartes révélés :");
	        while(deffausse.hasNext()) {
	        	Carte C=deffausse.next();
	        	System.out.println(C.getNom());
	        }
	        //actionTour pour soit accuser soit chasser
	        
	        effet="hunt";
			//Afficher les cartes en mains :
	        overideAccuse=true;
	        main = jActu.getMain().iterator();
	        while(main.hasNext()) {
	        	Carte C=main.next();
	        	jouable=C.jouabiliteCarte(effet, jActu, listJ);
	        	if(jouable==true) {
	        		jouable=false;
	        		overideAccuse=false;
	        	}	
	        }
	        if(overideAccuse==true || jActu.getMain().size()==0 || jActu.getStrategie()==1 ) {
	        	System.out.println("\nPlus de carte possible à jouer, vous accusez qqun ! :");
	        	choix=1;
	        }
	        else {choix=jActu.actionTour();}
	        
	        
	        jouable=false;
	        
	        
				
			if(choix==1) {
			//Accuser joueur
			System.out.println("Liste des joueurs accusable :");
			itA = listJ.iterator();
			//on affiche les joueurs ayant leur carte encore secràte et pas notre joueur
			while(itA.hasNext()) {
				Joueur A=itA.next();
				if(A.getEtatcarte()==false && listJ.indexOf(A)!=index) {
					restrictChoix[restrict]=listJ.indexOf(A);
					restrict++;
				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
			}
			//Choisir qui accuser
			System.out.println("\nChoississez le joueur à accuser : ");
			Joueur Jaccuser=jActu.choisirVictime(restrictChoix, listJ);
			index2=listJ.indexOf(Jaccuser);
			
			//Tableau reinistialiser valeur
			for(i=0; i<restrictChoix.length; i++) {
				restrictChoix[i]=-1;
			}
    		restrict=0;
    		
    		effet="witch";
			//Afficher les cartes en mains :
	        
    		
			
	        overideAccuse=true;
	        main = Jaccuser.getMain().iterator();
	        while(main.hasNext()) {
	        	Carte C=main.next();
	        	jouable=C.jouabiliteCarte(effet, Jaccuser, listJ);
	        	if(jouable==true) {
	        		jouable=false;
	        		overideAccuse=false;
	        	}	
	        }
	        if(overideAccuse==true || Jaccuser.getMain().size()==0) {
	        	System.out.println("\nPlus de carte possible à jouer, vous révélez votre identité !!! :");
	        	choix3=1;
	        }
	        else {choix3=Jaccuser.repondreAccu();}
	        
					
			if(choix3==1) {
				if(Jaccuser.isIdentite()==true) { //si le joueur accusé est une sorciere
					System.out.println("Le joueur : " + Jaccuser.getNom() + "accusé est une sorciere !");
					System.out.println("Le joueur accusé " + Jaccuser.getNom() + " est exclus du round !");
					System.out.println("Le joueur qui a accusé gagne 1 point. Il rejout !");
					//Comme il rejout, index ne change pas pour qu'il reprenne la main lors du prochain tour de boucle
					
					Jaccuser.setEtatjeu(false);
					Jaccuser.setEtatcarte(true);
					nbJrevel=nbJrevel-1; //Parmi la totalità des joueurs, 1 a révélé sa carte
					
					listJ.set(index2, Jaccuser); //on met à jour dans listJ
					jActu.setScore(1);
				}
				else {
				System.out.println("Le joueur accusé à index   " + index2 + Jaccuser.getNom() +  "   est un villageois !");
				System.out.println("Le joueur accusé reprend la main (commence le prochain tour) !");
				System.out.println("Personne ne gagne ou perd de points !");
				//comme il reprend la main l'index du joueur accusé devient l'index qui sera utilisà pour le dàbut de boucle
				//faire en sorte que Jaccuser soit le bon en recommenàant la boucle
				overideJoueur=true;
				Jaccuser.setEtatcarte(true);
				nbJrevel=nbJrevel-1;
				
				listJ.set(index2, Jaccuser); //on met à jour dans listJ
					
				}
			}
			else {
				effet="witch";
				//Afficher les cartes en mains :
		        System.out.println("Vos carte en main :");
		        main = Jaccuser.getMain().iterator();
		        while(main.hasNext()) {
		        	Carte C=main.next();
		        	jouable=C.jouabiliteCarte(effet, Jaccuser, listJ);
		        	System.out.println("Jouable :  " +jouable);
		        	if(jouable==true) {
		        		
		        		jouable=false;
		        	System.out.println("Les cartes jouables sont : \n");
		        	System.out.println(C.getNom() + " à index :  "+ Jaccuser.getMain().indexOf(C));
		        	restrictChoix[restrict]=Jaccuser.getMain().indexOf(C);
					restrict++;}
		        	else {
		        		System.out.println("Carte injouable :  " +C.getNom() + "à index :   "+ Jaccuser.getMain().indexOf(C));
		        	}
		        }
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
		        Carte carteRecup=Jaccuser.choisirCarte(restrictChoix, Jaccuser.getMain());
		        //int choixcarte=scanner.nextInt();
				
				
				System.out.println("Carte choisi : " + carteRecup.getNom());
				Joueur Jtemp=Jaccuser.jouerCarte(carteRecup, effet, listJ, index, index2, deffausseGen, overideAccuse, nbJrevel);
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
				else if(indextemp==index) {
					//Jaccuser a àtà modifià en appelant la fonction mais pas accusateur qui est dans Jtemp 
					//Utile pour Hooked nose
					overideJoueur=true;
					jActu=Jtemp;
					listJ.set(index, jActu);
					listJ.set(index2, Jaccuser);
				}
				
				
			}
		} //fin du if accusation
				
			else if(choix==2) {
				effet="hunt";
				//Afficher les cartes en mains :
		        System.out.println("Vos carte en main : ");
		        main = jActu.getMain().iterator();
		        while(main.hasNext()) {
		        	Carte C=main.next();
		        	jouable=C.jouabiliteCarte(effet, jActu, listJ);
		        	System.out.println("Jouable :  " +jouable);
		        	if(jouable==true) {
		        		jouable=false;
		        	System.out.println("Les cartes jouables sont : \n");
		        	System.out.println(C.getNom() + " à index :  "+ jActu.getMain().indexOf(C));
		        	restrictChoix[restrict]=jActu.getMain().indexOf(C);
					restrict++;}
		        }
		        System.out.println("Choississez votre action : entrer l'index de la carte que vous souhaitez jouer");
		        Carte carteRecup=jActu.choisirCarte(restrictChoix, jActu.getMain());
		        
		        System.out.println("Carte choisi : " + carteRecup.getNom());
				Joueur Jtemp=jActu.jouerCarte(carteRecup, effet, listJ, index, index2, deffausseGen, overideAccuse, nbJrevel);
				indextemp=listJ.indexOf(Jtemp);
				
				int nbJrevel2=0;
				Iterator<Joueur> itJrevel=listJ.iterator();
				while(itJrevel.hasNext()) {
					Joueur J=itJrevel.next();
					if(J.getEtatcarte()==false) {
						nbJrevel2++;
					}
				}
				if(nbJrevel2<nbJrevel) {
					nbJrevel=nbJrevel2;
				}
				
				
				if(indextemp == index) {
					jActu=Jtemp;
				}
				else if(indextemp!=index) {
					listJ.set(indextemp, Jtemp);
					if(Jtemp.getEtatjeu()==true) {
						overideJautre=true;}
				}
				
			
			}
			
			//on remplace le joueur qu'on a pris avec les valeur de joueur actuelle, par exemple pour changà score
			listJ.set(index, jActu);
			
			//Si Joueur suivant changà, on affecte la valeur de son index2 à l'index.
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
	    
	        //Vàrifier point de joueur et mettre si ScoredeFin=true ou false
	    	it = listJ.iterator();
	    	//on affiche les joueurs ayant leur carte encore secràte et pas notre joueur
	    	while(it.hasNext()) {
	    		Joueur G=it.next();
	    		if(G.getEtatcarte()==false) {
	    			System.out.println("index : " + listJ.indexOf(G) + "Joueur : " + G.getNom() + "est le dernier a avoir sa carte identité secràte");
	    			if(G.isIdentite()==true) {
	    				System.out.println("Son identité est : sorcière, il gagne 2 points");
	    				G.setScore(2);
	    			}
	    			else {
	    				System.out.println("Son identité est : villageois. Il gagne 1 points");
	    				G.setScore(1);
	    			}
	    			listJ.set(listJ.indexOf(G), G);
	    		}
	    		//On rànitialise les jours et on vide leur main
	    		G.setEtatjeu(true);
	    		G.setEtatcarte(false);
	    		LinkedList<Carte> m1=G.getMain();
	    		m1.removeAll(m1);
	    		
	    		LinkedList<Carte> deffG=G.getDefausse();
	    		deffG.removeAll(deffG);
	    		
		}
	    	//Vàrifier point de joueur et mettre si ScoredeFin=true ou false
	    	it = listJ.iterator();
	    	while (it.hasNext()) {
				Joueur j = (Joueur) it.next();
				j.getMain().removeAll(j.getMain());
				j.getDefausse().removeAll(j.getDefausse());
				if(j.getScore()>=5) {
					ScoredeFin=true;
				}
				}
	        
	        return ScoredeFin;
    }
    
    
    
    
    
}