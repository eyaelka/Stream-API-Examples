package com.example.streamapitutorial.services.implementations;

import com.example.streamapitutorial.dto.AppUserDTO;
import com.example.streamapitutorial.models.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.streamapitutorial.repositories.AppUserRepository;
import com.example.streamapitutorial.services.interfaces.AppUserInterface;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserInterface {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public AppUserDTO addAppUser(AppUserDTO newUser) {
        AppUser user = modelMapper.map(newUser, AppUser.class);
        user.setId(null);
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));

        appUserRepository.save(user);

        return modelMapper.map(user, AppUserDTO.class);
    }

    @Override
    public AppUserDTO findAppUserByUsername(String username) {
        AppUser appUser= appUserRepository.findAppUserByUsername(username);
        return modelMapper.map(appUser, AppUserDTO.class);
    }

    @Override
    public Optional<AppUserDTO> findAppUserById(Long id) {
        Optional<AppUser> user = appUserRepository.findAppUserById(id);
        return user.map(appUser -> modelMapper.map(appUser, AppUserDTO.class));
    }

    @Override
    public Integer deleteAppUser(Long id) {
        Optional<AppUser> user = appUserRepository.findAppUserById(id);
        if (user.isPresent()){
            appUserRepository.delete(user.get());
            return 1;
        }
        return 0;
    }
}
