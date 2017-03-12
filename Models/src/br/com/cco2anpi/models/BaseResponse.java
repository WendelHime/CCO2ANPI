/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 * Class used to be the base of any response used to the return of services
 */
public class BaseResponse<T> implements IBaseResponse<T> {

	private long elapsed_ms;
	private String message;
	private int status_code;
	private T response;
	
	public BaseResponse() {
		
	}
	
	public BaseResponse(IBaseResponse<T> sourceObject) {
		this.elapsed_ms = sourceObject.getElapsed_ms();
		this.message = sourceObject.getMessage();
		this.status_code = sourceObject.getStatusCode();
		this.response = sourceObject.getResponse();
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
	public T getResponse() {
		return this.response;
	}

	@Override
	public void setElapsed_ms(long value) {
		this.elapsed_ms = value;
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
	public void setResponse(T response) {
		this.response = response;
	}
}
