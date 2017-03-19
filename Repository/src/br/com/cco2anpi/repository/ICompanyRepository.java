/**
 * 
 */
package br.com.cco2anpi.repository;

import java.util.HashMap;

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

    HashMap<String, Object> getAllCompanies(int pageSize, int offset);
}
