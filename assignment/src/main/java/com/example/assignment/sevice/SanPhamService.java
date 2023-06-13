package com.example.assignment.sevice;
/*
    @diemdz
*/

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.SanPham;
import com.example.assignment.request.CTSPRequest;
import com.example.assignment.request.SanPhamRequest;
import com.example.assignment.respone.GetSanPhamRespone;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPhamRequest getById(UUID id);

    void add(SanPhamRequest sanPhamRequest);

    void update(SanPhamRequest sanPhamRequest);

    void delete(UUID id);

    List<GetSanPhamRespone> listSanPham();
}
