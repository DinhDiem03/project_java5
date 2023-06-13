package com.example.assignment.controller;

import com.example.assignment.sevice.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  @author diemdz
 */
@Controller
public class TrangChuController {

    @Autowired
    private SanPhamService sanPhamService;
    @GetMapping("/trang-chu")
    public String listSanPham(Model model){
        model.addAttribute("list", sanPhamService.listSanPham());
        return "giaodien/trang-chu";
    }

}
