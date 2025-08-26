package com.example.skillswap.service;


import java.util.Optional;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.skillswap.model.User;
import com.example.skillswap.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new CustomUserDetails(user);
    }


    @Transactional
    public User registerUser(String username, String rawPassword) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already taken");
        }
        User u = User.builder()
                .username(username)
                .password(passwordEncoder.encode(rawPassword))
                .role("ROLE_USER") // always USER on signup
                .build();
        return userRepository.save(u);
    }

    public User login(String username, String rawPassword) {
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        }
        return null;
    }



    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}