package com.reginabei.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageDto {
    private long id;
    private String fileName;
    private String imageFile;
}
