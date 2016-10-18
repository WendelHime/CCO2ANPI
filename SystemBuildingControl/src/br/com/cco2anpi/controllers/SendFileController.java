package br.com.cco2anpi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import com.sun.corba.se.spi.oa.OADefault;

import br.com.cco2anpi.tools.Crypto;
import br.com.cco2anpi.tools.FileHandler;
import br.com.cco2anpi.tools.Searcher;
import br.com.cco2anpi.views.SendFileView;

public class SendFileController implements ActionListener{
	private SendFileView sendFileView;
	public SendFileController(SendFileView sendFileView){
		this.sendFileView = sendFileView;
		this.sendFileView.getremoveAllButton().addActionListener(this);
		this.sendFileView.getremoveSelectedButton().addActionListener(this);
		this.sendFileView.getallToRightButton().addActionListener(this);
		this.sendFileView.gettoRightButton().addActionListener(this);
		this.sendFileView.getconfirmButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.sendFileView.getremoveAllButton()) {
			
//			rightList.removeAll();
//			sendList.clear();
//			System.out.println("Listas vazias");
		}
		
		if (e.getSource() == this.sendFileView.getremoveSelectedButton()) {
				
			@SuppressWarnings("deprecation")
			Object[] listaDeSelecionados = this.sendFileView.getrightList().getSelectedValues();
			Object[] lista = new Object[this.sendFileView.getlistModelRight().size()];
			for (int i = 0; i < lista.length; i++){
				lista[i] = this.sendFileView.getlistModelRight().getElementAt(i);
			}
			

//			System.out.println(this.sendFileView.getlistModelRight().size());
			
			for (int j = 0; j < listaDeSelecionados.length; j++){
				System.out.println(Searcher.binarySearch(lista, listaDeSelecionados[j].toString()));
				System.out.println(lista[j].toString()+" "+ listaDeSelecionados[j].toString());

				this.sendFileView.getlistModelRight().remove(Searcher.binarySearch(lista, listaDeSelecionados[j].toString()));
			}
			
			
			
			
			this.sendFileView.fillListR();
		}
		
		if (e.getSource() == this.sendFileView.getallToRightButton()) {
			
			
			
			
			
			
//			
//			ListModel model = leftList.getModel();
//			
//			for (int i = 0; i < model.getSize(); i++) {
//				sendList.add((String) model.getElementAt(i));
//				
//			}
//			String aux[] = new String[sendList.size()];
//			for (int i = 0; i < aux.length; i++) {
//				aux[i] = sendList.get(i);
//			}
//			rightList = new JList<String>(aux);
//			System.out.println(Arrays.toString(sendList.toArray())+"\nTodos ter acesso");
		}
		
		if (e.getSource() == 	this.sendFileView.gettoRightButton()) {
			
//			ListModel model = rightList.getModel();
//
//			@SuppressWarnings("deprecation")
//			Object[] lista = leftList.getSelectedValues();
//			String[] itens = new String[lista.length];
//			// pego os valores selecionados
//			for(int i = 0; i<lista.length;i++){
//				itens[i] = lista[i].toString();
//			}
//			// adiciono a send list
//			for(String item : itens)
//		    {
//				sendList.add(item);
//		    }
//			// auxiliar para a lista da direita
//			
//			String aux[] = new String[sendList.size()+model.getSize()];
//			// adiciono o que ja existe
//			for (int i = 0; i < aux.length; i++) {
//				aux[i] = (String) model.getElementAt(i);
//			}
//			// adiciono o novo conteudo
//			for (int i = 0; i < aux.length; i++) {
//				aux[i] = sendList.get(i);
//			}
//			
//			rightList = new JList<String>(aux);
//			System.out.println(Arrays.toString(sendList.toArray())+"\nDevem ter acesso");
		}
		if (e.getSource() == this.sendFileView.getconfirmButton()) {
			
//			String content = "";
//			Path currentRelativePath = Paths.get("");
//			String s = currentRelativePath.toAbsolutePath().toString();
//			for (String line : sendList) {
//				if (line != null) {
//					content += line;
//				}
//			}
//			try {
//				FileHandler.write(s, "login.txt", content);
//				JOptionPane.showMessageDialog(null, "Arquivo login.txt criado com sucesso!");
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
		}
	}
}
