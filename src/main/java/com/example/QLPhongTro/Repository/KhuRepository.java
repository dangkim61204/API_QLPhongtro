package com.example.QLPhongTro.Repository;

import com.example.QLPhongTro.Models.Khu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuRepository extends JpaRepository<Khu, Integer> {
}
