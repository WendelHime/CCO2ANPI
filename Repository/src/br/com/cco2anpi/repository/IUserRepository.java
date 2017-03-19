/**
 * 
 */
package br.com.cco2anpi.repository;

import java.util.HashMap;

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

    HashMap<String, Object> getAllUsers(int pageSize, int offset);

    boolean exists(IUser user);
}
