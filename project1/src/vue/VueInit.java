package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**Classe supposé être vu grphique de l'initialisation des joueurs
 * @author victo
 *
 */
public class VueInit {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @param args args du main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueInit window = new VueInit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueInit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Joueur :");
		lblNewLabel.setBounds(34, 23, 109, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(151, 20, 30, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Nom du joueur :");
		lblNewLabel_1.setBounds(34, 53, 95, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(121, 50, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
