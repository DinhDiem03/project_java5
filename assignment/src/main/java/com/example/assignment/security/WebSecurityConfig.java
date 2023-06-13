package com.example.assignment.security;
/*
 *  @author diemdz
 */

import com.example.assignment.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig{


    @Autowired
    UserDetailsService userDetailsService;


    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    // mã hóa mật khẩu ở dạng String
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider( PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers("/trang-chu").permitAll()
//                .requestMatchers("/login").permitAll()
//                .requestMatchers("/logout").permitAll()
                .requestMatchers("/admin/dashboard").hasRole("ADMIN")
                .requestMatchers("/chi-tiet-san-pham/hien-thi").hasRole("ADMIN")

                .requestMatchers("/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/admin/dashboard")
                .failureForwardUrl("/trang-chu")
                // Sửa thành parameter đúng để nhận username
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/trang-chu")
                .and()
                .logout().clearAuthentication(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/trang-chu").permitAll()
                .and().exceptionHandling().accessDeniedPage("/trang-chu")
                .and().build();
    }




}
