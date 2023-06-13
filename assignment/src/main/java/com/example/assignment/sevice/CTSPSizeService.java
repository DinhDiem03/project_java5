package com.example.assignment.sevice;
/*
 *  @author diemdz
 */

import com.example.assignment.entity.CTSPSize;
import com.example.assignment.request.CTSPSizeRequest;

import java.util.List;
import java.util.UUID;

public interface CTSPSizeService {
    List<CTSPSize> getAll();
    CTSPSizeRequest getById(UUID id);
    void add(CTSPSizeRequest ctspSizeRequest);
    void update(CTSPSizeRequest ctspSizeRequest);
    void delete(UUID id);
}
