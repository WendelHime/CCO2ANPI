package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.cco2anpi.clients.ComplexBuildingClient;
import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.views.shared.ConsultPanel;
import br.com.cco2anpi.views.shared.CustomButton;

public class ComplexView extends JPanel{
	private JTabbedPane tabbedPane;
	private JPanel join;
	private CustomButton cadButton;
	private CustomButton cleanButton;
	private JTextField numeroTxf;
	ResourceBundle bn;

	/**
	 * Constructor
	 * set all variables
	 * */
	public ComplexView(ResourceBundle bn) {
		this.bn=bn;
//		employeePanel = new JPanel();
		tabbedPane = new JTabbedPane();
		join = new JPanel(new BorderLayout(1, 1));
		numeroTxf = new JTextField();
		cadButton = new CustomButton(bn.getString("cadastrar"));
		cleanButton = new CustomButton(bn.getString("limpar"));
		cadButton.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ComplexBuilding complex = new ComplexBuilding();
			complex.setNumber(numeroTxf.getText());
			complex.setCompanies(new HashSet<>(0));
			ComplexBuildingClient.insert(complex);
		    }
		});
		
		
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
		tabbedPane.add(bn.getString("cadastrar"), joinAllPanels());
		tabbedPane.add(bn.getString("limpar"), new ConsultPanel().getConsultPanel());
	}
	/**
	 * <b>joinAllPanels</b>
	 * Organize Layout of the ButtonsPanel
	 * */
	private JPanel joinAllPanels() {
		join.add(new JLabel("Numero Conjunto"), BorderLayout.NORTH);
		join.add(numeroTxf, BorderLayout.CENTER);
		join.add(cadButton,BorderLayout.WEST);
		return join;
	}

	public void updateLanguage(ResourceBundle bn2) {
		cadButton.setText(bn2.getString("cadastrar"));
		cleanButton.setText(bn2.getString("limpar"));
		tabbedPane.setTitleAt(0, bn2.getString("cadastrar"));
		tabbedPane.setTitleAt(1, bn2.getString("consultar"));
	
	}

}