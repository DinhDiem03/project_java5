package com.example.assignment.respone;
/*
    @diemdz
*/

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NSXRespone {
    @NotEmpty(message = "mã trống")
    private String ma;
    @NotEmpty(message = "tên trống")
    private String ten;
}
