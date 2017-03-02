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
	void setId(Integer id);
	
    void setAccessHour(String accessHour);

    void setPermissionTemperature(Boolean permission);

    void setCompanies(Set<ICompany> companys);
    
    void setUserID(Integer id);

    Integer getId();
    
    String getAccessHour();

    Boolean getPermissionTemperature();

    Set<ICompany> getCompanies();
    
    Integer getUserID();
}
