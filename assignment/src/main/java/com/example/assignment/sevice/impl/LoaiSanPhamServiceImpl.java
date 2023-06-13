package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.LoaiSanPham;
import com.example.assignment.repository.LoaiSanPhamRepository;
import com.example.assignment.request.LoaiSanPhamRequest;
import com.example.assignment.sevice.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamRepository sanPhamRepository;

    @Override
    public List<LoaiSanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public LoaiSanPham getById(UUID id) {
        return sanPhamRepository.getById(id);
    }

    @Override
    public void add(LoaiSanPhamRequest sanPhamRequest) {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        loaiSanPham.setMa(sanPhamRequest.getMa());
        loaiSanPham.setTen(sanPhamRequest.getTen());
        sanPhamRepository.save(loaiSanPham);
    }

    @Override
    public void update(LoaiSanPhamRequest sanPhamRequest) {
        LoaiSanPham loaiSanPham = sanPhamRepository.getById(sanPhamRequest.getId());
        loaiSanPham.setMa(sanPhamRequest.getMa());
        loaiSanPham.setTen(sanPhamRequest.getTen());
        sanPhamRepository.save(loaiSanPham);
    }

    @Override
    public void delete(UUID id) {
        sanPhamRepository.deleteById(id);
    }
}
