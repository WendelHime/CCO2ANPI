/**
 * 
 */
package br.com.cco2anpi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.User;

/**
 * @author wotan Class used to be the repository of the user
 */
public class UserRepository extends BaseRepository implements IUserRepository
{

    /**
     * Constructor of the class UserRepository
     * 
     * @param context
     */
    public UserRepository(String context)
    {
	super(context);
    }

    /**
     * Method to insert user in database
     * 
     * @param user
     *            user to be inserted
     * @return return object user filled
     */
    public IUser insert(IUser user)
    {
	Session session = getSessionFactory().openSession();
	Serializable id = session.save(new br.com.cco2anpi.database.User(user));
	IUser temp = session.get(br.com.cco2anpi.database.User.class, id);
	session.close();
	close();
	return new User(temp);
    }

    /**
     * Method used to update user in database
     * 
     * @param user
     *            user to be updated
     * @return return the object user filled
     */
    public IUser update(IUser user)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	try
	{
	    session.update(new br.com.cco2anpi.database.User(user));
	    transaction.commit();
	}
	catch (Exception ex)
	{
	    transaction.rollback();
	}
	session.close();
	close();
	return user;
    }

    /**
     * Method used to delete user
     * 
     * @param user
     *            to be deleted
     * @return status of the delection
     */
    public boolean delete(IUser user)
    {
	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	boolean status = false;
	try
	{
	    session.delete(new br.com.cco2anpi.database.User(user));
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
     * Method used to return used by id
     * 
     * @param id
     *            id of the user
     * @return object user by id
     */
    public IUser getUser(Integer id)
    {
	Session session = getSessionFactory().openSession();
	User user = new User(session.find(br.com.cco2anpi.database.User.class, id));
	session.close();
	close();
	return user;
    }

    /**
     * Method used to return all the users
     * 
     * @param pageSize
     *            quantity of objects
     * @param offset
     *            quantity offset
     * @return array of the users
     */
    public HashMap<String, Object> getAllUsers(int pageSize, int offset)
    {
	HashMap<String, Object> returnedValues = new HashMap<>();
	Session session = getSessionFactory().openSession();
	Query<br.com.cco2anpi.database.User> query = session.createQuery("from User",
		br.com.cco2anpi.database.User.class);
	returnedValues.put("total", new Integer(query.getResultList().size()));
	List<br.com.cco2anpi.database.User> users = query.setMaxResults(pageSize).setFirstResult(offset)
		.getResultList();
	ArrayList<IUser> list = new ArrayList<>(users);
	session.close();
	close();
	returnedValues.put("users", list);
	return returnedValues;
    }

    /**
     * Method used to check existense of the user
     * 
     * @return true if exists, false if not
     */
    public boolean exists(IUser user)
    {
	Session session = getSessionFactory().openSession();
	boolean status = false;
	if (user.getUserId() != null)
	{
	    try
	    {
		User objectTest = new User(session.find(br.com.cco2anpi.database.User.class, user.getUserId()));
		System.out.println("User id:\t" + objectTest.getUserId());
		status = true;
	    }
	    catch (Exception ex)
	    {
		status = false;
	    }
	}
	else
	{
	    try
	    {
		session.createQuery("from User user where user.username = :username",
			br.com.cco2anpi.database.User.class).setParameter("username", user.getUsername())
			.getSingleResult();
		status = true;
	    }
	    catch (NoResultException noResult)
	    {
		status = false;
	    }
	    catch (Exception ex)
	    {
		status = true;
	    }
	}
	session.close();
	close();
	return status;
    }

}
