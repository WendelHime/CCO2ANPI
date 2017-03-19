/**
 * 
 */
package br.com.cco2anpi.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.cco2anpi.models.ICompany;
import br.com.cco2anpi.models.IEmployer;

/**
 * @author wotan
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEES")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User implements Serializable, IEmployer
{

    // @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "access_hour")
    private String accessHour;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "permission_temperature", columnDefinition = "TINYINT")
    private Boolean permissionTemperature;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonBackReference
    private Company company;

    public Employer()
    {

    }

    public Employer(IEmployer sourceObject)
    {
	this.id = sourceObject.getId();
	this.userID = sourceObject.getUserID();
	this.accessHour = sourceObject.getAccessHour();
	this.permissionTemperature = sourceObject.getPermissionTemperature();
	this.setUsername(sourceObject.getUsername());
	this.setPassword(sourceObject.getPassword());
	this.setSalt(sourceObject.getSalt());
	this.setName(sourceObject.getName());
	this.setCpf(sourceObject.getCpf());
	this.setAccess(sourceObject.getAccess());
	this.setType(sourceObject.getType());
	this.setCompany(sourceObject.getCompany());
    }

    /**
     * @return the id
     */
    public Integer getId()
    {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id)
    {
	this.id = id;
    }

    /**
     * @return the accessHour
     */
    public String getAccessHour()
    {
	return accessHour;
    }

    /**
     * @param accessHour
     *            the accessHour to set
     */
    public void setAccessHour(String accessHour)
    {
	this.accessHour = accessHour;
    }

    /**
     * @return the permissionTemperature
     */
    public Boolean getPermissionTemperature()
    {
	return permissionTemperature;
    }

    /**
     * @param permissionTemperature
     *            the permissionTemperature to set
     */
    public void setPermissionTemperature(Boolean permissionTemperature)
    {
	this.permissionTemperature = permissionTemperature;
    }

    /**
     * @return the companies
     */
    public ICompany getCompany()
    {
	return this.company;
    }

    /**
     * @param company
     *            the companies to set
     */
    public void setCompany(ICompany company)
    {
	this.company = new Company(company);
    }

    /**
     * @return the user id
     */
    public Integer getUserID()
    {
	return super.getUserId();
    }

    /**
     * @param id
     *            id of the user
     */
    public void setUserID(Integer id)
    {
	super.setUserId(id);
    }

}
