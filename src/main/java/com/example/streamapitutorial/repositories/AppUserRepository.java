package com.example.streamapitutorial.repositories;

import com.example.streamapitutorial.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUsername(String username);

    //To handle nullPointerException in case we didn't find the user , we can use the Optional class
    //We use Optional when we are not sure whether the record exists or not

    Optional<AppUser> findAppUserById(Long id);


}
