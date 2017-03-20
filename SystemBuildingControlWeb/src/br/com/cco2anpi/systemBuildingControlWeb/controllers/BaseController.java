/**
 * 
 */
package br.com.cco2anpi.systemBuildingControlWeb.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.cco2anpi.clients.CompanyClient;
import br.com.cco2anpi.clients.UserClient;
import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.PagedResponse;

/**
 * @author wotan Class used to be de base of all controllers
 */

public class BaseController {
	protected UserClient userClient;
	protected CompanyClient companyClient;

	/**
	 * Constructor of BaseController
	 */
	public BaseController() {
		this.userClient = new UserClient("http://localhost:8080/Services");
		this.companyClient = new CompanyClient("http://localhost:8080/Services");
	}

}
