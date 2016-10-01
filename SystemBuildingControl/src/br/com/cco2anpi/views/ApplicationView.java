package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import br.com.cco2anpi.views.shared.ImgUtils;
import br.com.cco2anpi.views.shared.Menu;

public class ApplicationView extends JFrame {

	private static JPanel contentPanel = null;
	private static JPanel dashBoardPanel = null;
	private static JPanel applicationPane = null;
	
	private static JPanel blanckPane = null;

	private BufferedImage img;
	private JLabel picLabel;
	private JLabel nome;
	private JLabel funcao;
	private JLabel empresa;

	private static String frameTitle = "Sistema de controle predial";
	private String nomeTxt = "nome";
	private String funcaoTxt = "funcao";
	private String empresaTxt = "empresa";
	
	File currentDirFile = new File("");
	String helper = currentDirFile.getAbsolutePath();
	
	
	private String imgLocation = helper+"\\src\\main\\resources\\images\\image-placeholder.png";
	
	
	public static String employeeKey = "ecadastro/econsulta";
	public static String companyKey = "ccadastro/cconsulta";
	public static String airConditionerKey = "Ar-Condicionado";
	public static String accessKey = "Consultar Acessos";
	public static String sendKey = "Enviar Arquivo";
	public static String blanckKey = "inicio";

	/**
	 * Constructor Set all variables and show the Frame ApplicationView
	 * 
	 * @param consultAccessBuildingView
	 * @param airConditionerView
	 * @param companyView
	 * @param employeeView
	 */
	public ApplicationView(EmployeeView employeeView, CompanyView companyView, AirConditionerView airConditionerView,
			ConsultAccessBuildingView consultAccessBuildingView,SendFileView sendFileView) {

		super(frameTitle);
		dashBoardPanel = new JPanel();
		contentPanel = new JPanel();
		applicationPane = new JPanel();

		img = new ImgUtils().scaleImage(240, 180, imgLocation);
		picLabel = new JLabel(new ImageIcon(img));
		nome = new JLabel(nomeTxt);
		funcao = new JLabel(funcaoTxt);
		empresa = new JLabel(empresaTxt);

		setdashBoardPanel();
		setContentpanel(employeeView, companyView, airConditionerView, consultAccessBuildingView, sendFileView );
		setApplicationPane();

		setSize(1024, 720);
		JMenuBar bar = new Menu().getJMenuBar();
		bar.setBackground(new Color(255, 255, 255));
		setJMenuBar(bar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		add(applicationPane);

	}

	/**
	 * Set applicationPane content, dashBoardPanel and contentPanel
	 */
	private void setApplicationPane() {

		applicationPane.setLayout(new BorderLayout());
		applicationPane.add(dashBoardPanel, BorderLayout.WEST);
		applicationPane.add(contentPanel, BorderLayout.CENTER);

	}

	/**
	 * <b>Description</b> Set dashBoardPanel with photo, name, company and
	 * function of user! customs labels Not implemented!!!
	 */
	private void setdashBoardPanel() {

		dashBoardPanel.setLayout(new BoxLayout(dashBoardPanel, BoxLayout.Y_AXIS));
		dashBoardPanel.setBackground(new Color(255, 255, 255));

		dashBoardPanel.add(picLabel);
		dashBoardPanel.add(nome);
		dashBoardPanel.add(funcao);
		dashBoardPanel.add(empresa);
		dashBoardPanel.setSize(100, 720);
		dashBoardPanel.setMaximumSize(dashBoardPanel.getSize());
	}

	/**
	 * <b>Description</b> Set contentPanel A JPanel CardLayout with all views of
	 * application
	 */
	private void setContentpanel(EmployeeView employeeView, CompanyView companyView,
			AirConditionerView airConditionerView, ConsultAccessBuildingView consultAccessBuildingView, SendFileView sendFileView) {

		contentPanel.setLayout(new CardLayout());
		blanckPane = new JPanel();
		blanckPane.setBackground(new Color(255, 255, 255));

		contentPanel.add(blanckPane, blanckKey);
		contentPanel.add(employeeView, employeeKey);
		contentPanel.add(companyView, companyKey);
		contentPanel.add(airConditionerView, airConditionerKey);
		contentPanel.add(consultAccessBuildingView, accessKey);
		contentPanel.add(sendFileView, sendKey);

		contentPanel.setBackground(new Color(255, 255, 255));
	}

	/**
	 * <b>Description</b> This method is start with a action in menu item and
	 * redraw the contentPanel of application
	 * 
	 * @param String
	 *            key to contentPanel
	 */
	public void redrawContentPanel(String namePanel) {
		System.out.println("cheguei no redraw da view com " + namePanel);
		CardLayout cl = (CardLayout) (contentPanel.getLayout());
		System.out.println((String) namePanel);
		cl.show(contentPanel, (String) namePanel);
	}

}
