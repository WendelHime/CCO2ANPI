package br.com.cco2anpi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
*@author pitagoras
*/
public class SendFileView extends JPanel {
	private JPanel header;
	private JPanel dataListPanel;
	private JPanel selectedDataPanel;// To show the values that are out

	private JList dataList;
	private JList selectedDataList; // Selected values

	private JScrollPane scrollPane;
	private JScrollPane scrollPaneOut; // Scroll pane - Selected values
	//To test
	private String[] data = { "Funcionario 1 Empresa X Predio Y", "Funcionario 2 Empresa X Predio Y",
            "Funcionario 3 Empresa X Predio Y", "Funcionario 4 Empresa X Predio Y", 
            "Funcionario 5 Empresa X Predio Y", "Funcionario 6 Empresa X Predio Y",
            "Funcionario 7 Empresa X Predio Y","Funcionario 8 Empresa X Predio Y", 
            "Funcionario 9 Empresa X Predio Y","Funcionario 10 Empresa X Predio Y",
            "Funcionario 11 Empresa X Predio Y", "Funcionario 12 Empresa X Predio Y" };
	
	private JButton sendButton;
	
	public SendFileView(){
		  header = new JPanel();
		  dataListPanel = new JPanel();

		  dataList = new JList();
		  selectedDataList = new JList(); 

		  scrollPane = new JScrollPane();
		  scrollPaneOut = new JScrollPane(); 

		  sendButton = new JButton();


	      setLayout(new BorderLayout(2,2));


	      buildItensPanel();
	      buildSelectedMonthsPanel();
	      buildHeaderPanel();
	      add(header, BorderLayout.NORTH);
	      add(dataListPanel, BorderLayout.CENTER);
	      setBackground(new Color(255,255,255));
		
	}
	 /**
    The buildHeaderPanel method adds a title and main
    button to a panel.
 */

 private void buildHeaderPanel()
 {
    // Create a panel to hold the list.
    header = new JPanel(new BorderLayout(3,3));
    
    JLabel l = new JLabel("Enviar Arquivo",SwingConstants.CENTER);

    // Create the button.
    sendButton = new JButton("Send");

    // Add an action listener to the button.
    
    sendButton.addActionListener(new ButtonListener());

    header.add(l, BorderLayout.NORTH);

    // Add the button to the panel.
    header.add(sendButton, BorderLayout.CENTER);
 }

	/**
    The buildItensPanel method adds a list containing the
    names of the employees to a panel.
 */

 private void buildItensPanel()
 {
	   dataListPanel = new JPanel();
	   dataList = new JList(data);

	   dataList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	   dataList.setVisibleRowCount(6);

    scrollPane = new JScrollPane(dataList);

    dataListPanel.add(scrollPane);
 }

	/**
	 * <b>Description</b>
	 * This method make a panel to show elected items
	 * */
	   private void buildSelectedMonthsPanel()
	   {
		   selectedDataPanel = new JPanel(new BorderLayout(5,5));

		   selectedDataList = new JList();

		   selectedDataList.setVisibleRowCount(6);

	      scrollPaneOut = new JScrollPane(selectedDataList);

	      // Add the scroll pane to the panel.
	      selectedDataPanel.add(scrollPaneOut);
	   }
	   /**
	    * <b>Description</b>
	    * To add event in sendButton
	    * */
	   private class ButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	         // Get the selected values.
	         Object[] selections =
	                        dataList.getSelectedValues();

	         // Store the selected items in selectedMonthList.
	         selectedDataList.setListData(selections);
	         JOptionPane.showMessageDialog(null, selectedDataList);
	      }
	   }
}
