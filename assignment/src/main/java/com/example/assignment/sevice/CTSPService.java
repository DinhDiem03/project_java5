package com.example.assignment.sevice;
/*
    @diemdz
*/

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.request.CTSPRequest;
import com.example.assignment.respone.DetailRespone;
import com.example.assignment.respone.GetMauRespone;
import com.example.assignment.respone.GetSizeRepone;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface CTSPService {
    List<ChiTietSanPham> listCTSP();
    Page<ChiTietSanPham> getAll(Integer pageNo, Integer size);

    CTSPRequest getById(UUID id);

    String uploadFile (MultipartFile file) throws IOException;
    void add(CTSPRequest ctspRequest, MultipartFile file) throws IOException;

    void update(CTSPRequest ctspRequest,MultipartFile file)  throws IOException;

    void delete(UUID id);
    DetailRespone DetailSanPham(UUID id);
    List<GetMauRespone> getMau(UUID id);
    List<GetSizeRepone> getSize(UUID id);

    ChiTietSanPham getOne(UUID id);
}
