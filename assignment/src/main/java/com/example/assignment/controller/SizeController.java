package com.example.assignment.controller;
/*
 *  @author diemdz
 */

import com.example.assignment.request.LoaiSanPhamRequest;
import com.example.assignment.request.SizeRequest;
import com.example.assignment.sevice.LoaiSanPhamService;
import com.example.assignment.sevice.SizeService;
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
@Controller
@RequestMapping("/size/")
public class SizeController {
    @Autowired
    private SizeService sizeService;
    @GetMapping(value = "hien-thi")
    public String getAll(Model model){
        model.addAttribute("list",sizeService.getAll());
        model.addAttribute("size",new SizeRequest());
        return "size/size";
    }
    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("size") SizeRequest sizeRequest, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("list",sizeService.getAll());
            return "size/loai-size-pham";
        }
        sizeService.add(sizeRequest);
        return "redirect:/size/hien-thi";

    }
    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        model.addAttribute("size",sizeService.getById(id));
        return "size/view-update";
    }
    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("size") SizeRequest sizeRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "size/view-update";
        }
        sizeService.update(sizeRequest);
        return "redirect:/size/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        sizeService.delete(id);
        return "redirect:/loai-san-pham/hien-thi";
    }
}
