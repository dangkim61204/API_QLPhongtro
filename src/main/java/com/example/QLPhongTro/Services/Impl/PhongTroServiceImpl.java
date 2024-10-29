package com.example.QLPhongTro.Services.Impl;

import com.example.QLPhongTro.DTO.Requets.PhongTroRequest;
import com.example.QLPhongTro.DTO.Response.KhuResponse;
import com.example.QLPhongTro.DTO.Response.PhongTroResponse;
import com.example.QLPhongTro.Exception.AppException;
import com.example.QLPhongTro.Exception.ErrorCode;
import com.example.QLPhongTro.Models.Khu;
import com.example.QLPhongTro.Models.PhongTro;
import com.example.QLPhongTro.Repository.KhuRepository;
import com.example.QLPhongTro.Repository.PhongTroRepository;
import com.example.QLPhongTro.Services.PhongTroService;
import com.example.QLPhongTro.Util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.modelmapper.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PhongTroServiceImpl implements PhongTroService {
    @Autowired
    private PhongTroRepository phongTroRepository;
    @Autowired
    private KhuRepository khuRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UploadFileUtil uploadFileUtil;


    @Override
    public List<PhongTroResponse> getAllPT() {
        List<PhongTro> PtList = phongTroRepository.findAll();
        return PtList.stream().map((element) -> modelMapper.map(element, PhongTroResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public PhongTroResponse getById(int id) {
        PhongTro pt = phongTroRepository.findById(id)
                .orElseThrow(() -> (new AppException(ErrorCode.PRODUCT_NOT_FOUND)));
        return modelMapper.map(pt, PhongTroResponse.class);
    }

    @Override
    public PhongTroResponse create(PhongTroRequest request) {
        Khu khu = khuRepository.findById(request.getKhuId())
                .orElseThrow(() -> new AppException(ErrorCode.CART_ITEM_NOT_FOUND));

        PhongTro phongTro = modelMapper.map(request, PhongTro.class);
        phongTro.setKhu(khu);

        //Xu ly lưu file ảnh
        String imagePath = uploadFileUtil.saveImage(request.getImage());
        phongTro.setImage(imagePath);

        PhongTroResponse phongTroResponse = modelMapper.map(phongTroRepository.save(phongTro), PhongTroResponse.class);
        phongTroResponse.setKhuId(phongTro.getKhu().getMakhu());

        return phongTroResponse;
    }

    @Override
    public PhongTroResponse update(int id, PhongTroRequest request) {
        //find category by id
        Khu khu = khuRepository.findById(request.getKhuId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));

        //find product by id
        PhongTro phongTro = phongTroRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        modelMapper.map(request, phongTro);

        phongTro.setKhu(khu);

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            //save image into folder
            String imagePath = uploadFileUtil.saveImage(request.getImage());
            phongTro.setImage(imagePath);
        }

        PhongTro updatedPT = phongTroRepository.save(phongTro);
        return modelMapper.map(updatedPT, PhongTroResponse.class);
    }

    @Override
    public void delete(int id) {
        phongTroRepository.deleteById(id);
    }

}
