package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.com.cco2anpi.views.shared.CustomTextField;
import br.com.cco2anpi.views.shared.ImgUtils;

public class LoginView extends JFrame {
	// Para teste
	// public ApplicationView a;
	// public static ApplicationView a;
	// public static ApplicationView simulaController(){
	// return a;
	// }
	JButton bLogin;
	public CustomTextField tLogin;
	public JPasswordField tSenha;

	/*
	 * =================================================================
	 * Construtor
	 * =================================================================
	 */
	public JButton getLoginButton() {
		return bLogin;
	}

	public LoginView() {
		super("Efetuar Login");
		Container container = getContentPane();
		container.setLayout(new BorderLayout(5, 5));
		container.add(joinFrame(), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 650));
		setLocationRelativeTo(null);
		setVisible(true);
		System.out.println("cheguei em LoginView");

	}

	/*
	 * ================================================================= Agrupa
	 * Componentes
	 * =================================================================
	 */
	public JComponent joinFrame() {
		// Group components Login
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 7, 7));
		panel.setBorder(new EmptyBorder(0, 125, 50, 125));
		panel.setBackground(new Color(255, 255, 255));
		panel.add(textLogin());
		panel.add(textSenha());
		panel.add(buttonLogin());
		// Logo
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout(0, 100));
		pane.setBorder(new EmptyBorder(100, 0, 0, 0));
		pane.setBackground(new Color(255, 255, 255));

		// Panel Completed
		pane.add(logo(), BorderLayout.NORTH);
		pane.add(panel, BorderLayout.CENTER);
		return pane;
	}

	/*
	 * ================================================================= Bot�o
	 * Login =================================================================
	 */
	public JComponent buttonLogin() {
		bLogin = new JButton("Login");
		bLogin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
				new Color(86, 136, 163), new Color(86, 136, 163))));
		bLogin.setBackground(new Color(86, 136, 163));
		bLogin.setFont(bLogin.getFont().deriveFont(Font.BOLD));
		bLogin.setForeground(Color.WHITE);
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bLogin) {
					System.out.println(tLogin.getText());
					System.out.println(tSenha.getPassword());
				}
			}
		});
		return bLogin;
	}

	/*
	 * ================================================================= Campo
	 * de texto Login
	 * =================================================================
	 */
	public JComponent textLogin() {
		tLogin = new CustomTextField(20);
		tLogin.setPlaceholder(" Login");
		tLogin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
				new Color(221, 221, 221), new Color(221, 221, 221))));
		return tLogin;
	}

	/*
	 * ================================================================= Campo
	 * de texto Senha
	 * =================================================================
	 */
	public JComponent textSenha() {
		tSenha = new JPasswordField(20);
		// tSenha.setPlaceholder(" Password");
		tSenha.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
				new Color(221, 221, 221), new Color(221, 221, 221))));
		return tSenha;
	}

	/*
	 * ================================================================= Logo
	 * =================================================================
	 */
	public JComponent logo() {
		File currentDirFile = new File("");
		String helper = currentDirFile.getAbsolutePath();
		BufferedImage img = new ImgUtils().scaleImage(240, 180, helper+"\\src\\main\\resources\\images\\logo .png");
		
		JLabel picLabel = new JLabel(new ImageIcon(img));
		return picLabel;
	}

}