package com.example.streamapitutorial.security;

import java.util.ArrayList;
import java.util.Collection;


import com.example.streamapitutorial.dto.AppUserDTO;
import com.example.streamapitutorial.models.AppUser;
import com.example.streamapitutorial.repositories.AppUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.streamapitutorial.services.interfaces.AppUserInterface;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService{

    @Autowired
    private AppUserRepository appUserRepository;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser u = appUserRepository.findAppUserByUsername(username);
        if(u == null) throw  new UsernameNotFoundException("User doesn't exist");

        Collection<GrantedAuthority> authorisations = new ArrayList<>();

        authorisations.add(new SimpleGrantedAuthority(u.getRole()));
        return new User(u.getUsername(),u.getPassword(),authorisations);
    }

}
