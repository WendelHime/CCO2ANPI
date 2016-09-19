/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 * Class used to represent User
 */
public class User implements IUser {

	protected int id;
	protected String username;
	protected String password;
	protected String salt;
	protected String name;
	protected String cpf;
	protected int officeHours;
	protected Access[] access;
	
	
	public User()
	{
		
	}
	
	/**
	 * Constructor method class
	 * @param sourceObject
	 */
	public User(IUser sourceObject)
	{
		id = sourceObject.getId();
		username = sourceObject.getUsername();
		password = sourceObject.getPassword();
		salt = sourceObject.getSalt();
		name = sourceObject.getName();
		cpf = sourceObject.getCpf();
		officeHours = sourceObject.getOfficeHours();
		access = (Access[]) sourceObject.getAccess();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the officeHours
	 */
	public int getOfficeHours() {
		return officeHours;
	}

	/**
	 * @param officeHours the officeHours to set
	 */
	public void setOfficeHours(int officeHours) {
		this.officeHours = officeHours;
	}
	
	/**
	 * @return the access
	 */
	public Access[] getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(IAccess[] access) {
		this.access = (Access[]) access;
	}
	

}
