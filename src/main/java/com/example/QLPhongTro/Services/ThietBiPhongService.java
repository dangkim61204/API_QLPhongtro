package com.example.QLPhongTro.Services;

import com.example.QLPhongTro.DTO.Requets.PhongTroRequest;
import com.example.QLPhongTro.DTO.Requets.ThietBiPhongRequest;
import com.example.QLPhongTro.DTO.Response.PhongTroResponse;
import com.example.QLPhongTro.DTO.Response.ThietBiPhongResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ThietBiPhongService {
    List<ThietBiPhongResponse> getAll();
    ThietBiPhongResponse getById(int id);
    ThietBiPhongResponse create(ThietBiPhongRequest request);
    ThietBiPhongResponse update(int id, ThietBiPhongRequest request);
    void delete(int id);
}
