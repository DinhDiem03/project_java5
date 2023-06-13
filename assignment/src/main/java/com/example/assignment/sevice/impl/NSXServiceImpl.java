package com.example.assignment.sevice.impl;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.NSX;
import com.example.assignment.repository.NSXRepository;
import com.example.assignment.request.NSXRequest;
import com.example.assignment.sevice.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;
    @Override
    public List<NSX> getAll() {
        return nsxRepository.findAll();
    }

    @Override
    public NSX getById(UUID id) {
        return nsxRepository.getById(id);
    }

    @Override
    public void add(NSXRequest nsxRequest) {
        NSX nsx = new NSX();
        nsx.setMa(nsxRequest.getMa());
        nsx.setTen(nsxRequest.getTen());
        nsxRepository.save(nsx);
    }

    @Override
    public void update(NSXRequest nsxRequest) {
        NSX nsx = nsxRepository.getById(nsxRequest.getId());
        nsx.setMa(nsxRequest.getMa());
        nsx.setTen(nsxRequest.getTen());
        nsxRepository.save(nsx);
    }

    @Override
    public void delete(UUID id) {
     nsxRepository.deleteById(id);
    }
}
