package br.com.cco2anpi.controllers;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import br.com.cco2anpi.views.AccessConsultPanel;
import br.com.cco2anpi.views.AirConditionerView;
import br.com.cco2anpi.views.ApplicationView;
import br.com.cco2anpi.views.CompanyPanel;
import br.com.cco2anpi.views.CompanyView;
import br.com.cco2anpi.views.ComplexView;
import br.com.cco2anpi.views.ConsultAccessBuildingView;
import br.com.cco2anpi.views.EmployeeView;
import br.com.cco2anpi.views.EmployerPanel;
import br.com.cco2anpi.views.SendFileView;
import br.com.cco2anpi.views.UserPanel;
import br.com.cco2anpi.views.shared.Menu;

/**
 * @author pitagoras
 */
public class ApplicationViewController {

	private static AirConditionerView airConditionerView;
	private static CompanyView companyView;
	private static EmployeeView employeeView;
	private static ConsultAccessBuildingView consultAccessBuildingView;
	private static SendFileView sendFileView;
	private static ComplexView complexView;
	private static ApplicationView applicationViewContentPanel;
	
	// para teste
	private static CompanyPanel companyPanel;
	private static EmployerPanel employerPanel;
	private static AccessConsultPanel accessConsultPanel;
	private static UserPanel userPanel;
	
	private static JMenuBar bar;
	static Menu menu;
	ResourceBundle bn;
	/**
	 * Constructor Set Components to ApplicationController
	 */
	public ApplicationViewController() {
		bn = ResourceBundle.getBundle("language", new Locale("pt", "BR"));

		System.out.println("cheguei em ApplicationController!");
		menu = new Menu();
		this.bar = menu.getJMenuBar();
		this.airConditionerView = new AirConditionerView(bn);
//		this.companyView = new CompanyView(bn);
//		this.employeeView = new EmployeeView(bn);
		this.companyPanel = new CompanyPanel(bn);
		this.employerPanel = new EmployerPanel(bn);
		this.sendFileView= new SendFileView(bn);
		this.complexView = new ComplexView(bn);
		this.userPanel = new UserPanel(bn);
		this.accessConsultPanel = new AccessConsultPanel(bn);
//		applicationViewContentPanel = new ApplicationView(bar, employeeView, companyView, airConditionerView,
//				consultAccessBuildingView, sendFileView, complexView);
		applicationViewContentPanel = new ApplicationView(bar, employerPanel, companyPanel, airConditionerView,
				accessConsultPanel, sendFileView, complexView,userPanel);

	}
	public static void applicationViewController(ResourceBundle bn) {
		System.out.println("cheguei em ApplicationController!");
		
		airConditionerView.updateLanguage(bn);
//		companyView.updateLanguage(bn);
//		employeeView.updateLanguage(bn);
		companyPanel.updateLanguage(bn);
		employerPanel.updateLanguage(bn);
		sendFileView.updateLanguage(bn);
//		consultAccessBuildingView.updateLanguage(bn);
		accessConsultPanel.updateLanguage(bn);
		userPanel.updateLanguage(bn);
//		complexView.updateLanguage(bn);
		
		applicationViewContentPanel.updateLanguage(bn, employerPanel, companyPanel, airConditionerView, accessConsultPanel, sendFileView, complexView,userPanel);

	}	

	/**
	 * <b>Description</b> This method is start with a action in menu item and
	 * redraw the contentPanel of application
	 * 
	 * @param String
	 *            key to contentPanel
	 */
	public static void redrawContentPanel(String key) {
		System.out.println("cheguei no redraw com " + key);

		applicationViewContentPanel.redrawContentPanel(key);
	}

	/**
	 * @return the airConditionerView
	 */
	public static AirConditionerView getAirConditionerView() {
		return airConditionerView;
	}

	/**
	 * @return the companyView
	 */
	public static CompanyView getCompanyView() {
		return companyView;
	}

	/**
	 * @return the employeeView
	 */
	static EmployeeView getEmployeeView() {
		return employeeView;
	}

	/**
	 * @return the consultAccessBuildingView
	 */
	public static ConsultAccessBuildingView getConsultAccessBuildingView() {
		return consultAccessBuildingView;
	}

	/**
	 * @return the sendFileView
	 */
	public static SendFileView getSendFileView() {
		return sendFileView;
	}

	
}