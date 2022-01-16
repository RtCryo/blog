package com.reginabei.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Craft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String craftName;
    private String description;
}
