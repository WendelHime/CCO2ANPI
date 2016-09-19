package br.com.cco2anpi.views.shared;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ConsultPanel {
	private JPanel consultPanel;
	private JPanel searchPanel;
	private JPanel resultPanel;
	private JPanel searchButton;
	private JPanel searchField;
	
	public ConsultPanel(){
		consultPanel = new JPanel(new BorderLayout(2, 2));
		searchPanel = new JPanel(new BorderLayout(2,10));
		searchField = new JPanel(new GridLayout(1,1));
		searchButton = new JPanel(new GridLayout(1,2,5,5));
		resultPanel = new JPanel(new BorderLayout(5, 5));
		setTopPanel();
		setResultPanel();
		consultPanel.add(searchPanel);
		consultPanel.add(resultPanel);
	}
	

	private void setTopPanel(){
		searchPanel.add(getSearchFild(),BorderLayout.NORTH);
		searchPanel.add(getSearchButton(),BorderLayout.CENTER);
	}
	private JPanel getSearchFild(){
		searchField.add(new JTextField());
		searchField.setBorder(new EmptyBorder(10, 50, 10, 50));
		return searchField;
	}
	private JPanel getSearchButton(){
		searchButton.add(new JButton("Consultar"));
		searchButton.add(new JButton("Limpar"));
		searchButton.setBorder(new EmptyBorder(0, 50, 10, 50));
		return searchButton;
	}
	private void setResultPanel(){
		resultPanel.setBorder(new TitledBorder(""));
		resultPanel.setPreferredSize(new Dimension(200, 300));
		resultPanel.add(new JLabel("NO WORKING"));
	}


	public JPanel getConsultPanel() {
		return consultPanel;
	}
}