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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IComplexBuilding;

/**
 * @author wotan
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "BUILDING_SETS")
public class ComplexBuilding implements Serializable, IComplexBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String number;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "complexBuilding")
    private Set<Company> companies = new HashSet<>(0);

    public ComplexBuilding() {

    }

    public ComplexBuilding(IComplexBuilding sourceObject) {
	this.id = sourceObject.getId();
	this.number = sourceObject.getNumber();
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
     * @return the number
     */
    public String getNumber() {
	return number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(String number) {
	this.number = number;
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
