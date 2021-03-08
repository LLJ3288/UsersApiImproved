package com.tts.UsersAPI.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
//@NoArgsConstructor


@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)                 //added line
   // @GeneratedValue(strategy = GenerationType.IDENTITY)           //commented out
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)


    @NotNull
    @Size(min = 3, max = 25)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 25)
    private String lastName;


    @NotNull
    private String state;

    public Users() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Users(@NotNull @Size(min = 3, max = 25) String firstName, @NotNull @Size(min = 3, max = 25) String lastName, @NotNull String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
    }


}




