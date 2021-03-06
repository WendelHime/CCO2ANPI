/**
 * 
 */
package br.com.cco2anpi.services.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.PagedResponse;

/**
 * @author wotan Class used to be de base of all controllers
 */
public class BaseController {

	public final int defaultPageSize = 50;
	protected long startTime;

	/**
	 * Method to calculate elapsed time
	 * 
	 * @param start
	 *            when starts to count
	 * @return in ms time used until this call
	 */
	protected long calculateElapsedTime(long start) {
		return System.currentTimeMillis() - start;
	}

	/**
	 * Method used to return ok response personalized using BaseResponse
	 * 
	 * @param response
	 *            response
	 * @param message
	 *            message
	 * @param status
	 *            status
	 * @return request
	 */
	protected <T> ResponseEntity<BaseResponse<T>> okResponse(T response, String message, int status) {
		BaseResponse<T> baseResponse = new BaseResponse<>(response);
		baseResponse.setMessage(message);
		baseResponse.setStatusCode(status);
		baseResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
		return new ResponseEntity<BaseResponse<T>>(baseResponse, HttpStatus.OK);
	}

	/**
	 * Method used to return ok response personalized using PagedResponse
	 * 
	 * @param response
	 *            response
	 * @param message
	 *            message
	 * @param status
	 *            status
	 * @param total
	 *            quantity total
	 * @param pageSize
	 *            page size
	 * @param offset
	 *            offset
	 * @return request
	 */
	protected <T> ResponseEntity<PagedResponse<List<T>>> okResponse(List<T> response, String message, int status,
			int total, int pageSize, int offset) {
		PagedResponse<List<T>> pagedResponse = new PagedResponse<>(response, total, offset, pageSize);
		pagedResponse.setMessage(message);
		pagedResponse.setStatusCode(status);
		pagedResponse.setElapsed_ms(this.calculateElapsedTime(startTime));
		return new ResponseEntity<PagedResponse<List<T>>>(pagedResponse, HttpStatus.OK);
	}

}
