package com.MyWorkFolio.MyWorkFolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyWorkFolio.MyWorkFolio.Exception.UserNotFoundException;
import com.MyWorkFolio.MyWorkFolio.Model.User;
import com.MyWorkFolio.MyWorkFolio.Repository.UserRepostiory;

@Service
public class UserService {

	@Autowired
	UserRepostiory userRepository;
	
	public void addUser(User user){
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public void deleteUser(Integer userId){
		
		userRepository.deleteUserById(userId);
	}

	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User by Id "+userId+" was not found"));
	}
}
