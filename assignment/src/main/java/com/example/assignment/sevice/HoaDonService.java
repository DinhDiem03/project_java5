package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.request.HDCTRequest;
import com.example.assignment.request.HoaDonRequest;
import com.example.assignment.respone.HoaDonRespone;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    HoaDonRequest getById(UUID id);

    void add( HoaDonRequest hoaDonRequest);
    void addUser(Authentication authentication, HoaDonRequest hoaDonRequest);

    void update(HoaDonRequest hoaDonRequest);
    List<HoaDonRespone> getAll();
}
