/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.Set;

/**
 * @author wotan Interface of the company
 */
public interface ICompany {
    void setId(Integer id);

    void setCnpj(String cnpj);

    void setSocialReason(String socialReason);

    void setBusinessHours(Integer businessHours);

    void setMaximumTemperature(Double maximumTemperature);
    
    void setAirConditionerHours(Integer businessHours);

    void setComplexBuilding(IComplexBuilding complexBuilding);

    void setEmployers(Set<IEmployer> employers);

    Integer getId();

    String getCnpj();

    String getSocialReason();

    Integer getBusinessHours();

    Double getMaximumTemperature();
    
    Integer getAirConditionerHours();
    
    IComplexBuilding getComplexBuilding();

    Set<IEmployer> getEmployers();
}
