/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wotan Class used to represent complex building
 */
public class ComplexBuilding implements IComplexBuilding {
    private Integer id;
    private String number;
    private Set<ICompany> companies = new HashSet<>(0);

    public ComplexBuilding() {

    }

    public ComplexBuilding(IComplexBuilding sourceObject) {
	id = sourceObject.getId();
	number = sourceObject.getNumber();
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
        return companies;
    }

    /**
     * @param companies the companies to set
     */
    public void setCompanies(Set<ICompany> companies) {
        this.companies = companies;
    }
    
    

}
