/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.Set;

/**
 * @author wotan
 * Interface related of complex building
 */
public interface IComplexBuilding {
	void setId(Integer id);
	void setNumber(String number);
	void setCompanies(Set<ICompany> companies);
	Integer getId();
	String getNumber();
	Set<ICompany> getCompanies();
}
