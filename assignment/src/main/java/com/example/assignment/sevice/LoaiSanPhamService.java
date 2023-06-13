package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.LoaiSanPham;
import com.example.assignment.entity.MauSac;
import com.example.assignment.request.LoaiSanPhamRequest;
import com.example.assignment.request.MauSacRequest;

import java.util.List;
import java.util.UUID;

public interface LoaiSanPhamService {
    List<LoaiSanPham> getAll();

    LoaiSanPham getById(UUID id);

    void add(LoaiSanPhamRequest sanPhamRequest);

    void update(LoaiSanPhamRequest sanPhamRequest);

    void delete(UUID id);
}
