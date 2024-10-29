package com.example.QLPhongTro.Services;

import com.example.QLPhongTro.DTO.Requets.PhongTroRequest;
import com.example.QLPhongTro.DTO.Response.PhongTroResponse;
import com.example.QLPhongTro.Models.Khu;
import com.example.QLPhongTro.Models.PhongTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PhongTroService  {
    List<PhongTroResponse> getAllPT();
    PhongTroResponse getById(int id);
    PhongTroResponse create(PhongTroRequest request);
    PhongTroResponse update(int id, PhongTroRequest request);
    void delete(int id);
}
