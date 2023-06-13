package com.example.assignment.request;

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
public class KhachHangRequest {
    private UUID id;
    @NotEmpty(message = "mã trống")
    private String ma;
    @NotEmpty(message = "tên trống")
    private String ten;
    @NotEmpty(message = "email trống")
    private String email;
    @NotEmpty(message = "sdt trống")
    private String sdt;
    @NotEmpty(message = "địa chỉ trống")
    private String diaChi;

    @NotEmpty(message = "mật khẩu trống")
    private String matKhau;
    private UUID idChucVu;
}
