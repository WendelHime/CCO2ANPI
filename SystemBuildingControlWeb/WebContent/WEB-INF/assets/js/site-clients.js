/**
 * Clients to access functions controller
 */

/**
 * Method used to insert user by serialized form
 * 
 * @param serializedForm
 *            serialized form
 * @returns inserted user
 */
function insertUser(serializedForm) {
	return $.ajax({
		type : "POST",
		dataType : "json",
		url : "/User/insert",
		data : serializedForm,
		cache : false
	});
}

/**
 * Method used to update user
 * 
 * @param serializedForm
 *            serialized form
 * @returns updated user
 */
function updateUser(serializedForm) {
	return $.ajax({
		type : "POST",
		dataType : "json",
		url : "/User/update",
		data : serializedForm,
		cache : false
	});
}

/**
 * Method used to delete user
 * 
 * @param serializedForm
 *            serialized form
 * @returns status
 */
function deleteUser(serializedForm) {
	return $.ajax({
		type : "POST",
		dataType : "json",
		url : "/User/delete",
		data : serializedForm,
		cache : false
	});
}

/**
 * Method used to get pagined users
 * 
 * @param pageSize
 *            limit
 * @param offset
 *            offset
 * @returns users
 */
function getUsers(pageSize, offset) {
	return $.ajax({
		type : "GET",
		dataType : "json",
		url : "/User/getUsers?pageSize=" + pageSize + "&offset=" + offset,
		cache : false
	});
}