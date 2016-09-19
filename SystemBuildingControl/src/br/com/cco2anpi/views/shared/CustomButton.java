package br.com.cco2anpi.views.shared;
/**
 * @author Vinicius Biondi
 * Feito em 13/06/2016
 * */
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class CustomButton extends JButton {
	/**	Botao customizado para o Sistema de controle predial
	 * 	backgorund color RGB (86, 136, 163)
	 *  text color RGB (255,255,255) 
	 * @param text: Rotulo do botao
	 * */
	public CustomButton(String text) {
		super(text);
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
				new Color(86, 136, 163), new Color(86, 136, 163))));
		setBackground(new Color(86, 136, 163));
		setFont(getFont().deriveFont(Font.BOLD));
		setForeground(Color.WHITE);
	}
}
