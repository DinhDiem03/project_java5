package com.example.assignment.repository;

import com.example.assignment.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*
 *  @author diemdz
 */
@Repository
public interface SizeRepository extends JpaRepository<Size, UUID> {

    Size getByTen(String ten);
}
