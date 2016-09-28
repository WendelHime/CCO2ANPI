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
	void setAccessHour(Integer accessHour);

	void setPermissionTemperature(Boolean permission);

	void setCompanies(Set<ICompany> companys);

	Integer getAccessHour();

	Boolean getPermissionTemperature();

	Set<ICompany> getCompanies();
}
