package br.com.cco2anpi.views.shared;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.cco2anpi.clients.ComplexBuildingClient;
import br.com.cco2anpi.models.ComplexBuilding;

public class UpdateView extends JFrame implements ActionListener{
    JLabel numero = new JLabel("Conjunto");
    JTextField numerotxf = new JTextField();
    CustomButton update = new CustomButton("update");
    ComplexBuilding b;
    public UpdateView(ComplexBuilding b) {
	// TODO Auto-generated constructor stub
	setLayout(new BorderLayout(2,2));
	add(numero,BorderLayout.NORTH);
	add(numerotxf,BorderLayout.CENTER);
	add(update, BorderLayout.AFTER_LAST_LINE);
	this.b=b;
	setSize(new Dimension(200, 200));
	
	setVisible(true);
	setLocationRelativeTo(null);
	
    }
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	ComplexBuildingClient.update(b);
	setVisible(false);
    }
    
}
