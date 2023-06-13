package com.example.assignment.controller;

import com.example.assignment.cookies.GioHang;
import com.example.assignment.request.HoaDonRequest;
import com.example.assignment.sevice.GHCTService;
import com.example.assignment.sevice.GioHangService;
import com.example.assignment.sevice.HDCTService;
import com.example.assignment.sevice.HoaDonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

/*
 *  @author diemdz
 */
@Controller
@RequestMapping("/hoa-don/")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private GHCTService ghctService;
    @Autowired
    private HDCTService hdctService;

    @Autowired
    private GioHang gioHang;

    @GetMapping("hien-thi")
    public String getAll(Model model){

        model.addAttribute("list",hoaDonService.getAll());
        return "hoadon/hoa-don";
    }
    @PostMapping (value = "add")
    public String add(Authentication authentication, @ModelAttribute("hoaDon") HoaDonRequest hoaDonRequest){
    if(authentication==null){
        hoaDonService.add(hoaDonRequest);
        gioHang.deleteAll();
        return "redirect:/trang-chu";
    }else{
        hoaDonService.addUser(authentication,hoaDonRequest);
        ghctService.deleteAll();
        gioHangService.deleteAll();
        return "redirect:/trang-chu";
        }
    }
    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        model.addAttribute("hoaDon",hoaDonService.getById(id));
        return "hoadon/view-update";
    }
    @PostMapping("update")
    public String upadte( @ModelAttribute("hoaDon") HoaDonRequest hoaDonRequest){
      hoaDonService.update(hoaDonRequest);
        return "redirect:/hoa-don/hien-thi";
    }
    @PostMapping(value = "update/{id}")
    public String update(@PathVariable("id") UUID id){
        return "redirect:/hoa-don/hien-thi";
    }
    @GetMapping("{id}")
    public String getHDCT(@PathVariable("id") UUID id, Model model){

        model.addAttribute("list",hdctService.getListByIdDoaDon(id));
        return "hoadon/hoa-don-chi-tiet";
    }
}
