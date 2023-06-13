package com.example.assignment.repository;
/*
    @diemdz
*/

import com.example.assignment.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NSXRepository extends JpaRepository<NSX, UUID> {
}
