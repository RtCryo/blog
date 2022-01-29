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
    private String name;
    private String description;
    @OneToOne
    private Category category;
    @OneToOne
    private Theme theme;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> commentList;
    private long views;
    private long likes;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CraftDescriptionBlock> craftDescriptionBlocks;
    @Lob
    private String imageFile;
}
