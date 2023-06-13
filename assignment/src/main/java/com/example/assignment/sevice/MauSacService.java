package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.MauSac;
import com.example.assignment.request.MauSacRequest;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    MauSac getById(UUID id);

    void add(MauSacRequest mauSacRequest);

    void update(MauSacRequest mauSacRequest);

    void delete(UUID id);
}
