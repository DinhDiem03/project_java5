package com.example.assignment.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 *  @author diemdz
 */
@Controller
public class LoginController {

    private AuthenticationManager authenticationManager;

    public LoginController() {

    }

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @GetMapping("/view-login")
    public String login() {
        return "giaodien/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authentication = authenticationManager.authenticate(authRequest);

            // Đặt thông tin xác thực vào SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println(authentication.getAuthorities());
//            System.out.println( SecurityContextHolder.getContext().getAuthentication().);
            // Kiểm tra thông tin xác thực
            if (authentication.isAuthenticated()) {
                // Kiểm tra vai trò của người dùng và chuyển hướng tương ứng
                if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
                    return "redirect:/admin/dashboard";
                } else {
                    return "giaodien/trang-chu";
                }
            }
        } catch (AuthenticationException ex) {
            // Xử lý lỗi đăng nhập
            redirectAttributes.addAttribute("error", "true");
        }

        return "redirect:/view-login?error=true";
    }
    }
    


