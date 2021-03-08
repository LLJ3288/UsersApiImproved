package com.tts.UsersAPI.service;

import com.tts.UsersAPI.repo.UsersRepository;
import com.tts.UsersAPI.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {return usersRepository.findAll();}
    public void save(Users users){
        usersRepository.save(users);
    }
    public List<String> findByState() {return usersRepository.findByState();}


}
