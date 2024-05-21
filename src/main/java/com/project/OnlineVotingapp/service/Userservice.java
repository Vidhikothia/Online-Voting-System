package com.project.OnlineVotingapp.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingapp.entity.User;

public interface Userservice {
   public List<User> getAllUsers();
   public Optional<User> getUserById(Long userid);
   public void saveUser(User user);
   public void deleteUser(Long userId);
}
