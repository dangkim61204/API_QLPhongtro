package com.example.QLPhongTro.Controller;

import com.example.QLPhongTro.DTO.Requets.PhongTroRequest;
import com.example.QLPhongTro.DTO.Response.ApiResponse;
import com.example.QLPhongTro.DTO.Response.PhongTroResponse;
import com.example.QLPhongTro.Models.PhongTro;
import com.example.QLPhongTro.Services.KhuService;
import com.example.QLPhongTro.Services.PhongTroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/phongtros")
public class PhongTroController {
    @Autowired
    PhongTroService phongTroService;
    @Autowired
    KhuService khuService;

    @GetMapping
    public ApiResponse<List<PhongTroResponse>>  getAllPT() {
        List<PhongTroResponse> products = phongTroService.getAllPT();
        return ApiResponse.<List<PhongTroResponse>>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .result(products)
                .build();
    }
    @PostMapping
    public ApiResponse<PhongTroResponse> create (@ModelAttribute PhongTroRequest request) {
        PhongTroResponse phongTroResponse = phongTroService.create(request);
        return ApiResponse.<PhongTroResponse>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .result(phongTroResponse)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<PhongTroResponse> update ( @PathVariable int id ,@ModelAttribute PhongTroRequest request) {
        PhongTroResponse phongTroResponse = phongTroService.update(id, request);
        return ApiResponse.<PhongTroResponse>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .result(phongTroResponse)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete (@PathVariable int id) {
        phongTroService.delete(id);
        return ApiResponse.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }
}
