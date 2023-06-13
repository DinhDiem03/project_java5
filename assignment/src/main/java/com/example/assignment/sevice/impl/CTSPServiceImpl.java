package com.example.assignment.sevice.impl;
/*
    @diemdz
*/

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.repository.CTSPRepository;
import com.example.assignment.repository.DSPrepository;
import com.example.assignment.repository.MauSacRepository;
import com.example.assignment.repository.NSXRepository;
import com.example.assignment.repository.SanPhamRepository;
import com.example.assignment.repository.SizeRepository;
import com.example.assignment.request.CTSPRequest;
import com.example.assignment.respone.DetailRespone;
import com.example.assignment.respone.GetMauRespone;
import com.example.assignment.respone.GetSizeRepone;
import com.example.assignment.sevice.CTSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class CTSPServiceImpl implements CTSPService {
    @Autowired
    private CTSPRepository ctspRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private NSXRepository nsxRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private DSPrepository dsPrepository;
    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<ChiTietSanPham> listCTSP() {
        return ctspRepository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return ctspRepository.findAll(pageable);
    }

    @Override
    public CTSPRequest getById(UUID id) {
        ChiTietSanPham chiTietSanPham =ctspRepository.getById(id);
        CTSPRequest ctspRequest = new CTSPRequest();
        ctspRequest.setMa(chiTietSanPham.getMa());
        ctspRequest.setId(chiTietSanPham.getId());
        ctspRequest.setIdDSP(chiTietSanPham.getDongSanPham().getId());
        ctspRequest.setIdNsx(chiTietSanPham.getNsx().getId());
        ctspRequest.setIdSanPham(chiTietSanPham.getSanPham().getId());
        ctspRequest.setIdMauSac(chiTietSanPham.getMauSac().getId());
        ctspRequest.setHinhAnh(chiTietSanPham.getHinhAnh());
        ctspRequest.setGiaBan(chiTietSanPham.getGiaBan());
        ctspRequest.setGiaNhap(chiTietSanPham.getGiaNhap());
        ctspRequest.setNamBh(chiTietSanPham.getNamBh());
        ctspRequest.setMoTa(chiTietSanPham.getMoTa());
        return ctspRequest;
    }
    @Override
    public String uploadFile( MultipartFile file) throws IOException {

        String fileName = null;

        Path fileUpload = Paths.get("src/main/resources/static/images");
        if (!Files.exists(fileUpload)) {
            Files.createDirectories(fileUpload);
        }
        try {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path pathFile = fileUpload.resolve(fileName);
            Files.copy(file.getInputStream(), pathFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
        return fileName;
    }
    @Override
    public void add(CTSPRequest ctspRequest, MultipartFile file) throws IOException {
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setMa(ctspRequest.getMa());
        chiTietSanPham.setNamBh(ctspRequest.getNamBh());
        chiTietSanPham.setMoTa(ctspRequest.getMoTa());
        chiTietSanPham.setGiaNhap(ctspRequest.getGiaNhap());
        chiTietSanPham.setGiaBan(ctspRequest.getGiaBan());
        chiTietSanPham.setHinhAnh(uploadFile(file));
        chiTietSanPham.setSanPham(sanPhamRepository.getOne(ctspRequest.getIdSanPham()));
        chiTietSanPham.setNsx(nsxRepository.getOne(ctspRequest.getIdNsx()));
        chiTietSanPham.setDongSanPham(dsPrepository.getOne(ctspRequest.getIdDSP()));
        chiTietSanPham.setMauSac(mauSacRepository.getOne(ctspRequest.getIdMauSac()));
        ctspRepository.save(chiTietSanPham);
    }

    @Override
    public void update(CTSPRequest ctspRequest, MultipartFile file)throws IOException  {
        ChiTietSanPham chiTietSanPham = ctspRepository.getById(ctspRequest.getId());
        chiTietSanPham.setMa(ctspRequest.getMa());
        chiTietSanPham.setNamBh(ctspRequest.getNamBh());
        chiTietSanPham.setMoTa(ctspRequest.getMoTa());
        chiTietSanPham.setGiaNhap(ctspRequest.getGiaNhap());
        chiTietSanPham.setGiaBan(ctspRequest.getGiaBan());
        if(file.isEmpty()){
            chiTietSanPham.setHinhAnh(chiTietSanPham.getHinhAnh());
        }else{
                 chiTietSanPham.setHinhAnh(uploadFile(file));
        }
        chiTietSanPham.setSanPham(sanPhamRepository.getById(ctspRequest.getIdSanPham()));
        chiTietSanPham.setNsx(nsxRepository.getOne(ctspRequest.getIdNsx()));
        chiTietSanPham.setDongSanPham(dsPrepository.getOne(ctspRequest.getIdDSP()));
        chiTietSanPham.setMauSac(mauSacRepository.getOne(ctspRequest.getIdMauSac()));
        ctspRepository.save(chiTietSanPham);
    }

    @Override
    public void delete(UUID id) {
        ctspRepository.deleteById(id);
    }

    @Override
    public DetailRespone DetailSanPham(UUID id) {
        return ctspRepository.getDetail(id);
//        return  null;
    }

    @Override
    public List<GetMauRespone> getMau(UUID id) {

        return ctspRepository.getMau(id);
    }

    @Override
    public List<GetSizeRepone> getSize(UUID id) {
        return ctspRepository.getSize(id);
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return ctspRepository.findById(id).get();
    }

    public static void main(String[] args) {

//        Set<MauSac> set = new HashSet<>();
//        set.add(mauSacRepository.getOne(UUID.fromString("")));
//        ChiTietSanPham chiTietSanPham = new ChiTietSanPham("",1,"a",12,12,13,"aa", new SanPham().setId(UUID.fromString("5a8b20be-bd1c-4081-a0a7-e7525eb35b35")),new NSX().setId(UUID.fromString("1c751eae-9081-436c-a04d-2dd2bccc4ac8")),new DongSanPham().setId(UUID.fromString("1681a521-b657-4395-a397-ba8e121e7c9e")),);
//        new CTSPServiceImpl().add(new CTSPRequest());
        System.out.println(new CTSPServiceImpl().getAll(0,5));
    }
}
