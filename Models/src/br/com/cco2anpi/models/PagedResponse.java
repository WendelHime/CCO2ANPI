/**
 * 
 */
package br.com.cco2anpi.models;

import java.util.List;

/**
 * @author wotan class used to be a paged response
 */
public class PagedResponse<T> implements IPagedResponse<T> {

	private long elapsed_ms;
	private String message;
	private int status_code;
	private List<T> response;
	private int total;
	private int offset;
	private int pageSize;

	public PagedResponse(List<T> response, int total, int offset, int pageSize) {
		this.elapsed_ms = 0;
		this.message = "OK";
		this.status_code = 200;
		this.response = response;
		this.total = total;
		this.offset = offset;
		this.pageSize = pageSize;
	}

	@Override
	public long getElapsed_ms() {
		return this.elapsed_ms;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public int getStatusCode() {
		return this.status_code;
	}

	@Override
	public List<T> getResponse() {
		return this.response;
	}

	@Override
	public int getTotal() {
		return this.total;
	}

	@Override
	public int getOffset() {
		return this.offset;
	}

	@Override
	public int getPageSize() {
		return this.pageSize;
	}

	@Override
	public void setElapsed_ms(long elapsed_ms) {
		this.elapsed_ms = elapsed_ms;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setStatusCode(int status) {
		this.status_code = status;
	}

	@Override
	public void setResponse(List<T> response) {
		this.response = response;
	}

	@Override
	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
