package com.example.QLPhongTro.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Khu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Khu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makhu;
    @Column(columnDefinition="Nvarchar(100)")
    private String tenKhu;
    private int slPhong;

    //1 khu co nhieu phong tro
    @OneToMany(mappedBy = "khu",cascade = CascadeType.ALL)
    private List<PhongTro> phongTros;

}
