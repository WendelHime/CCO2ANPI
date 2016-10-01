/**
 * 
 */
package br.com.cco2anpi.repository;

import br.com.cco2anpi.models.IUser;

/**
 * @author wotan
 *
 */
public interface IUserRepository {
    IUser insert(IUser user);

    IUser update(IUser user);

    boolean delete(IUser id);

    IUser getUser(Integer id);
    
    IUser[] getAllUsers();

    boolean exists(IUser user);
}
