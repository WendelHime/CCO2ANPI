package br.com.cco2anpi.views.shared;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author pitagoras
 * <b>DatePick</b>
 * Class to choose a date by JComboBoxes
 * */
public class DatePick {
	static JPanel panel;
	ResourceBundle bn;
	static JComboBox month;
	static JComboBox year;
	static JComboBox day;
	
	static final int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static final String weekdays[]=	 { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	static final String months[]=new String[12] ;

	/**
	 * Set all JComboBox and groups in panel
	 * */
	public static JPanel datePick(String title, ResourceBundle bn) {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
	
		months[0]=bn.getString("janeiro");
		months[1]=bn.getString("fevereiro");
		months[2]=bn.getString("marco");
		months[3]=bn.getString("abril");
		months[4]=bn.getString("maio");
		months[5]=bn.getString("junho");
		months[6]=bn.getString("julho");
		months[7]=bn.getString("agosto");
		months[8]=bn.getString("setembro");
		months[9]=bn.getString("outubro");
		months[10]=bn.getString("novembro");
		months[11]=bn.getString("dezembro");
			
		
		createJComboBoxDay();
		createJComboBoxMonth();
		createJComboBoxYear();
		
		panel.add(day);
		panel.add(month);
		panel.add(year);
		panel.setBorder(new TitledBorder(title));

		Date date = new Date();
		// initialize in actual date 
		year.setSelectedItem((1900 + date.getYear()));
		month.setSelectedItem(months[date.getMonth()]);
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		day.setSelectedItem(Integer.parseInt(sdf.format(date)));
		
		return panel;
	}

	/**
	 * Set JComboBox of days
	 * */
	private static void createJComboBoxDay(){
		day = new JComboBox();
		for (int i = 1; i <= 31; i++) {
			day.addItem(i);
		}
	}

	/**
	 * Set JComboBox of months
	 * */
	private static void createJComboBoxMonth(){
		month = new JComboBox();

		for (int i = 0; i < months.length; i++) {
			month.addItem(months[i]);
		}
	}

	/**
	 * Set JComboBox of years
	 * */
	private static void createJComboBoxYear(){
		year = new JComboBox();
		for (int i = 1980; i <= 2099; i++) {
			year.addItem(i);
		}
	}
}