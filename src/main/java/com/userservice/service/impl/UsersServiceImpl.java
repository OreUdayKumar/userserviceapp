package com.userservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.userservice.entity.UserDetails;
import com.userservice.repository.UsersRepository;
import com.userservice.service.UsersService;

/**
 * This class is used to implement the user service specification methods 
 */
@Service
public class UsersServiceImpl implements UsersService {

	private UsersRepository usersRepository;

	public UsersServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public Optional<UserDetails> getUserDetailsById(Long Id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(Id);
	}

	@Override
	public List<UserDetails> getUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public UserDetails save(UserDetails user) {
		return usersRepository.save(user);

	}

	@Override
	public UserDetails update(UserDetails user) {
		// TODO Auto-generated method stub
		return usersRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);

	}

}
