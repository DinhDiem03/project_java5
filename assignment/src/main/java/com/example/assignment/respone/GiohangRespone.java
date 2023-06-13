package com.example.assignment.respone;
/*
    @diemdz
*/

import com.example.assignment.entity.CTSPSize;
import com.example.assignment.entity.ChiTietSanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiohangRespone {
    private UUID idGioHang;
    private UUID idGhct;
    private ChiTietSanPham chiTietSanPham;

    private Integer soLuong;

    private String size;
}
