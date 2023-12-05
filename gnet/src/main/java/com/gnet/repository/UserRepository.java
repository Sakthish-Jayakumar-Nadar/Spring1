package com.gnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gnet.model.User;

public interface UserRepository extends CrudRepository<User,String>{

	public List<User> findByNetwork(String network);
	
	@Query("SELECT u FROM User u")
	public List<Object> getAllUsers();
	
//	@Query("SELECT u.id, u.network, u.name, u.location FROM User u WHERE u.id =: id")
//	public List getUser(@Param("id") String userId);
}
