package com.example.assignment.sevice.impl;
/*
    @diemdz
*/

import com.example.assignment.entity.SanPham;
import com.example.assignment.repository.LoaiSanPhamRepository;
import com.example.assignment.repository.SanPhamRepository;
import com.example.assignment.request.SanPhamRequest;
import com.example.assignment.respone.GetSanPhamRespone;
import com.example.assignment.sevice.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPhamRequest getById(UUID id) {
       SanPham sanPham = sanPhamRepository.getById(id);
       SanPhamRequest sanPhamRequest = new SanPhamRequest();
       sanPhamRequest.setId(sanPham.getId());
       sanPhamRequest.setMa(sanPham.getMa());
       sanPhamRequest.setTen(sanPham.getTen());
       sanPhamRequest.setIdLoaiSanPham(sanPham.getLoaiSanPham().getId());
        return sanPhamRequest;
    }

    @Override
    public void add(SanPhamRequest sanPhamRequest) {
        SanPham sanPham = new SanPham();
        sanPham.setMa(sanPhamRequest.getMa());
        sanPham.setTen(sanPhamRequest.getTen());
        sanPham.setLoaiSanPham(loaiSanPhamRepository.getOne(sanPhamRequest.getIdLoaiSanPham()));
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void update(SanPhamRequest sanPhamRequest) {
        SanPham sanPham = sanPhamRepository.getById(sanPhamRequest.getId());
        sanPham.setMa(sanPhamRequest.getMa());
        sanPham.setTen(sanPhamRequest.getTen());
        sanPham.setLoaiSanPham(loaiSanPhamRepository.getById(sanPhamRequest.getIdLoaiSanPham()));

        sanPhamRepository.save(sanPham);
    }

    @Override
    public void delete(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public List<GetSanPhamRespone> listSanPham() {
        return sanPhamRepository.getSanPham();
    }
}
