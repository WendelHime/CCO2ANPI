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

import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.IEmployer;

/**
 * @author wotan Employer repository
 */
public class EmployersRepository extends BaseRepository implements IEmployerRepository
{

    /**
     * Constructor employer repository
     * 
     * @param context
     */
    public EmployersRepository(String context)
    {
	super(context);
    }

    /**
     * Method used to insert employer
     * 
     * @param employer
     *            to be inserted
     * @return employer inserted
     */
    public IEmployer insert(IEmployer employer)
    {
	Session session = getSessionFactory().openSession();
	Serializable id = session.save(new br.com.cco2anpi.database.Employer(employer));
	IEmployer temp = session.get(br.com.cco2anpi.database.Employer.class, id);
	session.close();
	close();
	return new Employer(temp);
    }

    /**
     * Method used to update employer
     * 
     * @param employer
     *            to be updated
     * @return employer updated
     */
    public IEmployer update(IEmployer employer)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	try
	{
	    session.update(new br.com.cco2anpi.database.Employer(employer));
	    transaction.commit();
	}
	catch (Exception ex)
	{
	    transaction.rollback();
	}
	session.close();
	close();
	return employer;
    }

    /**
     * Method used to delete employer
     * 
     * @param employer
     *            to be deleted
     * @return status
     */
    public boolean delete(IEmployer employer)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	boolean status = false;
	try
	{
	    session.delete(new br.com.cco2anpi.database.Employer(employer));
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
     * Method used to get employer by id
     * 
     * @param id
     *            to be used
     * @return employer if exists
     */
    public IEmployer getEmployer(Integer id)
    {
	Session session = getSessionFactory().openSession();
	Employer employer = new Employer(session.find(br.com.cco2anpi.database.Employer.class, id));
	session.close();
	close();
	return employer;
    }

    /**
     * Method used to get all employers
     * 
     * @param pageSize
     *            quantity of objects
     * @param offset
     *            quantity offset
     * @return return all employers
     */
    public HashMap<String, Object> getAllEmployers(int pageSize, int offset)
    {
	HashMap<String, Object> returnedValues = new HashMap<>();
	Session session = getSessionFactory().openSession();
	Query<br.com.cco2anpi.database.Employer> query = session.createQuery("from Employer",
		br.com.cco2anpi.database.Employer.class);
	returnedValues.put("total", new Integer(query.getResultList().size()));
	List<br.com.cco2anpi.database.Employer> list = query.setMaxResults(pageSize).setFirstResult(offset)
		.getResultList();
	session.close();
	close();
	List<IEmployer> employers = new ArrayList<>(list);

	returnedValues.put("employers", employers);
	return returnedValues;
    }

    /**
     * Method used to get all employers
     * 
     * @param pageSize
     *            quantity of objects
     * @param offset
     *            quantity offset
     * @return return all employers
     */
    public HashMap<String, Object> getEmployees(int companyID, int pageSize, int offset)
    {
	HashMap<String, Object> returnedValues = new HashMap<>();
	Session session = getSessionFactory().openSession();
	Query<br.com.cco2anpi.database.Employer> query = session
		.createQuery("from Employer employer where " + " employer.company.id = :companyID",
			br.com.cco2anpi.database.Employer.class)
		.setParameter("companyID", companyID);
	returnedValues.put("total", new Integer(query.getResultList().size()));
	List<br.com.cco2anpi.database.Employer> list = query.setMaxResults(pageSize).setFirstResult(offset)
		.getResultList();
	session.close();
	close();
	List<IEmployer> employers = new ArrayList<>(list);

	returnedValues.put("employees", employers);
	return returnedValues;
    }

}
