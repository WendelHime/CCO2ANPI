package sistemaexterno.catraca;
import sistemaexterno.catraca.LoginController;
import sistemaexterno.catraca.LoginView;
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

