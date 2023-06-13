package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.HoaDonChiTiet;
import com.example.assignment.repository.HDCTRepository;
import com.example.assignment.sevice.HDCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HDCTServcieImpl implements HDCTService {
    @Autowired
    private HDCTRepository hdctRepository;

    @Override
    public List<HoaDonChiTiet> getListByIdDoaDon(UUID id) {
        return hdctRepository.getListHDCT(id);
    }
}
