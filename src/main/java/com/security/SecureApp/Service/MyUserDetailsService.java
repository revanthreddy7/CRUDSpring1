package com.security.SecureApp.Service;

import com.security.SecureApp.User;
import com.security.SecureApp.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
    public void saveUserDetails(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
    public void deleteUserDetails(User user){

    }
     public void  updateUserDetails(User user){
        repo.getReferenceById(user.getId()).setWallet_amt(user.getWallet_amt());
     }


}
