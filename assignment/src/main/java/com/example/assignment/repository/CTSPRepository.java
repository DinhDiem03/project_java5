package com.example.assignment.repository;
/*
    @diemdz
*/

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.respone.DetailRespone;
import com.example.assignment.respone.GetMauRespone;
import com.example.assignment.respone.GetSizeRepone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface CTSPRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Transactional

    @Query("select new com.example.assignment.respone.DetailRespone(sp.id,ctsp.id,ctsp.giaBan,ctsp.hinhAnh,sp.ten)  from SanPham sp join ChiTietSanPham ctsp on sp.id = ctsp.sanPham.id  where ctsp.id =?1" )
     DetailRespone getDetail(UUID id);

    @Query("select new com.example.assignment.respone.GetMauRespone(ctsp.id,ctsp.mauSac.ten)  from SanPham sp join ChiTietSanPham ctsp on sp.id = ctsp.sanPham.id  where sp.id =?1" )
    List<GetMauRespone> getMau(UUID id);
    @Query("select new com.example.assignment.respone.GetSizeRepone(cs.size.ten)  from  ChiTietSanPham ctsp join CTSPSize cs on ctsp.id = cs.chiTietSanPham.id  where ctsp.id =?1" )
    List<GetSizeRepone> getSize(UUID id);
}
