package com.example.QLPhongTro.DTO.Response;


import com.example.QLPhongTro.Models.PhongTro;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhuResponse {
    private int maKhu;  //id mã khu
    private String tenKhu; //ten ma khu
    private int slPhong; //soluong phong
    private List<PhongTro> phongTros;
}
