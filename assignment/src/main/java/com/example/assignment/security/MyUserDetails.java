package com.example.assignment.security;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.KhachHang;
import com.example.assignment.respone.UserRespone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MyUserDetails implements UserDetails {
    private String email;
    private String matKhau;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(UserRespone userRespone){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        email = userRespone.getEmail();
        matKhau = encoder.encode(userRespone.getMatKhau());
        authorities = Arrays.stream(userRespone.getTenChucVu().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return authorities;
    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
