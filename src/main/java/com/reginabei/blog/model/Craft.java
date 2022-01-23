package com.reginabei.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Craft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String craftName;
    private String description;
    @OneToMany
    private List<Comment> commentList;
    private long views;
    private long likes;
    @Lob
    private String imageFile;
}
