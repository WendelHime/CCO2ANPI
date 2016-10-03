package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.cco2anpi.views.shared.ConsultPanel;
import br.com.cco2anpi.views.shared.CustomButton;

public class CompanyView extends JPanel {
//	private JPanel oPanel;
	private JTabbedPane tabbedPane;
	private JPanel join;

	private JPanel registrePanel;
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	
	private CustomButton cadButton;
	private CustomButton cleanButton;
	
	private String workingHoursTxt = "Horário de Funcionamento";
	private String workingHoursAirTxt = "Horário de Funcionamento";
	private String nameTxt = "Razao Social";
	private String companyTxt = "CNPJ";
	private String companySetTxt = "Conjunto Sitiado";
	private String hourStartTxt = "De";
	private String hourEndTxt = "Ate";
	private String temperatureTxt = "Temperatura Max";
	private String airConditionerTxt = "Ar-Condicionado";
	
	ResourceBundle bn;


	/**
	 * Constructor
	 * set all variables
	 * */
	public CompanyView(ResourceBundle bn) {
		this.bn=bn;
//		employeePanel = new JPanel();
		tabbedPane = new JTabbedPane();
		join = new JPanel(new BorderLayout(1, 1));
		
		registrePanel = new JPanel(new BorderLayout(2, 2));
		fieldsPanel = new JPanel(new BorderLayout(2, 2));
		buttonsPanel = new JPanel();
		
		cadButton = new CustomButton(bn.getString("cadastrar"));
		cleanButton = new CustomButton(bn.getString("limpar"));
		
		setButtonsPanel();
		setFildsPanel();
		joinAllPanels();
		
		setTabbedPane();
		add(tabbedPane);
		setBackground(new Color(255,255,255));
	}

	/**
	 * <b>Description</b>
	 * tabbedPane is the body of panel
	 * there are the tab of register and consult    
	 * */
	private void setTabbedPane() {
		tabbedPane.add(bn.getString("cadastrar"), registerPanel());
		tabbedPane.add(bn.getString("limpar"), new ConsultPanel().getConsultPanel());
	}
	/**
	 * <b>registerPanel</b>
	 * Panel to register a new Employee
	 * */
	private JPanel registerPanel() {
		registrePanel.add(fieldsPanel, BorderLayout.CENTER);
		registrePanel.add(join, BorderLayout.EAST);
		return registrePanel;
	}
	/**
	 * <b>setFildsPanel</b>
	 * Set all fields to panel of register
	 * */
	private void setFildsPanel() {

		JPanel campos = new JPanel(new GridLayout(3, 1, 5, 5));

		JPanel nome = new JPanel(new BorderLayout(2, 2));
		nome.setBorder(new TitledBorder(nameTxt));
		nome.add(new JTextField());

		JPanel emresa = new JPanel(new BorderLayout(2, 2));
		emresa.setBorder(new TitledBorder(companyTxt));
		emresa.add(new JTextField());

		JPanel conjemresa = new JPanel(new BorderLayout(2, 2));
		conjemresa.setBorder(new TitledBorder(companySetTxt));
		conjemresa.add(new JTextField());

		campos.add(nome);
		campos.add(emresa);
		campos.add(conjemresa);

		JPanel campos2 = new JPanel(new GridLayout(7, 2));
		
		
		JPanel de = new JPanel(new BorderLayout(2, 2));
		de.setBorder(new TitledBorder(hourStartTxt));
		de.add(new JTextField());

		JPanel ate = new JPanel(new BorderLayout(2, 2));
		ate.setBorder(new TitledBorder(hourEndTxt));
		ate.add(new JTextField());
		
	
		JPanel temp = new JPanel(new BorderLayout(2, 2));
		temp.setBorder(new TitledBorder(temperatureTxt));
		temp.add(new JTextField());

		JPanel de1 = new JPanel(new BorderLayout(2, 2));
		de1.setBorder(new TitledBorder(hourStartTxt));
		de1.add(new JTextField());

		JPanel ateq = new JPanel(new BorderLayout(2, 2));
		ateq.setBorder(new TitledBorder(hourEndTxt));
		ateq.add(new JTextField());
		

		campos2.add(new JLabel(workingHoursTxt));
		campos2.add(new JLabel(""));
		campos2.add(de);
		campos2.add(ate);
		
		
		campos2.add(new JLabel(airConditionerTxt));
		campos2.add(new JLabel(""));
		
		campos2.add(temp);
		campos2.add(new JLabel(""));
		
		
		campos2.add(new JLabel(workingHoursAirTxt));
		campos2.add(new JLabel(""));
		
		campos2.add(de1);
		campos2.add(ateq);
		
		fieldsPanel.add(campos, BorderLayout.NORTH);
		fieldsPanel.add(campos2, BorderLayout.CENTER);
	}
	/**
	 * <b>setButtonsPanel</b>
	 * Set buttons to panel of register
	 * */
	private void setButtonsPanel() {

		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		JPanel buttons = new JPanel(new BorderLayout(2, 2));
		JPanel gridButtons = new JPanel(new GridLayout(9, 1, 10, 10));
		JPanel subInterPanelButtonCad = new JPanel(new BorderLayout(2, 2));
		subInterPanelButtonCad.setBorder(null);
		subInterPanelButtonCad.add(cadButton);
		gridButtons.add(subInterPanelButtonCad);
		JPanel subInterPanelButtonClean = new JPanel(new BorderLayout(2, 2));
		subInterPanelButtonClean.setBorder(null);
		subInterPanelButtonClean.add(cleanButton);
		gridButtons.add(subInterPanelButtonClean);
		gridButtons.add(new JLabel(""));
		gridButtons.add(new JLabel(""));
		gridButtons.add(new JLabel(""));
		gridButtons.add(new JLabel(""));
		gridButtons.add(new JLabel(""));
		gridButtons.add(new JLabel(""));
		buttons.add(gridButtons);
		buttonsPanel.add(buttons);
	}
	/**
	 * <b>joinAllPanels</b>
	 * Organize Layout of the ButtonsPanel
	 * */
	private void joinAllPanels() {
		join.add(buttonsPanel, BorderLayout.EAST);
	}

	public void updateLanguage(ResourceBundle bn2) {
		cadButton.setText(bn2.getString("cadastrar"));
		cleanButton.setText(bn2.getString("limpar"));
		tabbedPane.setTitleAt(0, bn2.getString("cadastrar"));
		tabbedPane.setTitleAt(1, bn2.getString("consultar"));
	
	}
}