package com.example.assignment.sevice.impl;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.sevice.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *  @author diemdz
 */
@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;


    @Override
    public KhachHang getByEmail(String email) {
        return khachHangRepository.getKhachHangByEmail(email);
    }
}
