package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.CuaHang;
import com.example.assignment.request.CuahangRequest;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang getById(UUID id);

    void add(CuahangRequest cuahangRequest);

    void update(CuahangRequest cuahangRequest, UUID id);

    void delete(UUID id);
}
