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

//import javax.swing.CustomButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.cco2anpi.clients.UserClient;
import br.com.cco2anpi.models.User;
import br.com.cco2anpi.views.shared.CustomButton;

//import controll.AppController;

/**
 * @author pitagoras
 *
 */
public class UserPanel extends JPanel {
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel cpfLabel;
	private JTextField cpfField;
	private JLabel workHoursLabel;
	private JLabel startHourLabel;
	private JTextField startHourField;
	private JLabel endHourLabel;
	private JTextField endHourField;
	private JLabel userNameLabel;
	private JTextField userNameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	
	
	
	private TableModel dataModel;
	private JTable dataTable;
	private JScrollPane scrollpane;
	private DefaultTableModel tableModel;

	private CustomButton create;
	private CustomButton update;
	private CustomButton delete;
	private CustomButton clear;
	
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
	public UserPanel(ResourceBundle bn) {

		setLayout(new GridBagLayout());
//		this.baseController = baseController;
		this.create = new CustomButton(bn.getString("cadastrar"));
		this.update = new CustomButton(bn.getString("alterar"));
		this.delete = new CustomButton(bn.getString("excluir"));
		this.clear = new CustomButton(bn.getString("limpar"));
		this.nameLabel = new JLabel(bn.getString("nome"));
		this.nameField = new JTextField(20);
		this.cpfLabel = new JLabel(bn.getString("cpf"));
		this.cpfField = new JTextField(20);
		this.workHoursLabel = new JLabel(bn.getString("horario_de_trabalho"));
		this.startHourLabel = new JLabel(bn.getString("de"));
		this.startHourField = new JTextField(10);
		this.endHourLabel = new JLabel(bn.getString("ate"));
		this.endHourField = new JTextField(10);
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

		// CustomButtons
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 100, 100, 100);
		gbc.fill = GridBagConstraints.HORIZONTAL;
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
	@SuppressWarnings("serial")
	private void setDataTable() {
		// this.dataModel = getDataModel();
		
		this.dataTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nome", "cpf",
			 "horario_de_acesso", "username", "senha" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
			
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
		scrollTablePanel.setPreferredSize(new Dimension(600, 100));
		scrollTablePanel.setMinimumSize(new Dimension(600, 100));
		scrollTablePanel.setMaximumSize(new Dimension(600, 100));
		
		this.scrollTablePanel.setBackground(new Color(255, 255, 255));
	}

	private void fillTable() {
		tableModel = (DefaultTableModel) this.dataTable.getModel();
		tableModel.setNumRows(0);
		for (User user : UserClient.getAllUsers().getBody()) {
			tableModel.addRow(new String[] { user.getId().toString(), user.getName(), user.getCpf(),
					user.getOfficeHours(), user.getUsername(),user.getPassword() });
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
		this.fieldsPanel.add(cpfLabel, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(cpfField, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(workHoursLabel, gbc);


		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(startHourLabel, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(startHourField, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);
		
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(endHourLabel, gbc);

		gbc.insets = new Insets(0, 0, 0, 0);

		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(endHourField, gbc);

		gbc.insets = new Insets(0, 40, 0, 0);

		gbc.insets = new Insets(10, 40, 0, 0);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(userNameLabel, gbc);
		
		gbc.insets = new Insets(0, 40, 0, 0);
		
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(userNameField, gbc);
		
		gbc.insets = new Insets(10, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.fieldsPanel.add(passwordLabel, gbc);
		
		gbc.insets = new Insets(0, 40, 0, 0);

		gbc.gridx = 4;
		gbc.gridy = 3;
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
				User user = new User();
				user.setName(nameField.getText());
				user.setCpf(cpfField.getText());
				user.setOfficeHours(startHourField.getText()+"-"+endHourField.getText());
				user.setUsername(userNameField.getText());
				user.setPassword(passwordField.getText());
				UserClient.insert(user);
				fillTable();
			}
		});
		this.update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				// JOptionPane.showMessageDialog(baseController.getAppFrame(),
				// "OK");
				User[] user = UserClient.getAllUsers().getBody();
				tableModel = (DefaultTableModel) dataTable.getModel();
				user[dataTable.getSelectedRow()].setName(nameField.getText());
				user[dataTable.getSelectedRow()].setCpf(cpfField.getText());
				user[dataTable.getSelectedRow()].setOfficeHours(startHourField.getText()+"-"+endHourField.getText());
				user[dataTable.getSelectedRow()].setUsername(userNameField.getText());
				user[dataTable.getSelectedRow()].setPassword(passwordField.getText());
				UserClient.update(user[dataTable.getSelectedRow()]);
				fillTable();
			}
		});
		this.delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				// JOptionPane.showMessageDialog(baseController.getAppFrame(),
				// "OK");
				User[] user = UserClient.getAllUsers().getBody();
				tableModel = (DefaultTableModel) dataTable.getModel();

				UserClient.delete(user[dataTable.getSelectedRow()]);

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
		this.workHoursLabel.setText(bn.getString("horario_de_trabalho"));
		this.startHourLabel.setText(bn.getString("de"));		
		this.endHourLabel.setText(bn.getString("ate"));
		this.userNameLabel.setText(bn.getString("nome_usuario"));
		this.passwordLabel.setText(bn.getString("senha"));

	}


}
