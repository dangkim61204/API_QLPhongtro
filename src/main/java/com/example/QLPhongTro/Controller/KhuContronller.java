package com.example.QLPhongTro.Controller;

import com.example.QLPhongTro.DTO.Requets.KhuRequest;
import com.example.QLPhongTro.DTO.Response.ApiResponse;
import com.example.QLPhongTro.DTO.Response.KhuResponse;
import com.example.QLPhongTro.Services.KhuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khu")
@RequiredArgsConstructor
@Slf4j
public class KhuContronller {
    @Autowired
    private KhuService khuService;

    @GetMapping
    public ApiResponse<List<KhuResponse> > getAllKhu() {
        List<KhuResponse>  khuResponses= khuService.getAllKhu();
        return ApiResponse.<List<KhuResponse>>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .result(khuResponses)
                .build();

    }

    @GetMapping("/{id}")
    public ApiResponse<KhuResponse> getById(@PathVariable int id) {
        KhuResponse khuResponse = khuService.getById(id);
        return ApiResponse.<KhuResponse>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .result(khuResponse)
                .build();
    }

    @PostMapping
    public ApiResponse<KhuResponse> create (@RequestBody KhuRequest request) {
         KhuResponse response = khuService.create(request);
        return ApiResponse.<KhuResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .result(response)
                .build();

    }

    @PutMapping("/{id}")
    public ApiResponse<KhuResponse> update (@RequestBody KhuRequest request, @PathVariable int id) {
        KhuResponse response = khuService.update(id, request);
        return ApiResponse.<KhuResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .result(response)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete (@PathVariable int id) {
        khuService.delete(id);
        return ApiResponse.<Void>builder()
                .code(HttpStatus.OK.value())
                .message("Category is deleted successfully!")
                .build();
    }

}
