package com.example.assignment.controller;

import com.example.assignment.entity.LoaiSanPham;
import com.example.assignment.request.LoaiSanPhamRequest;
import com.example.assignment.sevice.LoaiSanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/*
 *  @author diemdz
 */
@Controller
@RequestMapping("/loai-san-pham/")
public class LoaiSanPhamController {
    @Autowired
    private LoaiSanPhamService sanPhamService;
    @GetMapping(value = "hien-thi")
    public String getAll(Model model){
        model.addAttribute("list",sanPhamService.getAll());
        model.addAttribute("loaiSanPham",new LoaiSanPhamRequest());
        return "loaisanpham/loai-san-pham";
    }
    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("loaiSanPham")LoaiSanPhamRequest sanPhamRequest, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("list",sanPhamService.getAll());
            return "loaisanpham/loai-san-pham";
        }
        sanPhamService.add(sanPhamRequest);
        return "redirect:/loai-san-pham/hien-thi";

    }
    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id,Model model){
        model.addAttribute("loaiSanPham",sanPhamService.getById(id));
        return "loaisanpham/view-update";
    }
    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("loaiSanPham") LoaiSanPhamRequest sanPhamRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "loaisanpham/view-update";
        }
        sanPhamService.update(sanPhamRequest);
        return "redirect:/loai-san-pham/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")UUID id){
       sanPhamService.delete(id);
        return "redirect:/loai-san-pham/hien-thi";
    }

}
