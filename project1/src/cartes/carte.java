package cartes;

public class carte {
	String rum;
	String nom;
	
	public carte(String rum, String nom) {
		this.rum=rum;
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
