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
@Table(name = "chi_tiet_san_pham")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "nam_bao_hanh")
    private Integer namBh;
    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;
    @Column(name = "gia_ban")
    private Double giaBan;
    @Column(name = "hinh_anh")
    private String hinhAnh;
    @ManyToOne()
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;
    @ManyToOne()
    @JoinColumn(name = "id_nsx")
    private NSX nsx;
    @ManyToOne()
    @JoinColumn(name = "id_dongSp")
    private DongSanPham dongSanPham;
    @ManyToOne()
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

}
