/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 * Interface related of access
 */
public interface IAccess {
	void setId(Integer id);
	void setDateIn(String date);
	void setDateOut(String date);
	void setUser(IUser user);
	Integer getId();
	String getDateIn();
	String getDateOut();
	IUser getUser();
}
