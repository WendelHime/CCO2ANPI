/**
 * 
 */
package br.com.cco2anpi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.IAccess;

/**
 * @author wotan class used to be the repository of the access
 */
public class AccessRepository extends BaseRepository implements IAccessRepository {
    /**
     * Constructor of the class AccessRepository
     * 
     * @param context
     */
    public AccessRepository(String context) {
	super(context);
    }

    /**
     * Method used to insert access
     * 
     * @param access
     *            object to be inserted
     * @return return the object inserted
     */
    public IAccess insert(IAccess access) {
	Session session = sessionFactory.openSession();
	Serializable id = session.save(new br.com.cco2anpi.database.Access(access));
	IAccess temp = session.get(br.com.cco2anpi.database.Access.class, id);
	session.close();
	return new Access(temp);
    }

    /**
     * Method used to update data
     * 
     * @param access
     *            object to be updated
     * @return return the object updated
     */
    public IAccess update(IAccess access) {
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.update(new br.com.cco2anpi.database.Access(access));
	    transaction.commit();
	} catch (Exception ex) {
	    transaction.rollback();
	}
	session.close();
	return access;
    }

    /**
     * Method used to delete access
     * 
     * @param access
     *            object to be deleted
     * @return return status
     */
    public boolean delete(IAccess access) {
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	boolean status = false;
	try {
	    session.delete(new br.com.cco2anpi.database.Access(access));
	    transaction.commit();
	    status = true;
	} catch (Exception ex) {
	    transaction.rollback();
	}
	session.close();
	return status;
    }

    /**
     * Method used to search access by id
     * 
     * @param id
     *            to be used
     * @return return the access if exists
     */
    public IAccess getAccess(Integer id) {
	Session session = sessionFactory.openSession();
	Access access = new Access(session.find(br.com.cco2anpi.database.Access.class, id));
	session.close();
	return access;
    }

    /**
     * Method used to get all access
     * 
     * @return return all access in array;
     */
    public IAccess[] getAllAccess() {
	Session session = sessionFactory.openSession();
	List<br.com.cco2anpi.database.Access> accessList = session
		.createQuery("from Access", br.com.cco2anpi.database.Access.class).getResultList();
	List<Access> accessTemp = new ArrayList<>();
	for (br.com.cco2anpi.database.Access access1 : accessList) {
	    accessTemp.add(new Access(access1));
	}
	session.close();
	IAccess[] accessArray = new Access[accessTemp.size()];
	accessTemp.toArray(accessArray);
	return accessArray;
    }

}
