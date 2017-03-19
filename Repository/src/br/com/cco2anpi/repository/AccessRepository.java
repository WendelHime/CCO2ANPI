/**
 * 
 */
package br.com.cco2anpi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.IAccess;

/**
 * @author wotan class used to be the repository of the access
 */
public class AccessRepository extends BaseRepository implements IAccessRepository
{
    /**
     * Constructor of the class AccessRepository
     * 
     * @param context
     */
    public AccessRepository(String context)
    {
	super(context);
    }

    /**
     * Method used to insert access
     * 
     * @param access
     *            object to be inserted
     * @return return the object inserted
     */
    public IAccess insert(IAccess access)
    {
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
    public IAccess update(IAccess access)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	try
	{
	    session.update(new br.com.cco2anpi.database.Access(access));
	    transaction.commit();
	}
	catch (Exception ex)
	{
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
    public boolean delete(IAccess access)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	boolean status = false;
	try
	{
	    session.delete(new br.com.cco2anpi.database.Access(access));
	    transaction.commit();
	    status = true;
	}
	catch (Exception ex)
	{
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
    public IAccess getAccess(Integer id)
    {
	Session session = getSessionFactory().openSession();
	Access access = new Access(session.find(br.com.cco2anpi.database.Access.class, id));
	session.close();
	close();
	return access;
    }

    /**
     * Method used to get all access
     * 
     * @param pageSize
     *            quantity of objects
     * @param offset
     *            quantity offset
     * @return return all access in array;
     */
    public HashMap<String, Object> getAllAccess(int pageSize, int offset)
    {
	HashMap<String, Object> returnedValues = new HashMap<>();
	Session session = getSessionFactory().openSession();
	Query<br.com.cco2anpi.database.Access> query = session.createQuery("from Access",
		br.com.cco2anpi.database.Access.class);
	returnedValues.put("total", new Integer(query.getResultList().size()));
	List<br.com.cco2anpi.database.Access> accessList = query.setMaxResults(pageSize).setFirstResult(offset)
		.getResultList();
	session.close();
	close();
	ArrayList<IAccess> list = new ArrayList<>(accessList);
	returnedValues.put("access", list);
	return returnedValues;
    }

    /**
     * Method used to get filtred access
     * 
     * @param type
     *            is the type of the user
     * @param dateInit
     *            is the date to start the search
     * @param pageSize
     *            quantity of objects
     * @param offset
     *            quantity offset
     * @return return all access in array;
     */
    public HashMap<String, Object> getAccessByTypeAndDate(Integer type, String dateInit, String dateEnd, int pageSize,
	    int offset)
    {
	HashMap<String, Object> returnedValues = new HashMap<>();
	Session session = getSessionFactory().openSession();
	Query<br.com.cco2anpi.database.Access> query = session
		.createQuery(
			"from Access access where " + "access.user.type = :type and "
				+ "STR_TO_DATE(access.dateIn, '%d/%m/%Y') " + "between "
				+ "STR_TO_DATE(:dateInit, '%d/%m/%Y') and " + "STR_TO_DATE(:dateEnd, '%d/%m/%Y')",
			br.com.cco2anpi.database.Access.class)
		.setParameter("dateInit", dateInit).setParameter("dateEnd", dateEnd).setParameter("type", type);
	returnedValues.put("total", new Integer(query.getResultList().size()));
	List<br.com.cco2anpi.database.Access> accessList = query.getResultList();
	session.close();
	close();
	ArrayList<IAccess> list = new ArrayList<>(accessList);
	returnedValues.put("access", list);
	return returnedValues;
    }

}
