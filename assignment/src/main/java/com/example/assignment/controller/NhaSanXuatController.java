package com.example.assignment.controller;

import com.example.assignment.request.NSXRequest;
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
@RequestMapping("/nsx/")
public class NhaSanXuatController {
    @Autowired
    private NSXService nsxService;

    @GetMapping(value = "hien-thi")
    public String getAll(Model model) {
        model.addAttribute("list", nsxService.getAll());
        model.addAttribute("nsx", new NSXRequest());
        return "nsx/nsx";
    }

    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("nsx") NSXRequest nsxRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", nsxService.getAll());
            return "nsx/nsx";
        }

        nsxService.add(nsxRequest);
        return "redirect:/nsx/hien-thi";

    }

    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("nsx", nsxService.getById(id));
        return "nsx/view-update";
    }

    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("nsx") NSXRequest nsxRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "nsx/view-update";
        }
        nsxService.update(nsxRequest);
        return "redirect:/nsx/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        nsxService.delete(id);
        return "redirect:/nsx/hien-thi";
    }
}
