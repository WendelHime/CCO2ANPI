/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public interface IEmployer extends IUser {
	void setAccessHour(int accessHour);
	void setPermissionTemperature(boolean permission);
	void setCompanys(ICompany[] companys);
	int getAccessHour();
	boolean getPermissionTemperature();
	ICompany[] getCompanys();
}
