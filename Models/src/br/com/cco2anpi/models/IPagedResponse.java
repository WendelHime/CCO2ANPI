/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.List;

/**
 * @author wotan
 *
 */
public interface IPagedResponse<T> {
	long getElapsed_ms();

	String getMessage();

	int getStatusCode();

	List<T> getResponse();

	int getTotal();

	int getOffset();

	int getPageSize();

	void setElapsed_ms(long elapsed_ms);

	void setMessage(String message);

	void setStatusCode(int status);

	void setResponse(List<T> response);

	void setTotal(int total);

	void setOffset(int offset);

	void setPageSize(int pageSize);

}
