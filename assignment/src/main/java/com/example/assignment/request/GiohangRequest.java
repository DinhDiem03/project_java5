package com.example.assignment.request;

import com.example.assignment.entity.CTSPSize;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.KhachHang;
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
public class GiohangRequest {
    private UUID id;
    private String ma;
    private UUID idKhachHang;
    private Integer soLuong;
    private Double donGia;
    private UUID idGioHang;
    private UUID idCtspSize;
}
