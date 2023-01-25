package com.example.streamapitutorial.controllers;

import com.example.streamapitutorial.dto.AppUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.streamapitutorial.services.interfaces.AppUserInterface;

@RestController
public class AppUserController {
    @Autowired
    private AppUserInterface appUserInterface;

    @PostMapping("/add-user")
    private AppUserDTO saveAppUser(@RequestBody AppUserDTO appUser){
        return appUserInterface.addAppUser(appUser);
    }
}
