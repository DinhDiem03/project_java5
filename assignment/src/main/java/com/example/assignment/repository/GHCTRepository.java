package com.example.assignment.repository;
/*
    @diemdz
*/

import com.example.assignment.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface GHCTRepository extends JpaRepository<GioHangChiTiet, UUID> {
    @Transactional
    @Query("select ghct from GioHangChiTiet  ghct where ghct.ctspSize.id =?1")
    GioHangChiTiet getByIdCtspSize(UUID id);
}
