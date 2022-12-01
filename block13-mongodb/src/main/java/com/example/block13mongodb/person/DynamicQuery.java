package com.example.block13mongodb.person;

import lombok.Data;

@Data
public class DynamicQuery {

    private Integer personIdLike;
    private String personNameLike;
    private String personSurLike;
    private String personUserLike;

}
