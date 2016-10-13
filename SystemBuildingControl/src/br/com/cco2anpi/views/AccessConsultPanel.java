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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.cco2anpi.clients.AccessClient;
import br.com.cco2anpi.clients.ComplexBuildingClient;
import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.views.shared.DatePick;

//import controll.AppController;

/**
 * @author pitagoras
 *
 */
public class AccessConsultPanel extends JPanel {
	private JLabel nameLabel;
	private JLabel startLabel;
	private JLabel endLabel;
	private JTextField nameField;
	private TableModel dataModel;
	private JTable dataTable;
	private JScrollPane scrollpane;
    private DefaultTableModel tableModel;

	private JButton read;
	private JButton clear;
	
	private JComboBox type;
	private String types[]=	 new String[3];
	private String coluns[] = new String[5];
	private JPanel buttonsPanel;
	private JPanel fieldsPanel;
	private JPanel scrollTablePanel;
	private GridBagConstraints gbc = new GridBagConstraints();
//	private AppController baseController;
	ResourceBundle bn;
	/**
	 * Constructor of panel to ComplexBuilding's CRUD
	 * 
	 * @return
	 */
	public AccessConsultPanel(ResourceBundle bn) {
		this.bn = bn;
		setLayout(new GridBagLayout());
//		this.baseController = baseController;
		this.read = new JButton(bn.getString("consultar"));
		this.clear = new JButton(bn.getString("limpar"));
		this.nameLabel = new JLabel(bn.getString("nome"));
		this.startLabel = new JLabel(bn.getString("de"));
		this.endLabel = new JLabel(bn.getString("ate"));
		this.nameField = new JTextField(30);
		
		this.types[0] = "empresa";
		this.types[1] = "atendente";
		this.types[2] = "sindico";
		
		this.coluns[0] = "id";
		this.coluns[1] = "date_in";
		this.coluns[2] = "date_out";
		this.coluns[3] = "date_out";
		this.coluns[4] = "user_id";
		
		this.type = new JComboBox();
		
		for (int i = 0; i < types.length; i++) {
			type.addItem(types[i]);
		}
		
		setDataTable();
		setFieldsPanel();
		setButtonsPanel();

		// JFields
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 350);
		add(getFieldsPanel(), gbc);

		// JButtons
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(getButtonsPanel(), gbc);
		
		// JTable
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(10, 0, 20, 0);
		add(getDataTable(), gbc);
		
		// Listeners
		setupListeners();
		setBackground(new Color(255,255, 255));
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
		
		this.dataTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { coluns[0], coluns[1], coluns[2], coluns[3],coluns[4] }) {
			    boolean[] canEdit = new boolean[] { false, false,false, false,false };
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
	for (Access access : AccessClient.getAllAccess().getBody()) {
	    tableModel.addRow(new String[] { access.getId().toString(), access.getDateIn().toString(), access.getDateOut().toString(),access.getUser().getId().toString() });
	}
	
    }

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
		this.buttonsPanel.add(read);
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
		this.fieldsPanel.add(nameLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(nameField, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(type, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(DatePick.datePick("de",bn), gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(DatePick.datePick("ate",bn), gbc);
		
		
	}

    /**
     * setup Listeners to all buttons
     */
    public void setupListeners() {

	this.read.addActionListener(new ActionListener() {

		@Override

	    public void actionPerformed(ActionEvent click) {

		// JOptionPane.showMessageDialog(baseController.getAppFrame(),
		// "OK");
			//TODO
	}});
	this.clear.addActionListener(new ActionListener() {

	    @Override

	    public void actionPerformed(ActionEvent click) {

		// JOptionPane.showMessageDialog(baseController.getAppFrame(),
		// "OK");
		tableModel.setNumRows(0);
	    }
	});
    }
	public void updateLanguage(ResourceBundle bn2) {
		// TODO Auto-generated method stub
		this.nameLabel.setText(bn.getString("nome"));
		this.startLabel.setText(bn.getString("de"));
		this.endLabel.setText(bn.getString("ate"));
		this.read.setText(bn.getString("consultar"));
		this.clear.setText(bn.getString("limpar"));
	}
}
