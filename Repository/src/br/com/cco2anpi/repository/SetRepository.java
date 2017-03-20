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

import br.com.cco2anpi.models.ISet;

/**
 * @author wotan
 *
 *         class used to realize interactios between Set and database
 */
public class SetRepository extends BaseRepository implements ISetRepository
{

    /**
     * Constructor of the class
     * 
     * @param context
     *            address to config file db
     */
    public SetRepository(String context)
    {
	super(context);
    }

    /**
     * Method used to insert Set
     * 
     * @param set
     *            to be inserted
     */
    public ISet insert(ISet set)
    {
	Session session = getSessionFactory().openSession();
	Serializable id = session.save(new br.com.cco2anpi.database.Set(set));
	ISet temp = session.get(br.com.cco2anpi.database.Set.class, id);
	session.close();
	close();
	return new br.com.cco2anpi.models.Set(temp);
    }

    /**
     * Method used to update Set
     * 
     * @param set
     *            to be updated
     */
    public ISet update(ISet set)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	try
	{
	    session.update(new br.com.cco2anpi.database.Set(set));
	    transaction.commit();
	}
	catch (Exception ex)
	{
	    transaction.rollback();
	}
	session.close();
	close();
	return set;
    }

    /**
     * Methos used to delete Set
     * 
     * @param id
     *            identifier to be deleted
     */
    public boolean delete(ISet set)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	boolean status = false;
	try
	{
	    session.delete(new br.com.cco2anpi.database.Set(set));
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
     * Method used to get Set
     * 
     * @param id
     *            identifier of the Set
     */
    public ISet getSet(Integer id)
    {
	Session session = getSessionFactory().openSession();
	ISet user = new br.com.cco2anpi.models.Set(session.find(br.com.cco2anpi.database.Set.class, id));
	session.close();
	close();
	return user;
    }

    /**
     * Method used to get Sets
     * 
     * @param pageSize
     *            quantity of values
     * @param offset
     *            quantity offset
     */
    public HashMap<String, Object> getSets(int pageSize, int offset)
    {
	HashMap<String, Object> returnedValues = new HashMap<>();
	Session session = getSessionFactory().openSession();
	Query<br.com.cco2anpi.database.Set> query = session.createQuery("from Set", br.com.cco2anpi.database.Set.class);
	returnedValues.put("total", new Integer(query.getResultList().size()));
	List<br.com.cco2anpi.database.Set> sets = query.setMaxResults(pageSize).setFirstResult(offset).getResultList();
	ArrayList<ISet> list = new ArrayList<>(sets);
	session.close();
	close();
	returnedValues.put("sets", list);
	return returnedValues;
    }

}
