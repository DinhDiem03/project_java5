package com.example.assignment.controller;

import com.example.assignment.request.MauSacRequest;
import com.example.assignment.request.SizeRequest;
import com.example.assignment.sevice.MauSacService;
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

/*
 *  @author diemdz
 */
@Controller
@RequestMapping("/mau-sac/")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;
    @GetMapping(value = "hien-thi")
    public String getAll(Model model){
        model.addAttribute("list",mauSacService.getAll());
        model.addAttribute("mauSac",new MauSacRequest());
        return "mausac/mau-sac";
    }
    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("mauSac") MauSacRequest mauSacRequest, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("list",mauSacService.getAll());
            return "mausac/mau-sac";
        }
        mauSacService.add(mauSacRequest);
        return "redirect:/mau-sac/hien-thi";

    }
    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        model.addAttribute("mauSac",mauSacService.getById(id));
        return "mausac/view-update";
    }
    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("size") MauSacRequest mauSacRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "mausac/view-update";
        }
        mauSacService.update(mauSacRequest);
        return "redirect:/mau-sac/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        mauSacService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }
}
