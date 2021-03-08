package com.tts.UsersAPI.repo;

import com.tts.UsersAPI.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {

        usersRepository.save(new Users("James", "Garner", "Ohio"));
        usersRepository.save(new Users("Craig", "Steger", "Florida"));
        usersRepository.save(new Users("Bruce", "Campbell", "Illinois"));
        usersRepository.save(new Users("Louis", "Greene", "Ohio"));
        usersRepository.save(new Users("Lawrence", "Spellman", "New Mexico"));
        usersRepository.save(new Users("Rita", "Richmond", "Florida"));
        usersRepository.save(new Users("Lisa", "Smith", "Ohio"));
        usersRepository.save(new Users("Melissa", "Grant", "Vermont"));
        usersRepository.save(new Users("Patti", "Simmons", "Maryland"));
        usersRepository.save(new Users("Mary", "Jackson", "Floria"));
    }


}
