package com.example.assignment.respone;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/*
    @diemdz
*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChucVuRespone {
    private UUID id;
    private String ma;
    private String ten;
}
