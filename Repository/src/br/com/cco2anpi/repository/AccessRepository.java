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
	Session session = getSessionFactory().openSession();
	Serializable id = session.save(new br.com.cco2anpi.database.Access(access));
	IAccess temp = session.get(br.com.cco2anpi.database.Access.class, id);
	session.close();
	close();
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
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.update(new br.com.cco2anpi.database.Access(access));
	    transaction.commit();
	} catch (Exception ex) {
	    transaction.rollback();
	}
	session.close();
	close();
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
	Session session = getSessionFactory().openSession();
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
	close();
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
	Session session = getSessionFactory().openSession();
	Access access = new Access(session.find(br.com.cco2anpi.database.Access.class, id));
	session.close();
	close();
	return access;
    }

    /**
     * Method used to get all access
     * 
     * @return return all access in array;
     */
    public IAccess[] getAllAccess() {
	Session session = getSessionFactory().openSession();
	List<br.com.cco2anpi.database.Access> accessList = session
		.createQuery("from Access", br.com.cco2anpi.database.Access.class).getResultList();
	List<Access> accessTemp = new ArrayList<>();
	for (br.com.cco2anpi.database.Access access1 : accessList) {
	    accessTemp.add(new Access(access1));
	}
	session.close();
	close();
	IAccess[] accessArray = new Access[accessTemp.size()];
	accessTemp.toArray(accessArray);
	return accessArray;
    }

    /**
     * Method used to get filtred access
     * 
     * @param type
     *            is the type of the user
     * @param dateInit
     *            is the date to start the search
     * 
     */
    public IAccess[] getAccessByTypeAndDate(Integer type, String dateInit, String dateEnd) {
	Session session = getSessionFactory().openSession();
	List<br.com.cco2anpi.database.Access> accessList = session
		.createQuery(
			"from Access access where " + "access.user.type = :type and "
				+ "STR_TO_DATE(access.dateIn, '%d/%m/%Y') " + "between "
				+ "STR_TO_DATE(:dateInit, '%d/%m/%Y') and " + "STR_TO_DATE(:dateEnd, '%d/%m/%Y')",
			br.com.cco2anpi.database.Access.class)
		.setParameter("dateInit", dateInit).setParameter("dateEnd", dateEnd).setParameter("type", type)
		.getResultList();
	session.close();
	close();
	IAccess[] access = new Access[accessList.size()];
	accessList.toArray(access);
	return access;
    }

}
