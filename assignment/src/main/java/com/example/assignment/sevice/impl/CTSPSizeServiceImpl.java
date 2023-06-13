package com.example.assignment.sevice.impl;

import com.example.assignment.entity.CTSPSize;
import com.example.assignment.repository.CTSPRepository;
import com.example.assignment.repository.CTSPSizeRepository;
import com.example.assignment.repository.SizeRepository;
import com.example.assignment.request.CTSPSizeRequest;
import com.example.assignment.sevice.CTSPSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Service
public class CTSPSizeServiceImpl implements CTSPSizeService {
    @Autowired
    private CTSPSizeRepository ctspSizeRepository;

    @Autowired
    private CTSPRepository ctspRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<CTSPSize> getAll() {
        return ctspSizeRepository.findAll();
    }

    @Override
    public CTSPSizeRequest getById(UUID id) {
        CTSPSize ctspSize = ctspSizeRepository.getById(id);
        CTSPSizeRequest ctspSizeRequest = new CTSPSizeRequest();
        ctspSizeRequest.setId(ctspSize.getId());
        ctspSizeRequest.setIdCtsp(ctspSize.getChiTietSanPham().getId());
        ctspSizeRequest.setIdSize(ctspSize.getSize().getId());
        ctspSizeRequest.setSoLuong(ctspSize.getSoLuong());
        return ctspSizeRequest;
    }

    @Override
    public void add(CTSPSizeRequest ctspSizeRequest) {
        CTSPSize ctspSize = new CTSPSize();
        ctspSize.setChiTietSanPham(ctspRepository.getById(ctspSizeRequest.getIdCtsp()));
        ctspSize.setSize(sizeRepository.getById(ctspSizeRequest.getIdSize()));
        ctspSize.setSoLuong(ctspSizeRequest.getSoLuong());
        ctspSizeRepository.save(ctspSize);
    }

    @Override
    public void update(CTSPSizeRequest ctspSizeRequest) {
        CTSPSize ctspSize = ctspSizeRepository.getById(ctspSizeRequest.getId());
        ctspSize.setChiTietSanPham(ctspRepository.getById(ctspSizeRequest.getIdCtsp()));
        ctspSize.setSize(sizeRepository.getById(ctspSizeRequest.getIdSize()));
        ctspSize.setSoLuong(ctspSizeRequest.getSoLuong());
        ctspSizeRepository.save(ctspSize);
    }

    @Override
    public void delete(UUID id) {
        ctspSizeRepository.deleteById(id);
    }
}
