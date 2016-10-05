package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

public class EmployeeView extends JPanel{
//	private JPanel employeePanel;
	private JTabbedPane tabbedPane;
	private JPanel join;

	private JPanel registrePanel;
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	private JPanel nome;
	private JPanel empresa;
	
	private JPanel campos2;
	
	private CustomButton cadButton;
	private CustomButton cleanButton;
	private TitledBorder titleBorderName;
	private TitledBorder titleBorderCompany;
	private TitledBorder titleBorderHourStart;
	private TitledBorder titleBorderHourEnd;
	private JPanel de;
	private JPanel ate;
	
	
	private JLabel workingHoursLabel;
	private JLabel authLabel;
	private JRadioButton yesRadioButton;
	private JRadioButton noRadioButton;
	


	ResourceBundle bn;
	/**
	 * Constructor
	 * set all variables
	 * */
	public EmployeeView(ResourceBundle bn) {
		this.bn = bn;
//		employeePanel = new JPanel();
		tabbedPane = new JTabbedPane();
		join = new JPanel(new BorderLayout(1, 1));
		
		registrePanel = new JPanel(new BorderLayout(2, 2));
		fieldsPanel = new JPanel(new BorderLayout(2, 2));
		buttonsPanel = new JPanel();
		
		cadButton = new CustomButton(bn.getString("cadastrar"));
		cleanButton = new CustomButton(bn.getString("limpar"));
		titleBorderName = new TitledBorder(bn.getString("nome"));
		titleBorderCompany = new TitledBorder(bn.getString("empresa"));
		titleBorderHourStart = new TitledBorder(bn.getString("de"));
		titleBorderHourEnd = new TitledBorder(bn.getString("ate"));
		workingHoursLabel = new JLabel(bn.getString("horario_de_funcionamento"));
		authLabel = new JLabel(bn.getString("autorizacao_para_alterar_temperatura"));
		yesRadioButton = new JRadioButton(bn.getString("sim"));
		noRadioButton = new JRadioButton(bn.getString("nao"));
		
		setButtonsPanel();
		setFildsPanel();
		joinAllPanels();
		
		setTabbedPane();

		add(tabbedPane);
		setBackground(new Color(255,255,255));
	}
//	/**
//	 * <b>Description</b>
//	 * @return JPanel employeePanel
//	 * */
//	public JPanel getEmployeePanel() {
//		return employeePanel;
//	}
	/**
	 * <b>Description</b>
	 * tabbedPane is the body of panel
	 * there are the tab of register and consult    
	 * */
	private void setTabbedPane() {
		tabbedPane.add(bn.getString("cadastrar"), registerPanel());
		tabbedPane.add(bn.getString("consultar"), new ConsultPanel().getConsultPanel());
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

		JPanel campos = new JPanel(new GridLayout(2, 1, 5, 5));

		nome = new JPanel(new BorderLayout(2, 2));
		nome.setBorder(titleBorderName);
		nome.add(new JTextField());

		empresa = new JPanel(new BorderLayout(2, 2));
		empresa.setBorder(titleBorderCompany);
		empresa.add(new JTextField());

		campos.add(nome);
		campos.add(empresa);

		campos2 = new JPanel(new GridLayout(5, 2));
		campos2.add(workingHoursLabel);
		campos2.add(new JLabel(""));
		de = new JPanel(new BorderLayout(2, 2));
		de.setBorder(titleBorderHourStart);
		de.add(new JTextField());

		ate = new JPanel(new BorderLayout(2, 2));
		ate.setBorder(titleBorderHourEnd);
		ate.add(new JTextField());
		campos2.add(de);
		campos2.add(ate);
		campos2.add(authLabel);
		campos2.add(new JLabel(""));
		campos2.add(yesRadioButton);

		campos2.add(noRadioButton);
		campos2.add(new JLabel(""));
		campos2.add(new JLabel(""));

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
		
		
		nome.setBorder(new TitledBorder(bn.getString("nome")));
		empresa.setBorder(new TitledBorder(bn.getString("empresa")) );
		workingHoursLabel.setText(bn.getString("horario_de_funcionamento"));
		de.setBorder( new TitledBorder(bn.getString("de")));
		ate.setBorder( new TitledBorder(bn.getString("ate")));
		authLabel.setText(bn.getString("autorizacao_para_alterar_temperatura"));
		yesRadioButton.setText(bn.getString("sim"));
		noRadioButton.setText(bn.getString("nao"));

	}

}