package modele.cartes;

/**Classe carte role qui définit si villageois ou sorciere
 * @author victo
 *
 */
public class carte_role extends Carte{
    public carte_role(String typeo, String nom) {
		super(typeo, nom);
		// TODO Auto-generated constructor stub
	}

	private static boolean role;
    private String nomCarte = "Carte Role";

    /**(surement non utilisé)
     * @return un string du nom de la carte
     */
    public String getNomCarte() {
        return nomCarte;
    }

    /**Savoir le role d'un joueur
     * @return un boolean qui indique si le joueur est villageois ou sorciere
     */
    public static boolean isRole() {
        return role;
    }

    /** Permet de définir le role d'un joueur
     * @param role boolean qui définit villageois ou sorciere
     */
    public static void setRole(boolean role) {
        carte_role.role = role;
    }

    /** Mettre le nom de la carte (non utilisé)
     * @param nomCarte
     */
    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }


}
