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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.cco2anpi.models.ICompany;
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
	private String businessHours;
	@Column(name = "maximum_temperature")
	private Double maximumTemperature;
	@Column(name = "air_conditioner_hours")
	private String airconditionerHours;
	private String set;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Employer> employers = new HashSet<>(0);

	public Company() {

	}

	public Company(ICompany sourceObject) {
		id = sourceObject.getId();
		cnpj = sourceObject.getCnpj();
		socialReason = sourceObject.getSocialReason();
		businessHours = sourceObject.getBusinessHours();
		maximumTemperature = sourceObject.getMaximumTemperature();
		airconditionerHours = sourceObject.getAirConditionerHours();
		set = sourceObject.getSet();
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
	public String getBusinessHours() {
		return businessHours;
	}

	/**
	 * @param businessHour
	 *            the businessHour to set
	 */
	public void setBusinessHours(String businessHours) {
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
	 * @return the businessHour
	 */
	public String getAirConditionerHours() {
		return airconditionerHours;
	}

	/**
	 * @param businessHour
	 *            the businessHour to set
	 */
	public void setAirConditionerHours(String airconditionerHours) {
		this.airconditionerHours = airconditionerHours;
	}

	/**
	 * @return the complexBuilding
	 */
	public String getSet() {
		return this.set;
	}

	/**
	 * @param complexBuilding
	 *            the complexBuilding to set
	 */
	public void setSet(String set) {
		this.set = set;
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
