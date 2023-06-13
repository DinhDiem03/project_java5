package com.example.assignment.cookies;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.sevice.CTSPService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@Service
public class GioHang {


    @Autowired
    private CTSPService ctspService;

    private List<Cart> list = new ArrayList<>();



    public void cart(UUID id, Integer soLuong, String size, HttpServletRequest request) throws JsonProcessingException {

        ChiTietSanPham chiTietSanPham = ctspService.getOne(id);

        Cart cart = new Cart();
        cart.setChiTietSanPham(chiTietSanPham);
        cart.setSoLuong(soLuong);
        cart.setSize(size);


        HttpSession session = request.getSession();
        list = (List<Cart>) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
            session.setAttribute("list", list);
        }
        add(cart);

    }

    public List<Cart> getCart(){
        return list;
    }
    public void add(Cart cart){
        for (Cart x:list){
            if(x.getChiTietSanPham().getId().equals(cart.getChiTietSanPham().getId()) && x.getSize().equals(cart.getSize())){
                x.setSoLuong(x.getSoLuong()+cart.getSoLuong());
                return;
            }
        }
        list.add(cart);
    }
    public void delete(UUID id){
       Cart cart = detail(id);
       list.remove(cart);
    }
    public void deleteAll(){
        list.removeAll(list);
    }
    public Cart detail(UUID id){
        for (Cart x: list) {
            if(x.getChiTietSanPham().getId().equals(id)){
                return x;
            }
        }
        return null;
    }
}
