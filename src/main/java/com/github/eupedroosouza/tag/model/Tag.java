package com.github.eupedroosouza.tag.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Pedro
 * @project pedrotags
 * @created 08/12/2022 - 15:54
 */
@Getter
@AllArgsConstructor
public class Tag {

    private String id;
    private String name;

    private String prefix;
    private String suffix;
    private int priority;

    private String permission;



}
