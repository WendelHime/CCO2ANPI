package br.com.cco2anpi.views.shared;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.com.cco2anpi.controllers.ApplicationViewController;

public class Menu extends JFrame {
	private JMenu arquivoMenu;
	private JMenuItem sobreMenuItem;
	private JMenu idiomaMenuItem;
	private JMenuItem portugueseItem;
	private JMenuItem englishItem;
	private JMenuItem espanishItem;
	private JMenuItem sairMenuItem;
	
	private ResourceBundle bn = null;
	JMenu userMenu;
	JMenuItem cadastrarMenuu;
	JMenu funcionarioMenu;
	JMenuItem cadastrarMenu;
	JMenu empresaMenu;
	JMenuItem cadastrarMenuc;
	JMenu conjuntoMenu;
	JMenuItem cadastrarMenucx;
	JMenuBar bar;
	JMenu arCondicionadoMenu;
	JMenuItem arCondicionadoMenuAlt;
	JMenu acessoMenu;
	JMenuItem consultarMenu;
	JMenuItem enviaraMenu;

	public static String employeeKey = "ecadastro/econsulta";
	public static String companyKey = "ccadastro/cconsulta";
	public static String airConditionerKey = "Ar-Condicionado";
	public static String accessKey = "Consultar Acessos";
	public static String sendKey = "Enviar Arquivo";
	public static String blanckKey = "inicio";
	public static String complexKey = "cxcadastro/cxconsulta";
	public static String userKey = "ucadastro/uconsulta";

	public Menu() {
//		File currentDirFile = new File("");
//		String helper = currentDirFile.getAbsolutePath();
		bn = ResourceBundle.getBundle("language", new Locale("pt", "BR"));
		barraMenu();
	}
	
	public JComponent menuArquivo(){
		/*
		 *  @return JComponent classic menu File
		 */
		arquivoMenu = new JMenu(bn.getString("arquivo"));
		arquivoMenu.setMnemonic('a');

		// about
		sobreMenuItem = new JMenuItem(bn.getString("sobre"));
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
		// language
		idiomaMenuItem = new JMenu("Idioma");
		idiomaMenuItem.setMnemonic('i');
		
		portugueseItem = new JMenuItem(bn.getString("portugues"));
		portugueseItem.setMnemonic('p'); 											
		idiomaMenuItem.add(portugueseItem);
	
		englishItem = new JMenuItem(bn.getString("ingles"));														
		englishItem.setMnemonic('n'); 
		idiomaMenuItem.add(englishItem); 

		espanishItem = new JMenuItem(bn.getString("espanhol"));
		espanishItem.setMnemonic('s'); 
		idiomaMenuItem.add(espanishItem); 
		
		arquivoMenu.add(idiomaMenuItem);
		
		// exit
		sairMenuItem = new JMenuItem("Sair");
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
	 *  @return JComponent menu to users (users and employee)
	 */
	public JComponent menuUser(){
		userMenu = new JMenu("usuario");
		userMenu.setMnemonic('o');

		cadastrarMenuu = new JMenuItem(userKey);
		userMenu.add(cadastrarMenuu);
		cadastrarMenuu.setMnemonic('u');
		cadastrarMenuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(userKey); 
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
		userMenu.add(menuFuncionario());
		return userMenu;
	}

	/*
	 *  @return JComponent menu to Employer
	 */
	public JComponent menuFuncionario(){
		funcionarioMenu = new JMenu(bn.getString("funcionario"));
		funcionarioMenu.setMnemonic('o');

		
		// ======================== Consultar ========================
		cadastrarMenu = new JMenuItem(employeeKey);
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
	 *  @return JComponent menu to Company
	 */
	public JComponent menuEmpresa(){
		empresaMenu = new JMenu(bn.getString("empresa"));
		empresaMenu.setMnemonic('o');

		cadastrarMenuc = new JMenuItem(companyKey);
		empresaMenu.add(cadastrarMenuc);
		cadastrarMenuc.setMnemonic('e');
		cadastrarMenuc.addActionListener(new ActionListener() {
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
	 *  @return JComponent menu to Complex Building
	 */
	public JComponent menuConjunto(){
		conjuntoMenu = new JMenu("conjunto");
		conjuntoMenu.setMnemonic('o');

		cadastrarMenucx = new JMenuItem(complexKey);
		conjuntoMenu.add(cadastrarMenucx);
		cadastrarMenucx.setMnemonic('e');
		cadastrarMenucx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(complexKey); 
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
		return conjuntoMenu;
	}

	/*
	 *  @return JComponent menu to Access consult and send file
	 */
	public JComponent menuAcesso(){
		acessoMenu = new JMenu(bn.getString("acesso"));
		acessoMenu.setMnemonic('s');
		
		// Consult
		consultarMenu = new JMenuItem(bn.getString("consulta_acesso"));
		acessoMenu.add(consultarMenu);
		consultarMenu.setMnemonic('e');
		consultarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(accessKey); 
			}

		});
	 		
		// Access
		enviaraMenu = new JMenuItem(bn.getString("enviar_arquivo"));
		acessoMenu.add(enviaraMenu); 
		enviaraMenu.setMnemonic('f');
		enviaraMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(sendKey);
			}

		});
		return acessoMenu;
	}

	/*
	 *  @return JComponent menu to Air-conditioner
	 */
	public JComponent menuArCondicionado(){
		arCondicionadoMenu = new JMenu(bn.getString("ar_condicionado"));
		arCondicionadoMenu.setMnemonic('r');
		
		arCondicionadoMenuAlt = new JMenuItem(airConditionerKey);
		arCondicionadoMenu.add(arCondicionadoMenuAlt);
		arCondicionadoMenuAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// TODO 
				System.out.println("cheguei no Menu");
				ApplicationViewController.redrawContentPanel(airConditionerKey); 
			}

		});
		return arCondicionadoMenu;
	}

	/*
	 *  @return JComponent menuBar with all menus
	 */
	public JComponent barraMenu(){
		bar = new JMenuBar(); 
		setJMenuBar(bar); 
		bar.add(menuArquivo()); 
		bar.add(menuUser());
		bar.add(menuEmpresa());
		bar.add(menuAcesso());
		bar.add(menuArCondicionado());
		bar.add(menuConjunto());
		
		return bar;
	}

	public void updateLanguage(ResourceBundle bn2) {
		// TODO para tratar eventos dos menus de idiomas
		/* 
		espanishItem.addActionListener( 
		         new ActionListener() // classe interna anonima 
		         { 
		            // exibe um dialogo de mensagem quando o usuario seleciona Portuguese 
		            public void actionPerformed( ActionEvent event ) 
		            { 
		               bn = ResourceBundle.getBundle("language", new Locale("es", "ESP"));
		       			System.out.println("es");

//		               displayJLabel.setText( bn.getString("mensagem"));
//		               setTitle(bn.getString("titulo"));
		               arquivoMenu.setText(bn.getString("arquivo"));
//		               fileMenu.setMnemonic(bn.getString("arquivo.mnemonico").charAt(0)); 
		               sobreMenuItem.setText(bn.getString("sobre"));
//		               aboutItem.setMnemonic(bn.getString("sobre.mnemonico").charAt(0));
		               idiomaMenuItem.setText(bn.getString("idioma"));
		               portugueseItem.setText(bn.getString("portugues"));
		               englishItem.setText(bn.getString("ingles"));
		               espanishItem.setText(bn.getString("espanhol"));
		               sairMenuItem.setText(bn.getString("sair"));
//		               exitItem.setMnemonic(bn.getString("sair.mnemonico").charAt(0));
		               funcionarioMenu.setText(bn.getString("funcionario"));
		               empresaMenu.setText(bn.getString("empresa"));
		               arCondicionadoMenu.setText(bn.getString("ar_condicionado"));
		               arCondicionadoMenuAlt.setText(bn.getString("temperatura"));
		               acessoMenu.setText(bn.getString("acesso"));
		               consultarMenu.setText(bn.getString("consulta_acesso"));
		               enviaraMenu.setText(bn.getString("enviar_arquivo"));
		               ApplicationViewController.applicationViewController(bn);
		               
		            } 
		         }  
		      ); */
	}
}
