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

//import javax.swing.CustomButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.cco2anpi.clients.CompanyClient;
import br.com.cco2anpi.clients.ComplexBuildingClient;
import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.models.IComplexBuilding;
import br.com.cco2anpi.views.shared.CustomButton;

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
	private DefaultTableModel tableModel;

	private CustomButton create;
	private CustomButton update;
	private CustomButton delete;
	private CustomButton clear;
	
	private String[] coluns = new String[7];

	private JPanel scrollTablePanel;
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	private	ResourceBundle bn;
	private GridBagConstraints gbc = new GridBagConstraints();
	// private AppController baseController;

	/**
	 * Constructor of panel to ComplexBuilding's CRUD
	 * 
	 * @return
	 */
	public CompanyPanel(ResourceBundle bn) {
		this.bn = bn;
		setLayout(new GridBagLayout());
		// this.baseController = baseController;
		this.create = new CustomButton(bn.getString("cadastrar"));
		this.update = new CustomButton(bn.getString("alterar"));
		this.delete = new CustomButton(bn.getString("excluir"));
		this.clear = new CustomButton(bn.getString("limpar"));
		this.nameLabel = new JLabel(bn.getString("razao_social"));
		this.nameField = new JTextField(20);
		this.cnpjLabel = new JLabel(bn.getString("cnpj"));
		this.cnpjField = new JTextField(20);
		this.comlpexBuildingLabel = new JLabel(bn.getString("conjunto_sitiado"));
		this.comlpexBuildingField = new JTextField(20);
		this.workHoursLabel = new JLabel(bn.getString("horario_de_funcionamento"));
		this.startHourLabel = new JLabel(bn.getString("de"));
		this.startHourField = new JTextField(10);
		this.endHourLabel = new JLabel(bn.getString("ate"));
		this.endHourField = new JTextField(10);
		this.airLabel = new JLabel(bn.getString("ar_condicionado"));
		this.temperatureLabel = new JLabel(bn.getString("temperatura_maxima"));
		this.temperatureField = new JTextField(10);
		this.airHoursLabel = new JLabel(bn.getString("horario_de_funcionamento"));
		this.startAirLabel = new JLabel(bn.getString("de"));
		this.startAirField = new JTextField(10);
		this.endAirLabel = new JLabel(bn.getString("ate"));
		this.endAirField = new JTextField(10);

		this.coluns[0]="Id";
		this.coluns[1]="CNPJ";
		this.coluns[2]="Social";
		this.coluns[3]="Conjunto";
		this.coluns[4]="horario_de_funcionamento";
		this.coluns[5]="Temperatura";
		this.coluns[6]="Horario_Ar-Cond";
		
		
		setDataTable();
		setFieldsPanel();
		setButtonsPanel();

		// JTable
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 20, 0);
		add(getDataTable(), gbc);

		// JFields
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 150, 350);
		add(getFieldsPanel(), gbc);

		// CustomButtons
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 100, 100, 100);
		gbc.fill = GridBagConstraints.HORIZONTAL;
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

		this.dataTable = new JTable(new DefaultTableModel(new Object[][] {}, coluns) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		this.dataTable.setBackground(new Color(255, 255, 255));
		fillTable();

		this.scrollpane = new JScrollPane(dataTable);
		this.scrollpane.getViewport().setBackground(dataTable.getBackground());

		scrollTablePanel = new JPanel(new BorderLayout());
		scrollTablePanel.add(scrollpane, BorderLayout.CENTER);
		scrollTablePanel.setSize(new Dimension(600, 100));
		scrollTablePanel.setPreferredSize(new Dimension(600, 100));
		scrollTablePanel.setMinimumSize(new Dimension(600, 100));
		scrollTablePanel.setMaximumSize(new Dimension(600, 100));
		this.scrollTablePanel.setBackground(new Color(255, 255, 255));

	}

	private void fillTable() {
		tableModel = (DefaultTableModel) this.dataTable.getModel();
		tableModel.setNumRows(0);
		for (Company company : CompanyClient.getAllCompanies().getBody()) {
			tableModel.addRow(new String[] { company.getId().toString(), company.getCnpj().toString(),
					company.getSocialReason().toString(), company.getComplexBuilding().toString(),
					company.getBusinessHours().toString(), company.getMaximumTemperature().toString(),
					company.getAirConditionerHours().toString() });
		}

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

				// JOptionPane.showMessageDialog(baseController.getAppFrame(),
				// "OK");
				Company company = new Company();
				company.setCnpj(cnpjField.getText());
				company.setSocialReason(nameField.getText());
				ComplexBuilding complexBuilding = new ComplexBuilding();
				complexBuilding.setNumber(comlpexBuildingField.getText());
				company.setComplexBuilding(
						(IComplexBuilding) ComplexBuildingClient.getComplexBuilding(complexBuilding));
				company.setBusinessHours(startHourField.getText() + "-" + endHourField.getText());
				company.setMaximumTemperature(Double.parseDouble(temperatureField.getText()));
				company.setAirConditionerHours(startAirField.getText() + "-" + endAirField.getText());
				company.setEmployers(new HashSet<>(0));
				CompanyClient.insert(company);
				fillTable();
			}
		});

		this.update.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent click) {

				// JOptionPane.showMessageDialog(baseController.getAppFrame(),
				// "OK");
				Company[] companies = CompanyClient.getAllCompanies().getBody();
				tableModel = (DefaultTableModel) dataTable.getModel();
				companies[dataTable.getSelectedRow()].setCnpj(cnpjField.getText());
				companies[dataTable.getSelectedRow()].setSocialReason(nameField.getText());
				ComplexBuilding complexBuilding = new ComplexBuilding();
				complexBuilding.setNumber(comlpexBuildingField.getText());
				companies[dataTable.getSelectedRow()].setComplexBuilding(
						(IComplexBuilding) ComplexBuildingClient.getComplexBuilding(complexBuilding));
				companies[dataTable.getSelectedRow()]
						.setBusinessHours(startHourField.getText() + "-" + endHourField.getText());
				companies[dataTable.getSelectedRow()]
						.setMaximumTemperature(Double.parseDouble(temperatureField.getText()));
				companies[dataTable.getSelectedRow()]
						.setAirConditionerHours(startAirField.getText() + "-" + endAirField.getText());

				CompanyClient.update(companies[dataTable.getSelectedRow()]);

				tableModel.setNumRows(0);
				for (Company company : CompanyClient.getAllCompanies().getBody()) {
					tableModel.addRow(new String[] { company.getId().toString(), company.getCnpj(), company.getSocialReason(),
													 company.getComplexBuilding().getNumber(),company.getBusinessHours(),
													 company.getMaximumTemperature().toString(), company.getAirConditionerHours() });
				}

			}
		});
		this.delete.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent click) {

				// JOptionPane.showMessageDialog(baseController.getAppFrame(),
				// "OK");
				Company[] companies = CompanyClient.getAllCompanies().getBody();
				tableModel = (DefaultTableModel) dataTable.getModel();

				CompanyClient.delete(companies[dataTable.getSelectedRow()]);

				tableModel.setNumRows(0);
				for (Company company : CompanyClient.getAllCompanies().getBody()) {
					tableModel.addRow(
							new String[] { company.getId().toString(), company.getCnpj(), company.getSocialReason(),
										   company.getComplexBuilding().getNumber(), company.getBusinessHours(),
										   company.getMaximumTemperature().toString(), company.getAirConditionerHours() });
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
		this.nameLabel.setText(bn.getString("razao_social"));		
		this.cnpjLabel.setText(bn.getString("cnpj"));		
		this.comlpexBuildingLabel.setText(bn.getString("conjunto_sitiado"));
		this.workHoursLabel.setText(bn.getString("horario_de_funcionamento"));
		this.startHourLabel.setText(bn.getString("de"));		
		this.endHourLabel.setText(bn.getString("ate"));
		this.airLabel.setText(bn.getString("ar_condicionado"));
		this.temperatureLabel.setText(bn.getString("temperatura_maxima"));		
		this.airHoursLabel.setText(bn.getString("horario_de_funcionamento"));
		this.startAirLabel.setText(bn.getString("de"));
		this.endAirLabel.setText(bn.getString("ate"));
		
	}
}
