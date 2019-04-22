package com.tcc.secureauthserver.service;

import com.tcc.secureauthserver.dto.UserDto;
import com.tcc.secureauthserver.model.User;

import java.util.List;

public interface UserService {

    public User save(UserDto user);
    public List<User> findAll();
    public void delete(long id);
    public User findOne(String username);
    public User findById(Long id);
}
