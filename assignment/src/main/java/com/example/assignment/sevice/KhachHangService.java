package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.KhachHang;

public interface KhachHangService {
    KhachHang getByEmail(String email);
}
