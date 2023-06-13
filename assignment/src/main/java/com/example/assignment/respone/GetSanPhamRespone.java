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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSanPhamRespone {
    private UUID id;
    private String ten;
    private Double giaBan;
    private String hinhAnh;

}
