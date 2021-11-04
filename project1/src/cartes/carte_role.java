package cartes;

public class carte_role extends carte{
    private static boolean role;
    private String nomCarte = "Carte Role";

    public String getNomCarte() {
        return nomCarte;
    }

    public static boolean isRole() {
        return role;
    }

    public static void setRole(boolean role) {
        carte_role.role = role;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }


}
