package com.example.assignment.cookies;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.ChiTietSanPham;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cart {

    private ChiTietSanPham chiTietSanPham;

    private Integer soLuong;

    private String size;


}
