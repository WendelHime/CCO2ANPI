/**
 * 
 */
package br.com.cco2anpi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cco2anpi.models.ComplexBuilding;
import br.com.cco2anpi.models.IComplexBuilding;

/**
 * @author wotan repository of the complex building
 */
public class ComplexBuildingRepository extends BaseRepository implements IComplexBuildingRepository {

    /**
     * Constructor of the repository
     * 
     * @param context
     */
    public ComplexBuildingRepository(String context) {
	super(context);
    }

    /**
     * Method used to insert complex building
     * 
     * @param complexBuilding
     *            object to be inserted
     * @return object inserted
     */
    public IComplexBuilding insert(IComplexBuilding complexBuilding) {
	Session session = getSessionFactory().openSession();
	Serializable id = session.save(new br.com.cco2anpi.database.ComplexBuilding(complexBuilding));
	IComplexBuilding temp = session.get(br.com.cco2anpi.database.ComplexBuilding.class, id);
	session.close();
	close();
	return new ComplexBuilding(temp);
    }

    /**
     * Method used to update complex building
     * 
     * @param complexBuilding
     *            to be updated
     * @return object updated
     */
    public IComplexBuilding update(IComplexBuilding complexBuilding) {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.update(new br.com.cco2anpi.database.ComplexBuilding(complexBuilding));
	    transaction.commit();
	} catch (Exception ex) {
	    transaction.rollback();
	}
	session.close();
	close();
	return complexBuilding;
    }

    /**
     * Method used to delete complex building
     * 
     * @param complexBuilding
     *            to be deleted
     * @return status;
     */
    public boolean delete(IComplexBuilding complexBuilding) {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	boolean status = false;
	try {
	    session.delete(new br.com.cco2anpi.database.ComplexBuilding(complexBuilding));
	    transaction.commit();
	    status = true;
	} catch (Exception ex) {
	    transaction.rollback();
	}
	session.close();
	close();
	return status;
    }

    /**
     * Method used to search complex building by id
     * 
     * @param id
     *            id to be used
     * @return complex building if exists
     */
    public IComplexBuilding getComplexBuilding(IComplexBuilding complexBuilding) {
	Session session = getSessionFactory().openSession();
	ComplexBuilding complexBuildingResult = new ComplexBuilding(session
		.createQuery("from ComplexBuilding complex where complex.id = :id or complex.number = :number",
			br.com.cco2anpi.database.ComplexBuilding.class)
		.setParameter("id", complexBuilding.getId()).setParameter("number", complexBuilding.getNumber())
		.getSingleResult());
	session.close();
	close();
	return complexBuildingResult;
    }

    /**
     * Method used to get all building sets
     * 
     * @return all complex building array
     */
    public IComplexBuilding[] getAllBuildingSets() {
	Session session = getSessionFactory().openSession();
	List<br.com.cco2anpi.database.ComplexBuilding> complexBuildingList = session
		.createQuery("from ComplexBuilding", br.com.cco2anpi.database.ComplexBuilding.class).getResultList();
	List<ComplexBuilding> complexBuildingTemp = new ArrayList<>();
	for (br.com.cco2anpi.database.ComplexBuilding user : complexBuildingList) {
	    complexBuildingTemp.add(new ComplexBuilding(user));
	}
	session.close();
	close();
	IComplexBuilding[] buildingSetsArray = new ComplexBuilding[complexBuildingTemp.size()];
	complexBuildingTemp.toArray(buildingSetsArray);
	return buildingSetsArray;
    }

}
