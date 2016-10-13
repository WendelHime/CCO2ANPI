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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.cco2anpi.clients.EmployerClient;
import br.com.cco2anpi.clients.EmployerClient;
import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.Employer;

//import controll.AppController;

/**
 * @author pitagoras
 *
 */
public class EmployerPanel extends JPanel {
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel cpfLabel;
	private JTextField cpfField;
	private JLabel companyLabel;
	private JTextField companyField;
	private JLabel workHoursLabel;
	private JLabel startHourLabel;
	private JTextField startHourField;
	private JLabel endHourLabel;
	private JTextField endHourField;
	private JLabel airLabel;
	private JLabel yesLabel;
	private JRadioButton yesField;
	private JLabel noLabel;
	private JRadioButton noField;
	private JLabel userNameLabel;
	private JTextField userNameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;

	private TableModel dataModel;
	private JTable dataTable;
	private JScrollPane scrollpane;
	private DefaultTableModel tableModel;

	private JButton create;
	private JButton update;
	private JButton delete;
	private JButton clear;

	private JPanel scrollTablePanel;
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;

	private GridBagConstraints gbc = new GridBagConstraints();
	// private AppController baseController;

	/**
	 * Constructor of panel to Employer's CRUD
	 * 
	 * @return
	 */
	public EmployerPanel(ResourceBundle bn) {

		setLayout(new GridBagLayout());
		// this.baseController = baseController;
		this.create = new JButton(bn.getString("cadastrar"));
		this.update = new JButton(bn.getString("alterar"));
		this.delete = new JButton(bn.getString("excluir"));
		this.clear = new JButton(bn.getString("limpar"));
		this.nameLabel = new JLabel(bn.getString("nome"));
		this.nameField = new JTextField(20);
		this.cpfLabel = new JLabel(bn.getString("cpf"));
		this.cpfField = new JTextField(20);
		this.companyLabel = new JLabel(bn.getString("empresa"));
		this.companyField = new JTextField(20);
		this.workHoursLabel = new JLabel(bn.getString("horario_de_trabalho"));
		this.startHourLabel = new JLabel(bn.getString("de"));
		this.startHourField = new JTextField(10);
		this.endHourLabel = new JLabel(bn.getString("ate"));
		this.endHourField = new JTextField(10);
		this.airLabel = new JLabel(bn.getString("altera_temperatura"));
		this.yesLabel = new JLabel(bn.getString("sim"));
		this.yesField = new JRadioButton();
		this.noLabel = new JLabel(bn.getString("nao"));
		this.noField = new JRadioButton();
		this.userNameLabel = new JLabel(bn.getString("nome_usuario"));
		this.userNameField = new JTextField(20);
		this.passwordLabel = new JLabel(bn.getString("senha"));
		this.passwordField = new JPasswordField(20);

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
	public JPanel getEmployerPanel() {
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

		this.dataTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nome", "cpf",
				"empresa", "horario trabalho", "altera temperatura", "username", "senha" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };

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
		for (Employer employer : EmployerClient.getAllEmployers().getBody()) {
			tableModel.addRow(new String[] { employer.getId().toString(), employer.getName(), employer.getCpf(),employer.getCompanies().toString(),
					employer.getOfficeHours(), employer.getPermissionTemperature().toString(), employer.getUsername(),
					employer.getPassword() });
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
		this.fieldsPanel.add(cpfLabel, gbc);

		gbc.insets = new Insets(0, 0, 0, 0);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(cpfField, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(companyLabel, gbc);

		gbc.insets = new Insets(0, 0, 0, 0);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(companyField, gbc);

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

		gbc.insets = new Insets(0, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(airLabel, gbc);

		gbc.insets = new Insets(10, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(yesLabel, gbc);

		gbc.insets = new Insets(0, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(yesField, gbc);

		gbc.insets = new Insets(10, 40, 0, 0);

		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(noLabel, gbc);

		gbc.insets = new Insets(0, 40, 0, 0);

		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(noField, gbc);

		gbc.insets = new Insets(10, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(userNameLabel, gbc);

		gbc.insets = new Insets(0, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(userNameField, gbc);

		gbc.insets = new Insets(10, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(passwordLabel, gbc);

		gbc.insets = new Insets(0, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(passwordField, gbc);
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
				Employer employer = new Employer();
				employer.setName(nameField.getText());
				employer.setCpf(cpfField.getText());
				employer.setCompanies(new HashSet<>(0));
				if (yesField.isSelected())
					employer.setPermissionTemperature(true);
				else
					employer.setPermissionTemperature(true);
				employer.setOfficeHours(startHourField+"-"+endHourField);
				employer.setUsername(userNameField.getText());
				employer.setPassword(passwordField.getText());
				EmployerClient.insert(employer);
				fillTable();
			}
		});
		this.update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				// JOptionPane.showMessageDialog(baseController.getAppFrame(),
				// "OK");
				Employer[] employee = EmployerClient.getAllEmployers().getBody();
				tableModel = (DefaultTableModel) dataTable.getModel();
				employee[dataTable.getSelectedRow()].setName(nameField.getText());
				employee[dataTable.getSelectedRow()].setCpf(cpfField.getText());
				employee[dataTable.getSelectedRow()].setCompanies(new HashSet<>(0));
				if (yesField.isSelected())
					employee[dataTable.getSelectedRow()].setPermissionTemperature(true);
				else
					employee[dataTable.getSelectedRow()].setPermissionTemperature(true);
				employee[dataTable.getSelectedRow()].setOfficeHours(startHourField+"-"+endHourField);
				employee[dataTable.getSelectedRow()].setUsername(userNameField.getText());
				employee[dataTable.getSelectedRow()].setPassword(passwordField.getText());
				EmployerClient.update(employee[dataTable.getSelectedRow()]);
				fillTable();
			}
		});
		this.delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				// JOptionPane.showMessageDialog(baseController.getAppFrame(),
				// "OK");
				Employer[] employer = EmployerClient.getAllEmployers().getBody();
				tableModel = (DefaultTableModel) dataTable.getModel();

				EmployerClient.delete(employer[dataTable.getSelectedRow()]);

				fillTable();

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
		this.nameLabel.setText(bn.getString("nome"));		
		this.cpfLabel.setText(bn.getString("cpf"));		
		this.companyLabel.setText(bn.getString("empresa"));
		this.workHoursLabel.setText(bn.getString("horario_de_trabalho"));
		this.startHourLabel.setText(bn.getString("de"));		
		this.endHourLabel.setText(bn.getString("ate"));
		this.airLabel.setText(bn.getString("altera_temperatura"));
		this.userNameLabel.setText(bn.getString("nome_usuario"));
		this.passwordLabel.setText(bn.getString("senha"));
		this.yesLabel.setText(bn.getString("sim"));
		this.noLabel.setText(bn.getString("nao"));
	}
}
