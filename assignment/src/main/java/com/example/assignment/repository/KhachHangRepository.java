package com.example.assignment.repository;
/*
    @diemdz
*/

import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.respone.UserRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,UUID> {
    @Transactional
    @Query("select new com.example.assignment.respone.UserRespone(kh.email,kh.matKhau,kh.chucVu.ten) from KhachHang kh where kh.email = ?1")
    Optional<UserRespone> getByEmail(String email);

    @Query("select kh from KhachHang kh where kh.email like ?1")
    KhachHang getKhachHangByEmail(String email);
    @Query("select gh from KhachHang kh join GioHang gh on kh.id = gh.khachHang.id where kh.id=?1")
    GioHang getGioHangByIdKhachHang(UUID id);


}
