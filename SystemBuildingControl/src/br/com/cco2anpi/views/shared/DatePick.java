package br.com.cco2anpi.views.shared;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	static JComboBox month;
	static JComboBox year;
	static JComboBox day;
	
	static final int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static final String weekdays[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	static final String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	/**
	 * Set all JComboBox and groups in panel
	 * */
	public static JPanel datePick(String title) {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
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