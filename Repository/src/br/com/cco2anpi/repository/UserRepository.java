/**
 * 
 */
package br.com.cco2anpi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.User;

/**
 * @author wotan Class used to be the repository of the user
 */
public class UserRepository extends BaseRepository implements IUserRepository {

	/**
	 * Constructor of the class UserRepository
	 * 
	 * @param context
	 */
	public UserRepository(String context) {
		super(context);
	}

	/**
	 * Method to insert user in database
	 * 
	 * @param user
	 *            user to be inserted
	 * @return return object user filled
	 */
	public IUser insert(IUser user) {
		Session session = sessionFactory.openSession();
		Serializable id = session.save(new br.com.cco2anpi.database.User(user));
		IUser temp = session.get(br.com.cco2anpi.database.User.class, id);
		session.close();
		return new User(temp);
	}

	/**
	 * Method used to update user in database
	 * 
	 * @param user
	 *            user to be updated
	 * @return return the object user filled
	 */
	public IUser update(IUser user) {
		Session session = sessionFactory.openSession();
		session.update(new br.com.cco2anpi.database.User(user));
		session.close();
		return user;
	}

	/**
	 * Method used to delete user
	 * 
	 * @param user
	 *            to be deleted
	 * @return status of the delection
	 */
	public boolean delete(IUser user) {
		Session session = sessionFactory.openSession();
		session.delete(new br.com.cco2anpi.database.User(user));
		session.close();
		return true;
	}

	/**
	 * Method used to return all the users
	 * 
	 * @return array of the users
	 */
	public IUser[] allUsers() {
		Session session = sessionFactory.openSession();
		List<br.com.cco2anpi.database.User> users = session
				.createQuery("from User", br.com.cco2anpi.database.User.class).getResultList();
		List<User> usersTemp = new ArrayList<>();
		for (br.com.cco2anpi.database.User user : users) {
			usersTemp.add(new User(user));
		}
		session.close();
		IUser[] usersArray = new User[usersTemp.size()];
		usersTemp.toArray(usersArray);
		return usersArray;
	}

}
