package com.example.assignment.repository;
/*
    @diemdz
*/

import com.example.assignment.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface HDCTRepository extends JpaRepository<HoaDonChiTiet, UUID> {
    @Transactional
    @Query("select hdct from HoaDonChiTiet hdct join HoaDon  hd on hdct.hoaDon.id = hd.id where hd.id =?1")
    List<HoaDonChiTiet> getListHDCT(UUID id);
}
