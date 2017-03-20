/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public interface ISet
{
    Integer getId();

    String getNumber();

    ICompany getCompany();

    void setId(Integer id);

    void setNumber(String number);

    void setCompany(ICompany company);
}
