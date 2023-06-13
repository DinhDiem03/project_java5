package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.CTSPSize;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.GioHangChiTiet;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.genma.GenMa;
import com.example.assignment.repository.CTSPSizeRepository;
import com.example.assignment.repository.GHCTRepository;
import com.example.assignment.repository.GiohangRepository;
import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.request.GiohangRequest;
import com.example.assignment.respone.GiohangRespone;
import com.example.assignment.sevice.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GiohangRepository giohangRepository;

    @Autowired
    private GHCTRepository ghctRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private CTSPSizeRepository ctspSizeRepository;


    @Override
    public void add(Authentication authentication,GiohangRequest giohangRequest, UUID idCtsp, String tenSize) {

        KhachHang khachHang = khachHangRepository.getKhachHangByEmail(authentication.getName());
        GioHang gh = khachHangRepository.getGioHangByIdKhachHang(khachHang.getId());
        CTSPSize ctspSize = ctspSizeRepository.getByCtspSize(idCtsp,tenSize);
        GioHangChiTiet ghct = ghctRepository.getByIdCtspSize(ctspSize.getId());
        GioHang gioHang = new GioHang();
        if(gh==null){
            gioHang.setMa(new GenMa().genMaGioHang());
            gioHang.setKhachHang(khachHang);
            giohangRepository.save(gioHang);

            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setSoLuong(giohangRequest.getSoLuong());
            gioHangChiTiet.setDonGia(giohangRequest.getDonGia());
            gioHangChiTiet.setGioHang(gioHang);
            gioHangChiTiet.setCtspSize(ctspSizeRepository.getByCtspSize(idCtsp,tenSize));
            ghctRepository.save(gioHangChiTiet);
        }else{
            if(ghct==null){
                GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setSoLuong(giohangRequest.getSoLuong());
                gioHangChiTiet.setDonGia(giohangRequest.getDonGia());
                gioHangChiTiet.setGioHang(gh);
                gioHangChiTiet.setCtspSize(ctspSizeRepository.getByCtspSize(idCtsp,tenSize));
                ghctRepository.save(gioHangChiTiet);
            }else{
                GioHangChiTiet gioHangChiTiet = ghctRepository.getById(ghct.getId());
                gioHangChiTiet.setSoLuong(giohangRequest.getSoLuong()+ gioHangChiTiet.getSoLuong());
                gioHangChiTiet.setDonGia(gioHangChiTiet.getDonGia());
                gioHangChiTiet.setGioHang(gh);
                gioHangChiTiet.setCtspSize(gioHangChiTiet.getCtspSize());
                ghctRepository.save(gioHangChiTiet);
            }

        }
    }

    @Override
    public List<GiohangRespone> getGioHangUser(UUID idKhachHang) {
        return giohangRepository.getGioHangUser(idKhachHang);
    }

    @Override
    public void deleteAll() {
        giohangRepository.deleteAll();
    }
}
