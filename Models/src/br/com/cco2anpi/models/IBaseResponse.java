/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public interface IBaseResponse<T> {
	long getElapsed_ms();
	String getMessage();
	int getStatusCode();	
	T getResponse();
	void setElapsed_ms(long value);
	void setMessage(String message);
	void setStatusCode(int status);
	void setResponse(T response);
}
