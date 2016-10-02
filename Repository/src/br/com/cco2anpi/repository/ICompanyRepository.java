/**
 * 
 */
package br.com.cco2anpi.repository;

import br.com.cco2anpi.models.ICompany;

/**
 * @author wotan
 *
 */
public interface ICompanyRepository {
    ICompany insert(ICompany company);

    ICompany update(ICompany company);

    boolean delete(ICompany company);

    ICompany getCompany(Integer id);

    ICompany[] getAllCompanies();
}
