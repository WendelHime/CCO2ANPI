/**
 * 
 */
package br.com.cco2anpi.database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.cco2anpi.models.IAccess;
import br.com.cco2anpi.models.IUser;

/**
 * @author wotan
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable, IUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String cpf;
    @Column(name = "office_hours")
    private String officeHours;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Access> access = new HashSet<>(0);

    public User() {

    }

    /**
     * Constructor of the class User
     * 
     * @param sourceObject
     *            Object to be used
     */
    public User(IUser sourceObject) {
	id = sourceObject.getId();
	username = sourceObject.getUsername();
	password = sourceObject.getPassword();
	salt = sourceObject.getSalt();
	name = sourceObject.getName();
	cpf = sourceObject.getCpf();
	officeHours = sourceObject.getOfficeHours();
	setAccess(sourceObject.getAccess());
    }

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
	return username;
    }

    /**
     * @param username
     *            the username to set
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
     * @param password
     *            the password to set
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
     * @param salt
     *            the salt to set
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
     * @param name
     *            the name to set
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
     * @param cpf
     *            the cpf to set
     */
    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    /**
     * @return the officeHours
     */
    public String getOfficeHours() {
	return officeHours;
    }

    /**
     * @param officeHours
     *            the officeHours to set
     */
    public void setOfficeHours(String officeHours) {
	this.officeHours = officeHours;
    }

    /**
     * @return the access
     */
    public Set<IAccess> getAccess() {
	return new HashSet<IAccess>(access);
    }

    /**
     * @param access
     *            the access to set
     */
    public void setAccess(Set<IAccess> access) {
	Iterator<IAccess> iterator = access.iterator();
	while (iterator.hasNext()) {
	    this.access.add((Access) iterator.next());
	}
    }


}
