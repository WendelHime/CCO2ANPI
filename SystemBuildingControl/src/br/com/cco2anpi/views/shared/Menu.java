package br.com.cco2anpi.views.shared;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.com.cco2anpi.controllers.ApplicationViewController;
import br.com.cco2anpi.views.AirConditionerView;
import br.com.cco2anpi.views.ApplicationView;
import br.com.cco2anpi.views.CompanyView;
import br.com.cco2anpi.views.ConsultAccessBuildingView;
import br.com.cco2anpi.views.EmployeeView;
import br.com.cco2anpi.views.LoginView;

public class Menu extends JFrame {
	public static String employee = "Funcionario";
	public static String employeeKey = "ecadastro/econsulta";
	public static String company = "Empresa";
	public static String companyKey = "ccadastro/cconsulta";
	public static String airConditioner = "Ar-Condicionado";
	public static String airConditionerKey = "Temperatura";
	public static String access = "Acesso";
	public static String accessKey = "Consultar Acessos";
	public static String accessSend = "Enviar Arquivo";

	public Menu() {
		barraMenu();
	}
	
	public JComponent menuArquivo(){
		/*
		 * ========================================================================= 
		 * 	----------------------------- Menu Arquivo -----------------------------				
		 * =========================================================================
		 */
		JMenu arquivoMenu = new JMenu("Arquivo");
		arquivoMenu.setMnemonic('a');

		// ======================== Sobre ========================
		JMenuItem sobreMenuItem = new JMenuItem("Sobre");
		arquivoMenu.add(sobreMenuItem);
		sobreMenuItem.setMnemonic('o');

		sobreMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(Menu.this,
				"2016 App. CCO2ANPI                                 "
				+ "\nNo menu (Consulta) ..."
				+ " \n",
				"Sobre", JOptionPane.PLAIN_MESSAGE);
			}

		});
		// ======================== Idioma ========================
		JMenuItem idiomaMenuItem = new JMenuItem("Idioma");
		arquivoMenu.add(idiomaMenuItem);
		idiomaMenuItem.setMnemonic('i');
		idiomaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
			}

		});
		// ======================== Sair ========================
		JMenuItem sairMenuItem = new JMenuItem("Sair");
		arquivoMenu.add(sairMenuItem);
		sairMenuItem.setMnemonic('s');
		sairMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.exit(0);
			}

		});
		return arquivoMenu;
	}
	/*
	 * ========================================================================= 
	 * 	----------------------------- Menu Funcionário -------------------------------				
	 * =========================================================================
	 */
	public JComponent menuFuncionario(){
		JMenu funcionarioMenu = new JMenu(employee);
		funcionarioMenu.setMnemonic('o');

		
		// ======================== Consultar ========================
		JMenuItem cadastrarMenu = new JMenuItem(employeeKey);
		funcionarioMenu.add(cadastrarMenu);
		cadastrarMenu.setMnemonic('e');
		cadastrarMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					// TODO 
					System.out.println("cheguei no Menu");
					ApplicationViewController.redrawContentPanel(employeeKey); 
				}
		
		});
//	 		
//		// ====================== Cadastrar =======================
//		JMenuItem consultaMenu = new JMenuItem("Consultar");
//		funcionarioMenu.add(consultaMenu); 
//		consultaMenu.setMnemonic('f');
//		consultaMenu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				// TODO 
//			}
//
//		});
	 		
		return funcionarioMenu;
	}
	/*
	 * ========================================================================= 
	 * 	--------------------------- Menu Empresa ----------------------------				
	 * =========================================================================
	 */
	public JComponent menuEmpresa(){
		JMenu empresaMenu = new JMenu(company);
		empresaMenu.setMnemonic('o');

		
		// ======================== Consultar ========================
		JMenuItem cadastrarMenu = new JMenuItem(companyKey);
		empresaMenu.add(cadastrarMenu);
		cadastrarMenu.setMnemonic('e');
		cadastrarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(companyKey); 
			}

		});
//	 		
//		// ====================== Cadastrar =======================
//		JMenuItem consultaMenu = new JMenuItem("Consultar");
//		empresaMenu.add(consultaMenu); 
//		consultaMenu.setMnemonic('f');
//		consultaMenu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				// TODO 
//			}
//
//		});
		return empresaMenu;
	}
	/*
	 * ========================================================================= 
	 * 	--------------------------- Barra de Menus ----------------------------				
	 * =========================================================================
	 */
	public JComponent barraMenu(){
		JMenuBar bar = new JMenuBar(); 
		setJMenuBar(bar); 
		bar.add(menuArquivo()); 
		bar.add(menuFuncionario());
		bar.add(menuEmpresa());
		bar.add(menuAcesso());
		bar.add(menuArCondicionado());
		return bar;
	}
	/*
	 * ========================================================================= 
	 * 	--------------------------- Menu Ar-Condicionado ----------------------------				
	 * =========================================================================
	 */
	public JComponent menuArCondicionado(){
		JMenu arCondicionadoMenu = new JMenu(airConditioner);
		arCondicionadoMenu.setMnemonic('r');
		
		JMenuItem arCondicionadoMenuAlt = new JMenuItem(airConditionerKey);
		arCondicionadoMenu.add(arCondicionadoMenuAlt);
		arCondicionadoMenuAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(airConditioner); 
			}

		});
		return arCondicionadoMenu;
	}
	/*
	 * ========================================================================= 
	 * 	--------------------------- Menu Acesso ----------------------------				
	 * =========================================================================
	 */
	public JComponent menuAcesso(){
		JMenu acessoMenu = new JMenu(access);
		acessoMenu.setMnemonic('s');
		
		// ======================== Consultar ========================
		JMenuItem consultarMenu = new JMenuItem(accessKey);
		acessoMenu.add(consultarMenu);
		consultarMenu.setMnemonic('e');
		consultarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(accessKey); 
			}

		});
	 		
		// ====================== Enviar =======================
		JMenuItem enviaraMenu = new JMenuItem(accessSend);
		acessoMenu.add(enviaraMenu); 
		enviaraMenu.setMnemonic('f');
		enviaraMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(accessSend);
			}

		});
		return acessoMenu;
	}
}