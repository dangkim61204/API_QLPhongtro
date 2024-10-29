package com.example.QLPhongTro.Services.Impl;
import com.example.QLPhongTro.Exception.AppException;
import com.example.QLPhongTro.Exception.ErrorCode;
import com.example.QLPhongTro.Repository.PhongTroRepository;
import org.modelmapper.*;

import com.example.QLPhongTro.DTO.Requets.KhuRequest;
import com.example.QLPhongTro.DTO.Response.KhuResponse;
import com.example.QLPhongTro.Models.Khu;
import com.example.QLPhongTro.Repository.KhuRepository;
import com.example.QLPhongTro.Services.KhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhuServiceImpl implements KhuService {
    @Autowired
    private KhuRepository khuRepository;
    @Autowired
    private PhongTroRepository phongTroRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<KhuResponse> getAllKhu() {
        List<Khu> khuList = khuRepository.findAll();
        return khuList.stream().map((element) ->  modelMapper.map(element, KhuResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public KhuResponse getById(int id) {
        Khu khu = khuRepository.findById(id)
                .orElseThrow( () -> (new AppException(ErrorCode.CATEGORY_NOT_FOUND)));
        return modelMapper.map(khu, KhuResponse.class);
    }

    @Override
    public KhuResponse create(KhuRequest request) {
        Khu khu = modelMapper.map(request, Khu.class);
        return modelMapper.map(khuRepository.save(khu), KhuResponse.class);
    }

    @Override
    public KhuResponse update(int id,KhuRequest request) {
        Khu existingKhu = khuRepository.findById(id)
                .orElseThrow( () -> (new AppException(ErrorCode.CATEGORY_NOT_FOUND)));
        modelMapper.map(request, existingKhu);
        Khu updateKhu = khuRepository.save(existingKhu);
        return modelMapper.map(updateKhu, KhuResponse.class);
    }

    @Override
    public void delete(int id) {
        boolean existsProduct = phongTroRepository.existsById(id);
        if (existsProduct) {
            throw new AppException(ErrorCode.PRODUCT_EXIST_IN_CATEGORY);
        }

        phongTroRepository.deleteById(id);
    }


}

