/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public interface IPagedResponse<T> {
	long getElapsed_ms();

	String getMessage();

	int getStatusCode();

	T getResponse();

	int getTotal();

	int getOffset();

	int getPageSize();

	void setElapsed_ms(long elapsed_ms);

	void setMessage(String message);

	void setStatusCode(int status);

	void setResponse(T response);

	void setTotal(int total);

	void setOffset(int offset);

	void setPageSize(int pageSize);

}
