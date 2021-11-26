package cartes;

public class carte_rumeur extends Carte{
    public carte_rumeur(String typeo, String nom) {
		super(typeo, nom);
		// TODO Auto-generated constructor stub
	}

	private String nomCarte = "Carte Rumeur";

    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }
    
    public void revelforce() {
    	
    }
}
