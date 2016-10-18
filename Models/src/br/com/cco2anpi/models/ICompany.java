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

    void setBusinessHours(String businessHours);

    void setMaximumTemperature(Double maximumTemperature);
    
    void setAirConditionerHours(String businessHours);

    void setComplexBuilding(ComplexBuilding complexBuilding);

    void setEmployers(Set<IEmployer> employers);

    Integer getId();

    String getCnpj();

    String getSocialReason();

    String getBusinessHours();

    Double getMaximumTemperature();
    
    String getAirConditionerHours();
    
    ComplexBuilding getComplexBuilding();

    Set<IEmployer> getEmployers();
}
