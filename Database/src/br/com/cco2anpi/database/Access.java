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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cco2anpi.models.IAccess;

/**
 * @author wotan
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCESS")
public class Access implements Serializable, IAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "date_in")
    private String dateIn;
    @Column(name = "date_out")
    private String dateOut;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Access() {

    }

    public Access(IAccess sourceObject) {
	this.id = sourceObject.getId();
	this.dateIn = sourceObject.getDateIn();
	this.dateOut = sourceObject.getDateOut();
	this.user = new User(sourceObject.getUser());
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
     * @return the dateIn
     */
    public String getDateIn() {
	return dateIn;
    }

    /**
     * @param dateIn
     *            the dateIn to set
     */
    public void setDateIn(String dateIn) {
	this.dateIn = dateIn;
    }

    /**
     * @return the dateOut
     */
    public String getDateOut() {
	return dateOut;
    }

    /**
     * @param dateOut
     *            the dateOut to set
     */
    public void setDateOut(String dateOut) {
	this.dateOut = dateOut;
    }

    /**
     * @return the user
     */
    public br.com.cco2anpi.models.User getUser() {
	return new br.com.cco2anpi.models.User(user);
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(br.com.cco2anpi.models.User user) {
	this.user = new User(user);
    }

}
