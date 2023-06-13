package com.example.assignment.request;

import com.example.assignment.entity.CTSPSize;
import com.example.assignment.entity.GioHang;
import com.example.assignment.entity.HoaDon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/*
    @diemdz
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HDCTRequest {

    private UUID id;
    private Integer soLuong;

    private Double donGia;
    private UUID idHoaDon;
    private UUID idGioHang;

    private UUID idCtspSize;
}
