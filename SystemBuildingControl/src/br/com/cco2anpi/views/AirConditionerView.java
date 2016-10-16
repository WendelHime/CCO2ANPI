package br.com.cco2anpi.views;

import java.awt.Color;
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
import javax.swing.JTextField;

import br.com.cco2anpi.views.shared.CustomButton;

public class AirConditionerView extends JPanel {
		private JLabel temperatureLabel;
		private JLabel newConfigurationLabel;
		private JLabel maximumTemperatureLabel;
		private JLabel startLabel;
		private JLabel endLabel;
		private JLabel grauLabel;
		private JTextField temperatureField;
		private JTextField startField;
		private JTextField endField;
		private JLabel hoursLabel;
		private CustomButton send;
		private ResourceBundle bn;

		private JPanel fieldsPanel;

		private GridBagConstraints gbc = new GridBagConstraints();
//		private AppController baseController;

		/**
		 * Constructor of panel to ComplexBuilding's CRUD
		 * 
		 * @return
		 */
		public AirConditionerView(ResourceBundle bn) {
			this.bn=bn;
			setLayout(new GridBagLayout());
			this.send = new CustomButton(bn.getString("enviar"));
			this.temperatureLabel = new JLabel(bn.getString("temperatura"));
			this.newConfigurationLabel = new JLabel(bn.getString("nova_configuracao"));
			this.maximumTemperatureLabel = new JLabel(bn.getString("temperatura_maxima"));
			this.startLabel = new JLabel(bn.getString("de"));
			this.endLabel = new JLabel(bn.getString("ate"));
			this.hoursLabel = new JLabel(bn.getString("horario_de_funcionamento"));
			this.temperatureField = new JTextField(2);
			this.startField = new JTextField();
			this.endField = new JTextField();
			this.grauLabel = new JLabel("Cº");
			setFieldsPanel();
			this.setBackground(new Color(255, 255, 255));

			// JFields
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(10, 0, 0, 0);
			add(getFieldsPanel(), gbc);

			// Listeners
			setupListeners();
		}

		/**
		 * @return This panel
		 */
		public JPanel getComplexBuildingPanel() {
			return this;
		}
		
		/**
		 * 
		 * @return the dataModel
		 */
		private JPanel getFields() {
			JPanel p = new JPanel(new GridLayout(1,2,0,0));
			startLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			endLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			startField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			endField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			p.setBounds(0, 0, 50, 10);
			p.add(startLabel);
			p.add(endLabel);
//			p.add(startField);
//			p.add(endField);
//			p.add(new JLabel(""));
//			p.add(new JLabel(""));
//			p.add(new JLabel(""));
//			p.add(send);
//	
			p.setBackground(new Color(255, 255, 255));

			return p;
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
			fieldsPanel.setBackground(new Color(255, 255, 255));

			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 3;
			gbc.insets = new Insets(0,70, 0, 0);

			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(temperatureLabel, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(10, 55, 50, 0);
			this.fieldsPanel.add(newConfigurationLabel, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(0, 40, 5, 0);
			this.fieldsPanel.add(maximumTemperatureLabel, gbc);
			
			
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 1;
			gbc.insets = new Insets(0,90, 5, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(temperatureField, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.gridwidth = 2;
			gbc.insets = new Insets(0,15, 5, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(grauLabel, gbc);

			
			gbc.gridx = 0;
			gbc.gridy = 5;
			gbc.gridwidth = 2;
			gbc.insets = new Insets(5, 65, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(hoursLabel, gbc);

			gbc.gridx = 0;
			gbc.gridy = 6;
			gbc.gridwidth = 4;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(getFields(), gbc);

			gbc.gridx = 0;
			gbc.gridy = 7;
			gbc.gridwidth = 1;
			gbc.insets = new Insets(0, 10, 0, 10);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(startField, gbc);

			gbc.gridx = 1;
			gbc.gridy = 7;
			gbc.gridwidth = 2;
			gbc.insets = new Insets(0, 5, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(endField, gbc);
			gbc.gridx = 1;
			gbc.gridy = 8;
			gbc.gridwidth = 2;
			gbc.insets = new Insets(5, 5, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			this.fieldsPanel.add(send, gbc);
		}

		/**
		 * setup Listeners to all buttons
		 */
		public void setupListeners() {
			
			this.send.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent click) {

//					JOptionPane.showMessageDialog(baseController.getAppFrame(), "OK");

				}
			});
			

		}

	public void updateLanguage(ResourceBundle bn) {
	
		this.send = new CustomButton(bn.getString("enviar"));
		this.temperatureLabel = new JLabel(bn.getString("temperature"));
		this.newConfigurationLabel = new JLabel(bn.getString("nova_configuracao"));
		this.maximumTemperatureLabel = new JLabel(bn.getString("temperatura_maxima"));
		this.startLabel = new JLabel(bn.getString("de"));
		this.endLabel = new JLabel(bn.getString("ate"));
		this.hoursLabel = new JLabel(bn.getString("horario_de_funcionamento"));
	}
}
