package com.training.services;

import com.training.dto.user.CustomUserDetails;
import com.training.dto.user.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDto> userOptional = userService.findByUsername(username);
        userOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return userOptional.map(CustomUserDetails::new).get();
    }
}
