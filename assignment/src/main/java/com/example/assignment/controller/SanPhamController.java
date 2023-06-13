package com.example.assignment.controller;
/*
    @diemdz
*/

import com.example.assignment.entity.LoaiSanPham;
import com.example.assignment.entity.SanPham;
import com.example.assignment.repository.SanPhamRepository;
import com.example.assignment.request.LoaiSanPhamRequest;
import com.example.assignment.request.SanPhamRequest;
import com.example.assignment.sevice.LoaiSanPhamService;
import com.example.assignment.sevice.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/san-pham/")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping(value = "hien-thi")
    public String getAll(Model model){
        model.addAttribute("list",sanPhamService.getAll());
        model.addAttribute("sanPham",new SanPhamRequest());
        model.addAttribute("loaiSanPham",loaiSanPhamService.getAll());
        return "sanpham/san-pham";
    }
    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("sanPham")SanPhamRequest sanPhamRequest, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("list",sanPhamService.getAll());
            return "sanpham/san-pham";
        }
        sanPhamService.add(sanPhamRequest);
        return "redirect:/san-pham/hien-thi";

    }
    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id, Model model){
        model.addAttribute("sanPham",sanPhamService.getById(id));
        model.addAttribute("loaiSanPham",loaiSanPhamService.getAll());
        return "sanpham/view-update";
    }
    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("sanPham") SanPhamRequest sanPhamRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "sanpham/view-update";
        }
        sanPhamService.update(sanPhamRequest);
        return "redirect:/san-pham/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        sanPhamService.delete(id);
        return "redirect:/san-pham/hien-thi";
    }


}
