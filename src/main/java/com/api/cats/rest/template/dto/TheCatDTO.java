package com.api.cats.rest.template.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheCatDTO {

    private String id;

    private String name;

    private String origin;

    private String description;

    private String temperament;
}
