package com.reginabei.blog.service;

import com.reginabei.blog.dao.ThemesDao;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThemesService {

    private final ThemesDao themesDao;

    public void createTheme(Theme theme) {
        themesDao.save(theme);
    }

    public List<Theme> findAllThemes() {
        return (List<Theme>) themesDao.findAll();
    }

    public void deleteThemes(List<Theme> themes) {
        themesDao.deleteAll(themes);
    }
}