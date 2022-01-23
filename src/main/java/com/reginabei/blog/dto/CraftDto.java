package com.reginabei.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CraftDto {

    private long id;
    private String craftName;
    private String description;
    private String imageFile;
}
