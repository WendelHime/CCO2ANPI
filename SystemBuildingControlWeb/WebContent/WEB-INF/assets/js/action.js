/**
 * File used to actions related to the general pages
 */

/**
 * Method used when button is clicked to insert user
 */
$("#btnInsertUser").click(function() {
	var insertedUser = insertUser($("#formUser").serialize());
});

