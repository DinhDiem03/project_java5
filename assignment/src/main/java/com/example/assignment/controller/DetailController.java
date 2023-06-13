package com.example.assignment.controller;

import com.example.assignment.repository.CTSPRepository;
import com.example.assignment.respone.DetailRespone;
import com.example.assignment.sevice.CTSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Controller
@RequestMapping("")
public class DetailController {
    @Autowired
    private CTSPRepository ctspRepository;

    @Autowired
    private CTSPService ctspService;
    @GetMapping("/product-detail/{id}")
    public String detail (@PathVariable("id")UUID id, Model model){
        DetailRespone detailRespone = ctspService.DetailSanPham(id);
        model.addAttribute("list",ctspService.DetailSanPham(id));
        model.addAttribute("mau",ctspService.getMau(detailRespone.getIdSanPham()));
        model.addAttribute("size",ctspService.getSize(detailRespone.getIdCTSP()));
        return "giaodien/san-pham-detail";
    }
//    @GetMapping("/{id}")
//    public DetailRespone detail (@PathVariable("id")UUID id, Model model){
//        model.addAttribute("list",ctspRepository.getDetail(id));
//        return ctspRepository.getDetail(id);
//    }

}
