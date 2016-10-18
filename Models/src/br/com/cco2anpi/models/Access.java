/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public class Access implements IAccess {
    private Integer id;
    private String dateIn;
    private String dateOut;
    private User user;

    public Access() {

    }

    public Access(IAccess sourceObject) {
	id = sourceObject.getId();
	dateIn = sourceObject.getDateIn();
	dateOut = sourceObject.getDateOut();
	setUser(sourceObject.getUser());
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
    public User getUser() {
	return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
	this.user = new User(user);
    }

}
