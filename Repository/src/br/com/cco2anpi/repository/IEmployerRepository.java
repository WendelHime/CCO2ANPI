/**
 * 
 */
package br.com.cco2anpi.repository;

import br.com.cco2anpi.models.IEmployer;

/**
 * @author wotan
 *
 */
public interface IEmployerRepository {
    IEmployer insert(IEmployer employer);

    IEmployer update(IEmployer employer);

    boolean delete(IEmployer employer);

    IEmployer getEmployer(Integer id);

    IEmployer[] getAllEmployers();
}
