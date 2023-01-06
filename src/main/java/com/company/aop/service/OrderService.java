package com.company.aop.service;

import com.company.aop.dto.SaveOrderDto;
import com.company.aop.dto.UpdateOrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    public Boolean saveOrder(SaveOrderDto saveOrderDto){
        log.info("保存订单id:"+saveOrderDto.getId());
        return true;
    }

    public Boolean updateOrder(UpdateOrderDto updateOrderDto){
        log.info("更新订单id:"+updateOrderDto.getOrderId());
        return true;
    }
}
