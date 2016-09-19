/**
 * 
 */
package br.com.cco2anpi.services;

/**
 * @author wotan
 *
 */
public class BaseResponse<T> {
	private T response;
	private int statusCode;
	private String message;
	private int elapsedMs;
	
	public BaseResponse(T response)
	{
		this.response = response;
	}

	/**
	 * @return the response
	 */
	public T getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(T response) {
		this.response = response;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the elapsedMs
	 */
	public int getElapsedMs() {
		return elapsedMs;
	}

	/**
	 * @param elapsedMs the elapsedMs to set
	 */
	public void setElapsedMs(int elapsedMs) {
		this.elapsedMs = elapsedMs;
	}
	
	
}
