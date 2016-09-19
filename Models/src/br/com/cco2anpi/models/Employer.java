/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public class Employer extends User implements IEmployer {
	private int accessHour;
	private boolean permissionTemperature;
	private Company[] companys;
	
	public Employer()
	{
		
	}
	
	public Employer(IEmployer sourceObject)
	{
		accessHour = sourceObject.getAccessHour();
		permissionTemperature = sourceObject.getPermissionTemperature();
		companys = (Company[]) sourceObject.getCompanys();
	}
	
	/**
	 * @return the accessHour
	 */
	public int getAccessHour() {
		return accessHour;
	}
	/**
	 * @param accessHour the accessHour to set
	 */
	public void setAccessHour(int accessHour) {
		this.accessHour = accessHour;
	}
	/**
	 * @return the permissionTemperature
	 */
	public boolean getPermissionTemperature() {
		return permissionTemperature;
	}
	/**
	 * @param permissionTemperature the permissionTemperature to set
	 */
	public void setPermissionTemperature(boolean permissionTemperature) {
		this.permissionTemperature = permissionTemperature;
	}

	/**
	 * @return the companys
	 */
	public ICompany[] getCompanys() {
		return (ICompany[]) companys;
	}

	/**
	 * @param companys the companys to set
	 */
	public void setCompanys(ICompany[] companys) {
		this.companys = (Company[]) companys;
	}
	
	
}
