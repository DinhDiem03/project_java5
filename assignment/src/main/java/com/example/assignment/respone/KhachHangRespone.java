package com.example.assignment.respone;

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
public class KhachHangRespone {
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private Long ngaySinh;
    private String sdt;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
}
