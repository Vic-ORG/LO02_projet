import joueurs.joueur;

public class app {
    public static void main(String[] args) throws Exception {
        partie.menu();

        joueur joueurActuel = new joueur(null, false, true, 0);
        //joueurActuel = joueurActuel.changerJoueur();
    }
}
