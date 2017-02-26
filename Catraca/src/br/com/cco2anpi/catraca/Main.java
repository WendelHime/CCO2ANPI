package br.com.cco2anpi.catraca;
import br.com.cco2anpi.catraca.controllers.LoginController;
import br.com.cco2anpi.catraca.views.LoginView;
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

