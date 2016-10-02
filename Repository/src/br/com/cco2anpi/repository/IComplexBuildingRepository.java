/**
 * 
 */
package br.com.cco2anpi.repository;

import br.com.cco2anpi.models.IComplexBuilding;

/**
 * @author wotan
 *
 */
public interface IComplexBuildingRepository {
    IComplexBuilding insert(IComplexBuilding complexBuilding);

    IComplexBuilding update(IComplexBuilding complexBuilding);

    boolean delete(IComplexBuilding complexBuilding);

    IComplexBuilding getComplexBuilding(Integer id);

    IComplexBuilding[] getAllBuildingSets();
}
