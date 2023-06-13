package com.example.assignment.respone;
/*
    @diemdz
*/

import com.example.assignment.entity.CTSPSize;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.KhachHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonRespone {
    private UUID id;
    private String ma;
    private KhachHang khachHang;
    private Integer trangThai;

}
