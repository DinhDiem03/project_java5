package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.MauSac;
import com.example.assignment.entity.NSX;
import com.example.assignment.request.MauSacRequest;
import com.example.assignment.request.NSXRequest;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getAll();

    NSX getById(UUID id);

    void add(NSXRequest nsxRequest);

    void update(NSXRequest nsxRequest);

    void delete(UUID id);
}
