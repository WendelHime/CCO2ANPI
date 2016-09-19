/**
 * 
 */
package br.com.cco2anpi.services;

import java.util.List;

/**
 * @author wotan
 *
 */
public class PagedResponse<T> {
	private int statusCode;
	private String message;
	private int elapsedMs;
	private List<T> response;
	private int total;
	private int offset;
	private int pageSize;
	
	public PagedResponse(List<T> response, int total, int offset, int pageSize)
	{
		this.response = response;
		this.total = total;
		this.offset = offset;
		this.pageSize = pageSize;
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

	/**
	 * @return the response
	 */
	public List<T> getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(List<T> response) {
		this.response = response;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
