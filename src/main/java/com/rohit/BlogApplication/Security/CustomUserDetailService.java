//package com.rohit.BlogApplication.Security;
//
//import com.rohit.BlogApplication.Exceptions.ResourceNotFoundException;
//import com.rohit.BlogApplication.Repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // load user from DB by username.
//        return this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "ID"));
//    }
//}
