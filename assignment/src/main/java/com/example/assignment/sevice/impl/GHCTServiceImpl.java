package com.example.assignment.sevice.impl;

import com.example.assignment.entity.GioHangChiTiet;
import com.example.assignment.repository.GHCTRepository;
import com.example.assignment.sevice.GHCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/*
 *  @author diemdz
 */
@Service
public class GHCTServiceImpl implements GHCTService {
    @Autowired
    private GHCTRepository ghctRepository;

    @Override
    public void delete(UUID id) {
        ghctRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        ghctRepository.deleteAll();
    }
}
