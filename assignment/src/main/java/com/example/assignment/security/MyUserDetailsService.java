package com.example.assignment.security;

import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.respone.UserRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 *  @author diemdz
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private KhachHangRepository khachHangrepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserRespone> userRespone = khachHangrepository.getByEmail(email);
        userRespone.orElseThrow(()->new UsernameNotFoundException("Not found: "+email));

        return  userRespone.map(MyUserDetails::new).get();
    }


}
