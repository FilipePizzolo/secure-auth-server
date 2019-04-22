package com.tcc.secureauthserver.dao;

import com.tcc.secureauthserver.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
