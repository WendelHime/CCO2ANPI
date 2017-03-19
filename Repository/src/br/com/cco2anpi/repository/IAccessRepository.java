package br.com.cco2anpi.repository;

import java.util.HashMap;

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

    HashMap<String, Object> getAllAccess(int pageSize, int offset);
    
    HashMap<String, Object> getAccessByTypeAndDate(Integer type, String dateInit, String dateEnd, int pageSize, int offset);
}
