package com.tts.UsersAPI.controller;


import com.tts.UsersAPI.repo.UsersRepository;
import com.tts.UsersAPI.model.Users;
import com.tts.UsersAPI.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@RequestMapping("/users")            //added line
@RestController
public class UsersController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersService userService;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createUser(@RequestBody @Valid Users users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        usersRepository.save(users);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Users>(user.get(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
      // return usersRepository.findAll();                  // com out
      return (List<Users>) usersRepository.findAll();     //added
    }

    @GetMapping("/users/state")
    public List<Users> getUsers(@RequestParam(value = "state", required = false) String state) {
        if (state != null) {
            return usersRepository.findByState(state);
        }
        return (List<Users>) usersRepository.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void createUser(@PathVariable(value = "id") Long id) {
        usersRepository.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public void createUser(@PathVariable(value = "id") Long id, @RequestBody Users users) {
        usersRepository.save(users);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody Users users) {
        usersRepository.save(users);
    }



}


