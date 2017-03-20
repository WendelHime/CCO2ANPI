/**
 * 
 */
package br.com.cco2anpi.database;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.ISet;

/**
 * @author wotan
 *
 */
@Entity
@Table(name = "SETS")
public class Set implements ISet
{

    private Integer id;
    private String number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonBackReference
    private Company company;

    public Set()
    {

    }

    public Set(ISet sourceObject)
    {
	id = sourceObject.getId();
	number = sourceObject.getNumber();
	this.setCompany(sourceObject.getCompany());
    }

    /**
     * @return the id
     */
    public Integer getId()
    {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id)
    {
	this.id = id;
    }

    /**
     * @return the number
     */
    public String getNumber()
    {
	return number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(String number)
    {
	this.number = number;
    }

    /**
     * @return the company
     */
    public ICompany getCompany()
    {
	return company;
    }

    /**
     * @param company
     *            the company to set
     */
    public void setCompany(ICompany company)
    {
	this.company = new Company(company);
    }

}
