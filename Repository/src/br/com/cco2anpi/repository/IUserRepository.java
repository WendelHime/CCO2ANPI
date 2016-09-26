/**
 * 
 */
package br.com.cco2anpi.repository;

import br.com.cco2anpi.models.IUser;
import br.com.cco2anpi.models.User;

/**
 * @author wotan
 *
 */
public interface IUserRepository {
	IUser insert(IUser user);

	IUser update(IUser user);

	boolean delete(IUser id);

	IUser[] allUsers();
}
