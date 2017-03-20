/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public class Set implements ISet
{

    private Integer id;
    private String number;
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
