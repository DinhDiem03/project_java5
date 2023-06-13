package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.ChucVu;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.repository.ChucVuRepository;
import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.request.ChucVuRequest;
import com.example.assignment.respone.UserRespone;
import com.example.assignment.sevice.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private KhachHangRepository khachHangrepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getById(UUID id) {
        return chucVuRepository.getById(id);
    }

    @Override
    public void add(ChucVuRequest chucVuRequest) {
        ChucVu chucVu = new ChucVu();
        chucVu.setMa(chucVuRequest.getMa());
        chucVu.setTen(chucVuRequest.getTen());
        chucVuRepository.save(chucVu);
    }

    @Override
    public void update(ChucVuRequest chucVuRequest) {
        ChucVu chucVu = chucVuRepository.getById(chucVuRequest.getId());
        chucVu.setMa(chucVuRequest.getMa());
        chucVu.setTen(chucVuRequest.getTen());
        chucVuRepository.save(chucVu);
    }

    @Override
    public void delete(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public Optional<UserRespone> findByEmail(String email) {
        return khachHangrepository.getByEmail(email);
    }

    @Override
    public List<KhachHang> getAll1() {
        return khachHangrepository.findAll();
    }

    public static void main(String[] args) {
//        System.out.println(new ChucVuServiceImpl().findByEmail("diem05152003@gmail.com"));
        System.out.println(new ChucVuServiceImpl().getAll());

    }
}
