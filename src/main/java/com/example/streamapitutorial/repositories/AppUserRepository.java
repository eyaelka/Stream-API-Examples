package com.example.streamapitutorial.repositories;

import com.example.streamapitutorial.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUsername(String username);


}
