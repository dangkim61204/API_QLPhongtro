package com.example.QLPhongTro.Repository;

import com.example.QLPhongTro.Models.ThietBiPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietBiPhongRepository extends JpaRepository<ThietBiPhong, Integer> {
}
