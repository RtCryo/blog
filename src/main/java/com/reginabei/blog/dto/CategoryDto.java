package com.reginabei.blog.dto;

import com.reginabei.blog.model.Theme;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryDto {

    private long id;
    private String name;
    private List<Theme> themes;

}
