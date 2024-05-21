package com.project.OnlineVotingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingapp.entity.User;
import com.project.OnlineVotingapp.repository.Userdao;

@Service
public class Userserviceimp implements Userservice {

	@Autowired
	private Userdao userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override

	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
