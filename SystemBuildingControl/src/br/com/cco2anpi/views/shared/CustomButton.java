package br.com.cco2anpi.views.shared;
/**
 * @author Vinicius Biondi
 * Feito em 13/06/2016
 * */
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class CustomButton extends JButton {
	/**	Botao customizado para o Sistema de controle predial
	 * 	backgorund color RGB (86, 136, 163)
	 *  text color RGB (255,255,255) 
	 * @param text: Rotulo do botao
	 * */
	public CustomButton(String text) {
		super(text);
		EmptyBorder emptyBorder = new EmptyBorder(7, 15, 7, 15);
        EtchedBorder etchedBorder = new EtchedBorder();

        CompoundBorder inner = new CompoundBorder(emptyBorder, etchedBorder);
        CompoundBorder outter = new CompoundBorder(inner, emptyBorder);

		
		setBorder(outter);
		setBackground(new Color(255, 255, 255));
//		setFont(new Font(getFont().getFontName(), Font.PLAIN, 16));
//		setFont(getFont().deriveFont(Font.BOLD));
//		setFont(getFont().set(Font.BOLD));
//		setForeground(Color.BLACK);
//		setBounds(new Rectangle(50, 20));
	}
}
