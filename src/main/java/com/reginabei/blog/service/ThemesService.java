package com.reginabei.blog.service;

import com.reginabei.blog.dao.ThemesDao;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemesService {

    private final ThemesDao themesDao;

    public void createTheme(Theme theme) {
        themesDao.save(theme);
    }

    public List<Theme> findAllThemes() {
        List<Theme> result = new ArrayList<>();
        themesDao.findAllDistinct().forEach((e) -> {
            Theme theme = new Theme();
            theme.setName(e);
            result.add(theme);
        });
        return result;
    }

    public void deleteThemes(List<Theme> themes) {
        themesDao.deleteAll(themes);
    }
}