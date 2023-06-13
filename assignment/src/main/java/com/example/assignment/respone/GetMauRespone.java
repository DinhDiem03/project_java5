package com.example.assignment.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/*
 *  @author diemdz
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetMauRespone {
    private UUID idCTSP;
    private String tenMau;
}
