package com.example.assignment.sevice.impl;

import com.example.assignment.cookies.Cart;
import com.example.assignment.cookies.GioHang;
import com.example.assignment.entity.CTSPSize;
import com.example.assignment.entity.HoaDon;
import com.example.assignment.entity.HoaDonChiTiet;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.genma.GenMa;
import com.example.assignment.repository.CTSPSizeRepository;
import com.example.assignment.repository.GiohangRepository;
import com.example.assignment.repository.HDCTRepository;
import com.example.assignment.repository.HoaDonRepository;
import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.repository.SizeRepository;
import com.example.assignment.request.HDCTRequest;
import com.example.assignment.request.HoaDonRequest;
import com.example.assignment.respone.GiohangRespone;
import com.example.assignment.respone.HoaDonRespone;
import com.example.assignment.sevice.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private HDCTRepository hdctRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private GiohangRepository giohangRepository;

    @Autowired
    private GioHang gioHang;
    @Autowired
    private CTSPSizeRepository ctspSizeRepository;

    @Override
    public HoaDonRequest getById(UUID id) {
        HoaDon hoaDon = hoaDonRepository.getById(id);
        HoaDonRequest hoaDonRequest = new HoaDonRequest();
        hoaDonRequest.setId(hoaDon.getId());
        hoaDonRequest.setMa(hoaDon.getMa());
        hoaDonRequest.setTenNguoiNhan(hoaDon.getTenNguoiNhan());
        hoaDonRequest.setDiaChi(hoaDon.getDiaChi());
        hoaDonRequest.setSdt(hoaDon.getSdt());
        hoaDonRequest.setTrangThai(hoaDon.getTrangThai());

        return hoaDonRequest;
    }

    @Override
    public void add( HoaDonRequest hoaDonRequest) {

        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa(new GenMa().genMaHoaDon());
        hoaDon.setTenNguoiNhan(hoaDonRequest.getTenNguoiNhan());
        hoaDon.setDiaChi(hoaDonRequest.getDiaChi());
        hoaDon.setSdt(hoaDonRequest.getSdt());
        hoaDon.setTrangThai(0);
        hoaDonRepository.save(hoaDon);
        for (Cart x: gioHang.getCart()) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setDonGia(x.getChiTietSanPham().getGiaBan());
            hoaDonChiTiet.setSoLuong(x.getSoLuong());
            hoaDonChiTiet.setHoaDon(hoaDon);
            CTSPSize ctspSize= ctspSizeRepository.getByCtspSize(x.getChiTietSanPham().getId(), x.getSize());
            hoaDonChiTiet.setCtspSize(ctspSize);
            hdctRepository.save(hoaDonChiTiet);
        }


    }



    @Override
    public void addUser(Authentication authentication, HoaDonRequest hoaDonRequest) {
        KhachHang khachHang = khachHangRepository.getKhachHangByEmail(authentication.getName());
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa(new GenMa().genMaHoaDon());
        hoaDon.setTenNguoiNhan(hoaDonRequest.getTenNguoiNhan());
        hoaDon.setDiaChi(hoaDonRequest.getDiaChi());
        hoaDon.setSdt(hoaDonRequest.getSdt());
        hoaDon.setKhachHang(khachHang);
        hoaDon.setTrangThai(0);
        hoaDonRepository.save(hoaDon);
        for (GiohangRespone x: giohangRepository.getGioHangUser(khachHang.getId())) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setDonGia(x.getChiTietSanPham().getGiaBan());
            hoaDonChiTiet.setSoLuong(x.getSoLuong());
            hoaDonChiTiet.setHoaDon(hoaDon);
            CTSPSize ctspSize= ctspSizeRepository.getByCtspSize(x.getChiTietSanPham().getId(), x.getSize());
            hoaDonChiTiet.setCtspSize(ctspSize);
            hdctRepository.save(hoaDonChiTiet);
        }
    }

    @Override
    public void update( HoaDonRequest hoaDonRequest) {
        HoaDon hoaDon = hoaDonRepository.getById(hoaDonRequest.getId());

        hoaDon.setMa(hoaDonRequest.getMa());
        hoaDon.setTenNguoiNhan(hoaDonRequest.getTenNguoiNhan());
        hoaDon.setDiaChi(hoaDonRequest.getDiaChi());
        hoaDon.setSdt(hoaDonRequest.getSdt());
        hoaDon.setTrangThai(hoaDonRequest.getTrangThai());
        hoaDon.setKhachHang(hoaDon.getKhachHang());
        hoaDonRepository.save(hoaDon);
    }

    @Override
    public List<HoaDonRespone> getAll() {
        return hoaDonRepository.getAll();
    }
}
