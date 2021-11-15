import joueurs.joueur;
import cartes.jeuCarte;

public class app {
	
    public static void main(String[] args) throws Exception {
        partie.menu();
        
        jeuCarte jeuActu = new jeuCarte();
        jeuActu = jeuCarte.createJeuCartes();
        jeuActu.melangeJeu();

        joueur joueurActuel = new joueur(null, false, true, 0);
        //joueurActuel = joueurActuel.changerJoueur();
    }
}
