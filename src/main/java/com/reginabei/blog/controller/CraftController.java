package com.reginabei.blog.controller;

import com.reginabei.blog.dto.CraftDto;
import com.reginabei.blog.model.Craft;
import com.reginabei.blog.service.CraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CraftController {

    private final CraftService craftService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Craft>> getAllProducts(){
        return new ResponseEntity<>(craftService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/saveCraft")
    public ResponseEntity<HttpStatus> saveCraft(@RequestBody CraftDto craftDto){
        craftService.saveCraft(craftDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
