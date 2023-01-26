package com.example.streamapitutorial.services.interfaces;

import com.example.streamapitutorial.dto.AppUserDTO;
import com.example.streamapitutorial.models.AppUser;

import java.util.Optional;

public interface AppUserInterface {

    AppUserDTO addAppUser(AppUserDTO newUser);

    AppUserDTO findAppUserByUsername(String username);

    Optional<AppUserDTO> findAppUserById(Long id);

    Integer deleteAppUser(Long id);
}
