/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cco2anpi.models.Access;
import br.com.cco2anpi.models.BaseResponse;
import br.com.cco2anpi.models.PagedResponse;
import br.com.cco2anpi.models.User;

/**
 * @author wotan class used to make connection with the user services
 */
public class UserClient
{

    private String restURLEndpoint;

    /**
     * Constructor client
     * 
     * @param restURLEndpoint
     *            URL of the service
     */
    public UserClient(String restURLEndpoint)
    {
	this.restURLEndpoint = restURLEndpoint;
    }

    /**
     * Method used to send a post to insert user
     * 
     * @param user
     *            user to be inserted
     * @return return user filled
     */
    public ResponseEntity<BaseResponse<User>> insert(User user, int typeUser)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/User/insert.json?typeUser=" + typeUser, HttpMethod.POST,
		new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>()
		{
		});
    }

    /**
     * Method used to update data
     * 
     * @param user
     *            user to be updated
     * @return user updated
     */
    public ResponseEntity<BaseResponse<User>> update(User user)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/User/update.json", HttpMethod.POST,
		new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>()
		{
		});
    }

    /**
     * Method used to delete user
     * 
     * @param user
     *            user to be deleted
     * @return status
     */
    public ResponseEntity<BaseResponse<Boolean>> delete(User user)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/User/delete.json", HttpMethod.POST,
		new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<Boolean>>()
		{
		});
    }

    /**
     * Method used to get all users
     * 
     * @param pageSize
     *            quantity of users
     * @param offset
     *            quantity to jump
     * @return return all users
     */
    public ResponseEntity<PagedResponse<User[]>> getAllUsers(int pageSize, int offset)
    {
	MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	params.add("pageSize", "" + pageSize);
	params.add("offset", "" + offset);
	UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(restURLEndpoint + "/User/getUsers.json")
		.queryParams(params).build();
	return new RestTemplate().exchange(uriComponents.toUriString(), HttpMethod.GET, null,
		new ParameterizedTypeReference<PagedResponse<User[]>>()
		{
		});
    }

    /**
     * Method user to get specific user
     * 
     * @param user
     *            object user to be searched
     * @return user filled
     */
    public ResponseEntity<BaseResponse<User>> getUser(User user)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/User/getUser.json", HttpMethod.POST,
		new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>()
		{
		});
    }

    /**
     * Method to authenticate user
     * 
     * @param user
     *            to be authenticated
     * @return user filled
     */
    public ResponseEntity<BaseResponse<User>> authentication(User user)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/User/authentication.json", HttpMethod.POST,
		new HttpEntity<>(user), new ParameterizedTypeReference<BaseResponse<User>>()
		{
		});
    }

    /**
     * Method used to send a post to insert access
     * 
     * @param access
     *            access to be inserted
     * @return return access filled
     */
    public ResponseEntity<BaseResponse<Access>> insertAccess(Access access)
    {
	return new RestTemplate().exchange(restURLEndpoint + "/User/insertAccess.json", HttpMethod.POST,
		new HttpEntity<>(access), new ParameterizedTypeReference<BaseResponse<Access>>()
		{
		});
    }

    /**
     * Method used to get access filtred
     * 
     * @param type
     *            of the user
     * @param dateInit
     *            date init
     * @param dateEnd
     *            date end
     * @return access array
     */
    public ResponseEntity<PagedResponse<Access[]>> getAccessByTypeAndDate(Integer type, String dateInit, String dateEnd,
	    int pageSize, int offset)
    {
	MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	params.add("type", type.toString());
	params.add("dateInit", dateInit);
	params.add("dateEnd", dateEnd);
	params.add("pageSize", "" + pageSize);
	params.add("offset", "" + offset);
	UriComponents uriComponents = UriComponentsBuilder
		.fromHttpUrl(restURLEndpoint + "/User/getAccessByTypeAndDate.json").queryParams(params).build();
	return new RestTemplate().exchange(uriComponents.toUriString(), HttpMethod.GET, null,
		new ParameterizedTypeReference<PagedResponse<Access[]>>()
		{
		});
    }

    /**
     * Method used to get all access
     * 
     * @return return all access
     */
    public ResponseEntity<PagedResponse<Access[]>> getAccess(int typeUser, int pageSize, int offset)
    {

	MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	params.add("pageSize", "" + pageSize);
	params.add("offset", "" + offset);
	params.add("typeUser", "" + typeUser);
	UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(restURLEndpoint + "/User/getAccess.json")
		.queryParams(params).build();
	return new RestTemplate().exchange(uriComponents.toUriString(), HttpMethod.GET, null,
		new ParameterizedTypeReference<PagedResponse<Access[]>>()
		{
		});
    }

}
