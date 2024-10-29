package com.example.QLPhongTro.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="TBP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThietBiPhong {
    @Id
    private int id;
    private String maTBP;
    private Date ngayCap;

    //Nhieu TBP trong 1 phong trọ
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phongTroId", referencedColumnName = "id")
    private ThietBiPhong thietBiPhong;
}
