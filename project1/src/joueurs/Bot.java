package joueurs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    
    public Joueur choisirVictime(int[] restrictChoix, ArrayList<Joueur> listJ, int index2) {
    	Random rand = new Random();
        index2 = rand.nextInt(restrictChoix.length);
		return listJ.get(index2);
    	
    }
    
    public int repondreAccu() {
    	System.out.println("Joueur : "+ this.getNom() + ", vous etes accusé.");
    	System.out.println("Choississez si vous révélez votre identité : 0 non et 1 oui");
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
    
}
