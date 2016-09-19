/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 * Interface of the company
 */
public interface ICompany {
	void setId(int id);
	void setCnpj(String cnpj);
	void setSocialReason(String socialReason);
	void setBusinessHours(int businessHours);
	void setMaximumTemperature(double maximumTemperature);
	void setComplexBuilding(IComplexBuilding complexBuilding);
	void setEmployers(IEmployer[] employers);
	int getId();
	String getCnpj();
	String getSocialReason();
	int getBusinessHours();
	double getMaximumTemperature();
	IComplexBuilding getComplexBuilding();
	IEmployer[] getEmployers();
}
