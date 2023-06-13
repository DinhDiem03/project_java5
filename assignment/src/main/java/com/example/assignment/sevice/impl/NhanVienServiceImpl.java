package com.example.assignment.sevice.impl;

import com.example.assignment.entity.NhanVien;
import com.example.assignment.repository.ChucVuRepository;
import com.example.assignment.repository.CuaHangRepository;
import com.example.assignment.repository.NhanVienRepository;
import com.example.assignment.request.NhanVienRequest;
import com.example.assignment.sevice.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Autowired
    private CuaHangRepository cuaHangRepository;
    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getById(UUID id) {
        return nhanVienRepository.getById(id);
    }

    @Override
    public void add(NhanVienRequest nhanVienRequest) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(nhanVienRequest.getMa());
        nhanVien.setTen(nhanVienRequest.getTen());
        nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
        nhanVien.setNgaySinh(nhanVienRequest.getNgaySinh());
        nhanVien.setSdt(nhanVienRequest.getSdt());
        nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
        nhanVien.setEmail(nhanVienRequest.getEmail());
        nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
        nhanVien.setChucVu(chucVuRepository.getById(nhanVienRequest.getIdChucVu()));

        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void update(NhanVienRequest nhanVienRequest, UUID id) {
        NhanVien nhanVien = nhanVienRepository.getById(id);
        nhanVien.setMa(nhanVienRequest.getMa());
        nhanVien.setTen(nhanVienRequest.getTen());
        nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
        nhanVien.setNgaySinh(nhanVienRequest.getNgaySinh());
        nhanVien.setSdt(nhanVienRequest.getSdt());
        nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
        nhanVien.setEmail(nhanVienRequest.getEmail());
        nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
        nhanVien.setChucVu(chucVuRepository.getById(nhanVienRequest.getIdChucVu()));
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }
}
