/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.Set;

/**
 * @author wotan
 *
 */
public interface IEmployer extends IUser {
	void setAccessHour(String accessHour);

	void setPermissionTemperature(Boolean permission);

	void setCompanies(Set<ICompany> companys);

	String getAccessHour();

	Boolean getPermissionTemperature();

	Set<ICompany> getCompanies();
}
