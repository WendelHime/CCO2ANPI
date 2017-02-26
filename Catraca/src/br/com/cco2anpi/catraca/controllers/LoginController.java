package br.com.cco2anpi.catraca.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import br.com.cco2anpi.catraca.views.LoginView;
import br.com.cco2anpi.tools.Crypto;
import br.com.cco2anpi.tools.FileHandler;
import br.com.cco2anpi.tools.Searcher;

/**
 * @author pitagoras
 */
public class LoginController implements ActionListener {
	private LoginView loginView;
	// private ApplicationView applicationView;

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
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			String content = "";
			try {
				content = FileHandler.read(s, "login.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String[] linhas = content.split("[\\r\\n]+");
			Arrays.sort(linhas);
			String[] usernames = new String[linhas.length];
			String[] passwords = new String[linhas.length];
			String[] salts = new String[linhas.length];
			for (int i = 0; i < linhas.length; i++) {
				String[] valores = linhas[i].split(" ");
				usernames[i] = valores[0];
				salts[i] = valores[1];
				passwords[i] = valores[2];
			}

			int position = Searcher.binarySearch(usernames, loginView.tLogin.getText());
			if (position >= 0) {
				String password = "";
				System.out.println("Username: username0");
				try {
					password = Crypto.decrypt(passwords[position], salts[position]);
					System.out.println("password: " + password);
				} catch (DataLengthException | IllegalStateException | InvalidCipherTextException e1) {
					e1.printStackTrace();
				}
				if (password.equals(new String(loginView.tSenha.getPassword()))) {
					//TODO 
					
//					loginView.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Username not found");
			}
		}
	}
}
