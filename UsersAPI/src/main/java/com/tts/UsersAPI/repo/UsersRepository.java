package com.tts.UsersAPI.repo;

//import com.tts.UsersAPI.model.Users;
import com.tts.UsersAPI.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersRepository extends CrudRepository <Users, Long>{


    List<Users> findByState(String state);

    @Query("SELECT DISTINCT u.state FROM Users u")
    List<String> findByState();

    List<Users> findAll();


}
