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

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import br.com.cco2anpi.clients.UserClient;
import br.com.cco2anpi.models.User;
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
	private String[] data2;

	private CustomButton removeSelectedButton;
	private CustomButton toRightButton;
	private CustomButton removeAllButton;
	private CustomButton allToRightButton;
	private CustomButton confirmButton;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel lbl ;

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
		leftPanel = new JPanel(new BorderLayout());
		rightPanel = new JPanel(new BorderLayout(5, 5));
		leftList = new JList();
		rightList = new JList();

		leftScrollPane = new JScrollPane();
		rightScrollPane = new JScrollPane();

		removeSelectedButton = new CustomButton(bn.getString("remover_selecionados"));
		removeSelectedButton.addActionListener(new ButtonListener());
		removeAllButton = new CustomButton(bn.getString("remover_todos"));
		removeAllButton.addActionListener(new ButtonListener());
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


		setBackground(new Color(255, 255, 255));
		setLayout(new GridBagLayout());
		lbl = new JLabel(bn.getString("acesso_a_usuarios"), SwingConstants.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 50, 0);
		add(lbl, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(joinButtonsPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 0, 10, 0);
		add(joinListsPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(10, 0, 100, 0);
		add(confirmButton, gbc);
	}
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
		buttonRightPanel.add(removeSelectedButton);
		buttonRightPanel.add(removeAllButton);
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
	public void buildLeftPanel() {
		
		
		System.out.println("chegei em buildLeftPanel");
		
		data = new String[UserClient.getAllUsers().getBody().length];
		
		int i = 0;
		for (User user : UserClient.getAllUsers().getBody()) {
			
			String salt = "";
			try {
				salt = Crypto.generateRandomSalt();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			String password = "";
			try {
				password = Crypto.encrypt(user.getPassword(), salt);
			} catch (DataLengthException | IllegalStateException | InvalidCipherTextException e) {
				e.printStackTrace();
			}
			data[i] = user.getName() + " " + salt + " " + password + "\n";
			i++;
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
		
		System.out.println("chegei em buildRightPanel");

		String content = "";
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		
		try {
			content = FileHandler.read(s, "login.txt");

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String[] sub = content.split("\n");
		
		rightList = new JList<String>(sub);
		rightList.setVisibleRowCount(6);
		leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		rightScrollPane = new JScrollPane(rightList);
		rightPanel.add(rightScrollPane);
	}

	/**
	 * Join lists in one new panel
	 */
	public void buildListsPanel() {		

		joinListsPanel.setLayout(new GridLayout(1, 2));
		joinListsPanel.add(leftPanel);
		joinListsPanel.add(rightPanel);
	}

	/**
	 * <b>Description</b> To add event in sendButton
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == removeAllButton) {
				ListModel model = leftList.getModel();
				sendList = new String[model.getSize()];
				for (int i = 0; i < model.getSize(); i++) {
					sendList[i] = ((String) model.getElementAt(i));
				}
				System.out.println(Arrays.toString(sendList)+"\nDevem ser removidos");

			}
			if (e.getSource() == allToRightButton) {
				ListModel model = rightList.getModel();
				sendList = new String[model.getSize()];
				for (int i = 0; i < model.getSize(); i++) {
					sendList[i] = ((String) model.getElementAt(i));
				}
				JOptionPane.showMessageDialog(null, "Valores selecionados: \n" + Arrays.toString(sendList));
				
			}
			if (e.getSource() == removeSelectedButton) {
				int index=rightList.getSelectedIndex();
				DefaultListModel listModel2 = new DefaultListModel();
				listModel2.addElement(rightList.getSelectedValue());
				rightList.remove(index);
				System.out.println(Arrays.toString(listModel2.toArray())+"\nDevem ser removidos");
			}
			if (e.getSource() == toRightButton) {
				System.out.println(Arrays.toString(sendList)+"\nDevem ser removidos");
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

	/**
	 * Update language of all literal components of this panel  
	 * */
	public void updateLanguage(ResourceBundle bn) {
		removeSelectedButton.setText(bn.getString("remover_selecionados"));
		removeAllButton.setText(bn.getString("remover_todos"));
		toRightButton.setText(bn.getString("mever_selecionados"));
		allToRightButton.setText(bn.getString("mover_todos"));		
		confirmButton.setText(bn.getString("confirmar"));		
		lbl.setText(bn.getString("acesso_a_usuarios"));
	}
}
