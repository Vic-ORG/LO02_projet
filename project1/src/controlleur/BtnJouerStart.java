package controlleur;

import modele.*;
import modele.principal.Partie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BtnJouerStart {
	
	private JButton unBouton;

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
