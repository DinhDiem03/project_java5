package com.example.assignment.controller;

import com.example.assignment.cookies.Cart;
import com.example.assignment.cookies.GioHang;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.request.GiohangRequest;
import com.example.assignment.request.HoaDonRequest;
import com.example.assignment.respone.GiohangRespone;
import com.example.assignment.sevice.GHCTService;
import com.example.assignment.sevice.GioHangService;
import com.example.assignment.sevice.KhachHangService;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Controller
@RequestMapping("/gio-hang/")

public class GioHangController {

    @Autowired
    private GioHang gioHang;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private GHCTService ghctService;
    private List<Cart> list = new ArrayList<>();

    @GetMapping(value = "hien-thi")
    public String gioHang(Authentication authentication,Model model)   {
//
        if(authentication==null){
            model.addAttribute("list", gioHang.getCart());
            return "giaodien/gio-hang";
        }
        else{
            KhachHang khachHang = khachHangService.getByEmail(authentication.getName());
            model.addAttribute("list", gioHangService.getGioHangUser(khachHang.getId()));
            return "giaodien/gio-hang-user";
        }

    }
    @GetMapping(value = "delete/{id}")
    public String delete(Authentication authentication,@PathVariable("id") UUID id)   {
        if(authentication==null){
            gioHang.delete(id);
            return "redirect:/gio-hang/hien-thi";
        }else{
            ghctService.delete(id);
            return "redirect:/gio-hang/hien-thi";
        }

    }
    @GetMapping(value = "deleteAll")
    public String deleteAll(Authentication authentication)   {
        if(authentication==null){
            gioHang.deleteAll();
            return "redirect:/gio-hang/hien-thi";
        }else{
            ghctService.deleteAll();
           gioHangService.deleteAll();

            return "redirect:/gio-hang/hien-thi";
        }

    }
    @PostMapping(value = "add-cart")
    public String add(@ModelAttribute("gioHang") GiohangRequest giohangRequest, @RequestParam("id") UUID id, @RequestParam("soLuong") Integer soLuong, @RequestParam("size") String size, HttpServletRequest request, Authentication authentication, Model model) throws JsonProcessingException {
        if(authentication ==null){
            gioHang.cart(id, soLuong, size, request);
            return "redirect:/gio-hang/hien-thi";
        }else{
            gioHangService.add(authentication,giohangRequest,id,size);
            return "redirect:/gio-hang/hien-thi";
        }


    }
    @GetMapping(value = "thanh-toan")
    public String thanhToan(Authentication authentication,Model model)   {

        if(authentication==null){
        model.addAttribute("list", gioHang.getCart());
        model.addAttribute("hoaDon",new HoaDonRequest());
        int tongTien = 0;
        for (Cart x: gioHang.getCart()) {
            tongTien = (int) (tongTien+ (x.getSoLuong()* x.getChiTietSanPham().getGiaBan()));
            model.addAttribute("tongTien",tongTien);
        }
        return "giaodien/thanh-toan";
        }else{
            model.addAttribute("hoaDon",new HoaDonRequest());
            KhachHang khachHang = khachHangService.getByEmail(authentication.getName());
            model.addAttribute("khachHang", khachHang);

            model.addAttribute("list", gioHangService.getGioHangUser(khachHang.getId()));
            int tongTien = 0;
            for (GiohangRespone x: gioHangService.getGioHangUser(khachHang.getId())) {
                tongTien = (int) (tongTien+ (x.getSoLuong()* x.getChiTietSanPham().getGiaBan()));
                model.addAttribute("tongTien",tongTien);
            }
            return "giaodien/thanh-toan-user";
        }
    }


}
