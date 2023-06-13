package com.example.assignment.request;
/*
    @diemdz
*/

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuahangRequest {
    @NotEmpty(message = "mã trống")
    private String ma;

    @NotEmpty(message = "tên trống")
    private String ten;

    @NotEmpty(message = "địa chỉ trống")
    private String diaChi;

}
