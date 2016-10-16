package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import br.com.cco2anpi.tools.Crypto;
import br.com.cco2anpi.tools.FileHandler;
import br.com.cco2anpi.views.shared.CustomButton;

public class SendFileView extends JPanel {
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel buttonRightPanel;
	private JPanel buttonLeftPanel;
	private JPanel joinButtonsPanel;
	private JPanel joinListsPanel;
	private JPanel joinAllPanel;

	private JList leftList;
	private JList rightList;
	private String[] sendList;

	private JScrollPane leftScrollPane;
	private JScrollPane rightScrollPane;

	private String[] data;

	private CustomButton toLeftButton;
	private CustomButton toRightButton;
	private CustomButton allToLeftButton;
	private CustomButton allToRightButton;
	private CustomButton confirmButton;
	private GridBagConstraints gbc = new GridBagConstraints();

	ResourceBundle bn;
	/**
	 * Set All variables
	 */
	public SendFileView(ResourceBundle bn) {
		this.bn = bn;
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		buttonRightPanel = new JPanel();
		buttonLeftPanel = new JPanel();
		joinButtonsPanel = new JPanel();
		joinListsPanel = new JPanel();
		joinAllPanel = new JPanel();

		leftList = new JList();
		rightList = new JList();

		leftScrollPane = new JScrollPane();
		rightScrollPane = new JScrollPane();

		toLeftButton = new CustomButton(bn.getString("mever_selecionados"));
		toLeftButton.addActionListener(new ButtonListener());
		allToLeftButton = new CustomButton(bn.getString("mover_todos"));
		allToLeftButton.addActionListener(new ButtonListener());
		toRightButton = new CustomButton(bn.getString("mever_selecionados"));
		toRightButton.addActionListener(new ButtonListener());
		allToRightButton = new CustomButton(bn.getString("mover_todos"));
		allToRightButton.addActionListener(new ButtonListener());
		confirmButton = new CustomButton(bn.getString("confirmar"));
		confirmButton.addActionListener(new ButtonListener());
		buildButtonLeftPanel();
		buildButtonRightPanel();
		buildButtonsPanel();
		buildLeftPanel();
		buildRightPanel();
		buildListsPanel();
//		joinAllPanel();

		setBackground(new Color(255, 255, 255));
		setLayout(new GridBagLayout());
		JLabel lbl = new JLabel(bn.getString("acesso_a_usuarios"), SwingConstants.CENTER);
		// JFields
		gbc.gridx = 0;
		gbc.gridy = 0;
//		gbc.gridwidth = 3;
//		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 50, 0);
		add(lbl, gbc);

		// CustomButtons
		gbc.gridx = 0;
		gbc.gridy = 1;
//		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(joinButtonsPanel, gbc);

		// JTable
		gbc.gridx = 0;
		gbc.gridy = 2;
//		gbc.gridwidth = 3;
		gbc.insets = new Insets(10, 0, 10, 0);
		add(joinListsPanel, gbc);
		
		// JTable
		gbc.gridx = 0;
		gbc.gridy = 3;
//		gbc.gridwidth = 3;
		gbc.insets = new Insets(10, 0, 100, 0);
		add(confirmButton, gbc);
		
				
		
//		add(lbl, BorderLayout.NORTH);
//		add(joinAllPanel, BorderLayout.CENTER);

	}

//	private void joinAllPanel() {
//		joinAllPanel.setLayout(new BorderLayout(2, 2));
//		joinAllPanel.add(joinButtonsPanel, BorderLayout.NORTH);
//		joinAllPanel.add(joinListsPanel, BorderLayout.CENTER);
//		joinAllPanel.add(confirmButton, BorderLayout.SOUTH);
//	}

	/**
	 * Create a grid with the buttons to send data of leftList to the rightList
	 */
	private void buildButtonLeftPanel() {

		buttonLeftPanel.setLayout(new GridLayout(1, 3));
		buttonLeftPanel.add(new JLabel(""));
		buttonLeftPanel.add(allToRightButton);
		buttonLeftPanel.add(toRightButton);
		buttonLeftPanel.setBackground(new Color(255, 255, 255));
	}

	/**
	 * Create a grid with the buttons to send data of rightList to the leftList
	 */
	private void buildButtonRightPanel() {

		buttonRightPanel.setLayout(new GridLayout(1, 3));
		buttonRightPanel.add(toLeftButton);
		buttonRightPanel.add(allToLeftButton);
		buttonRightPanel.add(new JLabel(""));
		buttonRightPanel.setBackground(new Color(255, 255, 255));
	}

	/**
	 * Join buttons of the leftPanel and rightPanel
	 */
	private void buildButtonsPanel() {

		joinButtonsPanel.setLayout(new GridLayout(1, 2));
		joinButtonsPanel.add(buttonLeftPanel);
		joinButtonsPanel.add(buttonRightPanel);
		joinButtonsPanel.setBackground(new Color(255, 255, 255));
	}

	/**
	 * The buildLeftPanel method list all user of system in a JList.
	 */
	private void buildLeftPanel() {
		leftPanel = new JPanel(new BorderLayout());
		data = new String[11];
		for (int i = 0; i < data.length; i++) {
			String salt = "";
			try {
				salt = Crypto.generateRandomSalt();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String password = "";
			try {
				password = Crypto.encrypt("password", salt);
			} catch (DataLengthException | IllegalStateException | InvalidCipherTextException e) {
				e.printStackTrace();
			}
			data[i] = "username" + i + " " + salt + " " + password + "\n";
		}
		leftList = new JList<String>(data);
		leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		leftList.setVisibleRowCount(6);
		leftScrollPane = new JScrollPane(leftList);
		leftPanel.add(leftScrollPane);
	}

	/**
	 * This method make a panel to show all users that has access to building
	 */
	private void buildRightPanel() {
		rightPanel = new JPanel(new BorderLayout(5, 5));
		rightList = new JList();
		rightList.setVisibleRowCount(6);
		rightScrollPane = new JScrollPane(rightList);
		rightPanel.add(rightScrollPane);
	}

	/**
	 * Join lists in one new panel
	 */
	private void buildListsPanel() {
		joinListsPanel.setLayout(new GridLayout(1, 2));
		joinListsPanel.add(leftPanel);
		joinListsPanel.add(rightPanel);
	}

	/**
	 * <b>Description</b> To add event in sendButton
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == allToLeftButton) {
				ListModel model = leftList.getModel();
				sendList = new String[model.getSize()];
				for (int i = 0; i < model.getSize(); i++) {
					sendList[i] = ((String) model.getElementAt(i));
				}
				System.out.println(Arrays.toString(sendList));

			}
			if (e.getSource() == allToRightButton) {
				ListModel model = rightList.getModel();
				sendList = new String[model.getSize()];
				for (int i = 0; i < model.getSize(); i++) {
					sendList[i] = ((String) model.getElementAt(i));
				}
				JOptionPane.showMessageDialog(null, "Valores selecionados: \n" + Arrays.toString(sendList));
				System.out.println(Arrays.toString(sendList));
			}
			if (e.getSource() == toLeftButton) {

			}
			if (e.getSource() == toRightButton) {

			}
			if (e.getSource() == confirmButton) {
				String content = "";
				Path currentRelativePath = Paths.get("");
				String s = currentRelativePath.toAbsolutePath().toString();
				for (String line : sendList) {
					if (line != null) {
						content += line;
					}
				}
				try {
					FileHandler.write(s, "login.txt", content);
					JOptionPane.showMessageDialog(null, "Arquivo login.txt criado com sucesso!");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void updateLanguage(ResourceBundle bn) {
		toLeftButton.setText(bn.getString("mever_selecionados"));
		
		allToLeftButton.setText(bn.getString("mover_todos"));
		
		toRightButton.setText(bn.getString("mever_selecionados"));
		
		allToRightButton.setText(bn.getString("mover_todos"));
		
		confirmButton.setText(bn.getString("confirmar"));		
	}
}
