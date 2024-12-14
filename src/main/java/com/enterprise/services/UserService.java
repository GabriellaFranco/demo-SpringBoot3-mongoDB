package com.enterprise.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.domain.User;
import com.enterprise.dto.UserDTO;
import com.enterprise.repository.UserRepository;
import com.enterprise.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		if (!userRepository.existsById(id)) {
			throw new ObjectNotFoundException(id);
		}
		
		userRepository.deleteById(id);
    }
	
	public User update(User obj) {
		
		User newObj = userRepository.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException(obj.getId()));
		updateData(newObj, obj);
		return userRepository.save(newObj);
		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	

	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	

}
