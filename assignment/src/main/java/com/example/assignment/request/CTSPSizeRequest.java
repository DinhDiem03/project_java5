package com.example.assignment.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CTSPSizeRequest {
    private UUID id;
    private UUID idCtsp;
    private UUID idSize;
    @NotNull(message = "So luong trong")
    private Integer soLuong;
}
