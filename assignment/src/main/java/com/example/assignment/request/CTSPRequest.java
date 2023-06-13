package com.example.assignment.request;
/*
    @diemdz
*/

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CTSPRequest {
    private UUID id;
    private UUID idSanPham;
    private UUID idNsx;
    private UUID idDSP;
    private UUID idMauSac;
    private UUID idSize;
    private String hinhAnh;
    @NotNull(message = "mã trống")
    private String ma;
    @NotNull(message = "năm bảo hành trống")
    private Integer namBh;
    @NotEmpty(message = "mô tả trống")
    private String moTa;
    @NotNull(message = "giá nhập trống")
    private BigDecimal giaNhap;
    @NotNull(message = "giá bán trống")
    private Double giaBan;

}
