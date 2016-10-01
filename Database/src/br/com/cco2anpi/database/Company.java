/**
 * 
 */
package br.com.cco2anpi.database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IComplexBuilding;
import br.com.cco2anpi.models.IEmployer;

/**
 * @author wotan
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "COMPANIES")
public class Company implements Serializable, ICompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String cnpj;
    @Column(name = "social_reason")
    private String socialReason;
    @Column(name = "business_hours")
    private Integer businessHours;
    @Column(name = "maximum_temperature")
    private Double maximumTemperature;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_complex_id", nullable = false)
    private ComplexBuilding complexBuilding;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYERS_COMPANIES", joinColumns = {
	    @JoinColumn(name = "company_id", nullable = false, updatable = false) }, inverseJoinColumns = {
		    @JoinColumn(name = "employer_id", nullable = false, updatable = false) })
    private Set<Employer> employers = new HashSet<>(0);

    public Company() {

    }

    public Company(ICompany sourceObject) {
	id = sourceObject.getId();
	cnpj = sourceObject.getCnpj();
	socialReason = sourceObject.getSocialReason();
	businessHours = sourceObject.getBusinessHours();
	maximumTemperature = sourceObject.getMaximumTemperature();
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
     * @return the businessHour
     */
    public Integer getBusinessHours() {
	return businessHours;
    }

    /**
     * @param businessHour
     *            the businessHour to set
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
