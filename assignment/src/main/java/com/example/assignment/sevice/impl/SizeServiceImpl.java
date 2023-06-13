package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.Size;
import com.example.assignment.repository.SizeRepository;
import com.example.assignment.request.SizeRequest;
import com.example.assignment.sevice.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(UUID id) {
        return sizeRepository.getById(id);
    }

    @Override
    public void add(SizeRequest sizeRequest) {
        Size size = new Size();
        size.setMa(sizeRequest.getMa());
        size.setTen(sizeRequest.getTen());
        sizeRepository.save(size);
    }

    @Override
    public void update(SizeRequest sizeRequest) {
        Size size = sizeRepository.getById(sizeRequest.getId());
        size.setMa(sizeRequest.getMa());
        size.setTen(sizeRequest.getTen());
        sizeRepository.save(size);
    }

    @Override
    public void delete(UUID id) {
        sizeRepository.deleteById(id);
    }
}
