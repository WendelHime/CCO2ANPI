package br.com.cco2anpi.views.shared;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.cco2anpi.clients.ComplexBuildingClient;
import br.com.cco2anpi.models.ComplexBuilding;

public class ConsultPanel {
    private JPanel consultPanel;
    private JPanel searchPanel;
    private JPanel resultPanel;
    private JPanel searchButton;
    private JPanel searchField;
    private JPanel resultAreaPanel;
    private JPanel resultButtonsPanel;
    private JButton searchBtn;
    private JButton cleanButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JList resultsArea;
    private JScrollPane resultsScrollArea;

    public ConsultPanel() {
	consultPanel = new JPanel(new BorderLayout(2, 2));
	searchPanel = new JPanel(new BorderLayout(2, 10));
	searchField = new JPanel(new GridLayout(1, 1));
	searchButton = new JPanel(new GridLayout(1, 2, 5, 5));
	resultPanel = new JPanel(new BorderLayout(5, 5));
	resultAreaPanel = new JPanel(new BorderLayout(5, 5));
	resultButtonsPanel = new JPanel(new GridLayout(6, 1, 8, 2));
	searchBtn = new JButton("Consultar");
	searchBtn.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ComplexBuilding[] buildingSets = ComplexBuildingClient.getAllBuildingSets().getBody();
		ArrayList<String> complexs = new ArrayList<>();
		for (ComplexBuilding complexBuilding : buildingSets) {
		    complexs.add(complexBuilding.getNumber());
		}
		resultsArea.setListData(complexs.toArray());

	    }
	});
	cleanButton = new JButton("Limpar");
	deleteButton = new JButton("deletar");
	deleteButton.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ComplexBuilding[] buildingSets = ComplexBuildingClient.getAllBuildingSets().getBody();
		ArrayList<String> complexs = new ArrayList<>();
		for (ComplexBuilding complexBuilding : buildingSets) {
		    complexs.add(complexBuilding.getNumber());
		}
		
		ComplexBuildingClient.delete(buildingSets[resultsArea.getSelectedIndex()]);
		
	    }
	});

	updateButton = new JButton("atualizar");
	updateButton.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ComplexBuilding[] buildingSets = ComplexBuildingClient.getAllBuildingSets().getBody();
		UpdateView u = new UpdateView(buildingSets[resultsArea.getSelectedIndex()]);
		
	    }
	});
	resultsArea = new JList();
	setTopPanel();
	setResultPanel();
	consultPanel.add(searchPanel, BorderLayout.NORTH);
	consultPanel.add(resultPanel, BorderLayout.CENTER);
    }

    private void setTopPanel() {
	searchPanel.add(getSearchFild(), BorderLayout.NORTH);
	searchPanel.add(getSearchButton(), BorderLayout.CENTER);
    }

    private JPanel getSearchFild() {
	searchField.add(new JTextField());
	searchField.setBorder(new EmptyBorder(10, 50, 10, 50));
	return searchField;
    }

    private JPanel getSearchButton() {
	searchButton.add(searchBtn);
	searchButton.add(cleanButton);
	searchButton.setBorder(new EmptyBorder(0, 50, 10, 50));
	return searchButton;
    }

    private void setResultPanel() {

	resultAreaPanel.setBorder(new TitledBorder("Results"));
	resultAreaPanel.add(resultsArea);
	resultsScrollArea = new JScrollPane(resultAreaPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	resultButtonsPanel.add(updateButton);
	resultButtonsPanel.add(deleteButton);
	resultButtonsPanel.add(new JLabel(""));
	resultButtonsPanel.add(new JLabel(""));
	resultButtonsPanel.add(new JLabel(""));
	resultButtonsPanel.add(new JLabel(""));

	resultPanel.setBorder(new TitledBorder(""));
	resultPanel.add(resultsScrollArea, BorderLayout.CENTER);
	resultPanel.add(resultButtonsPanel, BorderLayout.EAST);

    }

    public JPanel getConsultPanel() {
	return consultPanel;
    }
}