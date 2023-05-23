package com.MyWorkFolio.MyWorkFolio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyWorkFolio.MyWorkFolio.Model.User;
import com.MyWorkFolio.MyWorkFolio.Service.UserService;

@RestController
@RequestMapping("/users")
public class ResourceController {

	@Autowired
	UserService userService;
	
	@PostMapping(value="/addUsers",consumes =MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> addUser(@RequestBody User user){
		userService.addUser(user);
		return new ResponseEntity(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/getUsers")
	ResponseEntity<?> getUser(){
		List<User> users=userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/getUsersById/{id}")
	ResponseEntity<?> getUser(@PathVariable("id") Integer userId){
		User user=userService.getUserById(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUsers/{id}")
	ResponseEntity<?> deleteUser(@PathVariable("id") Integer userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
