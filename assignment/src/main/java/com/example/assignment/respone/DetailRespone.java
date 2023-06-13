package com.example.assignment.respone;
/*
    @diemdz
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailRespone {
    private UUID idSanPham;
    private UUID idCTSP;
    private Double giaBan;
    private String hinhAnh;
    private String tenSanPham;

}
