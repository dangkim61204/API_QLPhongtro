package com.example.QLPhongTro.DTO.Requets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThietBiPhongRequest implements Serializable {
    private int id;
    private String maTBP;
    private Date ngayCap;
}
