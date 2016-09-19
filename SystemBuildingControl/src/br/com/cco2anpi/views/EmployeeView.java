package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.cco2anpi.views.shared.ConsultPanel;

public class EmployeeView extends JPanel{
//	private JPanel employeePanel;
	private JTabbedPane tabbedPane;
	private JPanel join;

	private JPanel registrePanel;
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	
	private JButton cadButton;
	private JButton cleanButton;
	
	private String cadButtonTxt = "registrear";
	private String cleanButtonTxt = "Limpar";
	private String consultTxt = "Consultar";
	private String workingHoursText = "Horário de Trabalho";
	private String nameTxt = "Nome";
	private String companyTxt = "Empresa";
	private String txtHourStartText = "De";
	private String txtHourEndText = "Ate";
	private String authText = "Autorizacao para alterar temperatura";
	private String yesText = "Sim";
	private String noText = "Nao";

	/**
	 * Constructor
	 * set all variables
	 * */
	public EmployeeView() {
		
//		employeePanel = new JPanel();
		tabbedPane = new JTabbedPane();
		join = new JPanel(new BorderLayout(1, 1));
		
		registrePanel = new JPanel(new BorderLayout(2, 2));
		fieldsPanel = new JPanel(new BorderLayout(2, 2));
		buttonsPanel = new JPanel();
		
		cadButton = new JButton(cadButtonTxt);
		cleanButton = new JButton(cleanButtonTxt);
		
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
		tabbedPane.add(cadButtonTxt, registerPanel());
		tabbedPane.add(consultTxt, new ConsultPanel().getConsultPanel());
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

		JPanel nome = new JPanel(new BorderLayout(2, 2));
		nome.setBorder(new TitledBorder(nameTxt));
		nome.add(new JTextField());

		JPanel emresa = new JPanel(new BorderLayout(2, 2));
		emresa.setBorder(new TitledBorder(companyTxt));
		emresa.add(new JTextField());

		campos.add(nome);
		campos.add(emresa);

		JPanel campos2 = new JPanel(new GridLayout(5, 2));
		campos2.add(new JLabel(workingHoursText));
		campos2.add(new JLabel(""));
		JPanel de = new JPanel(new BorderLayout(2, 2));
		de.setBorder(new TitledBorder(txtHourStartText));
		de.add(new JTextField());

		JPanel ate = new JPanel(new BorderLayout(2, 2));
		ate.setBorder(new TitledBorder(txtHourEndText));
		ate.add(new JTextField());
		campos2.add(de);
		campos2.add(ate);
		campos2.add(new JLabel(authText));
		campos2.add(new JLabel(""));
		campos2.add(new JRadioButton(yesText));

		campos2.add(new JRadioButton(noText));
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
}