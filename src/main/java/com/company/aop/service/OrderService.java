package com.company.aop.service;

import com.company.aop.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    @LogService(desc = "保存订单", convert = SaveOrderConvert.class)
    public Boolean saveOrder(SaveOrderDto saveOrderDto){
        log.info("保存订单,订单ID:"+saveOrderDto.getOrderId());
        return Boolean.TRUE;
    }

    @LogService(desc = "更新订单", convert = UpdateOrderConvert.class)
    public Boolean updateOrder(UpdateOrderDto updateOrderDto){
        log.info("更新订单，订单ID:"+updateOrderDto.getId());
        return Boolean.TRUE;
    }
}
