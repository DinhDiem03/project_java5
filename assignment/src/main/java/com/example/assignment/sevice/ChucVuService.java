package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.ChucVu;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.entity.MauSac;
import com.example.assignment.request.ChucVuRequest;
import com.example.assignment.request.MauSacRequest;
import com.example.assignment.respone.UserRespone;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getById(UUID id);

    void add(ChucVuRequest chucVuRequest);

    void update(ChucVuRequest chucVuRequest);

    void delete(UUID id);
    Optional<UserRespone> findByEmail(String email);
    List<KhachHang> getAll1();
}
