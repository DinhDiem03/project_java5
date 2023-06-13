package com.example.assignment.controller;

import com.example.assignment.request.CTSPSizeRequest;
import com.example.assignment.sevice.CTSPService;
import com.example.assignment.sevice.CTSPSizeService;
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
@RequestMapping("/ctsp-size/")
public class ChiTietSanPhamSizeController {
    @Autowired
    private CTSPSizeService ctspSizeService;
    @Autowired
    private CTSPService ctspService;
    @Autowired
    private SizeService sizeService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("list", ctspSizeService.getAll());
        model.addAttribute("ctsp", ctspService.listCTSP());
        model.addAttribute("size",sizeService.getAll());

        model.addAttribute("ctspSize",new CTSPSizeRequest());
        return "ctspsize/ctsp-size";
    }
    @PostMapping(value = "add")
    public String add(@Valid @ModelAttribute("ctspSize") CTSPSizeRequest ctspSizeRequest, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("list",ctspSizeService.getAll());
            return "ctspsize/ctsp-size";
        }
        ctspSizeService.add(ctspSizeRequest);
        return "redirect:/ctsp-size/hien-thi";

    }
    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        model.addAttribute("cs",ctspSizeService.getById(id));
        model.addAttribute("ctsp", ctspService.listCTSP());
        model.addAttribute("size",sizeService.getAll());
        return "ctspsize/view-update";
    }
    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("cs") CTSPSizeRequest ctspSizeRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "ctspsize/view-update";
        }
        ctspSizeService.update(ctspSizeRequest);
        return "redirect:/ctsp-size/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        ctspSizeService.delete(id);
        return "redirect:/ctsp-size/hien-thi";
    }
}
