package com.example.assignment.controller;

import com.example.assignment.request.ChucVuRequest;
import com.example.assignment.request.NSXRequest;
import com.example.assignment.sevice.ChucVuService;
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
@RequestMapping("/chuc-vu/")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping(value = "hien-thi")
    public String getAll(Model model) {
        model.addAttribute("list", chucVuService.getAll());
        model.addAttribute("chucVu", new ChucVuRequest());
        return "chucvu/chuc-vu";
    }

    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("chucVu") ChucVuRequest chucVuRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", chucVuService.getAll());
            return "chucvu/chuc-vu";
        }

        chucVuService.add(chucVuRequest);
        return "redirect:/chuc-vu/hien-thi";

    }

    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("chucVu", chucVuService.getById(id));
        return "chucvu/view-update";
    }

    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("nsx") ChucVuRequest chucVuRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "chucvu/view-update";
        }
        chucVuService.update(chucVuRequest);
        return "redirect:/chuc-vu/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        chucVuService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }
}
