package com.company.aop.dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SaveOrderDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
