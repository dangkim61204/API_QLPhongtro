package com.example.QLPhongTro.DTO.Requets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhuRequest implements Serializable {
    private String tenKhu;
    private int slPhong;

}
