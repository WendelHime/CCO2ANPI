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
	public JMenu arquivoMenu;
	public JMenuItem sobreMenuItem;
	public JMenu idiomaMenuItem;
	public JMenuItem portugueseItem;
	public JMenuItem englishItem;
	public JMenuItem espanishItem;
	public JMenuItem sairMenuItem;
	public static String employeeKey = "ecadastro/econsulta";
	public static String companyKey = "ccadastro/cconsulta";
	public static String airConditionerKey = "Ar-Condicionado";
	public static String accessKey = "Consultar Acessos";
	public static String sendKey = "Enviar Arquivo";
	public static String blanckKey = "inicio";
	public static String complexKey = "cxcadastro/cxconsulta";
	private ResourceBundle bn = null;
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
	public Menu() {
//		File currentDirFile = new File("");
//		String helper = currentDirFile.getAbsolutePath();
		bn = ResourceBundle.getBundle("language", new Locale("pt", "BR"));
		barraMenu();
	}
	
	public JComponent menuArquivo(){
		/*
		 * ========================================================================= 
		 * 	----------------------------- Menu Arquivo -----------------------------				
		 * =========================================================================
		 */
		arquivoMenu = new JMenu(bn.getString("arquivo"));
		arquivoMenu.setMnemonic('a');

		// ======================== Sobre ========================
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
		// ======================== Idioma ========================
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
		      ); 
		englishItem.addActionListener( 
		         new ActionListener() // classe interna anonima 
		         { 
		            // exibe um dialogo de mensagem quando o usuario seleciona Portuguese 
		            public void actionPerformed( ActionEvent event ) 
		            { 
		               bn = ResourceBundle.getBundle("language", new Locale("en", "US"));
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
		      ); 
		portugueseItem.addActionListener( 
		         new ActionListener() // classe interna anonima 
		         { 
		            // exibe um dialogo de mensagem quando o usuario seleciona Portuguese 
		            public void actionPerformed( ActionEvent event ) 
		            { 
		               bn = ResourceBundle.getBundle("language", new Locale("pt", "BR"));
		               
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
		      ); 
		// ======================== Sair ========================
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
	 * ========================================================================= 
	 * 	----------------------------- Menu Funcion�rio -------------------------------				
	 * =========================================================================
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
	 * ========================================================================= 
	 * 	--------------------------- Menu Empresa ----------------------------				
	 * =========================================================================
	 */
	public JComponent menuEmpresa(){
		empresaMenu = new JMenu(bn.getString("empresa"));
		empresaMenu.setMnemonic('o');

		
		// ======================== Consultar ========================
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
	 * ========================================================================= 
	 * 	--------------------------- Menu Empresa ----------------------------				
	 * =========================================================================
	 */
	public JComponent menuConjunto(){
		conjuntoMenu = new JMenu(bn.getString("empresa"));
		conjuntoMenu.setMnemonic('o');

		
		// ======================== Consultar ========================
		cadastrarMenucx = new JMenuItem(companyKey);
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
	 * ========================================================================= 
	 * 	--------------------------- Barra de Menus ----------------------------				
	 * =========================================================================
	 */
	public JComponent barraMenu(){
		bar = new JMenuBar(); 
		setJMenuBar(bar); 
		bar.add(menuArquivo()); 
		bar.add(menuFuncionario());
		bar.add(menuEmpresa());
		bar.add(menuAcesso());
		bar.add(menuArCondicionado());
		bar.add(menuConjunto());
		return bar;
	}
	/*
	 * ========================================================================= 
	 * 	--------------------------- Menu Ar-Condicionado ----------------------------				
	 * =========================================================================
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
	 * ========================================================================= 
	 * 	--------------------------- Menu Acesso ----------------------------				
	 * =========================================================================
	 */
	public JComponent menuAcesso(){
		acessoMenu = new JMenu(bn.getString("acesso"));
		acessoMenu.setMnemonic('s');
		
		// ======================== Consultar ========================
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
	 		
		// ====================== Enviar =======================
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
}