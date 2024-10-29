package com.example.QLPhongTro.DTO.Requets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongTroRequest implements Serializable {
    private int id;
    private String maPT;
    private String tenPT;
    private MultipartFile image;
    private int tangSo;
    private double giaTien;
    private String moTa;
    private Boolean trangThai;
    private int khuId;
}
