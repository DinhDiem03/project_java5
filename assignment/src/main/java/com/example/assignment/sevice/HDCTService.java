package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.HoaDonChiTiet;

import java.util.List;
import java.util.UUID;

public interface HDCTService {
    List<HoaDonChiTiet> getListByIdDoaDon(UUID id);
}
