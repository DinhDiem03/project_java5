package com.example.assignment.repository;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.CTSPSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface CTSPSizeRepository extends JpaRepository<CTSPSize, UUID> {

    @Transactional
    @Query("select ct from CTSPSize ct where ct.chiTietSanPham.id = ?1 and ct.size.ten=?2")
    CTSPSize getByCtspSize(UUID idCtsp,String tenSize);
}
