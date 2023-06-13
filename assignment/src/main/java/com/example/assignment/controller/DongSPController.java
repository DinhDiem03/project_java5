package com.example.assignment.controller;

import com.example.assignment.request.DSPRequest;
import com.example.assignment.request.NSXRequest;
import com.example.assignment.sevice.DSPService;
import com.example.assignment.sevice.NSXService;
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
@RequestMapping("/dong-san-pham/")
public class DongSPController {
    @Autowired
    private DSPService dspService;

    @GetMapping(value = "hien-thi")
    public String getAll(Model model) {
        model.addAttribute("list", dspService.getAll());
        model.addAttribute("dongSanPham", new DSPRequest());
        return "dongsanpham/dong-san-pham";
    }

    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("dongSanPham")  DSPRequest dspRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", dspService.getAll());
            return "dongsanpham/dong-san-pham";
        }

        dspService.add(dspRequest);
        return "redirect:/dong-san-pham/hien-thi";

    }

    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("dongSanPham", dspService.getById(id));
        return "dongsanpham/view-update";
    }

    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("dongSanPham")   DSPRequest dspRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dongsanpham/view-update";
        }
        dspService.update(dspRequest);
        return "redirect:/dong-san-pham/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        dspService.delete(id);
        return "redirect:/dong-san-pham/hien-thi";
    }
}
