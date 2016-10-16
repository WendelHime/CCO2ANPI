/**
 * 
 */
package br.com.cco2anpi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cco2anpi.models.Employer;
import br.com.cco2anpi.models.IEmployer;

/**
 * @author wotan Employer repository
 */
public class EmployersRepository extends BaseRepository implements IEmployerRepository {

    /**
     * Constructor employer repository
     * 
     * @param context
     */
    public EmployersRepository(String context) {
	super(context);
    }

    /**
     * Method used to insert employer
     * 
     * @param employer
     *            to be inserted
     * @return employer inserted
     */
    public IEmployer insert(IEmployer employer) {
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
    public IEmployer update(IEmployer employer) {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	try {
	    session.update(new br.com.cco2anpi.database.Employer(employer));
	    transaction.commit();
	} catch (Exception ex) {
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
    public boolean delete(IEmployer employer) {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	boolean status = false;
	try {
	    session.delete(new br.com.cco2anpi.database.Employer(employer));
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
     * Method used to get employer by id
     * 
     * @param id
     *            to be used
     * @return employer if exists
     */
    public IEmployer getEmployer(Integer id) {
	Session session = getSessionFactory().openSession();
	Employer employer = new Employer(session.find(br.com.cco2anpi.database.Employer.class, id));
	session.close();
	close();
	return employer;
    }

    /**
     * Method used to get all employers
     * 
     * @return return all employers
     */
    public IEmployer[] getAllEmployers() {
	Session session = getSessionFactory().openSession();
	List<br.com.cco2anpi.database.Employer> list = session
		.createQuery("from Employer", br.com.cco2anpi.database.Employer.class).getResultList();
	List<Employer> tempList = new ArrayList<>();
	for (br.com.cco2anpi.database.Employer employer : list) {
	    tempList.add(new Employer(employer));
	}
	session.close();
	close();
	IEmployer[] employers = new Employer[tempList.size()];
	tempList.toArray(employers);
	return employers;
    }

}
