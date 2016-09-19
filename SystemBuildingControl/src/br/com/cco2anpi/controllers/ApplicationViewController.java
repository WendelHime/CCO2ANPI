package br.com.cco2anpi.controllers;

import br.com.cco2anpi.views.AirConditionerView;
import br.com.cco2anpi.views.ApplicationView;
import br.com.cco2anpi.views.CompanyView;
import br.com.cco2anpi.views.ConsultAccessBuildingView;
import br.com.cco2anpi.views.EmployeeView;
import br.com.cco2anpi.views.SendFileView;

/**
 * @author pitagoras
 */
public class ApplicationViewController {

	private AirConditionerView airConditionerView;
	private CompanyView companyView;
	private EmployeeView employeeView;
	private ConsultAccessBuildingView consultAccessBuildingView;
	private SendFileView sendFileView;
	private static ApplicationView applicationViewContentPanel;

	/**
	 * Constructor Set Components to ApplicationController
	 */
	public ApplicationViewController() {

		System.out.println("cheguei em ApplicationController!");
		this.airConditionerView = new AirConditionerView();
		this.companyView = new CompanyView();
		this.employeeView = new EmployeeView();
		this.sendFileView= new SendFileView(); 

		this.consultAccessBuildingView = new ConsultAccessBuildingView();
		applicationViewContentPanel = new ApplicationView(employeeView, companyView, airConditionerView,
				consultAccessBuildingView, sendFileView);

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
}