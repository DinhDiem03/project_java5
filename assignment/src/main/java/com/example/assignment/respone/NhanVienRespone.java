package com.example.assignment.respone;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.entity.CuaHang;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/*
    @diemdz
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienRespone {
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Long ngaySinh;
    private String sdt;
    private String diaChi;
    private int trangThai;
    private CuaHang cuaHang;
    private ChucVu chucVu;
}
