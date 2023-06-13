package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.GioHang;
import com.example.assignment.request.GiohangRequest;
import com.example.assignment.respone.GiohangRespone;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.UUID;

public interface GioHangService {

    void add(Authentication authentication,GiohangRequest giohangRequest, UUID idCtsp, String tenSize);

    List<GiohangRespone> getGioHangUser (UUID idKhachHang);
    void deleteAll();

}
