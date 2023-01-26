package com.example.streamapitutorial.controllers;

import com.example.streamapitutorial.dto.AppUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.streamapitutorial.services.interfaces.AppUserInterface;

import java.util.Optional;

@RestController
public class AppUserController {
    @Autowired
    private AppUserInterface appUserInterface;

    @PostMapping("/add-user")
    private AppUserDTO saveAppUser(@RequestBody AppUserDTO appUser){
        return appUserInterface.addAppUser(appUser);
    }

    @GetMapping("/user/{id}")
    private Optional<AppUserDTO> findAppUserById(@PathVariable Long id){
        return appUserInterface.findAppUserById(id);
    }

    @DeleteMapping("/delete-user/{id}")
    private Integer deleteAppUser(@PathVariable Long id){
        return appUserInterface.deleteAppUser(id);
    }
}
