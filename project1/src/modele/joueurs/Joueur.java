package modele.joueurs;
import java.util.*;
//import java.util.stream.IntStream;

import modele.cartes.Carte;
import modele.cartes.carte_role;


/**Classe Joueur (définition et ses actions)
 * @author victo
 *
 */

public class Joueur {
    private String nom;
    private boolean etatCarte; //true=idendità revelà, false = identité encore secràte
    private boolean etatJeu; // true = en vie dans le round, false = mort dans le round
    private boolean identite = carte_role.isRole(); //sorciere true, villageois false
    private int score;
    private LinkedList<Carte> main;
    private LinkedList<Carte> defausse;
    private int resultat; // 0=neutre, 1=vainqueur, 2=perdant (pour savoir avec qui dàmarrà le round)
    
    private Carte derniereCarteJouee;

    /** Constructeur classe Joueur
     * @param nom : celui du joeur pour la partie
     * @param etatCarte : révélé ou non
     * @param etatJeu : hors jeu ou non (exemple sorciere révélé)
     * @param identite soricere ou villageois
     * @param score : celui de la partie en cours
     */
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
    /** Surement inutile
     * @return 3
     */
    public int getStrategie() {
    	return 3;
    }
    
    /**Fonction permettant d'obtenir les cartes en main du joueur appelant la fonction
     * @return liste des cartes en main
     */
    public LinkedList<Carte> getMain(){
    	return this.main;
    }
    
    /**Fonction permettant d'obtenir les cartes joué et révélé du joueur appelant la fonction
     * @return liste des cartes joué et révélé du joueur appelant la fonction
     */
    public LinkedList<Carte> getDefausse(){
    	return this.defausse;
    }
    
    /** FOnction ajoutant une carte à la main du joueur
     * @param carte carte à ajouté à la main du joueur
     */
    public void prendreCarte(Carte carte) {
    	main.add(carte);
    }
    
    /**Fonction permettant de choisir en entrant un entier dans la console le role du joueur
     * @return entier qui permet de savoir si sorciere ou villageois
     */
    public int choisirRole() {
    	int chx;
    	Scanner scannerfct = new Scanner(System.in);
    	System.out.println("Choississez votre action : 1 pour sorcière, 2 pour villageois");
		chx=scannerfct.nextInt();
		
    	return chx;
    }
    
    /**Fonction permettant de choisir l'action à réaliser pour ce tour en entrant un entier dans la console)
     * @return entier déterminant l'action de ce tour
     */
    public int actionTour() {
    	int chx;
    	Scanner scannerfct = new Scanner(System.in);
    	System.out.println("Choississez votre action : 1 pour accuser, 2 pour utiliser carte rumeur");
		chx=scannerfct.nextInt();
		
    	return chx;
    }
    
    /**Fonction pour viser un joueur pour une action (accusation, choisir prochain joueur,...)
     * @param restrictChoix : tableau d'entier correspondant aux entier parmi lesquels choisir.
     * @param listJ : liste des joueurs de la partie
     * @return le joueur sélectionné
     */
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
    
    /** FOnction permettant de choisir une carte parmis celle en main
     * @param restrictChoix : tableau d'entier correspondant aux entier parmi lesquels choisir.
     * @param listCd : liste de carte
     * @return la carte choisi
     */
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
    
    /**Fonction permettant de réagir face à une accusation en entrant un entier dans la console.
     * @return entier qui définit l'action à suivre
     */
    public int repondreAccu() {
    	Scanner scannerfct = new Scanner(System.in);
    	System.out.println("Joueur : "+ this.getNom() + ", vous etes accusé.");
    	System.out.println("Choississez si vous révélez votre identité : 0 non et 1 oui");
		int choix3=scannerfct.nextInt();
		return choix3;
		}
    
    
    

    
    /**Fonction permettant de jouer une carte appelé par un joueur<br>
     * Principe :<br>
     * La carte choisi par le joueur est envoyé en paramètre ainsi que si il faut la jouer en hunt ou witch<br>
     * EN fonction du nom de la carte et de l'effet envoyé en paramètre, l'effet est joué.<br><br>
     * 
     * @param carteChoisi : carte à jouer
     * @param effet : witch ou hunt
     * @param listJ : liste de Joueur
     * @param indexActu : index du joueur actuel
     * @param indexdelautre : index d'un autre joueur si besoin (exemple accusé)
     * @param deffausseGeneral : liste des cartes en défausse générale
     * @param overideAccuse : boolean qui détermine si il faut forcer l'accusation ensuite
     * @param nbJrevel : nombre de carte identité révélé dans ce round
     * @return un joueur
     */
    public Joueur jouerCarte(Carte carteChoisi, String effet, ArrayList<Joueur> listJ, int indexActu, int indexdelautre, LinkedList<Carte> deffausseGeneral, boolean overideAccuse, int nbJrevel) {
    	
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
        		
        	}
        	else if(effet=="hunt"){
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && A.getEtatcarte()==false && listJ.indexOf(A)!=listJ.indexOf(this)) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur à qui révéler son identité de maniàre forcà");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			Jdesigner.setEtatcarte(true);
    			System.out.println("*******************************************************************************");
    			System.out.println("************révélation de l'identité du joueur :  " + Jdesigner.getNom() + "***********");
    			if(Jdesigner.isIdentite()==true) {
    				System.out.println("identité du joueur désigné : SORCIERE ");
    				Jdesigner.setEtatjeu(false);
    				System.out.println("*Joueur :  " + Jdesigner.getNom() + " est exlus du round ***********");
    				this.setScore(2);
    				System.out.println("Accusatueur :  " + this.getNom() + " gagne 2points ***********");
    				System.out.println("Accusatueur :  " + this.getNom() + " rejout ***********");
    			}
    			else {
    				System.out.println("************identité du joueur désigné : VILLAGEOIS ");
    				this.setScore(-2);
    				System.out.println("Accusatueur :  " + this.getNom() + " pert 2points ***********");
    				System.out.println("accusé :  " + Jdesigner.getNom() + " prend la main ***********");
    			}
    			nbJrevel=nbJrevel-1;
    			System.out.println("*******************************************************************************");
        		
        		//carteChoisi
        	}
            
            break;
    
        case "The Inquisition":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		m1=this.getMain();
        		cartfct=m1.iterator();
        		
        		System.out.println("Vos carte en main :");
		        
		        while(cartfct.hasNext()) {
		        	Carte C=cartfct.next();
		        	System.out.println("Les cartes en main sont : \n");
		        	System.out.println(C.getNom() + " à index :  "+ m1.indexOf(C));
		        	restrictChoix[restrict]=m1.indexOf(C);
					restrict++;}
		        System.out.println("Choississez la carte à mettre en défausse générale : entrer l'index de la carte");
		        Carte carteRecup=this.choisirCarte(restrictChoix, m1);
				System.out.println("Carte choisi et en défausse générale : " + carteRecup.getNom());
				this.getMain().remove(carteRecup);
				deffausseGeneral.add(carteRecup);
		        
				
		      //Tableau reinistialiser valeur
				for(i=0; i<restrictChoix.length; i++) {
					restrictChoix[i]=-1;
				}
	    		restrict=0;
				
        		
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		
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
    			System.out.println("*******************************************************************************");
    			System.out.println("************Ceci est secret et à destination de :  " + this.getNom() + "***********");
    			if(Jdesigner.isIdentite()==true) {
    			System.out.println("************identité du joueur désigné : SORCIERE ");}
    			else {
    				System.out.println("************identité du joueur désigné : VILLAGEOIS ");
    			}
    			System.out.println("*******************************************************************************");
        	}
            break;
    
            
            
        case "Pointed Hat":
        	if(effet=="witch") {
        		deffoss=this.getDefausse();
        		cartfct=deffoss.iterator();
        		
        		System.out.println("Vos carte joué et révélé :");
		        
		        while(cartfct.hasNext()) {
		        	Carte C=cartfct.next();
		        	System.out.println("Les cartes révélé sont : \n");
		        	System.out.println(C.getNom() + " à index :  "+ deffoss.indexOf(C));
		        	restrictChoix[restrict]=deffoss.indexOf(C);
					restrict++;}
		        System.out.println("Entrer l'index de la carte que vous souhaitez récupérér en main parmi carte déjà joué");
		        Carte carteRecup=this.choisirCarte(restrictChoix, deffoss);
				System.out.println("Carte choisi et récupéré dans la main : " + carteRecup.getNom());
				this.getMain().add(carteRecup);
		        this.getDefausse().remove(carteRecup);
				
        		
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
		        	System.out.println(C.getNom() + " à index :  "+ deffoss.indexOf(C));
		        	restrictChoix[restrict]=deffoss.indexOf(C);
					restrict++;}
		        System.out.println("Entrer l'index de la carte que vous souhaitez récupérér en main parmi carte déjà joué");
		        Carte carteRecup=this.choisirCarte(restrictChoix, deffoss);
				System.out.println("Carte choisi et récupérér dans la main : " + carteRecup.getNom());
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
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=listJ.indexOf(this)) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			
        		
        	}
            
            break;
            
            
        case "Hooked Nose":
        	if(effet=="witch") {
        		Joueur Accusateur=listJ.get(indexActu);
        		int taillelist= Accusateur.getMain().size();
    	    	Carte carteVoulu = Accusateur.getMain().get(rand.nextInt(taillelist));
    	    	System.out.println("Carte  " + carteVoulu.getNom() + " prise au joueur :  " + Accusateur.getNom());
    	        this.getMain().add(carteVoulu);
    	        Accusateur.getMain().remove(carteVoulu);
        		
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        		listJ.set(indexActu, Accusateur);
        		
        	}
        	else if(effet=="hunt"){
        		//Tableau reinistialiser valeur
				for(i=0; i<restrictChoix.length; i++) {
					restrictChoix[i]=-1;
				}
	    		restrict=0;
        		itfct = listJ.iterator();
    			//on affiche les joueurs encore en jeux et pas notre joueur
    			while(itfct.hasNext()) {
    				Joueur A=itfct.next();
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=listJ.indexOf(this)) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom() + "Nombre de carte en main :  "+ A.getMain().size() );} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain en lui piquant une carte :");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			
    			int taillelist= Jdesigner.getMain().size();
    	    	Carte carteVoulu = Jdesigner.getMain().get(rand.nextInt(taillelist));
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
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=listJ.indexOf(this)) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom());} 
    			}
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur qui commencera le tour prochain");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			
        		
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
    			
        		
        	}
        	else if(effet=="hunt"){
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
    			System.out.println("Choississez le joueur qui devra faire un grand choix :");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			System.out.println("Joueur  " + Jdesigner.getNom()  +  "choisisser si vous voulez ràlàver identité : 0 non et 1 oui  ");
    			int choix=Jdesigner.repondreAccu();
    			if(choix==0) {
    				//prendre le tour suivant
            		m1=Jdesigner.getMain();
            		cartfct=m1.iterator();
            		
            		System.out.println("Vos carte en main :");
    		        
    		        while(cartfct.hasNext()) {
    		        	Carte C=cartfct.next();
    		        	System.out.println("Les cartes en main sont : \n");
    		        	System.out.println(C.getNom() + " à index :  "+ m1.indexOf(C));
    		        	restrictChoix[restrict]=m1.indexOf(C);
    					restrict++;}
    		        System.out.println("Choississez la carte à mettre en défausse générale : entrer l'index de la carte");
    		        Carte carteRecup=Jdesigner.choisirCarte(restrictChoix, m1);
    				System.out.println("Carte choisi et en défausse générale : " + carteRecup.getNom());
    				Jdesigner.getMain().remove(carteRecup);
    				deffausseGeneral.add(carteRecup);
    		        
    				
    			}
    			else {
    				if(Jdesigner.isIdentite()==true) {
    					System.out.println("Joueur sélectionné est une sorciere");
    					Jdesigner.setEtatcarte(true);
    					Jdesigner.setEtatjeu(false);
    					this.setScore(1);
    					//Jdesigner sera hors jeu et Jactu continue de jouer
    				}
    				else {
    					System.out.println("Joueur sélectionné est un villageois");
    					Jdesigner.setEtatcarte(true);
    					this.setScore(-1);
    					//Jdesinger reprend la main
    					
    				}
	    			nbJrevel=nbJrevel-1;
	    			
	    		}
    			//Tableau reinistialiser valeur
				for(i=0; i<restrictChoix.length; i++) {
					restrictChoix[i]=-1;
				}
	    		restrict=0;
	    		
	    		
    			
        		
        	}
        	break;
        case "Cauldron":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		Joueur Accusateur=listJ.get(indexActu);
        		int taillelist= Accusateur.getMain().size();
    	    	Carte carteVoulu = Accusateur.getMain().get(rand.nextInt(taillelist));
    	    	System.out.println("Carte  " + carteVoulu.getNom() + " prise au joueur :  " + Accusateur.getNom() + "et mise dans deffausse generale");
    	        deffausseGeneral.add(carteVoulu);
    	        Accusateur.getMain().remove(carteVoulu);
    	        listJ.set(indexActu, Accusateur);
    	        
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		System.out.println("Le joueur actuel   " + this.getNom() + "  révéle son identité !!!");
        		if(this.isIdentite()==true) {
        			System.out.println("************identité du joueur désigné : SORCIERE ");
        			this.setEtatcarte(true);
        			nbJrevel=nbJrevel-1;
        			System.out.println("nbJrevel : " + nbJrevel);
        			this.setEtatjeu(false);
        			listJ.set(indexActu, this);
        			int indtamp=indexActu;
        			while(listJ.get(indtamp).getEtatjeu()==false) {
        				indtamp++;
        			}
        			Jdesigner=listJ.get(indtamp);
        			}
        			else {
        				System.out.println("************identité du joueur désigné : VILLAGEOIS ");
        				this.setEtatcarte(true);
        				nbJrevel=nbJrevel-1;
        				System.out.println("nbJrevel : " + nbJrevel);
        				listJ.set(indexActu, this);
        				//il faut choisir le prochain joueur
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
        			System.out.println("*******************************************************************************");
        			
        		
        	}
        	break;
        case "Evil Eye":
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
    			overideAccuse=true;
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			
        		
        	}
        	else if(effet=="hunt"){
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
    			overideAccuse=true;
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			
        		
        	}
        	break;
        case "Toad":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		System.out.println("Le joueur actuel   " + this.getNom() + "  révéle son identité !!!");
        		if(this.isIdentite()==true) {
        			System.out.println("************identité du joueur désigné : SORCIERE ");
        			this.setEtatcarte(true);
        			this.setEtatjeu(false);
        			listJ.set(indexActu, this);
        			int indtamp=indexActu;
        			while(listJ.get(indtamp).getEtatjeu()==false) {
        				if(indtamp==listJ.size()) {
        					indtamp=0;
        				}
        				else{indtamp++;}
        			}
        			Jdesigner=listJ.get(indtamp);
        			}
        			else {
        				System.out.println("************identité du joueur désigné : VILLAGEOIS ");
        				this.setEtatcarte(true);
        				listJ.set(indexActu, this);
        				//il faut choisir le prochain joueur
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
            			
        				
        			}
        			System.out.println("*******************************************************************************");
        			nbJrevel=nbJrevel-1;
        		
        	}
        	break;
        case "Black Cat":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		//prendre le tour suivant
        		
        		if(deffausseGeneral.size()>0) {
        			cartfct=deffausseGeneral.iterator();
        			System.out.println("Vos carte en dans la déffausse générale :");
    		        
    		        while(cartfct.hasNext()) {
    		        	Carte C=cartfct.next();
    		        	System.out.println("Les cartes en main sont : \n");
    		        	System.out.println(C.getNom() + " à index :  "+ deffausseGeneral.indexOf(C));
    		        	restrictChoix[restrict]=deffausseGeneral.indexOf(C);
    					restrict++;}
    		        System.out.println("Choississez la carte de la défausse générale à prendre en main : entrer l'index de la carte");
    		        Carte carteRecup=this.choisirCarte(restrictChoix, deffausseGeneral);
    				System.out.println("Carte choisi et prise en main " + carteRecup.getNom());
    				this.getMain().add(carteRecup);
    				deffausseGeneral.remove(carteRecup);
    		        
    				
    		      //Tableau reinistialiser valeur
    				for(i=0; i<restrictChoix.length; i++) {
    					restrictChoix[i]=-1;
    				}
    	    		restrict=0;
        			
        		}
        		else {
        		System.out.println("déffausse vide, vous rejouez juste");
        		}
        		
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
    				if(A.getEtatjeu()==true && listJ.indexOf(A)!=listJ.indexOf(this) && A.getDefausse().size()>0) {
    					restrictChoix[restrict]=listJ.indexOf(A);
    					restrict++;
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom() + "Nombre de carte en révélé :  "+ A.getDefausse().size() );
    				
    				//
    				deffoss=A.getDefausse();
            		cartfct=deffoss.iterator();
            		
            		System.out.println("Les cartes révélé de ce joueurs sont :   ");
    		        
    		        while(cartfct.hasNext()) {
    		        	Carte C=cartfct.next();
    		        	System.out.println(C.getNom() + " à index :  "+ deffoss.indexOf(C));
    		        	}
    				}
    				else {
        				System.out.println("Impossible de jouer cette carte");
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
		        	System.out.println(C.getNom() + " à index :  "+ deffoss.indexOf(C));
		        	restrictChoix[restrict]=deffoss.indexOf(C);
					restrict++;
		        	}
		        
		        Carte carteVoulu = this.choisirCarte(restrictChoix, deffoss);
		        System.out.println("Carte  " + carteVoulu.getNom() + " prise au joueur :  " + Jdesigner.getNom());
    	        this.getMain().add(carteVoulu);
    	        Jdesigner.getMain().remove(carteVoulu);
    	        listJ.set(listJ.indexOf(Jdesigner), Jdesigner);
    	        
    	        //Probleme pour choisir le joueur suivant
    	      //Tableau reinistialiser valeur
				for(i=0; i<restrictChoix.length; i++) {
					restrictChoix[i]=-1;
				}
	    		restrict=0;
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
    			
	    		
        	}
        	break;     	
        default:
            System.out.println("Choix incorrect");
            break;
    	}    	
    	if(carteChoisi.getNom()=="black cat") {
    		deffausseGeneral.add(carteChoisi);
    	}
    	else {
    		this.getDefausse().add(carteChoisi);
    	}
    	
    	this.getMain().remove(carteChoisi);
    	
    	
    	return Jdesigner;
    	
    	}
    	
    /**
     * @return la dernieère carte joué
     */
    public Carte derniereCarteJouee() {
    	return derniereCarteJouee;
    	}
    	
    	
    	
    	
    	/**Version texte d'un joueur
    	 *
    	 */
    	public String toString() {
    		StringBuffer sb = new StringBuffer();
    		sb.append(nom);
    		sb.append(" : ");
    		sb.append(main);
    		sb.append("\n");
    		return sb.toString();
    		}
    
    //--------------------------
    
    /**Constructeur vide
     * 
     */
    public Joueur() {
    }

    /**obtenir le nom du joueur
     * @return string
     */
    public String getNom() {
        return nom;
    }

    /**obtenir score du joueur
     * @return entier
     */
    public int getScore() {
        return score;
    }

    /**définir le score du joueur en augment le score actuel avec la nouvelle valeur
     * @param score entier
     */
    public void setScore(int score) {
        this.score = this.score+score;
    }

    /**obtenir identité du joueur
     * @return boolean
     */
    public boolean isIdentite() {
        return identite;
    }

    /**Définir identité du joueur
     * @param identite boolean
     */
    public void setIdentite(boolean identite) {
        this.identite = identite;
    }

    

    /**définir état de la carte identité
     * @param etatCarte boolean
     */
    public void setEtatcarte(boolean etatCarte) {
        this.etatCarte = etatCarte;
    }
    /**obtenir état de jeu du joueur en question
     * @return boolean
     */
    public boolean getEtatcarte() {
        return this.etatCarte;
    }
    /**définir état de jeu du joueur en question
     * @param etatJeu boolean
     */
    public void setEtatjeu(boolean etatJeu) {
        this.etatJeu = etatJeu;
    }
    
    /**obtenir l'état de jeu du joueur en question
     * @return boolean
     */
    public boolean getEtatjeu() {
        return this.etatJeu;
    }

    /**définir nom joueur
     * @param nom string
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**obtenir résultat
     * @return entier
     */
    public int getResultat() {
        return this.resultat;
    }
    
    

    
}
