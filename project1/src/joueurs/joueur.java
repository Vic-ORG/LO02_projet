package joueurs;

import cartes.carte_role;

public class joueur {
    private String nom;
    private boolean etat;
    private boolean identite = carte_role.isRole();
    private int score;

    public joueur(String nom, boolean etat, boolean identite, int score) {
        this.nom = nom;
        this.etat = etat;
        this.identite = identite;
        this.score = score;
    }
    
    public joueur() {
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

}
