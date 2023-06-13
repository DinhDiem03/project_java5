package com.example.assignment.repository;
/*
    @diemdz
*/

import com.example.assignment.entity.GioHang;
import com.example.assignment.respone.GiohangRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface GiohangRepository extends JpaRepository<GioHang, UUID> {
    @Transactional
    @Query("select new com.example.assignment.respone.GiohangRespone(gh.id,ghct.id,ghct.ctspSize.chiTietSanPham,ghct.soLuong,ghct.ctspSize.size.ten)  from GioHang gh join GioHangChiTiet ghct on gh.id = ghct.gioHang.id where gh.khachHang.id = ?1")
    List<GiohangRespone> getGioHangUser(UUID idKhachHang);
}
