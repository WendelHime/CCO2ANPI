/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.Set;

/**
 * @author 201407067
 *
 */
public interface IUser {
	void setUserId(Integer id);
	void setUsername(String username);
	void setPassword(String password);
	void setSalt(String salt);
	void setName(String name);
	void setCpf(String cpf);
	void setOfficeHours(String officeHours);
	void setAccess(Set<IAccess> access);
	void setType(Integer type);
	Integer getUserId();
	String getUsername();
	String getPassword();
	String getSalt();
	String getName();
	String getCpf();
	String getOfficeHours();
	Set<IAccess> getAccess();
	Integer getType();
}
