package com.example.assignment.repository;
/*
    @diemdz
*/


import com.example.assignment.entity.SanPham;
import com.example.assignment.respone.GetSanPhamRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Transactional
    @Modifying
    @Query("select new com.example.assignment.respone.GetSanPhamRespone(ctsp.id,sp.ten,ctsp.giaBan,ctsp.hinhAnh)  from SanPham sp join ChiTietSanPham ctsp on sp.id = ctsp.sanPham.id " )
    List<GetSanPhamRespone> getSanPham();
}
