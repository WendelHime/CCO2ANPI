package br.com.cco2anpi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

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
		
			
			
			
			
			
			
//			@SuppressWarnings("deprecation")
//			Object[] lista = rightList.getSelectedValues();
//			String[] itens = new String[lista.length];
//						
//			for(int i = 0; i < sendList.size(); i++)
//		    {
//				itens[i] = (String) lista[i];					
//				rightList.remove(i);
//				sendList.remove(i);
//		    }
//
//			System.out.println(Arrays.toString(itens)+"\nForam removidos");
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
