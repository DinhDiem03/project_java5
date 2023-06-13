package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.Size;
import com.example.assignment.request.SizeRequest;

import java.util.List;
import java.util.UUID;

public interface SizeService {
    List<Size> getAll();

    Size getById(UUID id);

    void add(SizeRequest sizeRequest);

    void update(SizeRequest sizeRequest);

    void delete(UUID id);
}
