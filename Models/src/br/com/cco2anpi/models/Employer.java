/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.Set;

/**
 * @author wotan
 *
 */
public class Employer extends User implements IEmployer {
	private String accessHour;
	private Boolean permissionTemperature;
	private Set<ICompany> companies;

	public Employer() {

	}

	public Employer(IEmployer sourceObject) {
		accessHour = sourceObject.getAccessHour();
		permissionTemperature = sourceObject.getPermissionTemperature();
		companies = sourceObject.getCompanies();
	}

	/**
	 * @return the accessHour
	 */
	public String getAccessHour() {
		return accessHour;
	}

	/**
	 * @param accessHour
	 *            the accessHour to set
	 */
	public void setAccessHour(String accessHour) {
		this.accessHour = accessHour;
	}

	/**
	 * @return the permissionTemperature
	 */
	public Boolean getPermissionTemperature() {
		return permissionTemperature;
	}

	/**
	 * @param permissionTemperature
	 *            the permissionTemperature to set
	 */
	public void setPermissionTemperature(Boolean permissionTemperature) {
		this.permissionTemperature = permissionTemperature;
	}

	/**
	 * @return the companys
	 */
	public Set<ICompany> getCompanies() {
		return this.companies;
	}

	/**
	 * @param companys
	 *            the companies to set
	 */
	public void setCompanies(Set<ICompany> companies) {
		this.companies = companies;
	}

}
