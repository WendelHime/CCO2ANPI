/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public interface IEmployer extends IUser {
	void setId(Integer id);

	void setAccessHour(String accessHour);

	void setPermissionTemperature(Boolean permission);

	void setCompany(ICompany company);

	void setUserID(Integer id);

	Integer getId();

	String getAccessHour();

	Boolean getPermissionTemperature();

	ICompany getCompany();

	Integer getUserID();
}
