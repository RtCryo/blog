package com.reginabei.blog.service;

import com.reginabei.blog.dao.CategoryThemesRelationshipDao;
import com.reginabei.blog.dao.ThemesDao;
import com.reginabei.blog.dto.ThemeDto;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemesService {

    private final ThemesDao themesDao;
    private final CategoryThemesRelationshipDao categoryThemesRelationshipDao;

    public void createTheme(ThemeDto themeDto) {
        themesDao.save(dtoToModel(themeDto));
    }

    public List<Theme> findAllThemes() {
        return (List<Theme>) themesDao.findAll();
    }

    public void deleteThemes(List<ThemeDto> themesDto) {
        themesDto.forEach(e -> {
            categoryThemesRelationshipDao.deleteAll(categoryThemesRelationshipDao.findAllByTheme(dtoToModel(e)));
            themesDao.delete(dtoToModel(e));
        });
    }

    private Theme dtoToModel(ThemeDto themeDto) {
        Theme theme = new Theme();
        theme.setId(themeDto.getId());
        theme.setName(themeDto.getName());
        return theme;
    }
}