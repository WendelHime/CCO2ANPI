package br.com.cco2anpi;
import br.com.cco2anpi.controllers.LoginController;
import br.com.cco2anpi.views.LoginView;
/**
 * @author pitagoras
 * */
public class Main {
	/**
	 * Start application
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView loginView = new LoginView();
		new LoginController(loginView);
		
	}
}

