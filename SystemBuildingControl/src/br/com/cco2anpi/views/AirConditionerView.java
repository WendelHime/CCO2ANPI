package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.cco2anpi.views.shared.CustomButton;

public class AirConditionerView extends JPanel {
	private JPanel headPanel;
	private JPanel labelsPanel;
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	private JPanel joinPanels;

	private JLabel lblTitle;
	private JLabel lblDescription;
	private JLabel lblTemperature;
	private JLabel lblWorkingHours;
	
	private JTextField txtHourStart;
	private JTextField txtHourEnd;
	private JTextField txtTemperature;
	CustomButton sendButton;

	ResourceBundle bn;
	/**
	 * Constructor set all variables
	 */
	public AirConditionerView(ResourceBundle bn) {
		this.bn=bn;
		headPanel = new JPanel(new GridLayout(3, 1, 1, 10));
		labelsPanel = new JPanel(new GridLayout(1, 2, 1, 1));
		fieldsPanel = new JPanel(new BorderLayout(2, 2));
		buttonsPanel = new JPanel(new BorderLayout(2, 2));
		joinPanels = new JPanel(new BorderLayout(1, 1));

		lblTitle = new JLabel(bn.getString("temperatura"), JLabel.CENTER);
		lblDescription = new JLabel(bn.getString("nova_configuracao"), JLabel.CENTER);

		lblTemperature = new JLabel(bn.getString("temperatura_maxima"));
		txtTemperature = new JTextField(10);

		lblWorkingHours = new JLabel(bn.getString("horario_de_funcionamento"));
		txtHourEnd = new JTextField(5);
		txtHourStart = new JTextField(5);
		sendButton = new CustomButton(bn.getString("enviar"));
		setArCondicionadoView();
		setBackground(new Color(255, 255, 255));
	}

	/**
	 * <b>Description</b> headPanel is the panel to head of panel
	 * 
	 * lblTitle label to title. lblDescription label to short description.
	 */
	private void setHead() {
		headPanel.add(lblTitle);
		headPanel.add(lblDescription);
		headPanel.add(new JLabel(""));// void label to break line between head
										// and content
	}

	/**
	 * <b>Description</b> labelsPanel intern panel to the set of label
	 * concerning the temperature.
	 * 
	 * lblTemperature label concerning the temperature. lblWorkingHours labels
	 * concerning the operation time of the air conditioner.
	 */
	private void setLabels() {
		labelsPanel.add(lblTemperature);
		labelsPanel.add(lblWorkingHours);
	}

	/**
	 * <b>setFields()</b> fieldsPanel is the panel to content to
	 * airConditionerPanel
	 * 
	 * temperatureInterPanel intern panel to the set of label and field
	 * concerning the temperature. temperatureSubInterPanel subIntern panel to
	 * field concerning the temperature. workingHoursInternPanel intern panel
	 * concerning the operation time of the air conditioner. hour1SubInternPanel
	 * subIntern panel refers the time that the air conditioner is on.
	 * hour2SubInternPanel subIntern panel refers the time that the air
	 * conditioner is off.
	 */
	private void setFields() {

		// Intern Panels
		JPanel temperatureInterPanel = new JPanel(new GridLayout(1, 1, 1, 1));
		JPanel temperatureSubInterPanel = new JPanel(new BorderLayout(2, 2));
		JPanel workingHoursInternPanel = new JPanel(new GridLayout(1, 2, 1, 1));
		JPanel hour1SubInternPanel = new JPanel(new BorderLayout(2, 2));
		JPanel hour2SubInternPanel = new JPanel(new BorderLayout(2, 2));

		// set subIntern panel of temperatureInterPanel
		temperatureSubInterPanel.setBorder(new TitledBorder("ºC"));
		temperatureSubInterPanel.add(txtTemperature);

		// add subIntern panels to intern pane temperatureInterPanel
		temperatureInterPanel.add(temperatureSubInterPanel);

		// set subIntern panels of workingHoursInternPanel
		hour1SubInternPanel.setBorder(new TitledBorder(bn.getString("de")));
		hour1SubInternPanel.add(txtHourStart);
		hour2SubInternPanel.setBorder(new TitledBorder(bn.getString("ate")));
		hour2SubInternPanel.add(txtHourEnd);

		// add subIntern panels to intern pane workingHoursInternPanel
		workingHoursInternPanel.add(hour1SubInternPanel);
		workingHoursInternPanel.add(hour2SubInternPanel);

		// Add intern panes to fieldsPanel
		fieldsPanel.add(temperatureInterPanel);
		fieldsPanel.add(workingHoursInternPanel, BorderLayout.EAST);

	}

	/**
	 * <b>setButton()</b> JPanel buttonsPanel buttons to airConditionerPanel
	 */
	private void setButton() {

		// intern panel to buttonsPane
		JPanel buttonsInterpanelPanel = new JPanel(new GridLayout(2, 2, 1, 1));

		// set intern panel
		buttonsInterpanelPanel.add(new JLabel(""));
		buttonsInterpanelPanel.add(new JLabel(""));
		buttonsInterpanelPanel.add(new JLabel(""));
		buttonsInterpanelPanel.add(sendButton);

		// add intern panel to buttonsPanel
		buttonsPanel.add(buttonsInterpanelPanel);
	}

	/**
	 * <b>joinAllPanels()</b> joinPanels is a set of panes of labels fields and
	 * buttons to airConditionerPanel
	 */
	private void joinAllPanels() {
		joinPanels.add(labelsPanel, BorderLayout.NORTH);
		joinPanels.add(fieldsPanel, BorderLayout.CENTER);
		joinPanels.add(buttonsPanel, BorderLayout.SOUTH);
	}

	/**
	 * Set all components of ArCondicionadoView
	 */
	private void setArCondicionadoView() {
		setHead();
		setLabels();
		setFields();
		setButton();
		joinAllPanels();
		this.add(headPanel, BorderLayout.NORTH);
		this.add(joinPanels);
	}

	public void updateLanguage(ResourceBundle bn) {
	
		lblTitle.setText(bn.getString("temperatura"));
		lblDescription.setText(bn.getString("nova_configuracao"));
		lblTemperature.setText(bn.getString("temperatura_maxima"));
		lblWorkingHours.setText(bn.getString("horario_de_funcionamento"));
		sendButton.setText(bn.getString("enviar"));
	}
}
