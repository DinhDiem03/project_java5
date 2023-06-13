package com.example.assignment.request;
/*
    @diemdz
*/

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
public class HoaDonRequest {
    private UUID id;
    private String ma;
    private Long ngayTao;

    private String tenNguoiNhan;

    private String diaChi;

    private String sdt;
    private int trangThai;

    private UUID idKhachHang;




    private Integer soLuong;

    private Double donGia;
    private UUID idHoaDon;
    private UUID idGioHang;

    private UUID idCtspSize;
}
