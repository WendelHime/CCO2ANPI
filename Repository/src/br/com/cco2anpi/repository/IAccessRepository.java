package br.com.cco2anpi.repository;

import br.com.cco2anpi.models.IAccess;

/**
 * 
 * @author wotan
 *
 */
public interface IAccessRepository {
    IAccess insert(IAccess access);

    IAccess update(IAccess access);

    boolean delete(IAccess access);

    IAccess getAccess(Integer id);

    IAccess[] getAllAccess();
}
