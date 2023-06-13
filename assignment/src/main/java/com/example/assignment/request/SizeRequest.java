package com.example.assignment.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/*
 *  @author diemdz
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SizeRequest {
    private UUID id;
    @NotEmpty(message = "mã trống")
    private String ma;
    @NotEmpty(message = "tên trống")
    private String ten;
}
