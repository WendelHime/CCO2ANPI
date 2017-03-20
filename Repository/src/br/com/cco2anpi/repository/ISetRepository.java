/**
 * 
 */
package br.com.cco2anpi.repository;

import java.util.HashMap;

import br.com.cco2anpi.models.ISet;

/**
 * @author wotan
 *
 */
public interface ISetRepository
{
    ISet insert(ISet set);

    ISet update(ISet set);

    boolean delete(ISet id);

    ISet getSet(Integer id);

    HashMap<String, Object> getSets(int pageSize, int offset);
}
