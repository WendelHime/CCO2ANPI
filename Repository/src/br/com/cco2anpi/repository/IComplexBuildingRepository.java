/**
 * 
 */
package br.com.cco2anpi.repository;

import java.util.HashMap;

import br.com.cco2anpi.models.IComplexBuilding;

/**
 * @author wotan
 *
 */
public interface IComplexBuildingRepository {
    IComplexBuilding insert(IComplexBuilding complexBuilding);

    IComplexBuilding update(IComplexBuilding complexBuilding);

    boolean delete(IComplexBuilding complexBuilding);

    IComplexBuilding getComplexBuilding(IComplexBuilding id);

    HashMap<String, Object> getAllBuildingSets(int pageSize, int offset);
}
