package com.example.QLPhongTro.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThietBiPhongResponse {
    private int id;
    private String maTBP;
    private Date ngayCap;
    private int phongTroId;
    private String maPT;
    private String tenPT;

}
