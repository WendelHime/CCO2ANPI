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
//	JMenu funcionarioMenu;
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
		// File currentDirFile = new File("");
		// String helper = currentDirFile.getAbsolutePath();
		bn = ResourceBundle.getBundle("languages.language", new Locale("en", "US"));
		barraMenu();
	}

	public JComponent menuArquivo() {
		/*
		 * @return JComponent classic menu File
		 */
		arquivoMenu = new JMenu(bn.getString("arquivo"));

		// about
		sobreMenuItem = new JMenuItem(bn.getString("sobre"));
		arquivoMenu.add(sobreMenuItem);

		sobreMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(Menu.this,
						"2016 App. CCO2ANPI                                 " + "\nNo menu (Consulta) ..." + " \n",
						"Sobre", JOptionPane.PLAIN_MESSAGE);
			}

		});
		// language
		idiomaMenuItem = new JMenu(bn.getString("idioma"));

		portugueseItem = new JMenuItem(bn.getString("portugues"));
		idiomaMenuItem.add(portugueseItem);
		portugueseItem.addActionListener(new ActionListener() // classe interna
																// anonima
		{
			// exibe um dialogo de mensagem quando o usuario seleciona
			// Portuguese
			public void actionPerformed(ActionEvent event) {
				bn = ResourceBundle.getBundle("languages.language", new Locale("pt", "BR"));
				System.out.println("idioma alterado para => br");

				// displayJLabel.setText( bn.getString("mensagem"));
				// setTitle(bn.getString("titulo"));
				arquivoMenu.setText(bn.getString("arquivo"));
				// fileMenu.setMnemonic(bn.getString("arquivo.mnemonico").charAt(0));
				sobreMenuItem.setText(bn.getString("sobre"));
				// aboutItem.setMnemonic(bn.getString("sobre.mnemonico").charAt(0));
				idiomaMenuItem.setText(bn.getString("idioma"));
				portugueseItem.setText(bn.getString("portugues"));
				englishItem.setText(bn.getString("ingles"));
				espanishItem.setText(bn.getString("espanhol"));
				sairMenuItem.setText(bn.getString("sair"));
				// exitItem.setMnemonic(bn.getString("sair.mnemonico").charAt(0));
//				funcionarioMenu.setText(bn.getString("funcionario"));
				empresaMenu.setText(bn.getString("empresa"));
				arCondicionadoMenu.setText(bn.getString("ar_condicionado"));
				arCondicionadoMenuAlt.setText(bn.getString("temperatura"));
				acessoMenu.setText(bn.getString("acesso"));
				consultarMenu.setText(bn.getString("consulta_acesso"));
				enviaraMenu.setText(bn.getString("enviar_arquivo"));
				userMenu.setText(bn.getString("usuario"));
				conjuntoMenu.setText(bn.getString("conjunto"));
				cadastrarMenuu.setText(bn.getString("gerenciar_usuarios"));
				cadastrarMenu.setText(bn.getString("gerenciar_funcionarios"));
				cadastrarMenucx.setText(bn.getString("gerenciar_conjuntos"));
				cadastrarMenuc.setText(bn.getString("gerenciar_empresas"));
				ApplicationViewController.applicationViewController(bn);

			}
		});

		englishItem = new JMenuItem(bn.getString("ingles"));
		idiomaMenuItem.add(englishItem);
		englishItem.addActionListener(new ActionListener() // classe interna
															// anonima
		{
			// exibe um dialogo de mensagem quando o usuario seleciona
			// Portuguese
			public void actionPerformed(ActionEvent event) {
				bn = ResourceBundle.getBundle("languages.language", new Locale("en", "US"));
				System.out.println("idioma alterado para => en");

				// displayJLabel.setText( bn.getString("mensagem"));
				// setTitle(bn.getString("titulo"));
				arquivoMenu.setText(bn.getString("arquivo"));
				// fileMenu.setMnemonic(bn.getString("arquivo.mnemonico").charAt(0));
				sobreMenuItem.setText(bn.getString("sobre"));
				// aboutItem.setMnemonic(bn.getString("sobre.mnemonico").charAt(0));
				idiomaMenuItem.setText(bn.getString("idioma"));
				portugueseItem.setText(bn.getString("portugues"));
				englishItem.setText(bn.getString("ingles"));
				espanishItem.setText(bn.getString("espanhol"));
				sairMenuItem.setText(bn.getString("sair"));
//				 exitItem.setMnemonic(bn.getString("sair.mnemonico").charAt(0));
//				funcionarioMenu.setText(bn.getString("funcionario"));
				empresaMenu.setText(bn.getString("empresa"));
				arCondicionadoMenu.setText(bn.getString("ar_condicionado"));
				arCondicionadoMenuAlt.setText(bn.getString("temperatura"));
				acessoMenu.setText(bn.getString("acesso"));
				consultarMenu.setText(bn.getString("consulta_acesso"));
				enviaraMenu.setText(bn.getString("enviar_arquivo"));
				userMenu.setText(bn.getString("usuario"));
				conjuntoMenu.setText(bn.getString("conjunto"));
				cadastrarMenuu.setText(bn.getString("gerenciar_usuarios"));
				cadastrarMenu.setText(bn.getString("gerenciar_funcionarios"));
				cadastrarMenucx.setText(bn.getString("gerenciar_conjuntos"));
				cadastrarMenuc.setText(bn.getString("gerenciar_empresas"));
				ApplicationViewController.applicationViewController(bn);

			}
		});

		espanishItem = new JMenuItem(bn.getString("espanhol"));
		idiomaMenuItem.add(espanishItem);
		espanishItem.addActionListener(new ActionListener() // classe interna
															// anonima
		{
			// exibe um dialogo de mensagem quando o usuario seleciona
			// Portuguese
			public void actionPerformed(ActionEvent event) {
				bn = ResourceBundle.getBundle("languages.language", new Locale("es", "ESP"));
				System.out.println("idioma alterado para => es");

				// displayJLabel.setText( bn.getString("mensagem"));
				// setTitle(bn.getString("titulo"));
				arquivoMenu.setText(bn.getString("arquivo"));
				// fileMenu.setMnemonic(bn.getString("arquivo.mnemonico").charAt(0));
				sobreMenuItem.setText(bn.getString("sobre"));
				// aboutItem.setMnemonic(bn.getString("sobre.mnemonico").charAt(0));
				idiomaMenuItem.setText(bn.getString("idioma"));
				portugueseItem.setText(bn.getString("portugues"));
				englishItem.setText(bn.getString("ingles"));
				espanishItem.setText(bn.getString("espanhol"));
				sairMenuItem.setText(bn.getString("sair"));
				// exitItem.setMnemonic(bn.getString("sair.mnemonico").charAt(0));
//				funcionarioMenu.setText(bn.getString("funcionario"));
				empresaMenu.setText(bn.getString("empresa"));
				arCondicionadoMenu.setText(bn.getString("ar_condicionado"));
				arCondicionadoMenuAlt.setText(bn.getString("temperatura"));
				acessoMenu.setText(bn.getString("acesso"));
				consultarMenu.setText(bn.getString("consulta_acesso"));
				enviaraMenu.setText(bn.getString("enviar_arquivo"));
				userMenu.setText(bn.getString("usuario"));
				conjuntoMenu.setText(bn.getString("conjunto"));
				cadastrarMenuu.setText(bn.getString("gerenciar_usuarios"));
				cadastrarMenu.setText(bn.getString("gerenciar_funcionarios"));
				cadastrarMenucx.setText(bn.getString("gerenciar_conjuntos"));
				cadastrarMenuc.setText(bn.getString("gerenciar_empresas"));
				ApplicationViewController.applicationViewController(bn);

			}
		});

		arquivoMenu.add(idiomaMenuItem);

		// exit
		sairMenuItem = new JMenuItem(bn.getString("sair"));
		arquivoMenu.add(sairMenuItem);
		sairMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}

		});
		return arquivoMenu;
	}

	/*
	 * @return JComponent menu to users (users and employee)
	 */
	public JComponent menuUser() {
		userMenu = new JMenu(bn.getString("usuario"));

		cadastrarMenuu = new JMenuItem(bn.getString("gerenciar_usuarios"));
		userMenu.add(cadastrarMenuu);
		cadastrarMenuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ApplicationViewController.redrawContentPanel(userKey);
			}

		});
		userMenu.add(menuFuncionario());
		return userMenu;
	}

	/*
	 * @return JComponent menu to Employer
	 */
	public JComponent menuFuncionario() {
//		funcionarioMenu = new JMenu(bn.getString("funcionario"));

		cadastrarMenu = new JMenuItem(bn.getString("gerenciar_funcionarios"));
//		funcionarioMenu.add(cadastrarMenu);
		cadastrarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ApplicationViewController.redrawContentPanel(employeeKey);
			}

		});
		return cadastrarMenu;
	}

	/*
	 * @return JComponent menu to Company
	 */
	public JComponent menuEmpresa() {
		empresaMenu = new JMenu(bn.getString("empresa"));

		cadastrarMenuc = new JMenuItem(bn.getString("gerenciar_empresas"));
		empresaMenu.add(cadastrarMenuc);
		cadastrarMenuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ApplicationViewController.redrawContentPanel(companyKey);
			}

		});
		return empresaMenu;
	}

	/*
	 * @return JComponent menu to Complex Building
	 */
	public JComponent menuConjunto() {
		conjuntoMenu = new JMenu(bn.getString("conjunto"));

		cadastrarMenucx = new JMenuItem(bn.getString("gerenciar_conjuntos"));
		conjuntoMenu.add(cadastrarMenucx);
		cadastrarMenucx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ApplicationViewController.redrawContentPanel(complexKey);
			}

		});
		return conjuntoMenu;
	}

	/*
	 * @return JComponent menu to Access consult and send file
	 */
	public JComponent menuAcesso() {
		acessoMenu = new JMenu(bn.getString("acesso"));

		// Consult
		consultarMenu = new JMenuItem(bn.getString("consulta_acesso"));
		acessoMenu.add(consultarMenu);
		consultarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ApplicationViewController.redrawContentPanel(accessKey);
			}

		});

		// Access
		enviaraMenu = new JMenuItem(bn.getString("enviar_arquivo"));
		acessoMenu.add(enviaraMenu);
		enviaraMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ApplicationViewController.redrawContentPanel(sendKey);
			}

		});
		return acessoMenu;
	}

	/*
	 * @return JComponent menu to Air-conditioner
	 */
	public JComponent menuArCondicionado() {
		arCondicionadoMenu = new JMenu(bn.getString("ar_condicionado"));

		arCondicionadoMenuAlt = new JMenuItem(bn.getString("temperatura"));
		arCondicionadoMenu.add(arCondicionadoMenuAlt);
		arCondicionadoMenuAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ApplicationViewController.redrawContentPanel(airConditionerKey);
			}

		});
		return arCondicionadoMenu;
	}

	/*
	 * @return JComponent menuBar with all menus
	 */
	public JComponent barraMenu() {
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
}
