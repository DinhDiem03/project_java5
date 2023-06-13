package com.example.assignment.request;

import jakarta.persistence.Column;
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
public class NhanVienRequest {
    private UUID id;
    @NotEmpty(message = "mã trống")
    private String ma;
    @NotEmpty(message = "tên trống")
    private String ten;
    @NotEmpty(message = "giới tính trống")
    private String gioiTinh;
    @NotNull(message = "Ngày sinh trống")
    private Long ngaySinh;
    @NotEmpty(message = "email trống")
    private String email;
    @NotEmpty(message = "sdt trống")
    private String sdt;
    @NotEmpty(message = "địa chỉ trống")
    private String diaChi;
    @NotEmpty(message = "mật khẩu trống")
    private String matKhau;

    @NotNull(message = "trạng thái trống")
    private int trangThai;
    private UUID idCuaHang;
    private UUID idChucVu;
}
