package com.example.QLPhongTro.Services;

import com.example.QLPhongTro.DTO.Requets.KhuRequest;
import com.example.QLPhongTro.DTO.Response.KhuResponse;
import com.example.QLPhongTro.Models.Khu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KhuService {
    List<KhuResponse> getAllKhu();
    KhuResponse getById(int id);
    KhuResponse create(KhuRequest request);
    KhuResponse update(int id, KhuRequest request);
    void delete(int id);
}
