package br.com.cco2anpi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import br.com.cco2anpi.tools.Crypto;
import br.com.cco2anpi.tools.FileHandler;
import br.com.cco2anpi.views.ApplicationView;
import br.com.cco2anpi.views.LoginView;

/**
 * @author pitagoras
 */
public class LoginController implements ActionListener {
	private LoginView loginView;
	private ApplicationView applicationView;

	/**
	 * Constructor Set Components to LoginController
	 */
	public LoginController(LoginView loginView) {
		// TODO Auto-generated constructor stub
		this.loginView = loginView;
		this.loginView.getLoginButton().addActionListener(this);
	}

	/**
	 * <b>Description</b> Method to authentication of the login. Not
	 * implemented!!!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.loginView.getLoginButton()) {
			System.out.println("cheguei em LoginController");
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			String content = "";
			try {
				content = FileHandler.read(s, "login.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] linhas = content.split("[\\r\\n]+");
			for (String linha : linhas) {
				System.out.println(linha);
				String[] valores = linha.split(" ");
				System.out.println(valores[0]);
				System.out.println(loginView.textLogin().getName());
				if (valores[0] == loginView.textLogin().getName()) {
					String password = "";
					try {
						password = Crypto.decrypt(valores[2], valores[1]);
					} catch (DataLengthException | IllegalStateException | InvalidCipherTextException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(password.equals(loginView.textSenha()))
					{
						new ApplicationViewController();
						// applicationView.setVisible(true);
						loginView.setVisible(false);
					}
				}
			}
			JOptionPane.showMessageDialog(null, "DEEEEEEEEEEU PAAAAAAAAAAAAAAAAAAAAAAAAAAAAU\nHMMMMMMMMMMMMMMMMMMMM");
		}
	}
}
