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
	void setDateIn(Long date);
	void setDateOut(Long date);
	void setUser(IUser user);
	Integer getId();
	Long getDateIn();
	Long getDateOut();
	IUser getUser();
}
