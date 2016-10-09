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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

//import controll.AppController;

/**
 * @author pitagoras
 *
 */
public class CompanyPanel extends JPanel {
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel cnpjLabel;
	private JTextField cnpjField;
	private JLabel comlpexBuildingLabel;
	private JTextField comlpexBuildingField;
	private JLabel workHoursLabel;
	private JLabel startHourLabel;
	private JTextField startHourField;
	private JLabel endHourLabel;
	private JTextField endHourField;
	private JLabel airLabel;
	private JLabel temperatureLabel;
	private JTextField temperatureField;
	private JLabel airHoursLabel;
	private JLabel startAirLabel;
	private JTextField startAirField;
	private JLabel endAirLabel;
	private JTextField endAirField;
	
	private TableModel dataModel;
	private JTable dataTable;
	private JScrollPane scrollpane;
	
	private JButton create;
	private JButton update;
	private JButton delete;
	private JButton clear;
	
	private JPanel scrollTablePanel;
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
		
	private GridBagConstraints gbc = new GridBagConstraints();
//	private AppController baseController;

	/**
	 * Constructor of panel to ComplexBuilding's CRUD
	 * 
	 * @return
	 */
	public CompanyPanel(ResourceBundle bn) {

		setLayout(new GridBagLayout());
//		this.baseController = baseController;
		this.create = new JButton("criar");
		this.update = new JButton("atualizar");
		this.delete = new JButton("excluir");
		this.clear = new JButton("limpar");
		this.nameLabel = new JLabel("razao_social");
		this.nameField = new JTextField(20);
		this.cnpjLabel = new JLabel("cnpj");
		this.cnpjField = new JTextField(20);
		this.comlpexBuildingLabel = new JLabel("conjunto_sitiado");
		this.comlpexBuildingField = new JTextField(20);
		this.workHoursLabel = new JLabel("horario_de_funcionamento");
		this.startHourLabel = new JLabel("de");
		this.startHourField = new JTextField(10);
		this.endHourLabel = new JLabel("ate");
		this.endHourField = new JTextField(10);
		this.airLabel = new JLabel("ar_condicionado");
		this.temperatureLabel = new JLabel("temperatura_max");
		this.temperatureField = new JTextField(10);
		this.airHoursLabel = new JLabel("horario_de_funcionamento");
		this.startAirLabel = new JLabel("de");
		this.startAirField = new JTextField(10);
		this.endAirLabel = new JLabel("ate");
		this.endAirField = new JTextField(10);
				
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
	private void setDataTable() {
		this.dataModel = getDataModel();
		this.dataTable = new JTable(dataModel);
		this.scrollpane = new JScrollPane(dataTable);

		scrollTablePanel = new JPanel(new BorderLayout());
		scrollTablePanel.add(scrollpane, BorderLayout.CENTER);
		scrollTablePanel.setPreferredSize(new Dimension(600, 150));
		scrollTablePanel.setSize(new Dimension(600, 100));
	}

	/**
	 * 
	 * @return the dataModel
	 */
	private TableModel getDataModel() {
		return new AbstractTableModel() {
			public int getColumnCount() {
				return 10;
			}

			public int getRowCount() {
				return 10;
			}

			public Object getValueAt(int row, int col) {
				return new Integer(row * col);
			}
		};
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
		this.fieldsPanel.add(nameLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(nameField, gbc);
		
		gbc.insets = new Insets(10, 0, 0, 0);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(cnpjLabel, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(cnpjField, gbc);
		
		gbc.insets = new Insets(10, 0, 0, 0);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(comlpexBuildingLabel, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(comlpexBuildingField, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(workHoursLabel, gbc);


		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(startHourLabel, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(startHourField, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);
		
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(endHourLabel, gbc);

		gbc.insets = new Insets(0, 0, 0, 0);

		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(endHourField, gbc);

		gbc.insets = new Insets(0, 105, 0, 0);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(airLabel, gbc);
		
		gbc.insets = new Insets(10, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(temperatureLabel, gbc);
		
		gbc.insets = new Insets(0, 40, 0, 0);
		
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(temperatureField, gbc);
		
		gbc.insets = new Insets(10, 40, 0, 0);
		
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(airHoursLabel, gbc);	
		
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(startAirLabel, gbc);

		gbc.insets = new Insets(0, 40, 0, 0);
		
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(startAirField, gbc);
		
		gbc.insets = new Insets(10, 0, 0, 0);
		
		gbc.gridx = 6;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(endAirLabel, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		gbc.gridx = 6;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(endAirField, gbc);

		
	}

	/**
	 * setup Listeners to all buttons
	 */
	public void setupListeners() {

		this.create.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent click) {

//				JOptionPane.showMessageDialog(baseController.getAppFrame(), "OK");

			}
		});

		this.update.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent click) {

//				JOptionPane.showMessageDialog(baseController.getAppFrame(), "OK");

			}
		});
		this.delete.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent click) {

//				JOptionPane.showMessageDialog(baseController.getAppFrame(), "OK");

			}
		});
		this.clear.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent click) {

//				JOptionPane.showMessageDialog(baseController.getAppFrame(), "OK");

			}
		});
	}

	public void updateLanguage(ResourceBundle bn) {
		// TODO Auto-generated method stub
		
	}
}
