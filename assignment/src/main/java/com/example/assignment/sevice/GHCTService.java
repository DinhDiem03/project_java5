package com.example.assignment.sevice;
/*
 *  @author diemdz
 */



import com.example.assignment.entity.GioHangChiTiet;

import java.util.UUID;

public interface GHCTService {
    void delete(UUID id);
    void deleteAll();

}
