/**
 * 
 */
package br.com.cco2anpi.database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IEmployer;

/**
 * @author wotan
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYERS")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User implements Serializable, IEmployer {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "access_hour")
    private Integer accessHour;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "permission_temperature", columnDefinition = "TINYINT")
    private Boolean permissionTemperature;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "employers")
    private Set<Company> companies = new HashSet<>(0);

    public Employer() {

    }

    public Employer(IEmployer sourceObject) {
	this.id = sourceObject.getId();
	this.accessHour = sourceObject.getAccessHour();
	this.permissionTemperature = sourceObject.getPermissionTemperature();
	setCompanies(sourceObject.getCompanies());
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
     * @return the accessHour
     */
    public Integer getAccessHour() {
	return accessHour;
    }

    /**
     * @param accessHour
     *            the accessHour to set
     */
    public void setAccessHour(Integer accessHour) {
	this.accessHour = accessHour;
    }

    /**
     * @return the permissionTemperature
     */
    public Boolean getPermissionTemperature() {
	return permissionTemperature;
    }

    /**
     * @param permissionTemperature
     *            the permissionTemperature to set
     */
    public void setPermissionTemperature(Boolean permissionTemperature) {
	this.permissionTemperature = permissionTemperature;
    }

    /**
     * @return the companies
     */
    public Set<ICompany> getCompanies() {
	return new HashSet<ICompany>(companies);
    }

    /**
     * @param companies
     *            the companies to set
     */
    public void setCompanies(Set<ICompany> companies) {
	Iterator<ICompany> iterator = companies.iterator();
	while (iterator.hasNext()) {
	    this.companies.add((Company) iterator.next());
	}
    }

}
