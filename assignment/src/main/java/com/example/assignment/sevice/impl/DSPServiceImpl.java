package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.repository.DSPrepository;
import com.example.assignment.request.DSPRequest;
import com.example.assignment.sevice.DSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class DSPServiceImpl implements DSPService {
    @Autowired
    private DSPrepository dsPrepository;
    @Override
    public List<DongSanPham> getAll() {
        return dsPrepository.findAll();
    }

    @Override
    public DongSanPham getById(UUID id) {
        return dsPrepository.getById(id);
    }

    @Override
    public void add(DSPRequest dspRequest) {
        DongSanPham dongSanPham = new DongSanPham();
        dongSanPham.setMa(dspRequest.getMa());
        dongSanPham.setTen(dspRequest.getTen());
        dsPrepository.save(dongSanPham);
    }

    @Override
    public void update(DSPRequest dspRequest) {
        DongSanPham dongSanPham = dsPrepository.getById(dspRequest.getId());
        dongSanPham.setMa(dspRequest.getMa());
        dongSanPham.setTen(dspRequest.getTen());
        dsPrepository.save(dongSanPham);
    }

    @Override
    public void delete(UUID id) {
    dsPrepository.deleteById(id);
    }
}
