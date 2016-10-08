/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wotan
 *
 */
public class Company implements ICompany {
    private Integer id;
    private String cnpj;
    private String socialReason;
    private Integer businessHours;
    private Double maximumTemperature;
    private Integer airconditionerHours;
    private ComplexBuilding complexBuilding;
    private Set<IEmployer> employers = new HashSet<>(0);

    public Company() {

    }

    public Company(ICompany sourceObject) {
	id = sourceObject.getId();
	cnpj = sourceObject.getCnpj();
	socialReason = sourceObject.getSocialReason();
	businessHours = sourceObject.getBusinessHours();
	maximumTemperature = sourceObject.getMaximumTemperature();
	airconditionerHours = sourceObject.getAirConditionerHours();
	complexBuilding = (ComplexBuilding) sourceObject.getComplexBuilding();
	setEmployers(sourceObject.getEmployers());
    }

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
	return cnpj;
    }

    /**
     * @param cnpj
     *            the cnpj to set
     */
    public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
    }

    /**
     * @return the socialReason
     */
    public String getSocialReason() {
	return socialReason;
    }

    /**
     * @param socialReason
     *            the socialReason to set
     */
    public void setSocialReason(String socialReason) {
	this.socialReason = socialReason;
    }

    /**
     * @return the businessHours
     */
    public Integer getBusinessHours() {
	return businessHours;
    }

    /**
     * @param businessHours
     *            the businessHours to set
     */
    public void setBusinessHours(Integer businessHours) {
	this.businessHours = businessHours;
    }

    /**
     * @return the maximumTemperature
     */
    public Double getMaximumTemperature() {
	return maximumTemperature;
    }

    /**
     * @param maximumTemperature
     *            the maximumTemperature to set
     */
    public void setMaximumTemperature(Double maximumTemperature) {
	this.maximumTemperature = maximumTemperature;
    }

    /**
     * @return the businessHours
     */
    public Integer getAirConditionerHours() {
	return airconditionerHours;
    }

    /**
     * @param businessHours
     *            the businessHours to set
     */
    public void setAirConditionerHours(Integer airconditionerHours) {
	this.airconditionerHours = airconditionerHours;
    }
    
    /**
     * @return the complexBuilding
     */
    public IComplexBuilding getComplexBuilding() {
	return complexBuilding;
    }

    /**
     * @param complexBuilding
     *            the complexBuilding to set
     */
    public void setComplexBuilding(IComplexBuilding complexBuilding) {
	this.complexBuilding = (ComplexBuilding) complexBuilding;
    }

    /**
     * @return the employers
     */
    public Set<IEmployer> getEmployers() {
	return new HashSet<IEmployer>(employers);
    }

    /**
     * @param employers
     *            the employers to set
     */
    public void setEmployers(Set<IEmployer> employers) {
	Iterator<IEmployer> iterator = employers.iterator();
	while (iterator.hasNext()) {
	    this.employers.add((Employer) iterator.next());
	}
    }

}
