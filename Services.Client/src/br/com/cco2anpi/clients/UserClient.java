/**
 * 
 */
package br.com.cco2anpi.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.cco2anpi.models.User;

/**
 * @author wotan
 *
 */
public class UserClient {

    public static final String REST_SERVICE_URI = "http://localhost:8080/Services";

    // /**
    // * @param args
    // */
    // public static void main(String[] args) {
    // System.out.println("Testing create User API----------");
    // User user = new User();
    // user.setCpf("442.022.408-80");
    // user.setName("Wendel Hime Lino");
    // user.setUsername("teste2");
    // try {
    // user.setSalt(Crypto.generateRandomSalt());
    // } catch (UnsupportedEncodingException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // try {
    // user.setPassword(Crypto.encrypt("teste", user.getSalt()));
    // } catch (DataLengthException | IllegalStateException |
    // InvalidCipherTextException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // user.setOfficeHours(8);
    // user.setAccess(new HashSet<IAccess>(0));
    // ResponseEntity<User> response = insert(user);
    // user = response.getBody();
    // System.out.println("name: " + user.getName());
    // user.setName("Wendel Hime Lino Castro");
    // response = update(user);
    // user = response.getBody();
    // System.out.println("name: " + user.getName());
    //
    // ResponseEntity<User[]> responseUsers = getAllUsers();
    // for (User searchedUser : responseUsers.getBody()) {
    // System.out.println("Username: " + searchedUser.getUsername());
    // }
    //
    // ResponseEntity<Boolean> responseStatus = delete(user);
    // System.out.println("Status: " + responseStatus.getBody());
    // }

    /**
     * Method used to send a post to insert user
     * 
     * @param user
     *            user to be inserted
     * @return return user filled
     */
    public static ResponseEntity<User> insert(User user) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/User/insert.json", user, User.class);
    }

    /**
     * Method used to update data
     * 
     * @param user
     *            user to be updated
     * @return user updated
     */
    public static ResponseEntity<User> update(User user) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/User/update.json", user, User.class);
    }

    /**
     * Method used to delete user
     * 
     * @param user
     *            user to be deleted
     * @return status
     */
    public static ResponseEntity<Boolean> delete(User user) {
	return new RestTemplate().postForEntity(REST_SERVICE_URI + "/User/delete.json", user, Boolean.class);
    }

    /**
     * Method used to get all users
     * 
     * @return return all users
     */
    public static ResponseEntity<User[]> getAllUsers() {
	return new RestTemplate().getForEntity(REST_SERVICE_URI + "/User/getAllUsers.json", User[].class);
    }

}
