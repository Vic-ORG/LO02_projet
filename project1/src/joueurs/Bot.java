package joueurs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import cartes.Carte;

public class Bot extends Joueur {

    public Bot(String nom, boolean etatCarte, boolean etatJeu, boolean identite, int score, int strategie) {
        super(nom, etatCarte, etatJeu, identite, score);
        //TODO Auto-generated constructor stub
    }
    
    public int actionTour() {
    	int chxb=1;
    	double x;
    	x=Math.random();
    	if(x<=0.5) {
    		chxb=1;
    		System.out.println("Bot veut accuser qqun ");
    	}
    	else {
    		chxb=2;
    		System.out.println("Bot veut chasser qqun ");
    	}
    	return chxb;
    }
    
    public Joueur choisirVictime(int[] restrictChoix, ArrayList<Joueur> listJ) {
    	Random rand = new Random();
    	int index2=0;
    	boolean contains=false;
    	int i;
    	while(contains==false) {
    		index2 = rand.nextInt(restrictChoix.length);
    		for(i=0; i<restrictChoix.length; i++) {
    			if(restrictChoix[i]==index2) {
    				contains=true;
    			}		
		}}
    	return listJ.get(index2);
    	
    }
    
    public int repondreAccu() {
    	System.out.println("Joueur : "+ this.getNom() + ", vous etes accusï¿½.");
    	System.out.println("Choississez si vous rï¿½vï¿½lez votre identitï¿½ : 0 non et 1 oui");
    	int choix3;
    	double x;
    	x=Math.random();
    	if(x<=0.5) {
    		choix3=1;
    		System.out.println("Bot veut reveler son identiten ");
    	}
    	else {
    		choix3=0;
    		System.out.println("Bot veut activer sa carte piege witch ");
    	}
    	
		return choix3;
		}
    
    public Carte choisirCarte(int[] restrictChoix, LinkedList<Carte> listCd) {
    	Random rand = new Random();
    	
    	int index2=0;
    	boolean contains=false;
    	int i;
    	while(contains==false) {
    		index2 = rand.nextInt(restrictChoix.length);
    		for(i=0; i<restrictChoix.length; i++) {
    			if(restrictChoix[i]==index2) {
    				contains=true;
    			}		
		}}
		return listCd.get(index2);
		
    	
    }
    
    public Joueur jouerCarte(Carte carteChoisi, String effet, ArrayList<Joueur> listJ, int indexActu, int indexdelautre, LinkedList<Carte> deffausseGeneral) {
    	//derniereCarteJouee = carteChoisi;
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
        		//System.out.println("Vous rejouez un tour !");
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
    			System.out.println("Choississez le joueur ï¿½ qui rï¿½vï¿½ler son identitï¿½ de maniï¿½re forcï¿½");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			Jdesigner.setEtatcarte(true);
    			System.out.println("*******************************************************************************");
    			System.out.println("************Rï¿½vï¿½lation de l'identitï¿½ du joueur :  " + Jdesigner.getNom() + "***********");
    			if(Jdesigner.isIdentite()==true) {
    				System.out.println("Identitï¿½ du joueur dï¿½signï¿½ : SORCIERE ");
    				Jdesigner.setEtatjeu(false);
    				System.out.println("*Joueur :  " + Jdesigner.getNom() + " est exlus du round ***********");
    				this.setScore(2);
    				System.out.println("Accusatueur :  " + this.getNom() + " gagne 2points ***********");
    				System.out.println("Accusatueur :  " + this.getNom() + " rejout ***********");
    			}
    			else {
    				System.out.println("************Identitï¿½ du joueur dï¿½signï¿½ : VILLAGEOIS ");
    				this.setScore(-2);
    				System.out.println("Accusatueur :  " + this.getNom() + " pert 2points ***********");
    				System.out.println("Accusï¿½ :  " + Jdesigner.getNom() + " prend la main ***********");
    			}
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
		        	System.out.println(C.getNom() + "ï¿½ index :  "+ m1.indexOf(C));
		        	restrictChoix[restrict]=m1.indexOf(C);
					restrict++;}
		        System.out.println("Choississez la carte ï¿½ mettre en dï¿½fausse gï¿½nï¿½rale : entrer l'index de la carte");
		        Carte carteRecup=this.choisirCarte(restrictChoix, m1);
				System.out.println("Carte choisi et en dï¿½fausse gï¿½nï¿½rale : " + carteRecup.getNom());
				this.getMain().remove(carteRecup);
				deffausseGeneral.add(carteRecup);
		        //erreur de comprï¿½hension de ma part sur les cartes rejetï¿½s
				//this.getDefausse().add(carteRecup);
				
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
    			System.out.println("************Ceci est secret et ï¿½ destination de :  " + this.getNom() + "***********");
    			if(Jdesigner.isIdentite()==true) {
    			System.out.println("************Identitï¿½ du joueur dï¿½signï¿½ : SORCIERE ");}
    			else {
    				System.out.println("************Identitï¿½ du joueur dï¿½signï¿½ : VILLAGEOIS ");
    			}
    			System.out.println("*******************************************************************************");
        	}
            break;
    
            
            
        case "Pointed Hat":
        	if(effet=="witch") {
        		deffoss=this.getDefausse();
        		cartfct=deffoss.iterator();
        		
        		System.out.println("Vos carte jouï¿½ et rï¿½vï¿½lï¿½ :");
		        
		        while(cartfct.hasNext()) {
		        	Carte C=cartfct.next();
		        	System.out.println("Les cartes rï¿½vï¿½lï¿½ sont : \n");
		        	System.out.println(C.getNom() + "ï¿½ index :  "+ deffoss.indexOf(C));
		        	restrictChoix[restrict]=deffoss.indexOf(C);
					restrict++;}
		        System.out.println("Entrer l'index de la carte que vous souhaitez rï¿½cupï¿½rer en main parmi carte dï¿½jï¿½ jouï¿½");
		        Carte carteRecup=this.choisirCarte(restrictChoix, deffoss);
				System.out.println("Carte choisi et rï¿½cupï¿½rer dans la main : " + carteRecup.getNom());
				this.getMain().add(carteRecup);
		        this.getDefausse().remove(carteRecup);
				
        		
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        	    deffoss=this.getDefausse();
        		cartfct=deffoss.iterator();
        		
        		System.out.println("Vos carte jouï¿½ et rï¿½vï¿½lï¿½ :");
		        
		        while(cartfct.hasNext()) {
		        	Carte C=cartfct.next();
		        	System.out.println("Les cartes rï¿½vï¿½lï¿½ sont : \n");
		        	System.out.println(C.getNom() + "ï¿½ index :  "+ deffoss.indexOf(C));
		        	restrictChoix[restrict]=deffoss.indexOf(C);
					restrict++;}
		        System.out.println("Entrer l'index de la carte que vous souhaitez rï¿½cupï¿½rer en main parmi carte dï¿½jï¿½ jouï¿½");
		        Carte carteRecup=this.choisirCarte(restrictChoix, deffoss);
				System.out.println("Carte choisi et rï¿½cupï¿½rer dans la main : " + carteRecup.getNom());
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
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
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
        		//cas de force majeur mais ï¿½a devrait marcher j'espï¿½re ????
        		listJ.set(indexActu, Accusateur);
        		
        	}
        	else if(effet=="hunt"){
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
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
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
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
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
    			System.out.println("Joueur  " + Jdesigner.getNom()  +  "choisisser si vous voulez rï¿½lï¿½ver identitï¿½ :  ");
    			int choix=Jdesigner.repondreAccu();
    			if(choix==0) {
    				//prendre le tour suivant
            		m1=Jdesigner.getMain();
            		cartfct=m1.iterator();
            		
            		System.out.println("Vos carte en main :");
    		        
    		        while(cartfct.hasNext()) {
    		        	Carte C=cartfct.next();
    		        	System.out.println("Les cartes en main sont : \n");
    		        	System.out.println(C.getNom() + "ï¿½ index :  "+ m1.indexOf(C));
    		        	restrictChoix[restrict]=m1.indexOf(C);
    					restrict++;}
    		        System.out.println("Choississez la carte ï¿½ mettre en dï¿½fausse gï¿½nï¿½rale : entrer l'index de la carte");
    		        Carte carteRecup=this.choisirCarte(restrictChoix, m1);
    				System.out.println("Carte choisi et en dï¿½fausse gï¿½nï¿½rale : " + carteRecup.getNom());
    				Jdesigner.getMain().remove(carteRecup);
    				deffausseGeneral.add(carteRecup);
    		        //erreur de comprï¿½hension de ma part sur les cartes rejetï¿½s
    				//this.getDefausse().add(carteRecup);
    				
    				//Jdesigner reprend la main
    				
    			}
    			else {
    				if(Jdesigner.isIdentite()==true) {
    					System.out.println("Joueur sï¿½lectionnï¿½ est une sorciere");
    					Jdesigner.setEtatcarte(true);
    					Jdesigner.setEtatjeu(false);
    					this.setScore(1);
    					//Jdesigner sera hors jeu et Jactu continue de jouer
    				}
    				else {
    					System.out.println("Joueur sï¿½lectionnï¿½ est un villageois");
    					Jdesigner.setEtatcarte(true);
    					this.setScore(-1);
    					//Jdesinger reprend la main
    					
    				}
	    			
	    			
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
        		System.out.println("Le joueur actuel   " + this.getNom() + "  rï¿½vï¿½le son identitï¿½ !!!");
        		if(this.isIdentite()==true) {
        			System.out.println("************Identitï¿½ du joueur dï¿½signï¿½ : SORCIERE ");
        			this.setEtatcarte(true);
        			this.setEtatjeu(false);
        			listJ.set(indexActu, this);
        			int indtamp=indexActu;
        			while(listJ.get(indtamp).getEtatjeu()==false) {
        				indtamp++;
        			}
        			Jdesigner=listJ.get(indtamp);
        			}
        			else {
        				System.out.println("************Identitï¿½ du joueur dï¿½signï¿½ : VILLAGEOIS ");
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
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			//indexdeux=listJ.indexOf(Jdesigner);
        		
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
        case "Toad":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		System.out.println("Le joueur actuel   " + this.getNom() + "  rï¿½vï¿½le son identitï¿½ !!!");
        		if(this.isIdentite()==true) {
        			System.out.println("************Identitï¿½ du joueur dï¿½signï¿½ : SORCIERE ");
        			this.setEtatcarte(true);
        			this.setEtatjeu(false);
        			listJ.set(indexActu, this);
        			int indtamp=indexActu;
        			while(listJ.get(indtamp).getEtatjeu()==false) {
        				indtamp++;
        			}
        			Jdesigner=listJ.get(indtamp);
        			}
        			else {
        				System.out.println("************Identitï¿½ du joueur dï¿½signï¿½ : VILLAGEOIS ");
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
        case "Black Cat":
        	if(effet=="witch") {
        		//prendre le tour suivant
        		System.out.println("Le joueur actuel   " + this.getNom() + "  joue le prochain tour");
        		
        	}
        	else if(effet=="hunt"){
        		if(deffausseGeneral.size()>0) {
        			cartfct=deffausseGeneral.iterator();
        			System.out.println("Vos carte en dans la déffausse Général :");
    		        
    		        while(cartfct.hasNext()) {
    		        	Carte C=cartfct.next();
    		        	System.out.println("Les cartes en main sont : \n");
    		        	System.out.println(C.getNom() + "à index :  "+ deffausseGeneral.indexOf(C));
    		        	restrictChoix[restrict]=deffausseGeneral.indexOf(C);
    					restrict++;}
    		        System.out.println("Choississez la carte de la défausse générale à prendre en main : entrer l'index de la carte");
    		        Carte carteRecup=this.choisirCarte(restrictChoix, deffausseGeneral);
    				System.out.println("Carte choisi et prise en main " + carteRecup.getNom());
    				this.getMain().add(carteRecup);
    				deffausseGeneral.remove(carteRecup);
    		        //erreur de compréhension de ma part sur les cartes rejetés
    				//this.getDefausse().add(carteRecup);
    				
    		      //Tableau reinistialiser valeur
    				for(i=0; i<restrictChoix.length; i++) {
    					restrictChoix[i]=-1;
    				}
    	    		restrict=0;
        			
        		}
        		else {
        		System.out.println("Déffausse vide, vous rejouez juste");
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
    				System.out.println("index : " + listJ.indexOf(A) + "Joueur : " + A.getNom() + "Nombre de carte en rï¿½vï¿½lï¿½ :  "+ A.getDefausse().size() );
    				
    				//
    				deffoss=A.getDefausse();
            		cartfct=deffoss.iterator();
            		
            		System.out.println("Les cartes rï¿½vï¿½lï¿½ de ce joueurs sont :   ");
    		        
    		        while(cartfct.hasNext()) {
    		        	Carte C=cartfct.next();
    		        	System.out.println(C.getNom() + "ï¿½ index :  "+ deffoss.indexOf(C));
    		        	}
    				}
    				else {
        				System.out.println("Impossible de jouer cette carte");
        			}
    			}
    			
    			//Choisir qui joueur
    			System.out.println("Choississez le joueur ï¿½ qui prendre une carte rï¿½vï¿½lï¿½ :");
    			Jdesigner=this.choisirVictime(restrictChoix, listJ);
    			deffoss=Jdesigner.getDefausse();
        		cartfct=deffoss.iterator();
        		//Tableau reinistialiser valeur
				for(i=0; i<restrictChoix.length; i++) {
					restrictChoix[i]=-1;
				}
	    		restrict=0;
        		
        		System.out.println("Rappel : Les cartes rï¿½vï¿½lï¿½ de ce joueur sont :   ");
		        while(cartfct.hasNext()) {
		        	Carte C=cartfct.next();
		        	System.out.println(C.getNom() + "ï¿½ index :  "+ deffoss.indexOf(C));
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
    			//indexdeux=listJ.indexOf(Jdesigner);
	    		
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
    
}
