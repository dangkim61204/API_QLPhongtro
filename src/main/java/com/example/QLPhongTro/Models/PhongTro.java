package com.example.QLPhongTro.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="PhongTro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String maPT;
    private String tenPT;
    private String image;
    private int tangSo;
    private double giaTien;
    private String moTa;
    private Boolean trangThai;

    //nhieu phong tro thuoc 1 khu
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khuId", referencedColumnName = "maKhu")
    private Khu khu;

    //1 phong tro co nhieu  TBP
    @OneToMany(mappedBy = "phongTro",cascade = CascadeType.ALL)
    private List<ThietBiPhong> thietBiPhongs;


}
