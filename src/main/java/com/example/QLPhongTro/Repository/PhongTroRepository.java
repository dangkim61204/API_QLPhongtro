package com.example.QLPhongTro.Repository;


import com.example.QLPhongTro.Models.PhongTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongTroRepository extends JpaRepository<PhongTro, Integer> {
}
