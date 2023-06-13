package com.example.assignment.repository;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, UUID> {
}
