package com.example.QLPhongTro.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongTroResponse {
    private int id;
    private String maPT;
    private String tenPT;
    private String image;
    private int tangSo;
    private double giaTien;
    private String moTa;
    private Boolean trangThai;
    private int khuId;
    private String tenKhu;
}
