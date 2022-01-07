package controlleur;

//import modele.*;

import modele.principal.Partie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**Classe bouton controlleur pour démarrer jeu console
 * @author victo
 *
 */
public class BtnJouerStart {
	
	private JButton unBouton;

	/**bouton à appuyer et son action
	 * @param partieT partie en cours à affecter
	 * @param bouton le bouton en question à agir dessus
	 */
	public BtnJouerStart(Partie partieT, JButton bouton) {
		// TODO Auto-generated constructor stub
		unBouton=bouton;
		
		unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nDébut du Jeu\n ");
				partieT.initGame();
			}
		});
	}

}
