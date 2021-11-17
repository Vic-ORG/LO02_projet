package cartes;

public class Carte {
	String typeo;
	String nom;
	
	public Carte(String typeo, String nom) {
		this.typeo=typeo;
		this.nom=nom;
		
	}
    private boolean type;

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
