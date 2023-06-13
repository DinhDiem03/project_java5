package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.MauSac;
import com.example.assignment.entity.NhanVien;
import com.example.assignment.request.MauSacRequest;
import com.example.assignment.request.NhanVienRequest;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien getById(UUID id);

    void add(NhanVienRequest nhanVienRequest);

    void update(NhanVienRequest nhanVienRequest, UUID id);

    void delete(UUID id);
}
