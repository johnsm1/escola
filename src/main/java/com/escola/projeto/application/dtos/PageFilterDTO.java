package com.escola.projeto.application.dtos;

import lombok.Data;

@Data
public class PageFilterDTO {
    private Integer size = 10;
    private Integer page = 0;
}
