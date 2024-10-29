package com.example.QLPhongTro.Services.Impl;

import com.example.QLPhongTro.DTO.Requets.ThietBiPhongRequest;
import com.example.QLPhongTro.DTO.Response.ThietBiPhongResponse;
import com.example.QLPhongTro.Services.ThietBiPhongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThietBiPhongServiceImpl implements ThietBiPhongService {
    @Override
    public List<ThietBiPhongResponse> getAll() {
        return List.of();
    }

    @Override
    public ThietBiPhongResponse getById(int id) {
        return null;
    }

    @Override
    public ThietBiPhongResponse create(ThietBiPhongRequest request) {
        return null;
    }

    @Override
    public ThietBiPhongResponse update(int id, ThietBiPhongRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
