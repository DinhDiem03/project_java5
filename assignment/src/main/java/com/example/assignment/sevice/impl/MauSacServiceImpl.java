package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.MauSac;
import com.example.assignment.repository.MauSacRepository;
import com.example.assignment.request.MauSacRequest;
import com.example.assignment.sevice.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac getById(UUID id) {
        return mauSacRepository.getById(id);
    }

    @Override
    public void add(MauSacRequest mauSacRequest) {
        MauSac mauSac = new MauSac();
        mauSac.setMa(mauSacRequest.getMa());
        mauSac.setTen(mauSacRequest.getTen());
        mauSacRepository.save(mauSac);
    }

    @Override
    public void update(MauSacRequest mauSacRequest) {
        MauSac mauSac = mauSacRepository.getById(mauSacRequest.getId());
        mauSac.setMa(mauSacRequest.getMa());
        mauSac.setTen(mauSacRequest.getTen());
        mauSacRepository.save(mauSac);
    }

    @Override
    public void delete(UUID id) {
        mauSacRepository.deleteById(id);
    }
}
