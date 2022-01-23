package com.reginabei.blog.service;

import com.reginabei.blog.dao.ImageDao;
import com.reginabei.blog.exception.MyOwnRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("path")
public class ImageStorageService {

    @Setter
    private String siteImage;

    private final ImageDao imageDao;
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        if(!Files.isDirectory(Paths.get(siteImage))){
            try {
                Files.createDirectory(Paths.get(siteImage));
            } catch (IOException e) {
                throw new MyOwnRuntimeException("Could not initialize folder for upload!");
            }
        }
    }

    public String saveSiteImg(MultipartFile file) {
        String imgName = (getRandomString() + LocalDateTime.now() + "_" + file.getOriginalFilename()).replace(":", "_");
        try {
            Files.copy(file.getInputStream(), Paths.get(this.siteImage).resolve(imgName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new MyOwnRuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return imgName;
    }

    public void deleteFile(String fileName){
        try {
            Files.delete(Paths.get(this.siteImage).resolve(fileName));
        } catch (IOException e) {
            throw new MyOwnRuntimeException("Could not delete the file. Error: " + e.getMessage());
        }
    }

    private String getRandomString() {
        int leftLimit = 48;
        int rightLimit = 122;

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(6)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
