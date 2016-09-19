package br.com.cco2anpi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

			new ApplicationViewController();
			// applicationView.setVisible(true);
			loginView.setVisible(false);
		}
	}
}
