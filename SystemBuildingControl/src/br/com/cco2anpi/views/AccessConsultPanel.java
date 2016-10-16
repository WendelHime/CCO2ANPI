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
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.cco2anpi.clients.AccessClient;
import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.views.shared.CustomButton;
import br.com.cco2anpi.views.shared.DatePick;
import br.com.cco2anpi.views.shared.DatePick2;

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

	private CustomButton read;
	private CustomButton clear;
	
	private DatePick datePickFrom;
	private DatePick2 datePickTo;
	
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
		this.read = new CustomButton(bn.getString("consultar"));
		this.clear = new CustomButton(bn.getString("limpar"));
		this.nameLabel = new JLabel(bn.getString("nome"));
		this.startLabel = new JLabel(bn.getString("de"));
		this.endLabel = new JLabel(bn.getString("ate"));
		this.nameField = new JTextField(30);
		
		this.datePickFrom = new DatePick(bn);
		this.datePickTo = new DatePick2(bn);
		this.types[0] = "empresa";
		this.types[1] = "atendente";
		this.types[2] = "sindico";
		
		this.coluns[0] = "id";
		this.coluns[1] = "date_in";
		this.coluns[2] = "date_out";
		this.coluns[3] = "date_out";
		this.coluns[4] = "user_id";
		
		this.type = new JComboBox();
		this.type.setBackground(new Color(255, 255, 255));

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

		// CustomButtons
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
		this.dataTable.setBackground(new Color(255, 255, 255));
		fillTable();
	
		this.scrollpane = new JScrollPane(dataTable);
		this.scrollpane.getViewport().setBackground(dataTable.getBackground());

		this.scrollTablePanel = new JPanel(new BorderLayout());
		this.scrollTablePanel.add(scrollpane, BorderLayout.CENTER);
		this.scrollTablePanel.setPreferredSize(new Dimension(600, 100));
		this.scrollTablePanel.setMinimumSize(new Dimension(600, 100));
		this.scrollTablePanel.setMaximumSize(new Dimension(600, 100));
		this.scrollTablePanel.setBackground(new Color(255, 255, 255));

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
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.setBackground(new Color(255, 255, 255));
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
		this.fieldsPanel.setBackground(new Color(255, 255, 255));

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
		setDatapick();
		
		
		
	}

    private void setDatapick() {
    	gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(startLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(datePickFrom.getDatePick(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(endLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(datePickTo.getDatePick(), gbc);		
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
		this.nameLabel.setText(bn2.getString("nome"));
		this.startLabel.setText(bn2.getString("de"));
		this.endLabel.setText(bn2.getString("ate"));
		this.read.setText(bn2.getString("consultar"));
		this.clear.setText(bn2.getString("limpar"));
		datePickTo.updateLanguageDatePick(bn2);
		datePickFrom.updateLanguageDatePick(bn2);

		setDatapick();
	}
}
