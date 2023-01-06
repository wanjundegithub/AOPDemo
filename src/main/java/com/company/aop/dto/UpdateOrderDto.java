package com.company.aop.dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpdateOrderDto {
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
