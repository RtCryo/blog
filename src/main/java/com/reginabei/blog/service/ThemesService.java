package com.reginabei.blog.service;

import com.reginabei.blog.dao.ThemesDao;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemesService {

    private ThemesDao themesDao;

    public void createTheme(Theme theme) {
        themesDao.save(theme);
    }

    public List<Theme> findAllThemes() {
        return (List<Theme>) themesDao.findAll();
    }
}
