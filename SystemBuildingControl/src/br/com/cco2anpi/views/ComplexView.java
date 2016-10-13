package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.cco2anpi.clients.ComplexBuildingClient;
import br.com.cco2anpi.models.ComplexBuilding;

public class ComplexView extends JPanel {
    private JLabel numberLabel;
    private JTextField numberField;
    // private TableModel dataModel;
    private JTable dataTable;
    private JScrollPane scrollpane;
    private JButton create;
    private JButton update;
    private JButton delete;
    private JButton clear;
    private JPanel buttonsPanel;
    private JPanel fieldsPanel;
    private JPanel scrollTablePanel;
    private GridBagConstraints gbc = new GridBagConstraints();
    private DefaultTableModel tableModel;
    // private AppController baseController;
    
    /**
     * Constructor of panel to ComplexBuilding's CRUD
     * 
     * @return
     */
    public ComplexView(ResourceBundle bn) {

	setLayout(new GridBagLayout());
	// this.baseController = baseController;
	this.create = new JButton(bn.getString("cadastrar"));
	this.update = new JButton(bn.getString("alterar"));
	this.delete = new JButton(bn.getString("excluir"));
	this.clear = new JButton(bn.getString("limpar"));
	this.numberLabel = new JLabel(bn.getString("numero_conjunto"));
	this.numberField = new JTextField(20);

	setDataTable();
	setFieldsPanel();
	setButtonsPanel();

	// JTable
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.gridwidth = 3;
	gbc.insets = new Insets(0, 0, 20, 0);
	add(getDataTable(), gbc);

	// JFields
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.insets = new Insets(0, 0, 150, 350);
	add(getFieldsPanel(), gbc);

	// JButtons
	gbc.gridx = 0;
	gbc.gridy = 2;
	gbc.gridwidth = 3;
	gbc.insets = new Insets(0, 10, 100, 0);
	add(getButtonsPanel(), gbc);

	// Listeners
	setupListeners();
	setBackground(new Color(255, 255, 255));

    }

    /**
     * @return This panel
     */
    public JPanel getComplexBuildingPanel() {
	return this;
    }

    /**
     * @return the dataTable
     */
    private JPanel getDataTable() {
	return scrollTablePanel;
    }

    /**
     * @param dataTable
     *            the dataTable to set
     */
    @SuppressWarnings("serial")
    private void setDataTable() {
		// this.dataModel = getDataModel();
		
		this.dataTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Numero" }) {
			    boolean[] canEdit = new boolean[] { false, false };
			    public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			    }
			});
		
		fillTable();
	
		this.scrollpane = new JScrollPane(dataTable);
	
		scrollTablePanel = new JPanel(new BorderLayout());
		scrollTablePanel.add(scrollpane, BorderLayout.CENTER);
		scrollTablePanel.setPreferredSize(new Dimension(600, 150));
		scrollTablePanel.setSize(new Dimension(600, 100));
    }

    private void fillTable() {
	tableModel = (DefaultTableModel) this.dataTable.getModel();
	tableModel.setNumRows(0);
	for (ComplexBuilding complexBuilding : ComplexBuildingClient.getAllBuildingSets().getBody()) {
	    tableModel.addRow(new String[] { complexBuilding.getId().toString(), complexBuilding.getNumber() });
	}
	
    }
    

    // /**
    // *
    // * @return the dataModel
    // */
    // private TableModel getDataModel() {
    // return new DefaultTableModel(
    // new Object [][]
    // {
    //
    // },
    // new String []
    // {
    // "Id", "Descrição", "Preço", "Quantidade"
    // }
    // ) {
    // boolean[] canEdit = new boolean []
    // {
    // false, false, false, false
    // };
    //
    // public boolean isCellEditable(int rowIndex, int columnIndex)
    // {
    // return canEdit [columnIndex];
    // }
    // });)
    // }
    // tblItensCompra.addMouseListener(new MouseAdapter()
    // {
    // public void mouseClicked(MouseEvent evt)
    // {
    // tblItensCompraMouseClicked(evt);
    // }
    // });

    /**
     * @return the buttonsLayout
     */
    private JPanel getButtonsPanel() {
	return buttonsPanel;
    }

    /**
     * Set buttonsPanel
     */
    private void setButtonsPanel() {
	this.buttonsPanel = new JPanel(new GridLayout(1, 5, 10, 0));
	this.buttonsPanel.add(create);
	this.buttonsPanel.add(update);
	this.buttonsPanel.add(delete);
	this.buttonsPanel.add(new JLabel(""));
	this.buttonsPanel.add(clear);
    }

    /**
     * @return the fieldsLayout
     */
    private JPanel getFieldsPanel() {
	return fieldsPanel;
    }

    /**
     * @param fieldsLayout
     *            the fieldsLayout to set
     */
    private void setFieldsPanel() {

	this.fieldsPanel = new JPanel(new GridBagLayout());
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;

	this.fieldsPanel.add(numberLabel, gbc);
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	this.fieldsPanel.add(numberField, gbc);

    }

    /**
     * setup Listeners to all buttons
     */
    public void setupListeners() {

	this.create.addActionListener(new ActionListener() {

	    @Override

	    public void actionPerformed(ActionEvent click) {

		// JOptionPane.showMessageDialog(baseController.getAppFrame(),
		// "OK");
		ComplexBuilding complex = new ComplexBuilding();
		complex.setNumber(numberField.getText());
		complex.setCompanies(new HashSet<>(0));
		ComplexBuildingClient.insert(complex);
		fillTable();
	    }
	});

	this.update.addActionListener(new ActionListener() {

		@Override

	    public void actionPerformed(ActionEvent click) {

		// JOptionPane.showMessageDialog(baseController.getAppFrame(),
		// "OK");
			ComplexBuilding[] complex =ComplexBuildingClient.getAllBuildingSets().getBody();
			tableModel = (DefaultTableModel) dataTable.getModel();
			complex[dataTable.getSelectedRow()].setNumber(numberField.getText());
			
	    		
	    		
			 ComplexBuildingClient.update(complex[dataTable.getSelectedRow()]);
	    		
	    		tableModel.setNumRows(0);
	    		for (ComplexBuilding complexBuilding : ComplexBuildingClient.getAllBuildingSets().getBody()) {
	    		    tableModel.addRow(new String[] { complexBuilding.getId().toString(), complexBuilding.getNumber() });
	    		}

	    }
	});
	this.delete.addActionListener(new ActionListener() {

	    @Override

	    public void actionPerformed(ActionEvent click) {

		// JOptionPane.showMessageDialog(baseController.getAppFrame(),
		// "OK");
	    	ComplexBuilding[] complex =ComplexBuildingClient.getAllBuildingSets().getBody();
			tableModel = (DefaultTableModel) dataTable.getModel();
			
			
	    		
	    		
			 ComplexBuildingClient.delete(complex[dataTable.getSelectedRow()]);
	    		
	    		tableModel.setNumRows(0);
	    		for (ComplexBuilding complexBuilding : ComplexBuildingClient.getAllBuildingSets().getBody()) {
	    		    tableModel.addRow(new String[] { complexBuilding.getId().toString(), complexBuilding.getNumber() });
	    		}

	    }
	});
	this.clear.addActionListener(new ActionListener() {

	    @Override

	    public void actionPerformed(ActionEvent click) {

		// JOptionPane.showMessageDialog(baseController.getAppFrame(),
		// "OK");
		tableModel.setNumRows(0);
	    }
	});
    }
    public void updateLanguage(ResourceBundle bn) {
		// TODO Auto-generated method stub
		this.create.setText(bn.getString("cadastrar"));
		this.update.setText(bn.getString("alterar"));
		this.delete.setText(bn.getString("excluir"));
		this.clear.setText(bn.getString("limpar"));
		this.numberLabel.setText(bn.getString("numero_conjunto"));		
	}
}
