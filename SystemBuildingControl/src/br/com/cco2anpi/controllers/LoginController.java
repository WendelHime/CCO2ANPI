package br.com.cco2anpi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import br.com.cco2anpi.tools.Crypto;
import br.com.cco2anpi.tools.FileHandler;
import br.com.cco2anpi.tools.Searcher;
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
			// for (String linha : linhas) {
			// System.out.println(linha);
			Arrays.sort(linhas);
			// int position = Arrays.binarySearch(linhas,
			// loginView.tLogin.getText());
			String[] usernames = new String[linhas.length];
			String[] passwords = new String[linhas.length];
			String[] salts = new String[linhas.length];
			for (int i = 0; i < linhas.length; i++) {
				String[] valores = linhas[i].split(" ");
				usernames[i] = valores[0];
				salts[i] = valores[1];
				passwords[i] = valores[2];
			}

			// new Searcher<Comparable<String>>(usernames).search("");
//			int position = Arrays.binarySearch(usernames, loginView.tLogin.getText());
			int position = Searcher.binarySearch(usernames, loginView.tLogin.getText());
			// System.out.println("antes de verificar login");
			if (position >= 0) {
				String password = "";
				System.out.println("Username: username0");
				try {
					password = Crypto.decrypt(passwords[position], salts[position]);
					System.out.println("password: " + password);
				} catch (DataLengthException | IllegalStateException | InvalidCipherTextException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (password.equals(new String(loginView.tSenha.getPassword()))) {
					new ApplicationViewController();
					// applicationView.setVisible(true);
					loginView.setVisible(false);
				} else {

					JOptionPane.showMessageDialog(null, "Wrong password");

				}
			} else {
				JOptionPane.showMessageDialog(null, "Username not found");
			}
		}
	}
}
