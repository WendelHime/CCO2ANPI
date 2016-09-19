/**
 * 
 */
package br.com.cco2anpi.models;
/**
 * @author 201407067
 *
 */
public interface IUser {
	void setId(int id);
	void setUsername(String username);
	void setPassword(String password);
	void setSalt(String salt);
	void setName(String name);
	void setCpf(String cpf);
	void setOfficeHours(int officeHours);
	void setAccess(IAccess[] access);
	int getId();
	String getUsername();
	String getPassword();
	String getSalt();
	String getName();
	String getCpf();
	int getOfficeHours();
	IAccess[] getAccess();
}
