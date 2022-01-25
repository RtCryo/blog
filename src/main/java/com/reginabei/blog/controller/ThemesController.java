package com.reginabei.blog.controller;

import com.reginabei.blog.model.Theme;
import com.reginabei.blog.service.ThemesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ThemesController {

    private ThemesService themesService;

    @GetMapping("/getAllThemes")
    public ResponseEntity<List<Theme>> getListThemes(){
        return new ResponseEntity<>(themesService.findAllThemes(), HttpStatus.OK);
    }

}
