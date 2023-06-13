package com.example.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/*
 *  @author diemdz
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "don_gia")
    private Double donGia;
    @ManyToOne()
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;
    @ManyToOne()
    @JoinColumn(name = "id_gio_hang")
    private GioHang gioHang;
    @ManyToOne()
    @JoinColumn(name = "id_chi_tiet_san_pham_size")
    private CTSPSize ctspSize;
}
