/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author wotan Class used to represent User
 */
public class User implements IUser
{

    protected Integer userID;
    protected String username;
    protected String password;
    protected String salt;
    protected String name;
    protected String cpf;
    protected Integer type;
    @JsonDeserialize(as = HashSet.class, contentAs = Access.class)
    protected Set<Access> access = new HashSet<>(0);

    public User()
    {

    }

    /**
     * Constructor method class
     * 
     * @param sourceObject
     */
    public User(IUser sourceObject)
    {
	userID = sourceObject.getUserId();
	username = sourceObject.getUsername();
	password = sourceObject.getPassword();
	salt = sourceObject.getSalt();
	name = sourceObject.getName();
	cpf = sourceObject.getCpf();
	setAccess(sourceObject.getAccess());
	type = sourceObject.getType();
    }

    /**
     * @return the id
     */
    public Integer getUserId()
    {
	return userID;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setUserId(Integer id)
    {
	this.userID = id;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
	return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username)
    {
	this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
	return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password)
    {
	this.password = password;
    }

    /**
     * @return the salt
     */
    public String getSalt()
    {
	return salt;
    }

    /**
     * @param salt
     *            the salt to set
     */
    public void setSalt(String salt)
    {
	this.salt = salt;
    }

    /**
     * @return the name
     */
    public String getName()
    {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
	this.name = name;
    }

    /**
     * @return the cpf
     */
    public String getCpf()
    {
	return cpf;
    }

    /**
     * @param cpf
     *            the cpf to set
     */
    public void setCpf(String cpf)
    {
	this.cpf = cpf;
    }

    /**
     * @return the access
     */
    public Set<IAccess> getAccess()
    {
	return new HashSet<IAccess>(access);
    }

    /**
     * @param access
     *            the access to set
     */
    public void setAccess(Set<IAccess> access)
    {
	Iterator<IAccess> iterator = access.iterator();
	while (iterator.hasNext())
	{
	    this.access.add(new Access(iterator.next()));
	}
	// this.access = access;
    }

    /**
     * @return the type
     */
    public Integer getType()
    {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Integer type)
    {
	this.type = type;
    }

}
