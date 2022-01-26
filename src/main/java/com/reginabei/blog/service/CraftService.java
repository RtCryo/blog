package com.reginabei.blog.service;

import com.reginabei.blog.dao.CraftDao;
import com.reginabei.blog.dto.CraftDto;
import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.Craft;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CraftService {

    private final CraftDao craftDao;

    public List<Craft> findAll() {
        return (List<Craft>) craftDao.findAll();
    }

    public void saveCraft(CraftDto craftDto) {
        craftDao.save(dtoToModel(craftDto));
    }

    public List<Craft> findAllByCategoryByTheme(Category category, Theme theme){
        return craftDao.findCraftsByCategoryAndTheme(category, theme);
    }

    private Craft dtoToModel(CraftDto craftDto) {
        Craft craft = new Craft();
        craft.setName(craftDto.getName());
        craft.setDescription(craftDto.getDescription());
        craft.setImageFile(craftDto.getImageFile());
        return craft;
    }

}
