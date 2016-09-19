package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.cco2anpi.views.shared.CustomButton;
import br.com.cco2anpi.views.shared.DatePick;

public class ConsultAccessBuildingView extends JPanel{
	private JPanel contentPanel;
	private JPanel searchPanel;
	private JPanel fieldPanel;
	private JPanel resultPanel;
	private JPanel chooseDatePanel;
	private JPanel joinPanels;

	private String searchPanelTitle = "search";
	private String resultPanelTitle = "Results";
	private String consultButtonName = "Consult";
	private String cleanButtonName = "Clean";
	private String txtDateStart = "De";
	private String txtDateEnd = "Ate";

	/**
	 * Constructor set all variables and panels
	 */
	public ConsultAccessBuildingView() {
		
		contentPanel = new JPanel();
		searchPanel = new JPanel(new BorderLayout(2, 2));
		fieldPanel = new JPanel(new GridLayout(1, 3));
		resultPanel = new JPanel(new BorderLayout(2, 2));
		chooseDatePanel = new JPanel();
		joinPanels = new JPanel(new BorderLayout(1, 1));
		setconsultAccessBuildingPanel();
		setBackground(new Color(255,255,255));

	}

	/**
	 * <b>setconsultAccessBuildingPanel</b> set all items of
	 * consultAccessBuildingView
	 */
	private void setconsultAccessBuildingPanel() {

		setFieldPanel();
		setSearchPanel();
		setResultPanel();
		setContentPanel();
		setChooseDatePanel();
		joinAllPanels();

		this.add(contentPanel, BorderLayout.CENTER);
		this.add(joinPanels, BorderLayout.EAST);
	}

	/**
	 * <b>joinAllPanels</b> joinAllPanels is a adaptation to left pane, where
	 * stay the JComboBoxes
	 */
	private void joinAllPanels() {
		joinPanels.add(chooseDatePanel, BorderLayout.EAST);
	}

	/**
	 * <b>setChooseDatePanel</b> set JComboBoxes group
	 */
	private void setChooseDatePanel() {

		chooseDatePanel.setLayout(new BoxLayout(chooseDatePanel, BoxLayout.Y_AXIS));

		JPanel chooseDate = new JPanel(new BorderLayout(2, 2));
		JPanel dates = new JPanel(new GridLayout(3, 1));

		dates.add(panelJComboBoxes());
		chooseDate.add(dates);
		chooseDatePanel.add(chooseDate);
	}

	/**
	 * <b>setContentPanel</b> set search components group
	 */
	private void setContentPanel() {
		contentPanel.add(searchPanel, BorderLayout.NORTH);
		contentPanel.add(resultPanel, BorderLayout.SOUTH);
	}

	/**
	 * <b>setSearchPanel</b> set search components group
	 */
	private void setSearchPanel() {
		searchPanel.setBorder(new TitledBorder(searchPanelTitle));
		searchPanel.add(new JTextField(), BorderLayout.NORTH);
		searchPanel.add(fieldPanel, BorderLayout.CENTER);
	}

	/**
	 * <b>setFieldPanel</b> set fieldPanel, a component to search
	 */
	private void setFieldPanel() {
		fieldPanel.add(new CustomButton(consultButtonName));
		fieldPanel.add(new CustomButton(cleanButtonName));
		fieldPanel.add(new JLabel(""));// to space
	}

	/**
	 * <b>setResultPanel</b> set results components group
	 */
	private void setResultPanel() {
		resultPanel.setBorder(new TitledBorder(resultPanelTitle));
		resultPanel.add(new JTextArea(5,10));
	}

	/**
	 * @return JPanel with JComboBoxes to chooseDatePanel
	 */
	public JPanel panelJComboBoxes() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		JPanel panelDateStart = DatePick.datePick(txtDateStart);
		JPanel panelDateEnd = DatePick.datePick(txtDateEnd);
		panel.add(panelDateStart);
		panel.add(panelDateEnd);
		return panel;
	}

}
