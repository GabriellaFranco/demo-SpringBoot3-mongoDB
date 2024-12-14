package com.enterprise.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {

}
