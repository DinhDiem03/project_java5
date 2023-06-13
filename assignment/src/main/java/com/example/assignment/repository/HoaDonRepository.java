package com.example.assignment.repository;
/*
    @diemdz
*/

import com.example.assignment.entity.HoaDon;
import com.example.assignment.respone.HoaDonRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Transactional
    @Query("select new com.example.assignment.respone.HoaDonRespone(hd.id,hd.ma,hd.khachHang,hd.trangThai) from HoaDon hd ")
    List<HoaDonRespone> getAll();
}
