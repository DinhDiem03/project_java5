package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.MauSac;
import com.example.assignment.request.DSPRequest;
import com.example.assignment.request.MauSacRequest;

import java.util.List;
import java.util.UUID;

public interface DSPService {
    List<DongSanPham> getAll();

    DongSanPham getById(UUID id);

    void add(DSPRequest dspRequest);

    void update(DSPRequest dspRequest);

    void delete(UUID id);
}
