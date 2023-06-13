package com.example.assignment.sevice.impl;

import com.example.assignment.entity.CuaHang;
import com.example.assignment.repository.CuaHangRepository;
import com.example.assignment.request.CuahangRequest;
import com.example.assignment.sevice.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public CuaHang getById(UUID id) {
        return cuaHangRepository.getById(id);
    }

    @Override
    public void add(CuahangRequest cuahangRequest) {
        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(cuahangRequest.getMa());
        cuaHang.setTen(cuahangRequest.getTen());
        cuaHang.setMa(cuahangRequest.getMa());
        cuaHang.setDiaChi(cuahangRequest.getDiaChi());
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void update(CuahangRequest cuahangRequest, UUID id) {
        CuaHang cuaHang = cuaHangRepository.getById(id);
        cuaHang.setMa(cuahangRequest.getMa());
        cuaHang.setTen(cuahangRequest.getTen());
        cuaHang.setMa(cuahangRequest.getMa());
        cuaHang.setDiaChi(cuahangRequest.getDiaChi());
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void delete(UUID id) {
        cuaHangRepository.deleteById(id);
    }
}
