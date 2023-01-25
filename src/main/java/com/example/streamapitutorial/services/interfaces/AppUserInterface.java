package com.example.streamapitutorial.services.interfaces;

import com.example.streamapitutorial.dto.AppUserDTO;

public interface AppUserInterface {

    AppUserDTO addAppUser(AppUserDTO newUser);

    AppUserDTO findAppUserByUsername(String username);
}
