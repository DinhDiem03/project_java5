package com.example.assignment.respone;
/*
    @diemdz
*/

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuahangRespone {
    private UUID id;
    private String ma;

    private String ten;

    private String diaChi;

    private String thanhPho;

    private String quocGia;
}
