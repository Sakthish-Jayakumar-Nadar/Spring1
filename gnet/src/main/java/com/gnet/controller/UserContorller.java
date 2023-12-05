package com.gnet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnet.model.NetPlan;
import com.gnet.model.User;
import com.gnet.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RequestMapping("/")
public class UserContorller {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping("/add/newUser") 
	public String postUser(@RequestBody User user) {
		userRepo.save(user);
		return "Saved Successfully";
	}
	
//	@GetMapping("/get/allUsers")
//	public List<Object> getAllUsers() {
//		return (List<Object>) userRepo.getAllUsers();
//	} 
	
	@GetMapping("/get/{userId}")
	public Object getUser(@PathVariable String userId) {
		if(userRepo.findById(userId).isPresent()) {
			return userRepo.findById(userId);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/update/{userId}")
	public String updateUser(@PathVariable String userId, @RequestBody User updateUser) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			user.get().setName(updateUser.getName());
			user.get().setLocation(updateUser.getLocation());
			user.get().setNetwork(updateUser.getNetwork());
			user.get().setPhone(updateUser.getPhone());
			userRepo.save(user.get());
			return "Updated Successfully" ;
		}
		else {
			return "User with id "+userId+" Not Present";
		}
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable String userId) {
		userRepo.deleteById(userId);
		return "Deleted Successfully";
	}
	
//	@PostMapping("/delete")
//	public String deleteUsers(@RequestBody List<String> userIds) {
//		userRepo.deleteAllById(userIds);
//		return "Multiple Users Deleted Successfully";
//	}
	
	@PostMapping("/{userId}/postNetPlan")
	public String postNetPlan(@PathVariable String userId,@RequestBody NetPlan netPlan){
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {			
			user.get().getNetPlan().add(netPlan);
			this.userRepo.save(user.get());
			return "Added Successfully";
		}
		else {
			return "User with id "+userId+" Not Present";
		}
	}
	
	@GetMapping("/{userId}/getNetPlan")
	public List getNetPlan(@PathVariable String userId){
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {			
			return user.get().getNetPlan();
		}
		else {
			return (List) new ResponseEntity<NetPlan>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/networkName/{network}")
	public List<User> getNetworkUser(@PathVariable String network){
		return userRepo.findByNetwork(network);
	}
}
