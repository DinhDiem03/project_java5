package com.example.assignment.controller;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.request.CTSPRequest;
import com.example.assignment.sevice.CTSPService;
import com.example.assignment.sevice.DSPService;
import com.example.assignment.sevice.MauSacService;
import com.example.assignment.sevice.NSXService;
import com.example.assignment.sevice.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Controller
@RequestMapping("/chi-tiet-san-pham/")
public class ChiTietSanPhamController {
    @Autowired
    private CTSPService ctspService;

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DSPService dspService;
    @Autowired
    private NSXService nsxService;

    @GetMapping(value = "hien-thi")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAll(@RequestParam(value = "pageNo",defaultValue = "0") Integer pageNo,Model model){
        Page<ChiTietSanPham> page = ctspService.getAll(pageNo,5);
        model.addAttribute("list",page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("ctsp",new CTSPRequest());
        model.addAttribute("sp",sanPhamService.getAll());
        model.addAttribute("mauSac",mauSacService.getAll());
        model.addAttribute("dongSanPham",dspService.getAll());
        model.addAttribute("nsx",nsxService.getAll());

        return "ctsp/chi-tiet-san-pham";
    }
    @PostMapping(value = "add")
    public String add(@RequestParam("hinhAnh1") MultipartFile file,@Valid @ModelAttribute("ctsp") CTSPRequest ctspRequest ,BindingResult bindingResult,  Model model) throws IOException {
        if(bindingResult.hasErrors()){
            model.addAttribute("list",sanPhamService.getAll());
            return "ctsp/chi-tiet-san-pham";
        }
        ctspService.add(ctspRequest,file);
        return "redirect:/chi-tiet-san-pham/hien-thi";

    }
    @GetMapping(value = "view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        model.addAttribute("ctsp",ctspService.getById(id));

        model.addAttribute("sp",sanPhamService.getAll());
        model.addAttribute("mauSac",mauSacService.getAll());
        model.addAttribute("dongSanPham",dspService.getAll());
        model.addAttribute("nsx",nsxService.getAll());
        return "ctsp/view-update";
    }
    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute("ctsp") CTSPRequest ctspRequest,@RequestParam("hinhAnh1") MultipartFile file, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            return "ctsp/view-update";
        }
        ctspService.update(ctspRequest,file);
        return "redirect:/chi-tiet-san-pham/hien-thi";

    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        ctspService.delete(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}
