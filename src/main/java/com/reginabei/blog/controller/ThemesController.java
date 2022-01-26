package com.reginabei.blog.controller;

import com.reginabei.blog.model.Theme;
import com.reginabei.blog.service.ThemesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ThemesController {

    private final ThemesService themesService;

    @GetMapping("/getAllThemes")
    public ResponseEntity<List<Theme>> getListThemes(){
        return new ResponseEntity<>(themesService.findAllThemes(), HttpStatus.OK);
    }

    @PostMapping("/createTheme")
    public ResponseEntity<HttpStatus> createTheme(@RequestBody Theme theme){
        themesService.createTheme(theme);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteThemes")
    public ResponseEntity<HttpStatus> deleteTheme(@RequestBody List<Theme> themes) {
        themesService.deleteThemes(themes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
