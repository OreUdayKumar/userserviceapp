package com.userservice.service;

import java.util.List;
import java.util.Optional;

import com.userservice.entity.UserDetails;

public interface UsersService {

	/**
	 * @param user
	 * @return
	 * 
	 * To save the user details
	 */
	public UserDetails save(UserDetails user);

	/**
	 * @param user
	 * @return
	 * 
	 * To update the user details
	 */
	public UserDetails update(UserDetails user);

	/**
	 * @param Id
	 * 
	 * To delete the user details as per Id
	 */
	public void delete(Long Id);

	/**
	 * @param Id
	 * @return
	 * Get the user details as per Id
	 */
	public Optional<UserDetails> getUserDetailsById(Long Id);

	/**
	 * @return
	 * Get all the user details
	 */
	public List<UserDetails> getUsers();

}
